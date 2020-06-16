package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        Sandwich sandwich = new Sandwich();
        JSONObject jo = new JSONObject(json);

        JSONObject name = jo.getJSONObject("name");
        sandwich.setMainName(name.getString("mainName"));

        JSONArray ja = name.getJSONArray("alsoKnownAs");
        List<String> sandwichAKA = new ArrayList<>();
        for(int i = 0; i < ja.length(); i++) {
            sandwichAKA.add(ja.getString(i));
            sandwich.setAlsoKnownAs(sandwichAKA);
        }

        sandwich.setPlaceOfOrigin(jo.getString("placeOfOrigin"));
        sandwich.setDescription(jo.getString("description"));
        sandwich.setImage(jo.getString("image"));

        ja = jo.getJSONArray("ingredients");
        List<String> sandwichIngredients = new ArrayList<>();
        for(int i = 0; i < ja.length(); i++) {
            sandwichIngredients.add(ja.getString(i));
            sandwich.setIngredients(sandwichIngredients);
        }

        return sandwich;
    }
}
