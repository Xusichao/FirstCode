package com.xsic.firstcode;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.xsic.firstcode.ListView.MyAdapter;
import com.xsic.firstcode.RecycleView.RecycleAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {
    private List<Cat> catList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        initCat();
        /* listView */
        View view  = this.getLayoutInflater().inflate(R.layout.list_view,null);
        ListView listView = view.findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(MainActivity.this,R.layout.list_view_item,catList);
        setListViewClick(listView);
        listView.setAdapter(adapter);
        /* recycleView*/
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecycleAdapter rcAdapter = new RecycleAdapter(catList);
        recyclerView.setAdapter(rcAdapter);

    }

    private void initCat(){
        for (int i=0;i<100;i++){
            catList.add(new Cat("cat"+i,R.drawable.alipay));
        }
    }

    /**
     * listView的点击事件
     * @param listView
     */
    private void setListViewClick(ListView listView){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cat cat = catList.get(position);
                Toast.makeText(MainActivity.this,cat.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
