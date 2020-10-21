package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Shipment;

public interface IShipmentRepo
             extends JpaRepository<Shipment, Integer>
{

}
