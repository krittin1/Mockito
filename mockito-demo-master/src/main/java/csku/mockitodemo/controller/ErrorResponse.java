package csku.mockitodemo.controller;

public class ErrorResponse implements Response {

    private Request originalRequest;
    private Exception originalException;
    private String name;

    public ErrorResponse(Request request, Exception exception) {
        this.originalRequest = request;
        this.originalException = exception;
        this.name = "Error";
    }

    @Override
    public String getName() {
        return name;
    }

    public Request getOriginalRequest() {
        return this.originalRequest;
    }

    public Exception getOriginalException() {
        return this.originalException;
    }
}
