package com.wj.sell.controller;

import com.wj.sell.VO.ResultVO;
import com.wj.sell.dataobject.Picture;
import com.wj.sell.exception.SellException;
import com.wj.sell.form.PictureForm;
import com.wj.sell.repository.PictureRepository;
import com.wj.sell.utils.KeyUtil;
import com.wj.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {
    //TODO
    /**
     * 添加service层
     */

    @Autowired
    PictureRepository repository;


    /**
     * 前端调 获取轮播图片
     * @return
     */
    @GetMapping("/getAll")
    public ResultVO getUserInfo() {
        List<Picture> pictures = repository.findAll();
        return ResultVOUtil.success(pictures);
    }
    /*
     * 页面相关
     * */

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<Picture> pictures = repository.findAll();
        map.put("pictureList", pictures);
        return new ModelAndView("picture/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "picId", required = false) String picId,
                              Map<String, Object> map) {
        Picture picture = repository.findByPicId(picId);
        map.put("picture", picture);

        return new ModelAndView("picture/index", map);
    }

    /**
     * 保存/更新
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid PictureForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/picture/index");
            return new ModelAndView("common/error", map);
        }
        Picture picture = new Picture();
        try {
            if (!StringUtils.isEmpty(form.getPicId())) {
                picture = repository.findByPicId(form.getPicId());
            }
            BeanUtils.copyProperties(form, picture);
            picture.setPicId(KeyUtil.genUniqueKey());
            repository.save(picture);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/picture/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/picture/list");
        return new ModelAndView("common/success", map);
    }
}
