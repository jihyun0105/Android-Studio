package com.example.project4_4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch swAgree;
    RadioGroup rGroup1;
    RadioButton rdoQ, rdoR, rdoS;
    ImageView img;
    Button button, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        swAgree = (Switch) findViewById(R.id.SwAgree);
        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoQ = (RadioButton) findViewById(R.id.RdoQ);
        rdoR = (RadioButton) findViewById(R.id.RdoR);
        rdoS = (RadioButton) findViewById(R.id.RdoS);
        img = findViewById(R.id.Img);

        button = findViewById(R.id.button);
        button3 = findViewById(R.id.button3);




        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i){
                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.RdoQ:
                        img.setImageResource(R.drawable.r11);
                        break;
                    case R.id.RdoR:
                        img.setImageResource(R.drawable.s12);
                        break;
                    case R.id.RdoS:
                        img.setImageResource(R.drawable.t13);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "안드로이드 버전을 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        swAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (swAgree.isChecked()) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                  //  button.setEnabled(true);
                 //   button3.setEnabled(true); // Switch가 ON일 때 버튼 활성화

                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                  //  button.setEnabled(false);
                  //  button3.setEnabled(false); // Switch가 OFF일 때 버튼 비활성화
                }
            }
        });
        // 종료 버튼 클릭 이벤트 설정
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); // 모든 액티비티 종료
                System.exit(0); // 앱 프로세스 종료
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 초기 상태로 리셋
                swAgree.setChecked(false);
                rGroup1.clearCheck();
                img.setVisibility(View.INVISIBLE);
            }
        });

    }
}