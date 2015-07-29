package comfieldsofvisions.google.httpssites.drivesafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView textView;
    Button choose, create, message;
    EditText editText, createEt;

    //gets chosen item from list and puts result in text view.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       /* textView = (TextView) findViewById(R.id.responseTv);

        String gotData = data.getStringExtra("EtResponse");

        textView.setText("" + gotData);*/

        if (requestCode == 0) {
            switch (resultCode) {
                case RESULT_OK:
                    textView.setText(data.getStringExtra("response"));
                    break;
                case RESULT_CANCELED:
                    break;


            }

        }}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.responseTv);
        choose = (Button) findViewById(R.id.btnChoose);
        create = (Button) findViewById(R.id.btnCreate);
        message = (Button) findViewById(R.id.btnMessage);
        editText = (EditText) findViewById(R.id.editText);
        createEt = (EditText) findViewById(R.id.create_et);


        //Tells choose button what to do when it is clicked.
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openList = new Intent(getApplicationContext(), ChoiceList.class);
                startActivityForResult(openList, 0);
            }
        });




    }

    public void openMessage(View view) {
        Intent message = new Intent(this, Messaging.class);
        startActivity(message);

    }

    public void openCreate(View view) {
        final InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        textView.setText(editText.getText());
        imm.hideSoftInputFromWindow(editText.getWindowToken(),0);


    }


}











