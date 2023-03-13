package org.riverify;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        String idNum = "20111304028";
        String password = "20020126wdmzsLJ";

        connect(idNum, password);
    }

    private static void connect(String idNum, String password) {
        try {
            URL url = new URL("http://rz.ahnu.edu.cn:801/" +
                    "eportal/portal/login?callback=dr1003&login_method=1&user_account=" +
                    idNum +
                    "%40telecom&user_password=" +
                    password +
                    "&wlan_user_ip=172.23.168.249&wlan_user_ipv6=&wlan_user_mac=000000000000&wlan_ac_ip=&wlan_ac_name=&jsVersion=4.1.3&terminal_type=1&lang=en&v=4740&lang=en");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}