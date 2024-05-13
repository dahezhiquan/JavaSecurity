package com.dahe.hello.controller.Deserialize;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.XMLDecoder;
import java.io.*;

@RestController
@RequestMapping("/Deserialize/XMLDecoder")
public class XMLDecoderVul {

    private final String path = "src/main/resources/payload/payload1.xml";

    /**
     * XMLDecoder 是JDK的一个对象转XML的工具。所以本质上 XMLEncoder 与 XMLDecoder 也是一种序列化（编码）与反序列化（解码）的操作。
     */
    @ApiOperation(value = "vul: XMLDecoder反序列化", notes = "XMLDecoder类的readObject()方法执行反序列化操作")
    @GetMapping("/vul")
    public void vul() {
        File file = new File(path);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            System.out.println(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedInputStream bis = new BufferedInputStream(fis);
        XMLDecoder xmlDecoder = new XMLDecoder(bis);
        xmlDecoder.readObject();
        xmlDecoder.close();
    }

    /**
     * 替换XMLDecoder类，使用更安全的ObjectInputStream.readUnshared
     */
    @GetMapping("/safe")
    public void safe() throws IOException, ClassNotFoundException {
        File file = new File(path);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readUnshared();
        ois.close();
    }
}
