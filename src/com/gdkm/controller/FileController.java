package com.gdkm.controller;


import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gdkm.po.Admin;


@Controller
public class FileController {
     //执行单个文件上传，设置produces = “text/plain;charset=utf-8”使得json返回数据支持中文
	@RequestMapping(value="/admin/fileUpload.action",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String handleFileUpload(List<MultipartFile> uploadfile,
			HttpServletRequest request) {
		String account = ((Admin)request.getSession().getAttribute("ADMIN_SESSION")).getAccount();
		String fileAddress="";
		System.out.println("------handleFileUpload-----file num="+uploadfile.size());
		//判断所上传的文件
		if(!uploadfile.isEmpty() && uploadfile.size() > 0) {
			for(MultipartFile file : uploadfile) {
				//设置上传文件的原始路径
				String originalFilename = file.getOriginalFilename();
				//设置上传文件的保存地址目录
				String dirPath = request.getServletContext().getRealPath("../web/upload");
				File filePath = new File(dirPath);
				//如果保存文件的地址不存在，就先创建目录
				if(!filePath.exists()) {
					filePath.mkdir();
				}
				//新文件名=上传人+"_"+UUID码+"_"+原文件名
				String newFilename = account+"_"+UUID.randomUUID() + "_"+originalFilename;
				try {
					file.transferTo(new File(dirPath+File.separator+ newFilename));//上传文件
					System.out.println("----fileAddress="+fileAddress);
				}catch(Exception e) {
					e.printStackTrace();
					return "FAIL";
				}
			}
			return fileAddress;
		}else {
			return "FAIL";
		}
	}
}
