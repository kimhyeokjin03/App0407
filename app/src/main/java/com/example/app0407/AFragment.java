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
 * Use the {@link AFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AFragment() {
        // Required empty public constructor
    }

    public static AFragment newInstance(String param1, String param2) {
        AFragment fragment = new AFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.fragment_a, container, false);
        Button btn = vg.findViewById(R.id.button);
        EditText et = vg.findViewById(R.id.editTextText);
        EditText et2 = vg.findViewById(R.id.editTextText3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //BFragment bFragment = BFragment.newInstance(et.getText().toString());       // new 생성자 사용X
                BFragment bFragment = new BFragment();
                Bundle args = new Bundle();
                args.putString("name", et.getText().toString());
                args.putInt("grade", Integer.parseInt(et2.getText().toString()));
                bFragment.setArguments(args);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, bFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        getParentFragmentManager().setFragmentResultListener
                ("requestKey", this, (requestKey, result) -> {
            //EditText et = vg.findViewById(R.id.editTextText2);
            et.setText(result.getString("result"));
        });

        return vg;
    }
}

/*
    newInstance 생성자 사용 이유

    .addToBackStack -> BackStack을 할 때 받아주는 역할을 함  name은 NULL

    setFragmentResultListener -> 결과값에 추가적으로 내용이 붙어 리턴하는 경우를 확인하기 위함

 */