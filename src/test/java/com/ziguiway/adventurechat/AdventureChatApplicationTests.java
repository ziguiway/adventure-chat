package com.ziguiway.adventurechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ziguiway.adventurechat.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Slf4j
@SpringBootTest
class AdventureChatApplicationTests {


    @Test
    void ipTest() {
        String res = HttpClientUtil.doGet("https://api.vvhan.com/api/getIpInfo?ip=127.0.0.1");
        JSONObject parseObject = JSON.parseObject(res);
        Object info = parseObject.get("info");
        JSONObject jsonObject = JSONObject.parseObject(info.toString());
        System.out.println(jsonObject);
        Object country = jsonObject.get("country");
        System.out.println(country);
        Object prov = jsonObject.get("prov");
        Object lsp = jsonObject.get("lsp");
        Object postcode = jsonObject.get("postcode");
        System.out.println(prov);
        System.out.println(lsp);
        System.out.println(postcode);

        System.out.println(country + "-" + prov + "-" + lsp + "-" + postcode);


    }

    @Test
    void Tcp(){
        try {
            Socket socket = new Socket("192.168.3.229",10086);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello".getBytes(StandardCharsets.UTF_8));
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void Tcp2(){
        try {
            ServerSocket serverSocket = new ServerSocket(10086);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            String s = new String(bytes, 0, len);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void Tcp3(){

    }

}
