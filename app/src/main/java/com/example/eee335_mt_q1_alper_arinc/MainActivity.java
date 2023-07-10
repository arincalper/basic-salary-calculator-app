package com.example.eee335_mt_q1_alper_arinc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;

public class MainActivity extends AppCompatActivity {


    private SharedPreferences sharedPref = null;

    EditText et_reg; // define the android id of EditText
    EditText et_over; // define the android id of EditText
    Button btn_go; // define the android id of Button
    RadioButton rd_intern;
    RadioButton rd_cleric;
    RadioButton rd_manager;
    TextView tv_salary;
    int fnl_salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        et_reg = findViewById(R.id.et_input_reg);
        et_over = findViewById(R.id.et_input_ot);
        btn_go = findViewById(R.id.button_alper);
        rd_intern = findViewById(R.id.radio_intern);
        rd_cleric = findViewById(R.id.radio_cleric);
        rd_manager = findViewById(R.id.radio_manager);
        tv_salary = findViewById(R.id.tv_salary);


        btn_go.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                new Thread() {
                    public void run() {


                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {


                                    String regular = et_reg.getText().toString();
                                    String overtime = et_over.getText().toString();

                                    if (rd_intern.isChecked()) {

                                        int r = 7;
                                        int o = 10;
                                        int salary_r = 7 * Integer.parseInt(regular);
                                        int salary_o = 10 * Integer.parseInt(overtime);
                                        int fnl_salary = salary_o + salary_r;
                                        String a = sharedPref.getString("Salary of Intern", String.valueOf(fnl_salary));
                                        tv_salary.setText("Salary is: $" + a);

                                    }
                                    else if (rd_cleric.isChecked()) {

                                        int r = 15;
                                        int o = 20;
                                        int salary_r = 15 * Integer.parseInt(regular);
                                        int salary_o = 20 * Integer.parseInt(overtime);
                                        int fnl_salary = salary_o + salary_r;
                                        String a = sharedPref.getString("Salary of Cleric", String.valueOf(fnl_salary));
                                        tv_salary.setText("Salary is: $" + a);

                                    }
                                    else if (rd_manager.isChecked()) {

                                        int r = 15;
                                        int o = 20;
                                        int salary_r = 25 * Integer.parseInt(regular);
                                        int salary_o = 30 * Integer.parseInt(overtime);
                                        int fnl_salary = salary_o + salary_r;
                                        String a = sharedPref.getString("Salary of Manager", String.valueOf(fnl_salary));
                                        tv_salary.setText("Salary is: $" + a);

                                    }


                                }
                            });
                            Thread.sleep(0);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }.start();




            }


        });


    }
}


