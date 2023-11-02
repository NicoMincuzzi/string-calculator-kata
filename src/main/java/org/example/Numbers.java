package org.example;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Numbers {
    private final String sentence;

    public Numbers(String sentence) {
        this.sentence = sentence;
    }

    public List<Integer> retrieveSplittingBy(Delimiters delimiters) {
        String numbers = (delimiters.isDynamic())
                ? sentence.substring(sentence.indexOf("\n") + 1)
                : sentence;

        return stream(numbers.split(delimiters.retrieve()))
                .filter(it -> !it.isEmpty())
                .map(Integer::parseInt)
                .collect(toList());
    }
}
