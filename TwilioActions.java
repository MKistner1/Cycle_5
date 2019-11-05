package contacts;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 * Declares the variables needed to connect to the Twilio generated number
 * @author Owner
 */
public class TwilioActions {
    public static final String accountID = "AC50c1770ed4df7d280604159670973ad3";
    public static final String authToken = "ee20e7c96ed2e5743520bd4217a2d753";
    public static String phoneNum = "";
    //allows you to initiate the class with your own input for the reveiving number
    public TwilioActions(String number){
        phoneNum = number;
    }
    /**
     * method the initializes the twilio account
     * then creates a message from the values given by the user in the textcontact page
     * @param name - name of the contact selected
     * @param number - number of the contact selected
     */
    public static void sendMessage(String name, String number){
        Twilio.init(accountID, authToken);
        PhoneNumber to = new PhoneNumber("+1"+phoneNum);
        PhoneNumber from = new PhoneNumber("+120134774757");
        Message m = Message.creator(to,from,"hello").create();
    }


}
