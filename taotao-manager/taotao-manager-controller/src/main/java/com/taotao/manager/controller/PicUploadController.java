package com.taotao.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.manager.service.PictureService;

/**
 * 
 * 图片上传的contrlloer
 * @author Phillip Rade Xu
 * @date 创建时间：2019年4月27日 下午3:41:08
 * @version 1.0
 */
@Controller
public class PicUploadController {
	@Autowired
	PictureService pictureService;
	@ResponseBody
	@RequestMapping("/pic/upload")
	public PictureResult uploadPicture(MultipartFile uploadFile) {
		PictureResult uploadPicture = pictureService.uploadPicture(uploadFile);
		return uploadPicture;
	}
}
