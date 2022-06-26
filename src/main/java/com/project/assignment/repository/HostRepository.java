package com.project.assignment.repository;

import com.project.assignment.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {
    Host findByName(String name);
    Long countAllBy();
}
