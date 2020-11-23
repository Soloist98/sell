package com.wj.sell.repository;

import com.wj.sell.dataobject.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture,String> {
    Picture findByPicId(String picId);
}
