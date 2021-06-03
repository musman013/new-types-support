package com.fastcode.example.application.core.t1.dto;

import java.time.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
public class UpdateT1Input {

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

    @NotNull(message = "id Should not be null")
    private Long id;

    private String str;

    private Long versiono;
    private String jf;
    private String jbf;
    private String inet;
}
