package com.fastcode.example.application.core.t1.dto;

import java.time.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateT1Input {

    private char[] ca;

    private File file;

    private List<Double> flpa;

    private List<Double> fpa;

    private String str;
}
