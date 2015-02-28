package com.cs175.mymemes;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.view.*;
import android.widget.ListView;

public class Memes extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Resources res = getResources();
        int[] image = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10};
        final String[] name = res.getStringArray(R.array.name);
        String[] desc = res.getStringArray(R.array.desc);

        MemeAdapter adapter = new MemeAdapter(this,name,image,desc);
        setListAdapter(adapter);

        ListView list = getListView();
        list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                TextView title = (TextView) view.findViewById(R.id.name);
                TextView desc = (TextView) view.findViewById(R.id.desc);
                ImageView img = (ImageView) view.findViewById(R.id.image);

                String s = title.getText().toString();
                String d = desc.getText().toString();

                Toast.makeText(Memes.this, "Showing details for " + name[+position], Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MemeView.class);

                intent.putExtra("title", s);
                intent.putExtra("desc", d);
                intent.putExtra("image", position);
                startActivity(intent);

            }
        });
    }

}


