package com.zxn.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zxn.util.ECPSConstants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
@RequestMapping("/upload")
public class EbUploadController {
	
	@RequestMapping("/uploadPic.do")
	public void uploadPic(HttpServletRequest request, String fileName, PrintWriter out){
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
		CommonsMultipartFile cfile = (CommonsMultipartFile) mr.getFile(fileName);
		byte[] ftype = cfile.getBytes();
		String tfileName = "";
		tfileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		Random random = new Random();
		for(int i = 0; i < 3; i++){
			tfileName = tfileName + random.nextInt(10);
		}
		String suffix = "";
		String orgFileName = cfile.getOriginalFilename();
		suffix = orgFileName.substring(orgFileName.lastIndexOf("."));
		//创建jersy客户端
		Client client = Client.create();
		//指定图片服务器上的图片路径
		WebResource wr = client.resource(ECPSConstants.PIC_HOST+"/upload/"+tfileName+suffix);
		//直接上传图片到另一台主机
		wr.put(String.class, ftype);
		String realPath = ECPSConstants.PIC_HOST+"/upload/"+tfileName+suffix;
		String raltivePath = "/upload/"+tfileName+suffix;
		//{"realPath":"http;///"}
		String result = "{\"realPath\":\""+realPath+"\", \"raltivePath\":\""+raltivePath+"\"}";
		out.write(result);
		
	}

}
