package com.cheng.cli.example;

import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


public class Login implements Callable<Integer> {
    @Option(names = { "-u", "--user" }, description = "User Name")
    String user;

    @Option(names = { "-p", "--password" },arity = "0..1", description = "Passphrase",interactive = true)
    String password;
    @Option(names = { "-cp", "--checkPassword" }, arity = "0..1",description = "Check Password",interactive = true)
    String checkPassword;

    @Override
    public Integer call() throws Exception {
        System.out.println("password = "+password);
        System.out.println("checkPassword = "+checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u","userBen","-p","-cp");
    }
}
