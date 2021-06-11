package com.example.tree2.controller;

import com.example.tree2.domain.NodeTree;
import com.example.tree2.domain.Tree;
import com.example.tree2.repository.NodeTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/nodeTree")
@CrossOrigin("*")

public class NodeTreeController {
    @Autowired
    NodeTreeRepository nodeTreeRepository;
    @GetMapping("/v1/getall")
    public List<NodeTree> getAll() {
        return nodeTreeRepository.findAll();
    }
    @PostMapping("/v1/create")
    public NodeTree createNode(@RequestBody NodeTree nodeTree) {
        var parent =nodeTreeRepository.findById(nodeTree.getParent().getId()).orElseThrow();
        parent.getChildren().add(nodeTree);
          nodeTreeRepository.save(parent);
        return nodeTree;
    }
    @PostMapping("/v1/update")
    public NodeTree updateNode(@RequestBody NodeTree nodeTree) {
        if(nodeTreeRepository.existsById(nodeTree.getId()))
        {
            var node = nodeTreeRepository.save(nodeTree);
            return node;
        }
        return  null;
    }
    @GetMapping("/v1/delete/{id}/{parentId}")
    public boolean deleteNode(@PathVariable Long id,@PathVariable Long parentId) {
       var parent= nodeTreeRepository.getById(parentId);
        parent.getChildren().remove(nodeTreeRepository.getById(id));
        nodeTreeRepository.save(parent);
        return true;
    }
    @GetMapping("/v1/get/{id}")
    public NodeTree getNode(@PathVariable Long id) {
        return nodeTreeRepository.getById(id);
    }
}
