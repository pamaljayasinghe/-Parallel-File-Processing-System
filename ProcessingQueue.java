package com.fileprocessor.queue;

import java.nio.file.Path;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProcessingQueue {
    private final BlockingQueue<Path> fileQueue;
    private final int maxQueueSize;

    public ProcessingQueue(int maxSize) {
        this.maxQueueSize = maxSize;
        this.fileQueue = new LinkedBlockingQueue<>(maxSize);
    }

    public void addFile(Path file) throws InterruptedException {
        fileQueue.put(file);
    }

    public Path getFile() throws InterruptedException {
        return fileQueue.take();
    }

    public int getCurrentSize() {
        return fileQueue.size();
    }

    public int getMaxSize() {
        return maxQueueSize;
    }
}