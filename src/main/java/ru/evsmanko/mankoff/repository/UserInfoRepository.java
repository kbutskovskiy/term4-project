package ru.evsmanko.mankoff.repository;

import org.springframework.data.repository.CrudRepository;
import ru.evsmanko.mankoff.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {
    ArrayList<UserInfo> findAll();
   // Optional<UserInfo> findUserInfoByUserId(long id);
    //UserInfo save(UserInfo userInfo);
}
