package sg.edu.rp.c346.id19023702.week2lp1;

import java.io.Serializable;

public class Task  {
    private String Desc;
    private String Date;

    public Task(String Desc, String Date) {
        this.Desc = Desc;
        this.Date = Date;
    }

    public String getDesc() {
        return Desc;
    }

    public String getDate() {
        return Date;
    }
}


