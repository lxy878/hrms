package com.hrms.userservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.userservice.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    public Employee findByEmailId(Long id);
    public Employee findByEmpCode(String empCode);
    public Optional<Employee> findById(Long id);

    @Query(value = "select * from employee where month(birth_date) >= ?1 and day(birth_date) >= ?2 order by birth_date", nativeQuery = true)
    public List<Employee> findAllByBirthdateAfter(int month, int day);
}
