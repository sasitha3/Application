package com.varunarl.myapplication.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by varunarl on 3/17/18.
 */

public class PinDetails {

    @SerializedName("id")
    private Integer mId;
    @SerializedName("accountName")
    private String mAccountName;
    @SerializedName("pin")
    private String mPin;
    @SerializedName("description")
    private String mDescription;



//    public JSONObject toJson(){
//        JSONObject jsonObject = new JSONObject();
//        try {
//            if (this.getId() != null)
//                jsonObject.put("id",this.getId());
//
//            jsonObject.put("title",this.getTitle());
//            jsonObject.putOpt("rating", this.getRating());
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return jsonObject;
//    }

//    public static PinDetails fromJson(JSONObject jsonObject){
//        PinDetails brand = new PinDetails();
//        try {
//            brand.setId(jsonObject.getInt("id"));
//            brand.setTitle(jsonObject.getString("title"));
//            brand.setRating(jsonObject.getInt("rating"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return brand;
//    }

    public PinDetails clone() {
        PinDetails clonedPinDetails = new PinDetails();
        clonedPinDetails.setId(this.getId());
        clonedPinDetails.setAccountName(this.getAccountName());
        clonedPinDetails.setPin(this.getPin());
        clonedPinDetails.setDescription(this.getDescription());
        return clonedPinDetails;

    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer mId) {
        this.mId = mId;
    }

    public String getAccountName() {
        return mAccountName;
    }

    public void setAccountName(String mAccountName) {
        this.mAccountName = mAccountName;
    }

    public String getPin() {
        return mPin;
    }

    public void setPin(String mPin) {
        this.mPin = mPin;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
