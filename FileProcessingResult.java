package model;

import java.util.Map;
import java.util.HashMap;

public class FileProcessingResult {
    private int wordCount;
    private Map<Character, Integer> characterFrequency;
    private int sentenceCount;
    private Map<String, Integer> wordFrequency;
    private double averageWordLength;

    public FileProcessingResult() {
        this.characterFrequency = new HashMap<>();
        this.wordFrequency = new HashMap<>();
    }

    // Getters and Setters
    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public Map<Character, Integer> getCharacterFrequency() {
        return characterFrequency;
    }

    public void setCharacterFrequency(Map<Character, Integer> characterFrequency) {
        this.characterFrequency = characterFrequency;
    }

    public int getSentenceCount() {
        return sentenceCount;
    }

    public void setSentenceCount(int sentenceCount) {
        this.sentenceCount = sentenceCount;
    }

    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }

    public void setWordFrequency(Map<String, Integer> wordFrequency) {
        this.wordFrequency = wordFrequency;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(double averageWordLength) {
        this.averageWordLength = averageWordLength;
    }
}
