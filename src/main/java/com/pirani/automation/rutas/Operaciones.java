package com.pirani.automation.rutas;

public class Operaciones {

    private static String INDEX = "/";
    private static String UNIT_TEST = "/unitTest";

    public static String obtenerEndPoint(String endpoint){
        switch (endpoint){
            case "index":
                return INDEX;
            case "unitTest":
                return UNIT_TEST;
            default:
                break;
        }

        return "";
    }
}
