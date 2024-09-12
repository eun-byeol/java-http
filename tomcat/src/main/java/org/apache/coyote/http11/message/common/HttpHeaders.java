package org.apache.coyote.http11.message.common;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpHeaders {

    private static final String DELIMITER = ": ";
    private static final String NEWLINE = "\r\n";

    private final Map<String, String> headers = new HashMap<>();

    public HttpHeaders() {
        add("Content-Length", "0");
    }

    public HttpHeaders(List<String> lines) {
        lines.forEach(this::parse);
    }

    private void parse(String line) {
        String[] words = line.split(DELIMITER);

        if (words.length != 2) {
            throw new IllegalArgumentException("잘못된 header 형식입니다.");
        }
        headers.put(words[0].strip(), words[1].strip());
    }

    public void add(String header, String value) {
        headers.put(header, value);
    }

    public int getContentLength() {
        String contentLength = headers.getOrDefault("Content-Length", "0");
        return Integer.parseInt(contentLength);
    }

    public String getCookies() {
        return headers.getOrDefault("Cookie", "");
    }

    public String convertMessage() {
        return headers.keySet().stream()
                .map(key -> key + DELIMITER + headers.get(key))
                .collect(collectingAndThen(toList(), lines -> String.join(NEWLINE, lines)));
    }

    @Override
    public String toString() {
        return "HttpHeaders{" +
                "headers=" + headers +
                '}';
    }
}
