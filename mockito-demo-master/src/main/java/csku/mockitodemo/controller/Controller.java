package csku.mockitodemo.controller;

public interface Controller {
    Response processRequest(Request request); // catch all errors
    void addHandler(Request request, RequestHandler requestHandler);

}
