package c.example.mainscreen;

public class Payments {
    private String Name;
    private String Address;
    private String Phone;
    private String Notes;
    private String DeliveryMethod;
    private String PaymentMethod;
    //Name
    public String getName(){return Name;}
    public  void setName(String name){Name = name;}

    //Address
    public String getAddress(){return Address;}
    public void setAddress(String address){Address = address;}

    //Phone
    public String getPhone(){return Phone;}
    public void setPhone(String phone){Phone = phone;}

    //Notes
    public String getNotes(){return Notes;}
    public void setNotes(String notes){Notes = notes;}

    //RadioButtonDelivery
    public String getDeliveryMethod(){return DeliveryMethod;}
    public void setDeliveryMethod(String deliveryMethod){DeliveryMethod =deliveryMethod;}

    //RadioButtonPayment
    public String getPaymentMethod(){return PaymentMethod;}
    public void setPaymentMethod(String paymentMethod){PaymentMethod = paymentMethod;}
}
