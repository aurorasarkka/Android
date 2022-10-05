package com.example.android.ui.notifications;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.android.R;
import com.example.android.databinding.FragmentNotificationsBinding;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private CountDownTimer cdt;
    int valueOnPicker1 = 0;
    NumberPicker numPicker;
    private MaterialButtonToggleGroup materialButtonToggleGroup;
    public static final String TAG ="OH NO";
    private TextView textView;
    Uri ringtoneUri;
    Ringtone alarm;
    Animation animation;
    int pauseTime;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);




        String[] myValues = new String[61];
        for (int i = 0; i < myValues.length; i++) {
            myValues[i] = i+ " s";
        }
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textNotifications;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

       ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
       alarm = RingtoneManager.getRingtone(getContext(), ringtoneUri);

        animation = AnimationUtils.loadAnimation(getContext(), R.anim.animation2);

        pauseTime = 0;
        textView = root.findViewById(R.id.notifications);
        numPicker = root.findViewById(R.id.numberPicker);
        numPicker.setDisplayedValues(myValues);
        numPicker.setMinValue(0);
        numPicker.setMaxValue(60);
        numPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                valueOnPicker1 = numberPicker.getValue();
                Log.e(TAG, "painettu" + "");
            }
        });

        materialButtonToggleGroup = root.findViewById(R.id.toggleGroup);
        materialButtonToggleGroup.addOnButtonCheckedListener(
                new MaterialButtonToggleGroup.OnButtonCheckedListener() {
                    @Override
                    public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                        if (isChecked) {
                            if (checkedId == R.id.btn1) {
                                Log.e(TAG, "pause painettu" + String.valueOf(numPicker.getValue()));
                                //numPicker.getValue();
                                cdt.cancel();
                                textView.setText("paused!");




                            } else if (checkedId == R.id.btn2) {
                                Log.e(TAG, "start painettu" + String.valueOf(numPicker.getValue()));
                                int startTime = 0;
                                if(pauseTime > 0) {
                                    startTime = pauseTime;
                                }else {

                                    startTime =  numPicker.getValue() * 1000;

                                }
                                cdt = new CountDownTimer(startTime, 1000) {
                                    @Override
                                    public void onTick(long l) {
                                        textView.setText("seconds remaining: " + l / 1000);
                                        pauseTime = (int) l;

                                    }


                                    @Override
                                    public void onFinish() {
                                        textView.setText("end!");
                                        alarm.play();
                                        binding.notifications.startAnimation(animation);

                                    }
                                }.start();


                            }




                            } else if (checkedId == R.id.btn3) {
                                Log.e(TAG, "stop painettu" + String.valueOf(numPicker.getValue()));
                                numPicker.setValue(0);
                                cdt.cancel();
                                alarm.stop();
                                binding.notifications.clearAnimation();
                                textView.setText("Stopped!");

                            }

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


