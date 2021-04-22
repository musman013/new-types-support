package com.fastcode.example.application.core.t1.dto;

import java.time.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateT1Input {

    private char[] ca;

    private File file;

    private List<Double> flpa;

    private List<Double> fpa;

    @NotNull(message = "id Should not be null")
    private Long id;

    private String str;

    private Long versiono;
}
