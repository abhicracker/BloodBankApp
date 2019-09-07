package touch.one.life.lifeonetouch.Utils;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import touch.one.life.lifeonetouch.POJO.BloodBanks;
import touch.one.life.lifeonetouch.POJO.Donor;
import touch.one.life.lifeonetouch.POJO.Emergency;
import touch.one.life.lifeonetouch.POJO.Helplines;

public interface APIService {

    @POST("regDonor")
    @FormUrlEncoded
    Call<Donor> regDonor(@Field("name") String name,
                         @Field("bg") String bg,
                         @Field("email") String email,
                         @Field("password") String password,
                         @Field("gender") String gender,
                         @Field("address") String address,
                         @Field("phone") String phone,
                         @Field("age") String age,
                         @Field("weight") String weight)
                             ;




    @POST("loginDonor")
    @FormUrlEncoded
    Call<Donor> loginDonor(@Field("email") String email,
                                 @Field("password") String password);

    @POST("getDonor")
    @FormUrlEncoded
    Call<Donor> getDonor(@Field("bg") String bg,
                               @Field("address") String address);

    @POST("getAllDonors")
    Call<Donor> getAllDonors();

    @POST("getAllhelplines")
    Call<Helplines> getAllHelplines();

    @POST("getAllEmergency")
    Call<Emergency> getAllEmergency();



    @POST("getAllbloodBanks")
    Call<BloodBanks> getBloodBanks();

/*


    @POST("lockStatus")
    @FormUrlEncoded
    Call<Status> lockStatus(@Field("status") String status,
                            @Field("rid") String rid
    );



    @POST("bookRoom")
    @FormUrlEncoded
    //bookRoom(cid,guestcount,room_no,chekindate,checkoutdate)
    Call<Booking> bookRoom(@Field("cid") String cid,
                           @Field("guestcount") String guestcount,
                           @Field("room_no") String room_no,
                           @Field("checkindate") String checkindate,
                           @Field("checkoutdate") String checkoutdate

    );

    @POST("updateCustomer")
    @FormUrlEncoded
    Call<Customer> updateCustomer(@Field("id") String id,
                                  @Field("pname") String name,
                                  @Field("age") String age,
                                  @Field("mobile") String mobile,
                                  @Field("pass") String pass,
                                  @Field("gender") String gender
    );
    @POST("getCustomer")
    @FormUrlEncoded
    Call<Customer> getCustomer(@Field("id") String id);

    @POST("getBookingbyCid")
    @FormUrlEncoded
    Call<JSONResponse> getBookingbyCid(@Field("cid") String cid);



    @POST("getAllNotifications")
    Call<Notification> getAllNotifications();



    @POST("getAllSos")
    Call<Sos> getAllSos();


    @POST("getAllServices")
    Call<Service> getAllServices();

    @POST("getAllEvents")
    Call<Event> getAllEvents();




    @POST("loginStaff")
    @FormUrlEncoded
    Call<Staff> loginStaff(@Field("uname") String uname,
                           @Field("pass") String pass);
*/




}
