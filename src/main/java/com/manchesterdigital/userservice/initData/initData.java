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
        User johanna = new User("Johanna", "Longmuir");
        User emma = new User("Emma", "Dudley");
        User emmaSmith = new User("Emma", "Smith");
        emmaSmith.setAddress("123 Main Road");
        User john  = new User("John", "Smith");
        User jane = new User("Jane", "Doe");
        userRepository.save(johanna);
        userRepository.save(emma);
        userRepository.save(emmaSmith);
        userRepository.save(john);
        userRepository.save(jane);
    }
}
