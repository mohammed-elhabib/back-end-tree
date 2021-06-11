package com.example.tree2.repository;

import com.example.tree2.domain.NodeTree;
import com.example.tree2.domain.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {
}
