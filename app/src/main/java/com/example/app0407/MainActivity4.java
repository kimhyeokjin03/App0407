package com.example.app0407;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button button3 = (Button) findViewById(R.id.button3);
        registerForContextMenu(button3);
        Button button4 = (Button) findViewById(R.id.button4);
        registerForContextMenu(button4);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if (v.getId() == R.id.button3) {
            menu.setHeaderTitle("배경색 변경");
        } else if (v.getId() == R.id.button4) {
            menu.setHeaderTitle("버튼 변경");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        if (item.getItemId() == R.id.itemRed) {
            findViewById(R.id.button3).setBackgroundColor(0xFFFF0000);
            return true;
        }
        if (item.getItemId() == R.id.itemGreen) {
            findViewById(R.id.button3).setBackgroundColor(0xFF00FF00);
            return true;
        }
        if (item.getItemId() == R.id.itemBlue) {
            findViewById(R.id.button3).setBackgroundColor(0xFF0000FF);
            return true;
        }
        if (item.getItemId() == R.id.itemRotate) {
            findViewById(R.id.button4).setRotation(45);
            return true;
        }
        if (item.getItemId() == R.id.itemUp) {
            findViewById(R.id.button4).setScaleX(2);
            findViewById(R.id.button4).setScaleY(2);
            return true;
        }
        return false;
    }
}
