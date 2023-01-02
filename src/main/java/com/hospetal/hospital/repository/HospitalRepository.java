package com.hospetal.hospital.repository;

import com.hospetal.hospital.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
