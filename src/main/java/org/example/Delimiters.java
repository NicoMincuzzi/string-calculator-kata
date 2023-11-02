package org.example;

public class Delimiters {

    private final String sentence;

    public Delimiters(String sentence) {
        this.sentence = sentence;
    }

    public boolean isDynamic() {
        return sentence.startsWith("//");
    }

    public String retrieve() {
        return (isDynamic())
                ? sentence.substring(2, sentence.indexOf("\n"))
                : ",|\\n";
    }
}
