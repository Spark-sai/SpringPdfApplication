package com.example.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.example.model.Shipment;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentPdf  extends AbstractPdfView
{

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document,
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse 
			response) 
					throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Shipment> list=(List<Shipment>) model.get("list");
		
		response.addHeader("content-disposition","attachment;filename=Shipment.pdf");
		Paragraph p=new Paragraph("Shipment Data");
		
		
		PdfPTable table= new PdfPTable(6);
		table.addCell("ID");
		table.addCell("Mode");
		table.addCell("Code");
		table.addCell("Enable");
		table.addCell("Grade");
		table.addCell("Description");
		
		
		
		for(Shipment ship:list)
		{
			table.addCell(String.valueOf(ship.getShipmentID()));
			table.addCell(ship.getShipmentMode());
			table.addCell(ship.getShipmentCode());
			table.addCell(ship.getShipmentDescription());
			table.addCell(ship.getShipmentEnable());
			table.addCell(ship.getShipmentGrade());
			
		}
		document.add(p);
		document.add(table);
		
	}

}
