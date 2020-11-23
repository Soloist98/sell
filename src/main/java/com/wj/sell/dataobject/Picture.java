package com.wj.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Picture {
    @Id
    private String picId;

    /**
     * 图片链接
     */
    private String picUrl;

    /**
     * 图片信息
     */
    private String picMessage;

    /**
     * 创建时间
     */
    private Date picCreate;

}
