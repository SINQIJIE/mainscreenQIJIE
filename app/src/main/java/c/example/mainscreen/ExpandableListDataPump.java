package c.example.mainscreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> faq_one = new ArrayList<String>();
        faq_one.add("Our rule will not end until the epidemic is over.");

        List<String> faq_two = new ArrayList<String>();
        faq_two.add("You can contact us to cancel the service.");

        List<String> faq_three = new ArrayList<String>();
        faq_three.add("Please notify us an hour and a half before the appointment time.");

        List<String> faq_four = new ArrayList<String>();
        faq_four.add("Just in case, there have been customers who have ordered our service, but they missed the appointment.");

        List<String> faq_five = new ArrayList<String>();
        faq_five.add("The dyes we use are all natural and will not cause scalp problems. If accidents happen, we must take full responsibility.");

        List<String> faq_six = new ArrayList<String>();
        faq_six.add("Of course you can, but you must notify one and a half hours in advance.");

        expandableListDetail.put("~When will the rule that a customer can only book one service ends?", faq_one);
        expandableListDetail.put("~What if I want to cancel the service?", faq_two);
        expandableListDetail.put("~What should I do if I cannot make the appointment on the booking day?", faq_three);
        expandableListDetail.put("~Why do I have to give a deposit to book the service?", faq_four);
        expandableListDetail.put("~If I use your dyes and cause scalp sensitivity, what would you do?", faq_five);
        expandableListDetail.put("~If I cancel the booking service, can I still get my deposit back?", faq_six);
        return expandableListDetail;
    }
}