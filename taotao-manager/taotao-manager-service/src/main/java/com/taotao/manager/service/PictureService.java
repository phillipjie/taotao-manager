package com.taotao.manager.service;

import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;

/**
 * 
 * 图片上传的服务接口
 * @author Phillip Rade Xu
 * @date 创建时间：2019年4月27日 下午3:39:39
 * @version 1.0
 */
public interface PictureService {

	PictureResult uploadPicture(MultipartFile uploadFile);

}