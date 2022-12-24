package com.example.frontendproject.SoftwareInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.frontendproject.Model.Software;
public interface SoftwareInt extends JpaRepository<Software,Integer> {//<T,Id>
 

}
