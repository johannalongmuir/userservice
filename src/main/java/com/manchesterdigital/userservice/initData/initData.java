package com.manchesterdigital.userservice.initData;

import com.manchesterdigital.userservice.entity.User;
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
        User johannaLongmuir = new User("Johanna", "Longmuir");
        User emmaDudley = new User("Emma", "Dudley");
        User emmaSmith = new User("Emma", "Smith", "123 Main Road");
        User johnSmith  = new User("John", "Smith");
        User janeDoe = new User("Jane", "Doe", "123 Main Road");
        User craigLongmuir = new User("Craig", "Longmuir", "Australia");

        userRepository.save(johannaLongmuir);
        userRepository.save(emmaDudley);
        userRepository.save(emmaSmith);
        userRepository.save(johnSmith);
        userRepository.save(janeDoe);
        userRepository.save(craigLongmuir);
    }
}
