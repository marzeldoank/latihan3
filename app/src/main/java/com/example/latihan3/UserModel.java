package com.example.latihan3;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    private String email;
    private String username;
    private String password;
    private String noHp;
    private String alamat;
    private Boolean isActive;


    public UserModel(String email, String username, String password, String noHp, String alamat, Boolean isActive) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.noHp = noHp;
        this.alamat = alamat;
        this.isActive = isActive;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getActive() {
        return isActive;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(email);
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(alamat);
        parcel.writeString(noHp);
        parcel.writeByte((byte) (isActive == null ? 0 : isActive ? 1 : 2));
    }
    protected UserModel(Parcel in) {
        email = in.readString();
        username = in.readString();
        password = in.readString();
        noHp = in.readString();
        alamat = in.readString();
        byte  isActiv = in.readByte();
        isActive = isActiv == 0 ? null : isActiv == 1;
    }
    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
