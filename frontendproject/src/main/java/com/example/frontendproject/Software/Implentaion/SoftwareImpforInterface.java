package com.example.frontendproject.Software.Implentaion;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.frontendproject.SoftwareInterfaceforDef.SoftwareIntforDef;
import com.example.frontendproject.Model.Software;
import com.example.frontendproject.SoftwareInterface.SoftwareInt;
@Service
public class SoftwareImpforInterface implements  SoftwareIntforDef {
	private SoftwareInt software;
	public SoftwareImpforInterface(SoftwareInt software) {
		
			this.software = software;
		}
	@Override
	public List<Software> fetchAllRecords() {
		
		return software.findAll();
	}
	@Override
	public Software saveSoftware(Software obj) {
			return software.save(obj);
	}
	public void deleteSoftwarebyId(int id) {
	        software.deleteById(id);
}
	public Software getSoftwareById(int id) {
		return	software.findById(id).get();
		}
	
}