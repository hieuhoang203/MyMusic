package com.example.mymusic.repositories;

import com.example.mymusic.entity.commonProperties.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CommonRepository <T, ID> extends JpaRepository<T, ID> {

    Set<T> select(Status status);

    T updateStatus(ID id);

}
