package com.app.manager.repository;

import com.app.manager.entity.AppsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppEntityRepository extends JpaRepository<AppsEntity, Long> {
}
