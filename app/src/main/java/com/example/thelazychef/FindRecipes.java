package com.example.thelazychef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class FindRecipes extends AppCompatActivity {

    RelativeLayout searchButton;
    TextView enterDish;
    Button advancedSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_recipes);

        // initialise text view
        enterDish = findViewById(R.id.enterDish);

        // move to recipe results results page on pressing goButton
        searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check if query is valid
                String dishQuery = enterDish.getText().toString().trim();
                if (dishQuery.length() > 0){
                    Intent findRecipesResultsOpener = new Intent(FindRecipes.this, FindRecipesResults.class);

                    // pass the nutrition query to the results page
                    findRecipesResultsOpener.putExtra("DISH_QUERY", dishQuery);
                    startActivity(findRecipesResultsOpener);
                } else {

                    // shake box if no query is entered
                    YoYo.with(Techniques.Shake)
                            .duration(700)
                            .repeat(0)
                            .playOn(findViewById(R.id.enterDish));
                    Toast.makeText(getApplicationContext(), "Please enter a valid query!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        advancedSearchButton = findViewById(R.id.advancedSearchButton);
        advancedSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent advancedSearchPageOpener = new Intent(FindRecipes.this, AdvancedSearch.class);
                startActivity(advancedSearchPageOpener);
            }
        });
    }

    public void onClickBtn(View v)
    {
        Toast.makeText(this, "Functionality not added", Toast.LENGTH_SHORT).show();
    }

    // on click handler for back button
    public void backButtonClickHandler(View v) {
        finish();
    }
}