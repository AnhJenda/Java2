package Day1.exercise.exercise3;

/*
    @author: Dinh Quang Anh
    Date   : 4/26/2022
    Project: Java2
*/
public class cafe {
    private String cofName;
    private String cofID;
    private double cofPrice;
    private String size;

    public cafe(String cofName, String cofID, double cofPrice, String size){
        this.cofName = cofName;
        this.cofID = cofID;
        this.cofPrice = cofPrice;
        this.size = size;
    }

    public String getCofName() {
        return cofName;
    }
    public String getCofID() {
        return cofID;
    }
    public double getCofPrice() {
        return cofPrice;
    }
     public String getSize() {
        return size;
     }

     public void setCofName(String cofName) {
        this.cofName = cofName;
     }
     public void setCofID(String cofID) {
        this.cofID = cofID;
     }
     public void setCofPrice(double cofPrice) {
        this.cofPrice = cofPrice;
     }
     public void setSize(String size) {
        this.size = size;
     }

    @Override
    public String toString() {
        return "cafe{" +
                "cofName='" + cofName + '\'' +
                ", cofID='" + cofID + '\'' +
                ", cofPrice=" + cofPrice +
                ", size='" + size + '\'' +
                '}';
    }
}
