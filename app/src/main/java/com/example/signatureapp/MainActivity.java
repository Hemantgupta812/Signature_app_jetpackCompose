package com.example.signatureapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.signatureapp.signature.SignatureEditorPanel;

public class MainActivity extends AppCompatActivity {
    
    private Button editorPanelBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editorPanelBtn = findViewById(R.id.ediorPanelBtn);
        editorPanelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                Intent i = new Intent(MainActivity.this, SignatureEditorPanel.class);
                startActivity(i);
                
            }
        });
    }
}