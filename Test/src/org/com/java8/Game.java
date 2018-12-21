package org.com.java8;

import java.lang.annotation.Repeatable;  
// Declaring repeatable annotation type  
@Repeatable(Games.class)  
public @interface Game{  
    String name() default "cricket";  
    String day() default "Monday";  
    
}  
