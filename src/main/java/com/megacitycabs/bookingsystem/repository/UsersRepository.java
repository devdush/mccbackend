package com.megacitycabs.bookingsystem.repository;

import com.megacitycabs.bookingsystem.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

}
