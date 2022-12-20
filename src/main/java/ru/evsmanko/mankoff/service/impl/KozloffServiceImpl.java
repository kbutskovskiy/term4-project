package ru.evsmanko.mankoff.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.service.KozloffService;

@Slf4j
@Service
@RequiredArgsConstructor
public class KozloffServiceImpl implements KozloffService {


    @Override
    public void test() {

        log.info("KozloffService test");
    }
}
