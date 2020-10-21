package com.example.service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ShipmentNotFoundException;
import com.example.Repository.IShipmentRepo;
import com.example.model.Shipment;
import com.example.service.IShipmentService;

@Service
public class ShipmentServiceImple implements IShipmentService
{
	@Autowired
	private IShipmentRepo repo;

	@Override
	public Integer SaveShipment(Shipment ship) 
	{
		
		return repo.save(ship).getShipmentID();
	}

	@Override
	public List<Shipment> GetAllShipment() 
	{
		List<Shipment> list=repo.findAll();
		list.sort((l1,l2)-> l1.getShipmentID()-l2.getShipmentID());
		return list;
	}

	@Override
	public Shipment GetOneShipment(Integer id) 
	{
		return repo.findById(id).
				orElseThrow(() -> new ShipmentNotFoundException("Shipment not '" + id + "' Found"));
	}


	@Override
	public void UpdateShipment(Shipment ship) 
	{
		repo.save(ship);
		
	}

	@Override
	public void deleteShipment(Integer id) 
	{
		Optional<Shipment> s=repo.findById(id);
		
		if(s.isPresent())repo.delete(s.get());
		else throw new ShipmentNotFoundException("Shipment is not Found");
		
	}
}
