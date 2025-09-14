package com.http.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

import static java.lang.System.out;

public class HttpServerUtil {
    public static final String FILE_PATH = "static/";

    public static ServerSocket createHttpServer(int port) {
        try {
            return new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readRequest(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String requestLine = reader.readLine();
        String path = requestLine.split(" ")[1];

        File file = new File(FILE_PATH + path);

        if (file.exists() && !file.isDirectory()) {
            writeSuccessResponse(file, socket);
        } else {
            writeErrorResponse();
        }
    }

    private static void writeSuccessResponse(File file, Socket socket) throws IOException {
        byte[] content = Files.readAllBytes(file.toPath());
        String contentType = getContentType(file.getName());

        String header = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: " + contentType + " charset=utf-8\r\n" +
                "Content-Length: " + content.length + "\r\n" +
                "\r\n";

        socket.getOutputStream().write(header.getBytes());
        socket.getOutputStream().write(content);

        socket.getOutputStream().flush();
    }

    private static void writeErrorResponse() throws IOException {
        String header = """
                HTTP/1.1 404 Not Found\r
                Content-Type: text/plain\r
                \r
                File not found""";
        out.write(header.getBytes());
    }

    private static String getContentType(String fileName) {
        if (fileName.endsWith(".html")) return "text/html";
        if (fileName.endsWith(".css")) return "text/css";
        if (fileName.endsWith(".js")) return "application/javascript";
        if (fileName.endsWith(".png")) return "image/png";
        if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) return "image/jpeg";
        if (fileName.endsWith(".gif")) return "image/gif";
        return "application/octet-stream";
    }
}
