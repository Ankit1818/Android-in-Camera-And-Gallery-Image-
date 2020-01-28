package com.example.task2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button b1,b2;
    static final   int CAMERA_REQUEST = 1888;
    static final int IMAGE_PICK_CODE = 1000;
    private static final int REQUEST_CAPTURE_IMAGE = 100;
    Intent intent1;

   /* Intent ii;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                /*ii=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(ii,1);
*/               //finish();


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent1=new Intent(Intent.ACTION_PICK);
                intent1.setType("image/*");
                startActivityForResult(intent1, 200);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 200)
        {

            Uri photos=data.getData();
            Toast.makeText(this, String.valueOf(photos), Toast.LENGTH_SHORT).show();
            intent1.putExtra("photo",photos);
            setResult(3,intent1);
            finish();

        }


       /* if (resultCode==1)
        {
            String photos = (String) data.getExtras().get("data");
            ii.putExtra("photos",photos);
            setResult(2,ii);
            finish();
        }*/
        super.onActivityResult(requestCode, resultCode, data);
    }
}
