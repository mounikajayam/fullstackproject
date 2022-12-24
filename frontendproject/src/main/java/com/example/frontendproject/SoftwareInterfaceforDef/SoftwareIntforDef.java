package com.example.frontendproject.SoftwareInterfaceforDef;

import java.util.List;

import com.example.frontendproject.Model.Software;


public interface SoftwareIntforDef {
	List<Software> fetchAllRecords();
	 Software saveSoftware(Software obj);
void deleteSoftwarebyId(int id);
Software getSoftwareById(int id);
}
