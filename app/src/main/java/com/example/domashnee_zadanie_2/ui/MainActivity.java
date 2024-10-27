package com.example.domashnee_zadanie_2.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.domashnee_zadanie_2.databinding.ActivityMainBinding;

import com.example.domashnee_zadanie_2.R;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Main vertical LinearLayout
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setBackgroundColor(0xFFC8E6C9); // Light green background
        mainLayout.setPadding(16, 16, 16, 16);
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));

        // GridLayout for buttons
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(3);
        gridLayout.setRowCount(4);
        gridLayout.setUseDefaultMargins(true);

        String[] buttonLabels = {"BUTTON1", "BUTTON2", "BUTTON3", "BUTTON4", "BUTTON5",
                "BUTTON6", "BUTTON7", "BUTTON8", "BUTTON9", "BUTTON10"};

        for (int i = 0; i < buttonLabels.length; i++) {
            Button button = new Button(this);
            button.setText(buttonLabels[i]);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = GridLayout.LayoutParams.WRAP_CONTENT;
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;

            if (i == 3 || i == 6) {
                params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 2); // Span 2 columns
            }

            button.setLayoutParams(params);
            gridLayout.addView(button);
        }

        // Set layout parameters to make grid layout fill available space
        LinearLayout.LayoutParams gridLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1 // Weight of 1 to make it fill available space
        );
        gridLayout.setLayoutParams(gridLayoutParams);

        // Create the navigation button for SecondActivity
        Button nextButton = new Button(this);
        nextButton.setText("Second activity");
        nextButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        // Set layout parameters for the navigation button to make it full-width
        LinearLayout.LayoutParams nextButtonParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        nextButton.setLayoutParams(nextButtonParams);

        // Add views to the main layout
        mainLayout.addView(gridLayout);  // The grid layout goes first
        mainLayout.addView(nextButton);  // The button goes at the bottom

        // Set the main layout as the content view
        setContentView(mainLayout);

    }

}