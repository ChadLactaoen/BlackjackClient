package com.lactaoen.blackjack.client.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.JSONObject;

/**
 * JSON Processing util class.
 *
 * @author Chad Tomas
 */
public class JsonUtils {

    public static JSONObject toJson(Object obj) {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            return new JSONObject(ow.writeValueAsString(obj));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
