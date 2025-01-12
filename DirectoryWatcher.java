package com.fileprocessor.watcher;

import com.fileprocessor.queue.ProcessingQueue;
import java.nio.file.*;
import java.io.IOException;

public class DirectoryWatcher implements Runnable {
    private final Path directoryPath;
    private final ProcessingQueue queue;
    private volatile boolean running = true;

    public DirectoryWatcher(String directoryPath, ProcessingQueue queue) {
        this.directoryPath = Paths.get(directoryPath);
        this.queue = queue;
    }

    @Override
    public void run() {
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            directoryPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            while (running) {
                WatchKey key = watchService.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        Path newFile = directoryPath.resolve(((WatchEvent<Path>)event).context());
                        queue.addFile(newFile);
                        System.out.println("New file detected: " + newFile);
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public void stop() {
        running = false;
    }
}
