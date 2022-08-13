/*
 *   NIM : 10119026
 *   NAMA : Muhammad Khatami
 *   KELAS : IF-1
 * */

package khatami.belajar.uasakb10119026.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import khatami.belajar.uasakb10119026.R;
import khatami.belajar.uasakb10119026.models.AboutItemModel;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    ViewPager2 viewPager2;
    List<AboutItemModel> aboutList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        viewPager2 = view.findViewById(R.id.viewpager);
        aboutList = new ArrayList<>();

        int[] image = {R.drawable.android, R.drawable.android, R.drawable.argya};
        String[] judul = {"Version", "About", "Made by"};
        String[] desc = {"1.0.0", "This application was made with the aim of fulfilling one of the Aplikasi Komputasi Bergerak course assignments", "10119035_Argya Aulia Fauzandika"};

        for (int i=0; i < image.length; i++){
            AboutItemModel item = new AboutItemModel(image[i], judul[i], desc[i]);
            aboutList.add(item);
        }

        ViewPagerAboutAdapter adapter = new ViewPagerAboutAdapter(aboutList);

        viewPager2.setAdapter(adapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}