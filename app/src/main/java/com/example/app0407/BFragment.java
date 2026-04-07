package com.example.app0407;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static BFragment newInstance(String param1) {
        BFragment fragment = new BFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.fragment_b, container, false);
        EditText et = vg.findViewById(R.id.editTextText2);
        EditText et2 = vg.findViewById(R.id.editTextText4);
        Bundle args = getArguments();
        et.setText(args.getString("name") + " : " + args.getInt("grade"));
        //et.setText(mParam1);
        // Inflate the layout for this fragment
        Button btn = vg.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("result", et.getText().toString()+ " : " +et2.getText().toString());
                getParentFragmentManager().setFragmentResult("requestKey", args);
                getParentFragmentManager().popBackStack();
            }
        });

        return vg;
    }
}

/*
    (ViewGroup)으로 캐스팅하는 이유

    popBackStack() -> 메모리 상에서 뒤로 가는 경우에 사용      ※ new 생성자로 AFragment에 대해 추가 생성하면 스택 상에서 별도로 위에 쌓여 다른 객체가 됨
*/