package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {
    private List<Channel> channels = new ArrayList<>();

    public int calculateSumOfVideos() {
        return channels.stream()
                .mapToInt(Channel::getNumberOfVideos)
                .sum();
    }

    public void readDataFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            readLines(reader);
        } catch (
                IOException ioe) {
            throw new IllegalArgumentException("Cannot open file for read!", ioe);
        }
    }

    public List<Channel> getChannels() {
        return channels;
    }

    private void readLines(BufferedReader reader) throws IOException {
        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            createNewChannelObj(line);
        }
    }

    private void createNewChannelObj(String line) {
        String[] parts = line.split(";");
        String channelName = parts[0];
        int subscriptions = Integer.parseInt(parts[1]);
        int numberOfVideos = Integer.parseInt(parts[2]);
        channels.add(new Channel(channelName, subscriptions, numberOfVideos));
    }

}
