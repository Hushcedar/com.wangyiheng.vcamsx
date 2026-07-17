package com.wangyiheng.vcamsx;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FloatingPanel {
    
    public static void show(final Activity activity) {
        try {
            WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
            
            LinearLayout layout = new LinearLayout(activity);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setBackgroundColor(0xAA000000);
            layout.setPadding(16, 16, 16, 16);
            
            Button playBtn = new Button(activity);
            playBtn.setText("Play");
            playBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, "Play pressed", Toast.LENGTH_SHORT).show();
                }
            });
            layout.addView(playBtn);
            
            Button rotateBtn = new Button(activity);
            rotateBtn.setText("Rotate");
            rotateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, "Rotate pressed", Toast.LENGTH_SHORT).show();
                }
            });
            layout.addView(rotateBtn);
            
            Button resizeBtn = new Button(activity);
            resizeBtn.setText("Resize");
            resizeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, "Resize pressed", Toast.LENGTH_SHORT).show();
                }
            });
            layout.addView(resizeBtn);
            
            WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                android.graphics.PixelFormat.TRANSLUCENT
            );
            params.gravity = android.view.Gravity.TOP | android.view.Gravity.CENTER_HORIZONTAL;
            
            wm.addView(layout, params);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}