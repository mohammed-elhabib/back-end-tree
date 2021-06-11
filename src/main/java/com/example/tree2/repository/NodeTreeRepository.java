package com.example.tree2.repository;

import com.example.tree2.domain.NodeTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeTreeRepository extends JpaRepository<NodeTree, Long> {
}
