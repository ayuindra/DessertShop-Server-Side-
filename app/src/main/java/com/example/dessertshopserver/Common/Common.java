package com.example.dessertshopserver.Common;

import com.example.dessertshopserver.Model.Request;
import com.example.dessertshopserver.Model.User;

public class Common {
    public static User currentUser;

    public static final String UPDATE = "Update";
    public static final String DELETE = "Delete";

    public static final int PICK_IMAGE_REQUEST = 71;
    public static Request currentRequest;

    public static String convertCodeToStatus(String status) {
        if(status == null){
            return "null";
        }
        else if(status.equals("0")){
            return "Placed";
        }
        else if(status.equals("1")){
            return "On My Way";
        }
        else{
            return "Shipped";
        }
    }
}
