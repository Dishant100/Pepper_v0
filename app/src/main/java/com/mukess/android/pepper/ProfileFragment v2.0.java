package com.mukess.android.pepper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {
    Button signoutbtn,creditsbtn;
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

       //Sign out Button
        signoutbtn = (Button) rootView.findViewById(R.id.button8);
        signoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
            }
        });

       // Get User Details
        textView = rootView.findViewById(R.id.textView);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email
            if(user.getDisplayName() != null) {
                textView.setText("Signed In as : ");
                textView.append((CharSequence) user.getDisplayName());
            }
            //email = user.getEmail();
           }

        //Displaying Credits
        creditsbtn = rootView.findViewById(R.id.button9);
        creditsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(getActivity().getApplication(), Credits.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
