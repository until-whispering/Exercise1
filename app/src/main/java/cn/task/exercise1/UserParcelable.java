package cn.task.exercise1;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class UserParcelable implements Parcelable{
    String name;

    public UserParcelable(String name) {
        this.name = name;
    }

    protected UserParcelable(Parcel in) {
        name = in.readString();
    }

    public static final Creator<UserParcelable> CREATOR = new Creator<UserParcelable>() {
        @Override
        public UserParcelable createFromParcel(Parcel in) {
            return new UserParcelable(in);
        }

        @Override
        public UserParcelable[] newArray(int size) {
            return new UserParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }

    @Override
    public String toString() {
        return "UserParcelable{" +
                "name='" + name + '\'' +
                '}';
    }
}
