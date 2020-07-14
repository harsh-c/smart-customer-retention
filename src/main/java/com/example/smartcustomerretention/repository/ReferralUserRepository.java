package com.example.smartcustomerretention.repository;
import com.example.smartcustomerretention.models.ReferralUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ReferralUserRepository extends JpaRepository<ReferralUser, Integer>{
}
