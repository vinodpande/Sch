package expertgs.com.model;

public class Subject {
    //`subject_master`(`SUBJECT_ID`, `SUBJECT_NAME`, `SEMISTER_ID`, `CLASS_ID`, `STREAM_ID`)
    int subjectId;
    String subjectName;
    int semisterId;
    int classId;
    int streamId;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSemisterId() {
        return semisterId;
    }

    public void setSemisterId(int semisterId) {
        this.semisterId = semisterId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStreamId() {
        return streamId;
    }

    public void setStreamId(int streamId) {
        this.streamId = streamId;
    }
}
