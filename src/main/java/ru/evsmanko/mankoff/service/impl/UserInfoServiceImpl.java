package ru.evsmanko.mankoff.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.entity.UserInfo;
import ru.evsmanko.mankoff.repository.UserInfoRepository;
import ru.evsmanko.mankoff.repository.UserRepository;
import ru.evsmanko.mankoff.service.UserInfoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public ArrayList<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

   // @Override
 //   public Optional<UserInfo> findUserInfoByUserId(long id) {
   //     return Optional.empty();
    //}

   // @Override
    //public UserInfo save() {
 //       return null;
   // }
}
