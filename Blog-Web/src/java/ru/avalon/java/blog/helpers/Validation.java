/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.blog.helpers;

import ru.avalon.java.blog.exceptions.ValidationException;

/**
 *
 * @author JAVA
 */
public class Validation {
    private Validation(){}
    
    public static void require(
            String text, String error
    ) throws ValidationException{ 
        if (text == null || text.trim().isEmpty()){
            throw new ValidationException(error);
        }      
    }
    
    public static void requireEquals(
            Object a,
            Object b,
            String error
    ) throws ValidationException{
        if (!a.equals(b)){
            throw new ValidationException(error);
        }
    }
    
    public static void requireNull(
            Object object,
            String error
    ) throws ValidationException{
        if (object != null) {
            throw new ValidationException(error);
        }
    }
    
    public static void requireNonNull(
            Object object,
            String error
    ) throws ValidationException{
        if (object == null) {
            throw new ValidationException(error);
        }
    }
}
