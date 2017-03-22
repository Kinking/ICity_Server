package com.hundsun.jerry.icity.utils.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hundsun.jerry.icity.model.Moment;

import java.util.List;

/**
 * Created by huangzhiyuan on 2017/3/21.
 */
public class JsonUtilMoment {

    public List<Moment> momentStringFromJson (String jsonStr)
    {
        Gson gson=new Gson();
        List<Moment> list=gson.fromJson(jsonStr, new TypeToken<List<Moment>>(){}.getType());
        return list;

    }
}
