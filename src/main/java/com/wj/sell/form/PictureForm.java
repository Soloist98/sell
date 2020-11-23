package com.wj.sell.form;

import lombok.Data;

import java.util.Date;

@Data
public class PictureForm {

    private String picId;
    private String picUrl;
    private String picMessage;
    private Date picCreate;
}
