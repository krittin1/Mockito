package csku.mockitodemo.controller;

public interface RequestHandler {
    Response process(Request request) throws InvalidRequestException;
}
