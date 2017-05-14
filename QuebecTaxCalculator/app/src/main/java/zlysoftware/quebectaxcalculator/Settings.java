package zlysoftware.quebectaxcalculator;

import java.lang.String;
import java.util.Locale;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    private String[] languageSpinner;
    private String language;

    EditText languageTxt,title;

    public String getLanguage(){return language;}
    public void setLanguage(String lang){language=lang;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*Language Features
        //Lock any input on the language textbox
        languageTxt = (EditText) findViewById(R.id.Settings_LanguageTxt);
        languageTxt.setInputType(InputType.TYPE_NULL);

        //Add language to the spinner
        this.languageSpinner = new String[]{
                 getString(R.string.language_default),getString(R.string.language_second)
        };
        //Instantiate spinner
        Spinner spinner = (Spinner) findViewById(R.id.Language_Spinner);
        //Add an array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, languageSpinner);
        //Set the adapter to the spinner
        spinner.setAdapter(adapter);*/


    }

    public void onClickSaveButton(View view)
    {
        /*Language Features
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;

        Spinner spinner = (Spinner) findViewById(R.id.Language_Spinner);
        //Language code (For future purpose, if add more than 2 languages)
        switch (spinner.getSelectedItem().toString()){
            case "English":
                setLanguage("en");
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                this.setContentView(R.layout.activity_settings);
                Toast.makeText(getApplicationContext(), "Language switched to english", Toast.LENGTH_SHORT).show();
                break;
            case "French":
                setLanguage("fr");
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                this.setContentView(R.layout.activity_settings);
                Toast.makeText(getApplicationContext(), "Language switched to french", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }


        /*alternative version
        if(spinner.getSelectedItem().toString() == getString (R.string.language_defaultTag))
        {
            Toast.makeText(getApplicationContext(), "Language switched to english", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(), "Language switched to french", Toast.LENGTH_SHORT).show();
        */

    }
}
