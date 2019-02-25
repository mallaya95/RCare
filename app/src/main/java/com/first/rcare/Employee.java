package com.first.rcare;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Employee.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Employee#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Employee extends Fragment {
    Button b1,b2,b3,b4,b5,b6;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Employee() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Employee.
     */
    // TODO: Rename and change types and number of parameters
    public static Employee newInstance(String param1, String param2) {
        Employee fragment = new Employee();
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
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_employee, container, false);
        final AppCompatActivity activity = (AppCompatActivity) getContext();
        b1=(Button)view.findViewById(R.id.moffice);
        b1.setTransformationMethod(null);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment myFragment = new currentorg();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame, myFragment).addToBackStack(null).commit();
            }
        });
        b2=(Button)view.findViewById(R.id.clerical);
        b2.setTransformationMethod(null);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment myFragment = new currentorg();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame, myFragment).addToBackStack(null).commit();
            }
        });

        b3=(Button)view.findViewById(R.id.senioroff);
        b3.setTransformationMethod(null);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment myFragment = new currentorg();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame, myFragment).addToBackStack(null).commit();
            }
        });
        b4=(Button)view.findViewById(R.id.Mang);
        b4.setTransformationMethod(null);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment myFragment = new currentorg();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame, myFragment).addToBackStack(null).commit();
            }
        });
        b5=(Button)view.findViewById(R.id.Seniormang);
        b5.setTransformationMethod(null);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment myFragment = new currentorg();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame, myFragment).addToBackStack(null).commit();
            }
        });
        b6=(Button)view.findViewById(R.id.topmang);
        b6.setTransformationMethod(null);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment myFragment = new currentorg();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame, myFragment).addToBackStack(null).commit();
            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
//        else {
//
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
