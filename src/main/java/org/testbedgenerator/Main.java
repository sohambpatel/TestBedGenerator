package org.testbedgenerator;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static boolean flag=true;
    public static Properties properties;
    public static Scanner myObj,myConfirmationObj,myCustomChatGPTPrompt,myInhouseLLMCommand,myOllama;
    public static GenAIHandler genAIHandler;
    public static OllamaGenAIRESTHandler ollamaGenAIRESTHandler;

    public static File dest,source;
    public static void main(String args[]) throws Exception {
        System.out.println("**************************************************************************************");
        System.out.println("**************************************************************************************");
        System.out.println("Copyright © 2024 Soham Patel, Kailas Patil Vishwakarma University. All rights reserved");
        System.out.println("**************************************************************************************");
        System.out.println("**************************************************************************************");
        properties=PropertyFileLoader.readPropertyValues("src/main/resources/config.properties");
        String filelocation;
        if (System.getProperty("os.name").contains("Windows")) {
            filelocation = System.getProperty("user.home")+"\\Downloads\\";
        } else {
            filelocation = System.getProperty("user.name")+"/Downloads/";
        }
        while(flag){
            myObj = new Scanner(System.in);
            System.out.println("Please select the options below by typing number infront of option: ");
            System.out.println("1. Create Static Test Beds");
            System.out.println("2. Create Dynamic Test Beds by Typing your own query with Chatgpt");
            System.out.println("3. Create Dynamic Test Beds with your inhouse LLM like OLLAMA");
            System.out.println("4. Create Dynamic Test Bed by Typing your own query with OLLAMA REST Api");
            System.out.println("5. Exit");
            String choice = myObj.nextLine();
            switch(choice) {
                case "1":
                    source=new File("src/main/resources/staticfiles");
                    dest=new File(filelocation);
                    StaticContentHandler.copyDirectoryCompatibityMode(source,dest);
                    System.out.println("Static code generation is successful, you can find the content in: "+filelocation);
                    break;
                case "2":
                    myCustomChatGPTPrompt=new Scanner(System.in);
                    System.out.println("Please enter your prompt..");
                    String customprompt=myCustomChatGPTPrompt.nextLine();
                    genAIHandler=new GenAIHandler(properties.getProperty("CHATGPTURL"),properties.getProperty("CHATGPTAPI_KEY"));
                    String genaioutput=genAIHandler.generateResults(customprompt);
                    SingletonFileHandler.getInstance().writeToFile(filelocation+"generatedoutput.txt",genaioutput);
                    break;
                case "3":
                    myInhouseLLMCommand=new Scanner(System.in);
                    System.out.println("Please enter inhouse LLM Command");
                    String command=myInhouseLLMCommand.nextLine();
                    try{
                        String output=CommandExecuter.executeCommand(command);
                        SingletonFileHandler.getInstance().writeToFile(filelocation+"commandoutput.txt",output);
                        System.out.println("Command Executed successfully and file has been added: "+filelocation+"commandoutput.txt");
                    }catch(IOException ioException){
                        System.out.println("command cannot be executed");
                        ioException.printStackTrace();
                    }
                    break;
                case "4":
                    myOllama=new Scanner(System.in);
                    System.out.println("Please enter your prompt..");
                    String custompromptForOllama=myOllama.nextLine();
                    ollamaGenAIRESTHandler=new OllamaGenAIRESTHandler(properties.getProperty("OLLAMAURL"),properties.getProperty("OLLAMAMODELNAME"));
                    String ollamagenaioutput=ollamaGenAIRESTHandler.generateOllamaResults(custompromptForOllama);
                    SingletonFileHandler.getInstance().writeToFile(filelocation+"generatedOllamaoutput.txt",ollamagenaioutput);
                    break;
                case "5":
                    System.out.println("Are you sure you want to Exit? Please enter 'Y' to exit, else 'N'");
                    myConfirmationObj=new Scanner(System.in);
                    String yesno=myConfirmationObj.nextLine();
                    if(yesno.equalsIgnoreCase("Y")){
                        return;
                    } else if (yesno.equalsIgnoreCase("N")) {
                        continue;
                    }else{
                        System.out.println("PLEASE ENTER THE CORRECT CHOICE");
                    }
                    break;
                default:
                    System.out.println("PLEASE ENTER THE CORRECT CHOICE");
            }
        }
    }
}
