package cn.crm.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileToJson {
    public static JSONObject fileToJson(String filePath) throws IOException {
        ClassPathResource cpr = new ClassPathResource(filePath);
        byte[] bytes = FileCopyUtils.copyToByteArray(cpr.getInputStream());
        //File file = new File(filePath);
        //String string = FileUtils.readFileToString(file);
        String data = new String(bytes, StandardCharsets.UTF_8);
        return JSON.parseObject(data, Feature.OrderedField);
    }
}
