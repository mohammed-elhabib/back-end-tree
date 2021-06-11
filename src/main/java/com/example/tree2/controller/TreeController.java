package com.example.tree2.controller;

import com.example.tree2.domain.NodeTree;
import com.example.tree2.domain.Tree;
import com.example.tree2.repository.NodeTreeRepository;
import com.example.tree2.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api/tree")
@CrossOrigin("*")
public class TreeController {
    @Autowired
    TreeRepository treeRepository;
    @GetMapping("/v1/getall")
    public List<Tree> getAll() {
        return treeRepository.findAll().stream().map(x->Tree.builder().id(x.getId()).title(x.getTitle()).imageUrl(x.getImageUrl()).prev(x.getPrev()).build()).collect(Collectors.toList());
    }
    @PostMapping("/v1/create")
    public Tree createTree(@RequestBody Tree tree) {
        tree.setRoot(NodeTree.builder().title(tree.getTitle()).build());
        var newtree = treeRepository.save(tree);
        return newtree;
    }
    @PostMapping("/v1/update")
    public Tree updateTree(@RequestBody Tree nodeTree) {
        if(treeRepository.existsById(nodeTree.getId()))
        {
            var node = treeRepository.save(nodeTree);
            return node;
        }
        return  null;
    }
    @GetMapping("/v1/delete/{id}")
    public boolean deleteTree(@RequestBody Long id) {
        treeRepository.deleteById(id);
        return true;
    }
    @GetMapping("/v1/get/{id}")
    public Tree getNode(@PathVariable Long id) {
        return treeRepository.getById(id);
    }
}
