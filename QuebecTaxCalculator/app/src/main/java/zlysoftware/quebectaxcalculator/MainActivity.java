package zlysoftware.quebectaxcalculator;
import java.text.DecimalFormat;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText enterPrice,qst,gst,total,taxOut;
    TextView qstTxt,gstTxt,totalTxt,title;


    private float qstRate = 0.09975f;   //Quebec tax
    private float gstRate = 0.05f;      //Goods and Services Tax

    //Format of the currency
    DecimalFormat currency = new DecimalFormat("$###,###.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Font set up for title
        title = (TextView)findViewById(R.id.TitleTxt);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/CFQuebecStamp-Regular.ttf");
        title.setTypeface(customFont);

        //Assigning widget from content_main.xml
        enterPrice = (EditText) findViewById(R.id.EnterPriceTxt);
        total = (EditText) findViewById(R.id.TotalOut);
        gst = (EditText) findViewById(R.id.GstOut);
        qst = (EditText) findViewById(R.id.QstOut);
        taxOut = (EditText) findViewById(R.id.TaxOut);

        //Disable any input in these boxes
        gst.setInputType(InputType.TYPE_NULL);
        qst.setInputType(InputType.TYPE_NULL);
        taxOut.setInputType(InputType.TYPE_NULL);
        total.setInputType(InputType.TYPE_NULL);


        //Adding a textchanged listener
        enterPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try{
                    float price= Float.parseFloat(enterPrice.getText().toString());
                    float withGst = (price * gstRate);
                    float withQst = (price * qstRate);
                    gst.setText(currency.format(withGst));
                    qst.setText(currency.format(withQst));

                    taxOut.setText(currency.format(withGst+withQst));
                    total.setText(currency.format(price + withGst + withQst));
                }
                catch (Exception e)
                {
                    enterPrice.setText("0");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


     /*   Button calculate = (Button) findViewById(R.id.CalculateBtn);
        calculate.setOnClickListener(new View.OnClickListener(){
          public void onClick(View view)
          {
              NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

              float price= Float.parseFloat(enterPrice.getText().toString());
              float withGst = (price * gstRate);
              float withQst = (price * qstRate);

        //     String formattedString = (String) currencyFormat.format();

              gst.setText(String.format("%1$.3f",Float.toString(withGst)));
              qst.setText(Float.toString(withQst));

              taxOut.setText(Float.toString(withGst+withQst));
              total.setText(Float.toString(price + withGst + withQst));
              /*total.setText("Test Works!");
              taxOut.setText("Test Works2");
          }

        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Settings Selected", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(MainActivity.this, Settings.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_about) {
            Toast.makeText(getApplicationContext(), "About Selected", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(MainActivity.this, About.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*public void onSettingsButtonClick(View view)
    {
        if(view.getId() == R.id.action_settings)
        {
            Intent i = new Intent(MainActivity.this, Settings.class);
            startActivity(i);
        }
   }*/
}
