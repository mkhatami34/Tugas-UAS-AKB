/*
 *   NIM : 10119026
 *   NAMA : Muhammad Khatami
 *   KELAS : IF-1
 * */


package khatami.belajar.uasakb10119026.ui.diary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import khatami.belajar.uasakb10119026.MainActivity;
import khatami.belajar.uasakb10119026.R;
import khatami.belajar.uasakb10119026.DatabaseHelper;
import khatami.belajar.uasakb10119026.models.DiaryModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddDiaryActivity extends AppCompatActivity {

    EditText title_input,category_input, note_input;
    String date_input;
    //    Utils utils;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary);

        title_input = findViewById(R.id.title_input);
        category_input = findViewById(R.id.category_input);
        note_input = findViewById(R.id.note_input);
        date_input = getDateNow();
//        date_input = DateFormat.getDateInstance().format(Calendar.getInstance().getTime());
        System.out.println(date_input);
        addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(view -> {
            DatabaseHelper db = new DatabaseHelper(AddDiaryActivity.this);
            DiaryModel diary = new DiaryModel("id",
                    title_input.getText().toString().trim(),
                    category_input.getText().toString().trim(),
                    note_input.getText().toString().trim(),
                    date_input.trim());

            db.addDiary(diary);

            Intent intent = new Intent(AddDiaryActivity.this, MainActivity.class);
//            buat clear activity sebelumnya
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }

    public String getDateNow(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(new Date());
    }
}