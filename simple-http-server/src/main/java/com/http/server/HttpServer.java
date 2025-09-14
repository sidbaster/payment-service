package com.http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.http.server.HttpServerUtil.createHttpServer;
import static com.http.server.HttpServerUtil.readRequest;

public class HttpServer {
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = createHttpServer(PORT)) {
            Socket socket = serverSocket.accept();
            readRequest(socket);
        }
    }
}