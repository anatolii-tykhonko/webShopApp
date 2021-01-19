package com.anatolii.webShopApp.repository;

import com.anatolii.webShopApp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJPARepository extends JpaRepository<Client, Integer> {

}
