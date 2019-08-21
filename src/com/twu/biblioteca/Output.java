package com.twu.biblioteca;

public class Output {
    private boolean exit;
    public String outputString;

    public Output(boolean shouldExit, String outputString) {
        this.exit = shouldExit;
        this.outputString = outputString;
    }


    public boolean isExit() {
        return exit;
    }

    public String message() {
        return outputString;
    }
}
