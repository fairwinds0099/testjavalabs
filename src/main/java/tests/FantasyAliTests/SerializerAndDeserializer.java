package tests.FantasyAliTests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import org.apache.commons.io.FileUtils;
import utils.FileUtils;

import java.io.*;

public class SerializerAndDeserializer {
        static String json;

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Fantasy Ali Tests");
        serializeWithGson();
        Restaurant nR = deserializeWithGson();



    }

        private static void serializeWithGson() throws IOException {
            Owner.OwnerAddress ownerAdd = new Owner.OwnerAddress("alloway dr", 804, "VA", 23454);
            Owner owner = new Owner("Ali", 39, "TUR", ownerAdd);

            Restaurant.RestaurantStaff cook = new Restaurant.RestaurantStaff("Emir", 13, 2515.18);
            Restaurant.RestaurantStaff waiter = new Restaurant.RestaurantStaff("Belma", 9, 1877.39);
            Restaurant restaurant = new Restaurant("Donerci", owner, cook, waiter);
            System.out.println(restaurant);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            json = gson.toJson(restaurant);
            System.out.println(json);


        }

        private static Restaurant deserializeWithGson(){

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            return gson.fromJson(json, Restaurant.class);
        }

    }

