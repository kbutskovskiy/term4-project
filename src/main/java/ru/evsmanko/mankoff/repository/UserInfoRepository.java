package ru.evsmanko.mankoff.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.UserInfo;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {
    ArrayList<UserInfo> findAll();
    Optional<UserInfo> findUserInfoById(long id);
    UserInfo save(UserInfo userInfo);
}

