package com.training.ee.jpa;

import com.training.ee.model.Color;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by yusufyazici on 13/02/2018.
 */

@Converter
public class ColorConverter implements AttributeConverter<Color, String> {
    public String convertToDatabaseColumn(Color color) {
        return color.toString();
    }

    public Color convertToEntityAttribute(String s) {

        String[] split = s.split(",");
        Color color = new Color();

        color.setRed(Integer.parseInt(split[0]));
        color.setGreen(Integer.parseInt(split[1]));
        color.setBlue(Integer.parseInt(split[2]));
        return color;
    }
}
