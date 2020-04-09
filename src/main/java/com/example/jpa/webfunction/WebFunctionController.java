package com.example.jpa.webfunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class WebFunctionController {

    @Autowired
    WebFunctionRepository webFunctionRepository;

    @GetMapping("/webfunctions/{id}")
    public String getPost(@PathVariable("id") WebFunction webFunction) {

//         Optional<WebFunction> byId = webFunctionRepository.findById(id);
//         WebFunction webFunction = byId.get();

        return webFunction.getTitle();
    }

    @GetMapping("/webfunctions")
    public Page<WebFunction> getWebFunctions(Pageable pageable) {
        return webFunctionRepository.findAll(pageable);
    }
}
