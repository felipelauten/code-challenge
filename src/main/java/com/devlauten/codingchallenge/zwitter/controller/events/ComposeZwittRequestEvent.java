package com.devlauten.codingchallenge.zwitter.controller.events;

/**
 * RequestEvent that represents a Zwitt compose action
 * The payload is the text <code>String</code> of the Zwitt
 */
public class ComposeZwittRequestEvent extends RequestEvent<String> {

    public ComposeZwittRequestEvent(String text) {
        super(text);
    }
}
