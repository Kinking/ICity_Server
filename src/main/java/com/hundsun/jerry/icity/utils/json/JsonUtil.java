package com.hundsun.jerry.icity.utils.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hundsun.jerry.icity.model.User;

import java.util.List;

/**
 * Created by huangzhiyuan on 2017/1/21.
 */
public class JsonUtil {
    public List<User> StringFromJson (String jsondata)
    {
        Gson gson=new Gson();
        List<User> list=gson.fromJson(jsondata, new TypeToken<List<User>>(){}.getType());
        return list;

    }
}
