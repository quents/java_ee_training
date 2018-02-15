package com.training.ee.jpa;

import com.training.ee.model.Color;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Base64;

/**
 * Created by yusufyazici on 13/02/2018.
 */
@Converter
public class PasswordConverter implements AttributeConverter<String, String> {
    public String convertToDatabaseColumn(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes());
    }

    public String convertToEntityAttribute(String s) {

        return new String(Base64.getDecoder().decode(s));
    }
}
