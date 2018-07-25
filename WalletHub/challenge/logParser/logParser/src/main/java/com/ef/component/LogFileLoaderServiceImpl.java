package com.ef.component;

import java.io.File;
import java.util.Map;
import java.util.Objects;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.ef.common.Constant;
import com.ef.service.LogFileLoaderService;

@Component
public class LogFileLoaderServiceImpl implements LogFileLoaderService {

	@Override
	public File loadLogFile(Map<String, String> paramsMap) {

		File fileToParse = null;

		//TODO - Hammer Time!!
		//paramsMap.put(Constant.ACCESS_LOG, "C:/Users/nunof/Desktop/Java_MySQL_Test/access.log");

		//if a given path to a file was given through accessLog parameter, load it
		String pathToFile = paramsMap.get(Constant.ACCESS_LOG);

		//Load file with the given path
		FileSystemResource fileSystemFile = new FileSystemResource(pathToFile);

		//Check if file was loaded
		if(Objects.nonNull(fileSystemFile)) {
			fileToParse = fileSystemFile.getFile();
		}else {
			System.out.println("File not found on given path");
		}

		return fileToParse;
	}
	
	

}
