package exporter;

import struct.FrameData;

public abstract class Exporter {

    protected FrameData frameData;

    public abstract void init();

    public abstract void close();

    public void exportFrameData(FrameData frameData) {
        this.frameData = frameData;
    }

}
