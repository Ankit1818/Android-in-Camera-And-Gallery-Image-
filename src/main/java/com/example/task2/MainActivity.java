package com.example.task2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import static com.example.task2.Main2Activity.CAMERA_REQUEST;


public class MainActivity extends AppCompatActivity {
    ImageView imges;
    Button upload;
    static final   int CAMERA_REQUEST = 1888;
    static final int IMAGE_PICK_CODE = 1000;
    private static int RESULT_LOAD_IMAGE = 1;
    static final int PERMISON_CODE = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    imges=findViewById(R.id.images);
    upload=findViewById(R.id.upload);


    upload.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           Intent intent=new Intent(MainActivity.this,Main2Activity.class);
           startActivityForResult(intent,1);

        }
    });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.list1:
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,2);

            break;

            case R.id.list2:

                Intent intent1=new Intent(Intent.ACTION_PICK);
                intent1.setType("image/*");
                startActivityForResult(intent1, IMAGE_PICK_CODE);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==2)
        {
            Bitmap bitmap=(Bitmap)data.getExtras().get("data");
            imges.setImageBitmap(bitmap);
        }
        else if (resultCode==RESULT_OK && requestCode == IMAGE_PICK_CODE)
        {

          // imges.setImageURI();
        }
        else if (resultCode== 3)
        {
            Log.d("MyResult", String.valueOf(data.getExtras().get("photo")));
            imges.setImageURI((Uri) data.getExtras().get("photo"));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


}
