package com.fastcode.example.application.core.t1.dto;

import java.time.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
public class CreateT1Output {

    private char[] ca;
    private List<Double> flpa;
    private List<Double> fpa;
    private Long id;
    private String str;
    private String jf;
    private String jbf;
    private String inet;
}
