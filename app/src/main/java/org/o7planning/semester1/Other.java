package org.o7planning.semester1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Other  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
    }
    public void aboutme(View view) {
        Intent intent = new Intent(Other.this, AboutMe.class);
        Other.this.startActivity(intent);

    }
    public void bantuan(View view) {
        Intent intent2 = new Intent(Other.this, bantuan.class);
        Other.this.startActivity(intent2);

    }

}
