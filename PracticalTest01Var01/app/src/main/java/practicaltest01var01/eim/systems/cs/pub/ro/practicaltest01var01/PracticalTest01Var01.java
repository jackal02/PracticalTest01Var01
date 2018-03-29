package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var01 extends AppCompatActivity {

    private EditText text;
    private Button north, south, east, west, secondary;
    private int clicks;

    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String cnt = "";
            clicks++;
            if (clicks != 0)
                cnt = cnt + ",";

            switch(view.getId()) {
                case R.id.north:
                    text.setText(text.getText().toString() + cnt + "North");
                    break;
                case R.id.south:
                    text.setText(text.getText().toString() + cnt + "South");
                    break;
                case R.id.east:
                    text.setText(text.getText().toString() + cnt + "East");
                    break;
                case R.id.west:
                    text.setText(text.getText().toString() + cnt + "West");
                    break;
            }
        }
    }

    private Button3ClickListener button3ClickListener = new Button3ClickListener();
    private class Button3ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);
            intent.putExtra("clicks", clicks);
            startActivityForResult(intent, 100);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        north = findViewById(R.id.north);
        south = findViewById(R.id.south);
        east = findViewById(R.id.east);
        west = findViewById(R.id.west);

        secondary = findViewById(R.id.secondary);

        text = findViewById(R.id.text);
        clicks = 0;

        north.setOnClickListener(genericButtonClickListener);
        south.setOnClickListener(genericButtonClickListener);
        east.setOnClickListener(genericButtonClickListener);
        west.setOnClickListener(genericButtonClickListener);

        secondary.setOnClickListener(button3ClickListener);
       // Log.d("tag", String.valueOf(clicks));
    }


    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("var", clicks);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("var")) {

            clicks = savedInstanceState.getInt("var");
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case 100:
                Toast.makeText(this, "Activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
                break;
        }
    }
}