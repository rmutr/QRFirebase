package masterung.androidthai.in.th.qrfirebase.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import masterung.androidthai.in.th.qrfirebase.R;

/**
 * Created by masterung on 4/3/2018 AD.
 */

public class GetMultiDataFragment extends Fragment{

    private String resultString;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get All Weight
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Object> stringObjectMap = (Map<String, Object>) dataSnapshot.getValue();
                resultString = String.valueOf(stringObjectMap.get("Weight"));
                Log.d("4MarchV1", "ResultString ==> " + resultString);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }   // Main Method

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_data, container, false);
        return view;
    }
}
