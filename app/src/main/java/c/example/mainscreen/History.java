package c.example.mainscreen;

public class History {
    private  String Date;
    private  String Time;
    private  String Name;
    private  String Notes;
    private  String Address;
    private  String Payment;
    private  String Phone;


    public History(String date, String time, String name, String notes, String address, String payment, String phone) {
        Date = date;
        Time = time;
        Name = name;
        Notes = notes;
        Address = address;
        Payment = payment;
        Phone = phone;
    }

    public History() {

    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String payment) {
        Payment = payment;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
