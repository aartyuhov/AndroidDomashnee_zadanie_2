package com.example.domashnee_zadanie_2.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.domashnee_zadanie_2.databinding.ActivitySecondBinding;

import com.example.domashnee_zadanie_2.R;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create root LinearLayout to split screen vertically
        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));

        // Create two equal-sized LinearLayouts for top (green) and bottom (pink) halves
        LinearLayout topHalf = createHalf(Color.GREEN);
        LinearLayout bottomHalf = createHalf(Color.MAGENTA);

        // Add navigation button to go to ThirdActivity
        Button nextButton = new Button(this);
        nextButton.setText("Third activity");
        nextButton.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(intent);
        });

        rootLayout.addView(topHalf);
        rootLayout.addView(bottomHalf);
        rootLayout.addView(nextButton);
        setContentView(rootLayout);

    }

    private LinearLayout createHalf(int backgroundColor) {
        // Create half layout
        LinearLayout halfLayout = new LinearLayout(this);
        halfLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1 // weight to make each half equal
        ));
        halfLayout.setBackgroundColor(backgroundColor);
        halfLayout.setGravity(Gravity.CENTER);

        // Create GridLayout for 2x2 buttons
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(2);
        gridLayout.setRowCount(2);
        gridLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        // Add buttons to the GridLayout
        for (int i = 1; i <= 4; i++) {
            Button button = new Button(this);
            button.setText(String.valueOf(i));
            button.setLayoutParams(new GridLayout.LayoutParams(
                    GridLayout.spec((i - 1) / 2), // Row index
                    GridLayout.spec((i - 1) % 2)  // Column index
            ));
            button.setPadding(16, 16, 16, 16);
            gridLayout.addView(button);
        }

        // Add GridLayout to the half layout
        halfLayout.addView(gridLayout);

        return halfLayout;
    }

}