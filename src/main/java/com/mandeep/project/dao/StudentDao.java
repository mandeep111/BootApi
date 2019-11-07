package com.mandeep.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mandeep.project.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{

}
