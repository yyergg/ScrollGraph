package com.example.yyergg.graphscroll;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class MainActivity extends AppCompatActivity {
    private View vChart;
    private HorizontalScrollView hsvChart;
    private Button btPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vChart = (View) this.findViewById(R.id.vChart);
        hsvChart = (HorizontalScrollView) this.findViewById(R.id.hsvChart);
        btPlay = (Button) this.findViewById(R.id.btPlay);
        hsvChart.setSmoothScrollingEnabled(true);
        final Handler handler = new Handler();
        final Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Integer pos = 0;

                    while(pos < hsvChart.getMaxScrollAmount()) {
                        sleep(30);
                        pos = pos + 1;
                        hsvChart.smoothScrollTo(pos,0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        btPlay.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                thread.start();
            }
        });
    }
}
