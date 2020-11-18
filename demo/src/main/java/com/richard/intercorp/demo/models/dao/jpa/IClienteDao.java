package com.richard.intercorp.demo.models.dao.jpa;

import com.richard.intercorp.demo.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente , Long> {
}
