import java.util.Date;

public class Log {
    private Date date = new Date();
    private String status;
    //private attribute
    //default constructor
    public Log() {

    }
    //parameter constructor
    public Log(String status) {
        this.status = status;

    }

    //setter and getter
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //String
    @Override
    public String toString() {
        return "\n" + date + "\n" + status + "\n";
    }
}
