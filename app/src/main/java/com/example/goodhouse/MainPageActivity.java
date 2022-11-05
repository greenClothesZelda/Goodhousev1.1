package com.example.goodhouse;

import android.app.Dialog;
import android.graphics.Color;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class MainPageActivity extends AppCompatActivity {
    private LineChart chart;
    private Button complaintButton;
    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        chart = findViewById(R.id.linechart);
        complaintButton = findViewById(R.id.complaintbutton);
        dialog = new Dialog(MainPageActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.complaintdialog);

        complaintButton.setOnClickListener(view ->{
            showDialog();
        } );

        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < 144; i++) {

            float val = (float) (Math.random() * 60);
            values.add(new Entry(i, val));
        }

        LineDataSet set1;
        set1 = new LineDataSet(values, "dB");

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1); // add the data sets

        // create a data object with the data sets
        LineData data = new LineData(dataSets);

        // black lines and points
        set1.setDrawCircleHole(false);
        set1.setDrawCircles(false);
        set1.setColor(Color.BLACK);
        //set1.setCircleColor(Color.BLACK);
        set1.setDrawFilled(true); // 차트 아래 fill(채우기) 설정
        set1.setFillColor(Color.BLACK); // 차트 아래 채우기 색 설정

        // set data
        chart.setData(data);
    }
    public void showDialog(){
        dialog.show();

        Button btnComplaint = dialog.findViewById(R.id.complaintButtonInDialog);
        btnComplaint.setOnClickListener(v->{
            //통신 부분 미구현
            if(sendComplaint()) {
                Toast complaintToast = Toast.makeText(this.getApplicationContext(),
                        "신고가 완료되었습니다.", Toast.LENGTH_SHORT);
                complaintToast.show();
            }
            dialog.dismiss();
        });
    }
    public boolean sendComplaint(){
        return true;
    }
}