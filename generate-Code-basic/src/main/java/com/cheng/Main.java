package com.cheng;

import com.cheng.cli.CommandExecutor;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        args = new String[]{"generator","-l","-o","-a"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}