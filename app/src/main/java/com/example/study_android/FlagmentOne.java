package com.example.study_android;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FlagmentOne extends Fragment {
    View view;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Lifecycle", "FlagmentOne : onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Lifecycle", "FlagmentOne : onCreate");
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Lifecycle", "FlagmentOne : onActivityCreated");

        int number = getArguments().getInt("BUNDLE_KEY");
        Log.d("test", ""+number);

        Button button = view.findViewById(R.id.fragment_one_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test", "button");

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Lifecycle", "FlagmentOne : onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Lifecycle", "FlagmentOne : onPause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Lifecycle", "FlagmentOne : onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "FlagmentOne : onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Lifecycle", "FlagmentOne : onDetach");
    }
}
