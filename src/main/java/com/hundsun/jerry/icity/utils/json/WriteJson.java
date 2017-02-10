package com.hundsun.jerry.icity.utils.json;

import com.google.gson.Gson;

import java.util.List;


/**
 * Created by huangzhiyuan on 2017/1/21.
 */
public class WriteJson {
    public String getJsonData(List<?> list)
    {
        Gson gson=new Gson();
        String jsonStr=gson.toJson(list);
        return jsonStr;
    }
}
