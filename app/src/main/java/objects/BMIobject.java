package objects;

/**
 * Created by Tomas on 9/10/2017.
 */

public class BMIobject {

    private int id;
    private String date;
    private String val;

    public BMIobject(int id, String date, String val){
        this.id = id;
        this.date = date;
        this.val = val;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
