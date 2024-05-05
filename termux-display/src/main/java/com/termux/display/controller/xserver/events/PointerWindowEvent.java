package com.termux.display.controller.xserver.events;

import com.termux.display.controller.xserver.Bitmask;
import com.termux.display.controller.xserver.Window;

import java.io.IOException;

public abstract class PointerWindowEvent extends Event {
    public enum Detail {ANCESTOR, VIRTUAL, INFERIOR, NONLINEAR, NONLINEAR_VIRTUAL}
    public enum Mode {NORMAL, GRAB, UNGRAB}
    private final Detail detail;
    private final int timestamp;
    private final Window root;
    private final Window event;
    private final Window child;
    private final short rootX;
    private final short rootY;
    private final short eventX;
    private final short eventY;
    private final Bitmask state;
    private final Mode mode;
    private final boolean sameScreenAndFocus;

    public PointerWindowEvent(int code, Detail detail, Window root, Window event, Window child, short rootX, short rootY, short eventX, short eventY, Bitmask state, Mode mode, boolean sameScreenAndFocus) {
        super(code);
        this.detail = detail;
        this.timestamp = (int)System.currentTimeMillis();
        this.root = root;
        this.event = event;
        this.child = child;
        this.rootX = rootX;
        this.rootY = rootY;
        this.eventX = eventX;
        this.eventY = eventY;
        this.state = state;
        this.mode = mode;
        this.sameScreenAndFocus = sameScreenAndFocus;
    }

    @Override
    public void send(short sequenceNumber) throws IOException {
    }
}