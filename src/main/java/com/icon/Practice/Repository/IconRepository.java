package com.icon.Practice.Repository;

import com.icon.Practice.Entity.IconEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IconRepository extends JpaRepository<IconEntity, Long> {
}
