package com.example.tree2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeTree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String  title;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    List<NodeTree> children ;
    @Transient()
    NodeTree parent;
}

