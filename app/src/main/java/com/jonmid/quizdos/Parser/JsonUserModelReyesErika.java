package com.jonmid.quizdos.Parser;

import com.jonmid.quizdos.Models.UserModelReyesErika;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reyes on 10/10/2017.
 */

public class JsonUserModelReyesErika {

    public static List<UserModelReyesErika> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<UserModelReyesErika>  userModelReyesErikas = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject item_user = jsonArray.getJSONObject(i);
            UserModelReyesErika userModelReyesErika = new UserModelReyesErika();

            userModelReyesErika.setName(item_user.getString("name"));
            userModelReyesErika.setUsername(item_user.getString("username"));
            userModelReyesErika.setEmail(item_user.getString("email"));
            userModelReyesErika.setPhone(item_user.getString("phone"));
            JSONObject company =item_user.getJSONObject("company");
            company.getString("name");
            JSONObject addres =item_user.getJSONObject("adress");
            addres.getString("street");


            userModelReyesErikas.add(userModelReyesErika);
        }
        return userModelReyesErikas;
    }

}
