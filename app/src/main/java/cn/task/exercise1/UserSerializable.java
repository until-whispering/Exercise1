package cn.task.exercise1;

import android.os.Parcelable;

import java.io.Serializable;

public class UserSerializable implements  Serializable {
    String name;

    public UserSerializable(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserSerializable{" +
                "name='" + name + '\'' +
                '}';
    }
}
