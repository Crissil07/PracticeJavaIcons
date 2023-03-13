package com.icon.Practice.Repository;

import com.icon.Practice.Entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CountryRepository extends JpaRepository<CountryEntity,Long> {
}
