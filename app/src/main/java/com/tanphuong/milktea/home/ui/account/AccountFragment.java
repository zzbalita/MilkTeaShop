package com.tanphuong.milktea.home.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.tanphuong.milktea.authorization.data.UserFetcher;
import com.tanphuong.milktea.authorization.data.model.User;
import com.tanphuong.milktea.authorization.ui.SignInActivity;
import com.tanphuong.milktea.databinding.FragmentAccountBinding;
import com.tanphuong.milktea.home.ui.HomeActivity;

public class AccountFragment extends Fragment {

    private FragmentAccountBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        UserFetcher.fetchUserInfo(new UserFetcher.Callback() {
            @Override
            public void onLoaded(User userInfo) {
                binding.tvUserName.setText(userInfo.getUserName());
                binding.tvPhoneNumber.setText(userInfo.getPhoneNumber());
                binding.tvEmail.setText(userInfo.getEmail());
                binding.tvAddress.setText(userInfo.getAddress());
            }

            @Override
            public void onFailed() {

            }
        });

        binding.btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), SignInActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}