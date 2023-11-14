package com.utn.elbuensabor.autenticacion;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String firstName;
    String lastName;
    String address;
    String city;
    String phoneNumber;
    String email;
    String password;

}