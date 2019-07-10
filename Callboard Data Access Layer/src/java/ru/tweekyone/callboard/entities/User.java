/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tweekyone.callboard.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.hibernate.validator.constraints.CreditCardNumber;

/**
 *
 * @author Пирожок
 */
@NamedQueries({
    @NamedQuery(name="find-user-by-name",
            query="SELECT user FROM CallboardUsers AS user WHERE user.name = :name ")
})

@Entity(name = "CallboardUsers")
public class User implements Serializable{
    
    @Id
    private String name;
    
    private String password;
    
    protected User(){};
    
    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
