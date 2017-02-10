package com.hundsun.jerry.icity.utils.json;




import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hundsun.jerry.icity.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by huangzhiyuan on 2017/1/21.
 */
public class JsonUtil {
    public List<User> StringFromJson (String jsonStr)
    {
        Gson gson=new Gson();
        List<User> list=gson.fromJson(jsonStr, new TypeToken<List<User>>(){}.getType());
        return list;

    }

//    public static <User> List<User> getListFromJSON(String json, Class<User[]> user) {
//        User[] list = new Gson().fromJson(json, user);
//        return Arrays.asList(list);
//    }

}
