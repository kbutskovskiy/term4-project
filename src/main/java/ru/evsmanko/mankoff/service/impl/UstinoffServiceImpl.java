package ru.evsmanko.mankoff.service.impl;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.UserRepository;
import ru.evsmanko.mankoff.service.UstinoffService;

import java.io.FileWriter;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UstinoffServiceImpl implements UstinoffService {
    private final UserRepository userRepository;
    @Override
    public String exportToJson(long id) {
        User user = userRepository.getUserById(id);
        FileWriter writer = null;
        String json = null;
        try {
            writer = new FileWriter("jsons/user"+id+".json");
            json = new GsonBuilder().setPrettyPrinting().create().toJson(user);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
