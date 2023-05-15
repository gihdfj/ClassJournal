package com.example.classjournal;

import static android.text.TextUtils.substring;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.classjournal.databinding.ActivityDashboardAdminBinding;
import com.example.classjournal.databinding.ActivityMainBinding;
import com.example.classjournal.databinding.RowClassBinding;

import java.util.ArrayList;

public class DashboardAdminActivity extends AppCompatActivity {
    final Context context = this;
    private ActivityDashboardAdminBinding binding;
    private ArrayList<ClassRoom> classRoomArrayList = new ArrayList<ClassRoom>();
    private AdapterClass adapterClass;
    private RecyclerView recView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recView = findViewById(R.id.recView);
//Добавляем слушателя нажатий по кнопке Button:
        binding.addClassBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //Получаем вид с файла prompt.xml, который применим для диалогового окна:
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.addclass_prompt, null);


                //Создаем AlertDialog
                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);

                //Настраиваем prompt.xml для нашего AlertDialog:
                mDialogBuilder.setView(promptsView);

                //Настраиваем отображение поля для ввода текста в открытом диалоге:
                final EditText userInput = (EditText) promptsView.findViewById(R.id.input_text);
                //Настраиваем сообщение в диалоговом окне:
                mDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        //Вводим текст и отображаем в строке ввода на основном экране

                                        String s = String.valueOf(userInput.getText());
//                                        String s1 = null,s2 = null;
//                                        for(int i = 0; i < s.length(); i++)
//                                        {
//                                            if(s.charAt(i) == ' ')
//                                            {
//                                                s1 = s.substring(0, i);
//                                                s2 = s.substring(i);
//                                            }
//                                        }
                                        classRoomArrayList.add(new ClassRoom(s,10));
                                        recView= findViewById(R.id.recView);
                                        ClassRoomAdapter classRoomAdapter = new ClassRoomAdapter(context, classRoomArrayList);
                                        recView.setLayoutManager(new LinearLayoutManager(context));
                                        recView.setAdapter(classRoomAdapter);


                                    }
                                }).setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });
                //Создаем AlertDialog:
                AlertDialog alertDialog = mDialogBuilder.create();

                //и отображаем его:
                alertDialog.show();
            }
        });
    }


}