package org.testbedgenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecuter {
    public static String executeCommand(String command) throws IOException {
        if (System.getProperty("os.name").contains("Windows")) {
            System.out.println("Executing the command: "+command);
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            StringBuilder sb=new StringBuilder();
            String s;
            while ((s = reader.readLine()) != null) {
                sb=sb.append(s);
            }
            return sb.toString();
        } else {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            System.out.println("Executing the command: "+command);
            Process process = processBuilder.start();
            System.out.println(process);
            return process.toString();
        }

    }
}
