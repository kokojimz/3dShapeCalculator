package com.example.a3dshapecalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PiramidaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PiramidaFragment extends Fragment {
    private EditText editTextLuasAlas;
    private EditText editTextTinggi;
    private TextView textViewHasil;
    private Button buttonHitung;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PiramidaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PiramidaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PiramidaFragment newInstance(String param1, String param2) {
        PiramidaFragment fragment = new PiramidaFragment();
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
        View view = inflater.inflate(R.layout.fragment_piramida, container, false);

        editTextLuasAlas = view.findViewById(R.id.luasAlas); // Assuming ID stays the same and hint text changes to 'Enter side of base'
        editTextTinggi = view.findViewById(R.id.tinggi);
        textViewHasil = view.findViewById(R.id.hasil);
        buttonHitung = view.findViewById(R.id.result);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextLuasAlas.getText().toString().isEmpty() && !editTextTinggi.getText().toString().isEmpty()) {
                    double sisi = Double.parseDouble(editTextLuasAlas.getText().toString());
                    double tinggi = Double.parseDouble(editTextTinggi.getText().toString());
                    double volume = hitungVolumePiramida(sisi, tinggi);
                    textViewHasil.setText(String.format(Locale.getDefault(), "Volume Piramida: %.2f", volume));
                } else {
                    textViewHasil.setText("Masukkan sisi dasar dan tinggi piramida!");
                }
            }
        });

        return view;
    }

    private double hitungVolumePiramida(double sisi, double tinggi) {
        return (sisi * sisi * tinggi) / 3.0;
    }
}