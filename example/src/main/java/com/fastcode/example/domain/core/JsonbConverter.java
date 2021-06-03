package com.fastcode.example.domain.core;

import java.sql.SQLException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.postgresql.util.PGobject;

@Converter
public class JsonbConverter implements AttributeConverter<String, Object> {

  @Override
  public Object convertToDatabaseColumn(String attribute) {
      if (attribute == null)
          return null;
      PGobject pgobject = new PGobject();
      pgobject.setType("jsonb");
      try {
          pgobject.setValue(attribute);
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
      return pgobject;
  }

  @Override
  public String convertToEntityAttribute(Object dbData) {
      return dbData == null ? null : dbData.toString();
  }
}