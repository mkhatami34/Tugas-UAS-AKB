/*
 *   NIM : 10119026
 *   NAMA : Muhammad Khatami
 *   KELAS : IF-1
 * */

package khatami.belajar.uasakb10119026.ui.diary;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import khatami.belajar.uasakb10119026.R;
import khatami.belajar.uasakb10119026.models.DiaryModel;

import java.util.ArrayList;
import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder> {

    private Activity activity;
    private List<DiaryModel> diaryList = new ArrayList<DiaryModel>();

    DiaryAdapter(Activity activity, List<DiaryModel> diaryList){
        this.activity = activity;
        this.diaryList = diaryList;
    }

    @NonNull
    @Override
    public DiaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new DiaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryViewHolder holder, int position) {
        holder.title.setText(String.valueOf(diaryList.get(position).getTitle()));
        holder.category.setText(String.valueOf(diaryList.get(position).getCategory()));
        holder.date.setText(String.valueOf(diaryList.get(position).getDate()).substring(0,10));

        holder.diaryItem.setOnClickListener(view -> {
            Intent intent = new Intent(activity, UpdateDiaryActivity.class);
            intent.putExtra("id", String.valueOf(diaryList.get(position).getId()));
            intent.putExtra("title", String.valueOf(diaryList.get(position).getTitle()));
            intent.putExtra("category", String.valueOf(diaryList.get(position).getCategory()));
            intent.putExtra("note", String.valueOf(diaryList.get(position).getNote()));
            intent.putExtra("date", String.valueOf(diaryList.get(position).getDate()));
            activity.startActivityForResult(intent, 1);
        });

    }

    @Override
    public int getItemCount() {
        if(diaryList != null) return diaryList.size();
        return 0;
    }

    class DiaryViewHolder extends RecyclerView.ViewHolder{
        TextView title, category, date;
        LinearLayout diaryItem;

        DiaryViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_title);
            category = itemView.findViewById(R.id.text_category);
            date = itemView.findViewById(R.id.text_date);
            diaryItem = itemView.findViewById(R.id.diaryItem);
        }
    }
}
