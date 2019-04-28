package com.taotao.manager.serviceimpl;

import java.io.IOException;
import java.io.InputStream;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.util.ExceptionUtil;
import com.taotao.common.util.FtpUtil;
import com.taotao.common.util.IDUtils;
import com.taotao.manager.service.PictureService;



/**
 * 
 * 上传图片的service
 * @author Phillip Rade Xu
 * @date 创建时间：2019年4月26日 下午11:53:08
 * @version 1.0
 */

@Service
public class PictureServiceImpl implements PictureService {
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USER_NAME}")
	private String FTP_USER_NAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	
	public PictureResult uploadPicture(MultipartFile uploadFile) {
		//判断非空
		if (null == uploadFile || uploadFile.isEmpty()) {
			return PictureResult.error("上传的图片不存在");
		}
		//取文件扩展名
		String originalFilename = uploadFile.getOriginalFilename();
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新文件名
		//可以使用uuid生成新文件名。
		//UUID.randomUUID()
		//可以是时间+随机数生成文件名
		String imageName = IDUtils.genImageName();
		//把图片上传到ftp服务器（图片服务器）
		//需要把ftp的参数配置到配置文件中
		//文件在服务器的存放路径，应该使用日期分隔的目录结构
		DateTime dateTime = new DateTime();
		String filePath = dateTime.toString("/yyyy/MM/dd");
		//拼接新用户名
		String filename=imageName+ext;
		//文件变成我们需要的流
		InputStream inputStream;
		try {
			inputStream = uploadFile.getInputStream();
			boolean uploadFile2 = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD, FTP_BASE_PATH, filePath, filename, inputStream);
			if(!uploadFile2) {
				return PictureResult.error("图片上传失败");
			}
		} catch (IOException e) {
			e.printStackTrace();
			return PictureResult.error(ExceptionUtil.getStackTrace(e));
		}
		//返回结果
		return PictureResult.ok(IMAGE_BASE_URL+FTP_BASE_PATH + filePath + "/" + filename);
	}
}
