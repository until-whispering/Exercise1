package cn.task.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import cn.task.exercise1.inject.Nh;

@Nh(value = 1,id = "2")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //InjectUtils.injectAutowired(this);

        ArrayList<UserParcelable> userParcelableList = new ArrayList<>();

        userParcelableList.add(new UserParcelable("Jerry"));
        Intent intent = new Intent(this,SecondActivity.class)
                .putExtra("name","nh")
                .putExtra("attr","handsome")
                .putExtra("array",new int[]{1,2,3,4})
                .putExtra("userParcelable",new UserParcelable("NH"))
                .putExtra("userParcelables",new UserParcelable[]{new UserParcelable("CloudLuo")})
                .putExtra("user",new UserSerializable[]{new UserSerializable("Tom")})
                .putExtra("strs",new String[]{"1","2"})
                .putParcelableArrayListExtra("userParcelableList",userParcelableList);
        startActivity(intent);
    }
}