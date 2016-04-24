package students.alvas.school.alvas;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import apis.Students;
import apis.gitapi;
import butterknife.ButterKnife;
import butterknife.InjectView;
import model.StudentDetail;
import model.gitmodel;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StudentProfile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StudentProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentProfile extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @InjectView(R.id.student_name)
    TextView student_name;

    @InjectView(R.id.student_username)
    TextView student_usernamename;

    @InjectView(R.id.student_collegename)
    TextView student_college;

    @InjectView(R.id.student_dob)
    TextView student_dob;

    @InjectView(R.id.student_chakravyuh_id)
    TextView student_id;

    @InjectView(R.id.student_number)
    TextView student_contact_number;

    @InjectView(R.id.student_events)
    TextView student_events;


    ImageButton navigateToEventList;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public StudentProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentProfile newInstance(String param1, String param2) {
        StudentProfile fragment = new StudentProfile();
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

        View view =inflater.inflate(R.layout.fragment_student_profile, container, false);
        ButterKnife.inject(this, view);



        String API = "http://192.168.0.105";

        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(API).build();

        Students students = restAdapter.create(Students.class);
        String user="student.php?code="+"1234";
        students.getStudent(user, new Callback<StudentDetail>() {

            @Override
            public void success(StudentDetail student, Response response) {


                Toast.makeText(getActivity(), "Success /n " + response, Toast.LENGTH_SHORT).show();

                Toast.makeText(getActivity(), "Github Name :" + student.getName() + "\nWebsite :" + student.getCollege(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void failure(RetrofitError error) {
            }
        });




        Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "fonts/luckiest_guy.ttf");

        student_events.setTypeface(face);
        student_name.setTypeface(face);


        

        student_college.setTypeface(face);
        student_contact_number.setTypeface(face);

        student_name.setText("Sandeep Singh");


        navigateToEventList= (ImageButton)view.findViewById(R.id.geteventlist);

        navigateToEventList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Students_event_fragment displayEvents =new Students_event_fragment();
                android.app.FragmentManager fragmanager =getFragmentManager();
                FragmentTransaction fragmentTransaction =fragmanager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentspace, displayEvents);
                fragmentTransaction.commit();
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
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
