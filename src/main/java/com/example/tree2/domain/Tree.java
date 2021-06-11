package com.example.tree2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String  title;
    String  prev;
    String imageUrl;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    NodeTree  root;
}
