package Controller;

import Data.Homepage.Donation;
import Data.Homepage.Partners.DonationsAtBusiness;
import JDBC.Receive;
import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Partners extends Controller{
    public void getDonatedByBusiness(){
        enableCORS("*", "*", "*");
        get("/partners/available/:bid", (request, response) -> {
            String bid = request.params(":bid");
            DonationsAtBusiness donationsAtBusiness = new DonationsAtBusiness();
            donationsAtBusiness.setSum(Receive.available(bid));
            Gson gson = new Gson();
            response.body(gson.toJson(donationsAtBusiness));
            return response.body();
        });
    }
}