package com.fastcode.example.domain.core.t1;

import com.fastcode.example.domain.core.ByteArrayConverter;
import com.fastcode.example.domain.core.InetConverter;
import com.fastcode.example.domain.core.JsonConverter;
import com.fastcode.example.domain.core.JsonbConverter;
import com.fastcode.example.domain.core.abstractentity.AbstractEntity;
import java.io.File;
import java.time.*;
import java.util.List;
import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t1")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class T1Entity extends AbstractEntity {

    @Basic
    @Convert(converter = ByteArrayConverter.class)
    @Column(name = "ca", nullable = true)
    private char[] ca;

    @Basic
    @Column(name = "file", nullable = true)
    private byte[] file;

    @Basic
    @Convert(converter = ByteArrayConverter.class)
    @Column(name = "flpa", nullable = true)
    private List<Double> flpa;

//    @Basic
//    @Convert(converter = JsonConverter.class)
//    @Column(name = "jf", nullable = true)
//    private String jf;
//    
    @Basic
//    @Convert(converter = JsonbConverter.class)
    @Column(name = "jbf", nullable = true)
    private String jbf;
    
    @Basic
//    @Convert(converter = InetConverter.class)
    @Column(name = "inet", nullable = true)
    private String inet;

    @Basic
    @Convert(converter = ByteArrayConverter.class)
    @Column(name = "fpa", nullable = true)
    private List<Double> fpa;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Convert(converter = ByteArrayConverter.class)
    @Column(name = "str", nullable = true)
    private String str;
}
