package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity {

    private EditText text;
    private Button button1, button2;

    private Button1ClickListener button1ClickListener = new Button1ClickListener();
    private class Button1ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.button1:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.button2:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);

        text = (EditText)findViewById(R.id.text);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(button1ClickListener);
        button2.setOnClickListener(button1ClickListener);

        Intent intent = getIntent();
        if (intent != null) {
            if(intent.getExtras().containsKey("clicks"))
                text.setText(String.valueOf(intent.getIntExtra("clicks", -1)));
        }
    }

}
