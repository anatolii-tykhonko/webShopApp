package com.anatolii.webShopApp.util;

import com.anatolii.webShopApp.model.Client;
import com.anatolii.webShopApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class ClientValidator implements Validator {
    private final ClientService clientService;

    @Autowired
    public ClientValidator(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Client client = (Client) o;
        if(clientService.findByEmail(client.getEmail()) !=null){
            errors.rejectValue("email", "", "This Email is already use!");
        }

    }
}
