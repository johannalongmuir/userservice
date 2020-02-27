package com.manchesterdigital.userservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String userName;

    @NotBlank(message = "Name is mandatory")
    private String firstName;

    @NotBlank(message = "Name is mandatory")
    private String lastName;


    private String address;

    //encripted!
    private String password;


    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = firstName + lastName;
    }

    public UserDTO(String firstName, String lastName, String address) {
        this(firstName, lastName);
        this.address = address;

    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
