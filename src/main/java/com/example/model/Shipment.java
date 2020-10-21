package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "shippment_tab")
public class Shipment 
{
	@Id
	@GeneratedValue
	@Column(name = "ship_ID_Col")
	private Integer ShipmentID;
	
	
	@Column(name = "ship_Mode_Col")
	private String ShipmentMode;
	
	@Column(name = "ship_Code_Col")
	private  String ShipmentCode;

	@Column(name = "ship_Enable_Col")
	private String ShipmentEnable;
	
	@Column(name = "ship_Grade_Col")
	private String ShipmentGrade;
	
	@Column(name = "ship_Description_Col")
	private String ShipmentDescription;
}
