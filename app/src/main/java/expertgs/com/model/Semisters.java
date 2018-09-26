package expertgs.com.model;

public class Semisters {
    //`semister_master`(`SEMISTER_ID`, `SEMISTER_NAME`)
    int semisterId;
    String semisterName;

    public int getSemisterId() {
        return semisterId;
    }

    public void setSemisterId(int semisterId) {
        this.semisterId = semisterId;
    }

    public String getSemisterName() {
        return semisterName;
    }

    public void setSemisterName(String semisterName) {
        this.semisterName = semisterName;
    }
}
