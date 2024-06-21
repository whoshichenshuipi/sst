package com.bo.Mapper;

import com.bo.bean.Users;

import java.util.List;

public interface userMapper {
    List<Users> selectall();
    Users selectzhangsan();

}
