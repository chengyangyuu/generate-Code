package com.cheng.cli.example;

import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


public class Login implements Callable {
    @Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 19;
    @Override
    public Object call() throws Exception {
        return null;
    }
}
