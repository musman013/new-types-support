package com.fastcode.example.domain.core.t1;

import java.time.*;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository("t1Repository")
public interface IT1Repository extends JpaRepository<T1Entity, Long>, QuerydslPredicateExecutor<T1Entity> {}
