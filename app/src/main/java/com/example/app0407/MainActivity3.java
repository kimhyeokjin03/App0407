package com.example.app0407;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
         getMenuInflater().inflate(R.menu.menu1, menu);
         return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.item1) {
            findViewById(R.id.main).setBackgroundColor(0xFFFF0000);
            return true;
        }
        if (item.getItemId() == R.id.item2) {
            findViewById(R.id.main).setBackgroundColor(0xFF00FF00);
            return true;
        }
        if (item.getItemId() == R.id.item3) {
            findViewById(R.id.main).setBackgroundColor(0xFF0000FF);
            return true;
        }
        if (item.getItemId() == R.id.item4) {
            findViewById(R.id.imageView).setVisibility(VISIBLE);
            findViewById(R.id.imageView1).setVisibility(INVISIBLE);
            return true;
        }
        if (item.getItemId() == R.id.item5) {
            findViewById(R.id.imageView).setVisibility(INVISIBLE);
            findViewById(R.id.imageView1).setVisibility(VISIBLE);
            return true;
        }
        return false;
    }
}

/*
    inflater의 역할 | 단면 xml -> 입체적으로 만들어 기능 부여

    switch-case문에서 case에 R.id.item1를 넣는 경우 R파일의 변수이므로 상수가 X -> 사용 불가
*/
