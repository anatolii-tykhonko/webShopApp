package com.anatolii.webShopApp.controllers;

import com.anatolii.webShopApp.model.Client;
import com.anatolii.webShopApp.service.ClientService;
import com.anatolii.webShopApp.util.ClientValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientController {
    private final ClientService clientService;
    private final ClientValidator clientValidator;

    public ClientController(ClientService clientService, ClientValidator clientValidator) {
        this.clientService = clientService;
        this.clientValidator = clientValidator;
    }

    @GetMapping("/clients")
    public String findAll(Model model){
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "client-list";
    }

    @GetMapping("/client-create")
    public String createClientForm(Client client){
        return "client-create";
    }

    @PostMapping("/client-create")
    public String createClient(@Valid @ModelAttribute Client client, BindingResult result){
        clientValidator.validate(client, result);
        if(result.hasErrors()){
            return "client-create";
        }
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/client-delete/{id}")
    public String deleteClient(@PathVariable("id") int id){
        clientService.deleteClient(id);
        return "redirect:/clients";
    }

    @GetMapping("/client-update/{id}")
    public String updateClientForm(@PathVariable("id") int id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client-update";
    }

    @PostMapping("client-update")
    public String updateClient(@Valid @ModelAttribute Client client, BindingResult result){
        if(result.hasErrors()){
            return "/client-update";
        }
        clientService.saveClient(client);
        return "redirect:/clients";
    }
}
