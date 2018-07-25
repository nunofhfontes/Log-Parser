package com.ef;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ef.common.Constant;
import com.ef.service.ArgumentValidatorService;
import com.ef.service.LogFileService;

@SpringBootApplication
@ComponentScan("com.ef")
@EntityScan(basePackages = {"com.ef.domain"} )
@EnableJpaRepositories(basePackages = {"com.ef.repository"} )
public class Parser implements ApplicationRunner{

	@Autowired
	private ArgumentValidatorService argumentValidatorService;
	
	@Autowired
	private LogFileService logFileService;
	
	Map<String, String> paramsMap = new HashMap<>();
	
	public static void main(String[] args) {
		
		System.out.println("Starting Application...");
		
		SpringApplication.run(Parser.class, args);
	}
	
	@Override
    public void run(ApplicationArguments args) throws Exception {
		
		//1- Print Arguments on console
		System.out.println("Application started with command-line arguments: {}" + Arrays.toString(args.getSourceArgs()));
		
		args.getOptionNames().forEach( (name) -> {
        	
        	//Print each parameter
        	System.out.println("arg -> " + name + "=" + args.getOptionValues(name));
        	
        	//Map for parameters
        	paramsMap.put(name, args.getOptionValues(name).get(Constant.FIRST_POSITION));
        });

        //2- Validate Arguments
        Boolean validParams = argumentValidatorService.validateLogParserArguments(paramsMap);
        
        if(validParams) {
        	
        	//3- Load Log File
        	File fileToParse = logFileService.loadLogFile(paramsMap);
        	
        	//4- Parse Log File
        	logFileService.parseLog(fileToParse);
        	
        }else{
        	System.out.println("Invalid Parameters!");
        }
        
    }
	
}
