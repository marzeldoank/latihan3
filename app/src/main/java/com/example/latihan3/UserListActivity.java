package com.example.latihan3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.latihan3.databinding.ActivityUserListBinding;
import com.example.latihan3.databinding.ItemUserListBinding;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity implements RecyclerAdapterUserListener {

    private ActivityUserListBinding binding;
    private BaseRecyclerAdapter<UserModel> baseRvUserAdapter;

    private List<UserModel> userModelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_user_list);

        UserModel userModelA = new UserModel("email A", "username A","password A", "noHp A", " alamat A", true);
        UserModel userModelB = new UserModel("email B", "username B","password B", "noHp B", " alamat B", true);
        UserModel userModelC = new UserModel("email C", "username C","password C", "noHp C", " alamat C", false);
        UserModel userModelD = new UserModel("email D", "username D","password D", "noHp D", " alamat D", false);
        UserModel userModelE = new UserModel("email E", "username E","password E", "noHp E", " alamat E", true);

//        for (int i=0;i<datajson;i++){
//            UserModel userModelA = new UserModel(datajson[i]);
//            userModelList.add(userModelA);
//        }
        userModelList.add(userModelA);
        userModelList.add(userModelB);
        userModelList.add(userModelC);
        userModelList.add(userModelD);
        userModelList.add(userModelE);

//        rvUserAdapter = new RecyclerAdapterUser(userModelList);
//        rvUserAdapter.setListener(this);


        baseRvUserAdapter = new BaseRecyclerAdapter<>(
                userModelList,
                R.layout.item_user_list,
                ((viewHolder, userModel) -> {
                    ItemUserListBinding binding = (ItemUserListBinding) viewHolder.getBinding();
                    binding.setUseModel(userModel);
                    binding.cvMain.setOnClickListener(onClick -> onUserSelected(userModel));
                })
        );

        binding.setUserAdapater(baseRvUserAdapter);



    }

    @Override
    public void onUserSelected(UserModel userModel) {
        Log.v("user name", userModel.getUsername());
        Intent intent = new Intent(UserListActivity.this, UserDetailActivity.class);

//        intent.putExtra("username",userModel.getUsername());
//        intent.putExtra("email",userModel.getEmail());
//        intent.putExtra("password",userModel.getPassword());
        intent.putExtra("userModel",userModel);


        startActivity(intent);

    }
}