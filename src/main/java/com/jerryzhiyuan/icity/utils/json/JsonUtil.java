package com.jerryzhiyuan.icity.utils.json;




import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jerryzhiyuan.icity.model.Moment;
import com.jerryzhiyuan.icity.model.User;

import java.util.List;

/**
 * Created by huangzhiyuan on 2017/1/21.
 */
public class JsonUtil {
    public List<User> userStringFromJson (String jsonStr)
    {
        Gson gson=new Gson();
        List<User> list=gson.fromJson(jsonStr, new TypeToken<List<User>>(){}.getType());
        return list;

    }

    public List<Moment> momentStringFromJson (String jsonStr)
    {
        Gson gson=new Gson();
        List<Moment> list=gson.fromJson(jsonStr, new TypeToken<List<Moment>>(){}.getType());
        return list;

    }




}
