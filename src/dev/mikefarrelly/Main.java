package dev.mikefarrelly;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        // Impelment an efficient recursive function using an API
        // Need to call API in recursive function
        // Takes two parameters, seen and n
        // Base URL: http://challenge-server.code-check.io/api/recursive/ask
        URL url = new URL("http://challenge-server.code-check.io/api/recursive/ask?n=3&seed=someseedvalue");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestMethod("GET");
        InputStream responseStream = connection.getInputStream();

    }

    private static String printErrorMessage(String errorMessage) {
        return "";
    }

    private static void terminateProgramWithErrorCode(int errorCode) {
        System.exit(errorCode);
    }

    private static int recursiveFib(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return recursiveFib(n - 1) + recursiveFib(n - 2);
    }
}
