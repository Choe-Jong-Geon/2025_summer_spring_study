package me.choejonggeon.project.repository;

import me.choejonggeon.project.Entity.To_do;
import me.choejonggeon.project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface To_doRepository extends JpaRepository<To_do, Long> {

    List<To_do> findAllByUser(User user);



}
