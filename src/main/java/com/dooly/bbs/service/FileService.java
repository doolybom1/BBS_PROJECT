package com.dooly.bbs.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileService {

	// 파일 저장되어 있는 위치
	private final String filePath;
	
	public String fileUp(MultipartFile upFile) {
		String originalFileName = upFile.getOriginalFilename();
		
		// UUID가 붙은 상태로 업로드된 파일에 적용
		String strUUID = UUID.randomUUID().toString();
		strUUID += originalFileName;
		
		File serverFile = new File(filePath,strUUID);
		
		File dir = new File(filePath);
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		
		try {
			upFile.transferTo(serverFile);
			return strUUID;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
