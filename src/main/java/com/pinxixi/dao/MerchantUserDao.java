<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
package com.pinxixi.dao;

import com.pinxixi.model.UserModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
@Mapper
public interface MerchantUserDao {
    //获取MerchantUser表中所有用户资料
    @Select("Select * from MerchantUser")
    ArrayList<UserModel> getUserAll();
    //根据Email获取该用户所有资料
    @Select("select * from MerchantUser where email = #{email}")
    ArrayList<UserModel> getUserMailBased(@Param("email") String email);
    //写入用户资料
    @Insert("Insert into MerchantUser (name, password, email) values (#{name}, #{password}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addUser(UserModel merchantUser) throws SQLException;
    //根据id删除用户资料
    @Delete("Delete from MerchantUser where id = #{id}")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void deleteUserIdBased(@Param("id") long id);
    //根据账号和密码查找用户资料
    @Select("Select * from MerchantUser where email = #{email} and password = #{password}")
    ArrayList<UserModel> getUserBasedPasswordAndEmail(@Param("email") String email, @Param("password") String password) throws SQLException;

}
<<<<<<< HEAD
=======
package com.pinxixi.dao;

import com.pinxixi.model.UserModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
@Mapper
public interface MerchantUserDao {
    //获取MerchantUser表中所有用户资料
    @Select("Select * from MerchantUser")
    ArrayList<UserModel> getUserAll();
    //根据Email获取该用户所有资料
    @Select("select * from MerchantUser where email = #{email}")
    ArrayList<UserModel> getUserMailBased(@Param("email") String email);
    //写入用户资料
    @Insert("Insert into MerchantUser (name, password, email) values (#{name}, #{password}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addUser(UserModel merchantUser) throws SQLException;
    //根据id删除用户资料
    @Delete("Delete from MerchantUser where id = #{id}")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void deleteUserIdBased(@Param("id") long id);
    //根据账号和密码查找用户资料
    @Select("Select * from MerchantUser where email = #{email} and password = #{password}")
    ArrayList<UserModel> getUserBasedPasswordAndEmail(@Param("email") String email, @Param("password") String password) throws SQLException;

}
>>>>>>> pinxixi
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
