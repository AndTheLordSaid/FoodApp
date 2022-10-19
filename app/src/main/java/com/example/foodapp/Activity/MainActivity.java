package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodapp.Adaptor.CategoryAdaptor;
import com.example.foodapp.Adaptor.PopularAdaptor;
import com.example.foodapp.Domain.CategoryDomain;
import com.example.foodapp.Domain.FoodDomain;
import com.example.foodapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

private RecyclerView.Adapter adapter, adapter2; //2nd adaptor is for popular
private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        recyclerViewCategory();
        recyclerViewPopular();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza","cat_1"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("Hotdog","cat_3"));
        category.add(new CategoryDomain("Drink","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));

        adapter = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);

    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.recyclerview2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni Pizza","pop_1","slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce",9.76));
        foodList.add( new FoodDomain("Cheese Burger","pop_2","beef, gouda cheese, lettuce,tomato", 9.76));
        foodList.add( new FoodDomain("Vegetable Pizza","pop_3","vegetable oil, olive oil, kalamata, cherry tomato", 9.76));

        adapter2 = new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);

    }
}