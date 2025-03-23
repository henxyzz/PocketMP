
package com.pocketmp;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.util.ArrayList;

public class FileManagerActivity extends AppCompatActivity {
    private ListView fileList;
    private File currentDir;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_manager);
        
        fileList = findViewById(R.id.fileList);
        currentDir = getExternalFilesDir(null);
        
        loadFileList();
    }
    
    private void loadFileList() {
        File[] files = currentDir.listFiles();
        ArrayList<String> fileNames = new ArrayList<>();
        
        for (File file : files) {
            fileNames.add(file.getName());
        }
        
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, 
            android.R.layout.simple_list_item_1, fileNames);
        fileList.setAdapter(adapter);
        
        fileList.setOnItemClickListener((parent, view, position, id) -> {
            File selected = new File(currentDir, fileNames.get(position));
            if(selected.isDirectory()) {
                currentDir = selected;
                loadFileList();
            }
        });
    }
}
