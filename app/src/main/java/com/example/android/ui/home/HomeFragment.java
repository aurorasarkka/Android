package com.example.android.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.android.GameActivity;
import com.example.android.Interface;
import com.example.android.R;
import com.example.android.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

private FragmentHomeBinding binding;
    private Button welcomeButton;
    private View welcomeTextView;
    public static final String TAG = "MyAppMessage";
    private Button gameButton;
    private Button ytjButton;



    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        welcomeButton = root.findViewById(R.id.hello_button);
        welcomeTextView = root.findViewById(R.id.textView);
        Log.i(TAG, "activating play view");
        welcomeButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                handleClickEvents(v);
            }
        });
        gameButton = root.findViewById(R.id.game_button);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handleClickEvents(view);
            }

            public void OnClick(View v){
                handleClickEvents(v);
            }



        });

        ytjButton = root.findViewById(R.id.ytj_button);
        ytjButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                handleClickEvents(view);
            }

            public void OnClick(View v){
                handleClickEvents(v);
            }



        });




        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void handleClickEvents(View v) {
        switch (v.getId()) {
            case R.id.game_button:
                Intent i = new Intent( getActivity(), GameActivity. class);
                startActivity(i);
                break;
            case R.id.ytj_button:
                Intent  I= new Intent( getActivity(), Interface. class);
                startActivity(I);
                break;
            case R.id.hello_button:
                if (welcomeTextView.getVisibility() == View.VISIBLE)
                    welcomeTextView.setVisibility(View.INVISIBLE);

                else if (welcomeTextView.getVisibility() == View.INVISIBLE)
                    welcomeTextView.setVisibility(View.VISIBLE);
                break;
            default:

        }

    }
}