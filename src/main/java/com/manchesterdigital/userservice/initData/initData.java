package com.manchesterdigital.userservice.initData;

import com.manchesterdigital.userservice.entity.UserDTO;
import com.manchesterdigital.userservice.repository.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class initData implements ApplicationListener<ContextRefreshedEvent> {
    private UserRepository userRepository;

    public initData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        addData();
    }

    private void addData() {
        UserDTO johannaLongmuir = new UserDTO("Johanna", "Longmuir");
        UserDTO emmaDudley = new UserDTO("Emma", "Dudley");
        UserDTO emmaSmith = new UserDTO("Emma", "Smith", "123 Main Road");
        UserDTO johnSmith  = new UserDTO("John", "Smith");
        UserDTO janeDoe = new UserDTO("Jane", "Doe", "123 Main Road");
        UserDTO craigLongmuir = new UserDTO("Craig", "Longmuir", "Australia");

        userRepository.save(johannaLongmuir);
        userRepository.save(emmaDudley);
        userRepository.save(emmaSmith);
        userRepository.save(johnSmith);
        userRepository.save(janeDoe);
        userRepository.save(craigLongmuir);
    }
}
