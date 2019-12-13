package com.example.loginbegin.Fragments;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.example.loginbegin.Activity.SettingActivity;
import com.example.loginbegin.Activity.BookCollectionActivity;
import com.example.loginbegin.utils.AnalysisUtils;
import com.example.loginbegin.Activity.LoginActivity;
import com.example.loginbegin.R;

public class UserFragment extends Fragment implements View.OnClickListener {
    private LinearLayout llHead;
    private RelativeLayout rlBookCollection, rlSetting;
    private ImageView ivHeadIcon, ivBookCollectionIcon, ivUserInfoIcon;
    private TextView tvUserName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        llHead = (LinearLayout) view.findViewById(R.id.ll_head);
        ivHeadIcon = (ImageView) view.findViewById(R.id.iv_head_icon);
        tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
        rlBookCollection = (RelativeLayout) view.findViewById(R.id.rl_book_collection);
        ivBookCollectionIcon = (ImageView) view.findViewById(R.id.iv_book_collection_icon);
        rlSetting = (RelativeLayout) view.findViewById(R.id.rl_setting);
        ivUserInfoIcon = (ImageView) view.findViewById(R.id.iv_userInfo_icon);

        if (AnalysisUtils.readLoginStatus(getActivity())){
            tvUserName.setText(AnalysisUtils.readLoginUserName(getActivity()));
        }else {
            tvUserName.setText("点击登录");
        }


        llHead.setOnClickListener(this);
        rlBookCollection.setOnClickListener(this);
        rlSetting.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_head:
                if (AnalysisUtils.readLoginStatus(getActivity())){
                    //跳转到个人资料界面
                }else {
                    //跳转到登录界面
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    getActivity().startActivityForResult(intent,1); }
                break;
            case R.id.rl_book_collection:
                if (AnalysisUtils.readLoginStatus(getActivity())){
                    //跳转到播放记录页面
                    Intent intent=new Intent(getActivity(), BookCollectionActivity.class);
                    getActivity().startActivityForResult(intent,1);
                }else {
                    Toast.makeText(getActivity(), "Please log in first.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rl_setting:
                if (AnalysisUtils.readLoginStatus(getActivity())){
                    Intent intent=new Intent(getActivity(), SettingActivity.class);
                    getActivity().startActivityForResult(intent,1);
                }else {
                    Toast.makeText(getActivity(), "Please log in first.", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

}
