package com.ziguiway.adventurechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ziguiway.adventurechat.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

}
