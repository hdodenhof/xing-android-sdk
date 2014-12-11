package de.hdodenhof.xingapi.internal.util;

import org.scribe.model.Verb;

public class HTTPUtils {

    public static Verb scribeVerbFromString(String verb) {
        switch (verb) {
            case "GET":
                return Verb.GET;
            case "POST":
                return Verb.POST;
            case "PUT":
                return Verb.PUT;
            case "DELETE":
                return Verb.DELETE;
        }
        return null;
    }

}
