package com.example.service;

import java.util.List;

import com.example.model.Shipment;

public interface IShipmentService {

	public Integer SaveShipment(Shipment ship);

	public List<Shipment> GetAllShipment();

	public Shipment GetOneShipment(Integer id);

	public void UpdateShipment(Shipment ship);

	void deleteShipment(Integer id);

}
