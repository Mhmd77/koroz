package com.myapps.koroz.view.fragments;

import android.app.AlertDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.myapps.koroz.R;
import com.myapps.koroz.service.model.ResultBattle;
import com.myapps.koroz.service.model.User;
import com.myapps.koroz.utils.ProgressBarAnimation;
import com.myapps.koroz.utils.UserHolder;
import com.myapps.koroz.viewmodel.GetUserViewModel;
import com.myapps.koroz.viewmodel.WinnerViewModel;
import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.levelBar)
    RoundCornerProgressBar levelBar;
    @BindView(R.id.powerBar)
    RoundedHorizontalProgressBar powerBar;
    @BindView(R.id.healthBar)
    RoundedHorizontalProgressBar healthBar;
    @BindView(R.id.speedBar)
    RoundedHorizontalProgressBar speedBar;
    @BindView(R.id.btnBattle)
    Button btnBattle;
    @BindView(R.id.txtLev)
    TextView txtLevel;
    @BindView(R.id.txtFullName)
    TextView txtFullName;
    private GetUserViewModel viewModel;
    private WinnerViewModel winnerViewModel;
    private ResultBattle result;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        viewModel = ViewModelProviders.of(this).get(GetUserViewModel.class);
        winnerViewModel = ViewModelProviders.of(this).get(WinnerViewModel.class);
        viewModel.getUser();
        observe();
        observeWinner();
        return view;
    }

    private void observeWinner() {
        winnerViewModel.getViewModel().observe(this, new Observer<ResultBattle>() {
            @Override
            public void onChanged(@Nullable ResultBattle resultBattle) {
                result = resultBattle;
                if (result == null) {
                    Log.e("My Tag", "ERROR");
                } else {
                    Log.i("My Tag", resultBattle.getWinner());
                    showWinner();
                }
            }
        });
    }

    private void showWinner() {
        final AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        View view = getLayoutInflater().inflate(R.layout.layout_dialog, null);
        TextView resultTxt = view.findViewById(R.id.txtResult);
        TextView txtXP = view.findViewById(R.id.txtXp);
        if (result.getWinner().equals(UserHolder.getOurInstance().getUser().getFullName())) {
            resultTxt.setText(getString(R.string.win_title));
            resultTxt.setTextColor(ContextCompat.getColor(getActivity(), R.color.green));
            txtXP.setVisibility(View.VISIBLE);
        } else {
            resultTxt.setText(getString(R.string.loose_title));
            resultTxt.setTextColor(ContextCompat.getColor(getActivity(), R.color.red));
            txtXP.setVisibility(View.INVISIBLE);
        }
        Button btn = view.findViewById(R.id.btnClos);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
                alertDialog.dismiss();
                viewModel.getUser();
            }
        });
        alertDialog.setView(view);
        alertDialog.show();
    }

    private void observe() {
        viewModel.getViewModel().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                UserHolder.getOurInstance().setUser(user);
                setUserFields();
            }
        });
    }

    private void setUserFields() {
        User myUser = UserHolder.getOurInstance().getUser();
        levelBar.setProgress(calXp(myUser.getXp(), myUser.getLevels()));
        /*speedBar.setProgress(myUser.getSpeed());
        healthBar.setProgress(myUser.getHealth());
        powerBar.setProgress(myUser.getPower());*/
        txtLevel.setText("مرحله: " + String.valueOf(myUser.getLevels()));
        if (myUser.getBattleCounts() >= 3) {
            btnBattle.setEnabled(false);
        }
        //
        ProgressBarAnimation anim3 = new ProgressBarAnimation(powerBar, 0, myUser.getPower());
        anim3.setDuration(1000);
        powerBar.startAnimation(anim3);

        //
        ProgressBarAnimation anim2 = new ProgressBarAnimation(healthBar, 0, myUser.getHealth());
        anim2.setDuration(1000);
        healthBar.startAnimation(anim2);
        //
        ProgressBarAnimation anim = new ProgressBarAnimation(speedBar, 0, myUser.getSpeed());
        anim.setDuration(1000);
        speedBar.startAnimation(anim);
    }

    private float calXp(int xp, int levels) {
        int[] arrLevels = {0, 8, 24, 56, 120, 248, 504, 1016};
        levelBar.setMax(arrLevels[levels]);
        Log.i("My Tag", xp + "   " + levels);
        return xp - arrLevels[levels - 1];
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnBattle)
    public void onViewClicked() {
        winnerViewModel.battle();
    }
}
