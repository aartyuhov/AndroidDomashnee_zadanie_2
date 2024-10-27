package com.example.domashnee_zadanie_2.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.domashnee_zadanie_2.R;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the root LinearLayout with vertical orientation
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setBackgroundColor(Color.BLUE); // Set background to blue
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));

        // Create GridLayout for buttons with different sizes
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(3); // 3 columns to create different sized buttons
        gridLayout.setRowCount(3); // 3 rows to fill the area
        gridLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1 // Weight of 1 to make it fill the available space
        ));

        // Add buttons to GridLayout with different sizes
        addButtonToGrid(gridLayout, "", 2, 1); // Spans 2 columns
        addButtonToGrid(gridLayout, "", 1, 1);
        addButtonToGrid(gridLayout, "", 1, 2); // Spans 2 rows
        addButtonToGrid(gridLayout, "", 1, 1);
        addButtonToGrid(gridLayout, "", 1, 1);
        addButtonToGrid(gridLayout, "", 1, 1);
        addButtonToGrid(gridLayout, "", 1, 1);

        // Create the navigation button for "Main Activity" and set it to full width
        Button mainButton = new Button(this);
        mainButton.setText("Main activity");
        mainButton.setGravity(Gravity.CENTER);
        mainButton.setBackgroundColor(Color.GRAY);
        mainButton.setTextColor(Color.WHITE);
        mainButton.setOnClickListener(v -> {
            // Add navigation to another activity here if needed
            Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        // Set layout parameters for the Main Activity button to make it full-width
        LinearLayout.LayoutParams mainButtonParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        mainButton.setLayoutParams(mainButtonParams);

        // Add GridLayout and Main Activity button to the main layout
        mainLayout.addView(gridLayout);  // The grid layout fills the upper area
        mainLayout.addView(mainButton);  // The button is anchored at the bottom

        // Set the main layout as the content view
        setContentView(mainLayout);
    }

    // Helper method to add a button to the GridLayout with specified column and row spans
    private void addButtonToGrid(GridLayout gridLayout, String text, int colSpan, int rowSpan) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setStroke(5, Color.LTGRAY);
        drawable.setColor(Color.GRAY);


        Button button = new Button(this);
        button.setText(text);
        button.setBackgroundColor(Color.LTGRAY);
        button.setBackground(drawable);

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 0; // Make button fill available column space
        params.height = 0; // Make button fill available row space
        params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, colSpan, 1f); // Set column span
        params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, rowSpan, 1f); // Set row span
        button.setLayoutParams(params);

        gridLayout.addView(button);
    }
}