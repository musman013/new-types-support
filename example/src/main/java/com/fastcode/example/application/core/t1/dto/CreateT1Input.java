package com.fastcode.example.application.core.t1.dto;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import java.time.*;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateT1Input {

    private char[] ca;

    private byte[] file;
    
    public void setFile(MultipartFile mpfile) {
    	try {
			file = mpfile.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private List<Double> flpa;

    private List<Double> fpa;

    private String str;
//    private String jf;
    private String jbf;
    private String inet;
}
