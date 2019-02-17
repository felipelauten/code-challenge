package com.devlauten.codingchallenge.zwitter.repository;

import com.devlauten.codingchallenge.zwitter.vo.Zwitt;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ZwittRepository extends PagingAndSortingRepository<Zwitt, Long> {
    // No extra methods
}
