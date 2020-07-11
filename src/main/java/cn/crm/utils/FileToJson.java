package cn.crm.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileToJson {
    public static JSONObject fileToJson(String filePath) throws IOException {
        File file = new File(filePath);
        String string = FileUtils.readFileToString(file);
        return JSON.parseObject(string, Feature.OrderedField);
    }
}
