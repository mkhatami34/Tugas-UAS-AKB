/*
 *   NIM : 10119035
 *   NAMA : Muhammad Khatami
 *   KELAS : IF-1
 * */

package khatami.belajar.uasakb10119026.ui.diary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import khatami.belajar.uasakb10119026.R;
import khatami.belajar.uasakb10119026.helper.DatabaseHelper;
import khatami.belajar.uasakb10119026.models.DiaryModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DiaryFragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empty_imageView;
    TextView noData;

    DatabaseHelper db;
    List<DiaryModel> diaryList;
    DiaryAdapter diaryAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        add_button = view.findViewById(R.id.fab);
        empty_imageView = view.findViewById(R.id.empty_imageview);
        noData = view.findViewById(R.id.no_data);

        add_button.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), AddDiaryActivity.class);
            startActivity(intent);
        });

        db = new DatabaseHelper(getActivity());
        diaryList = new ArrayList<>();

        storeDataInListModel();

        diaryAdapter = new DiaryAdapter(getActivity(), diaryList);
        recyclerView.setAdapter(diaryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public void storeDataInListModel(){
        Cursor cursor = db.getAllData();
        if(cursor.getCount() == 0){
            empty_imageView.setVisibility(View.VISIBLE);
            noData.setVisibility(View.VISIBLE);
        }else{
            while(cursor.moveToNext()){

                System.out.println(cursor.getString(0));
                System.out.println(cursor.getString(1));
                System.out.println(cursor.getString(2));
                System.out.println(cursor.getString(3));
                System.out.println(cursor.getString(4));

                DiaryModel diary = new DiaryModel(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );

                diaryList.add(diary);

            }
            empty_imageView.setVisibility(View.GONE);
            noData.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}