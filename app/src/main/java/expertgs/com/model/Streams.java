package expertgs.com.model;

public class Streams {
    // `stream_master`(`STREAM_ID`, `STREAM_NAME`)
    int streamID;
    String streamName;

    public int getStreamID() {
        return streamID;
    }

    public void setStreamID(int streamID) {
        this.streamID = streamID;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }
}
