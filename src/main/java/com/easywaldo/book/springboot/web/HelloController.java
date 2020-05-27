package com.easywaldo.book.springboot.web;

import com.easywaldo.book.springboot.web.dto.HelloResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @GetMapping
    public String Hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

    //@RequestMapping(value = "/hello/file", method = RequestMethod.POST)
    @PostMapping("/hello/file")
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> upload(@RequestParam("file") List<MultipartFile> files) throws Exception {
        List<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            String originalfileName = file.getOriginalFilename();
            System.out.print(originalfileName);
            //File dest = new File("/Users/leejinam/Downloads/" + originalfileName);
            //file.transferTo(dest);
            // TODO
            list.add(originalfileName);
        }
        return list;
    }
}

