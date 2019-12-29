<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
package com.pinxixi.model;

import org.springframework.stereotype.Component;

@Component
public class UserModel {
    private long id;
    private String name;
    private String password;
    private String email;

    public UserModel() {
        super();
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
<<<<<<< HEAD
=======
package com.pinxixi.model;

import org.springframework.stereotype.Component;

@Component
public class UserModel {
    private long id;
    private String name;
    private String password;
    private String email;

    public UserModel() {
        super();
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
>>>>>>> pinxixi
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
