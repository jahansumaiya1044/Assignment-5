package com.example.assignment5;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> mobileCollection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        createGroupList();
        createGroupList();
        expandableListView = findViewById(R.id.eLvMobiles);
        expandableListAdapter = new MyExpandableListAdapter(this,groupList,mobileCollection);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition= -1;
            @Override
            public void onGroupExpand(int i) {
                  if (lastExpandedPosition != -1 && i != lastExpandedPosition){
                      expandableListView.collapseGroup(lastExpandedPosition)
                  }
                  lastExpandedPosition = i;
            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public boolean onChildclick(ExpandableListView expandableListView,View view,int i,int i1,long 1) {
              String selected=expandableListAdapter.getChild(i,i1).toString();
                Toast.makeText(getApplicationContext(),text:"Selected:"+selected,Toast.LENGTH_SHORT.show();
               return true;
            }
        });



    }
    private void createCollection(){
        String[] samsungModels={"Samsung Galaxy M21","Samsung Galaxy A50s","Samsung Galaxy M51"};
        String[] redmiModels={"Redmi9i","Redmi Note 9 pro"};
        String[] vivoModels={"Vivo V20","Vivo S1 Pro"};
        String[] nokiaModels={"Nokia 5.3","Nokia 2.3"};
        mobileCollection =new HashMap<String,List<String>>();
        for (String group: groupList){
            String[] googleModels;
            if (group.equals("Samsung")){
                loadChild(samsungModels);
            }else if (group.equals("Redmi"))
                loadChild(googleModels);
            else if (group.equals("Vivo" ))
                loadChild(vivoModels);
            else if (group.equals("Nokia"))
                loadChild(nokiaModels);
        }
    }

    private void loadChild(String[] mobileModels) {
        childList= new ArrayList<>();
        for (String model: mobileModels){
            childList.add(model);
        }
    }


    private void createGroupList() {
     groupList= new ArrayList<>();
     groupList.add("Samsung");
     groupList.add("Redmi");
     groupList.add("Nokia");
     groupList.add("Vivo");

    }
}