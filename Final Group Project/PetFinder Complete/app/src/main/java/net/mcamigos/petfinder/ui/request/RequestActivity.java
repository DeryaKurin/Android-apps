package net.mcamigos.petfinder.ui.request;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.mcamigos.petfinder.R;
import net.mcamigos.petfinder.utils.ToastUtills;
import net.mcamigos.petfinder.utils.ValidatorUtils;

public class RequestActivity extends AppCompatActivity {
    private String petDetails = null;
    private Button btnRequest;
    private EditText edName,edEmail,edPhone,edAddress1,edAddress2,edZipCode,edSocialSecurity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnRequest = findViewById(R.id.btnRequest);
        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edPhone = findViewById(R.id.edPhone);
        edAddress1 = findViewById(R.id.edAddress1);
        edAddress2 = findViewById(R.id.edAddress2);
        edZipCode = findViewById(R.id.edZipCode);
        edSocialSecurity = findViewById(R.id.edSocialSecurity);
        listenClick();

        Intent intent = getIntent();

        if(intent.getExtras() != null){
            petDetails = intent.getStringExtra("data");
        }else{
            finish();
        }
    }

    private void listenClick(){
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateDetails();
            }
        });
    }

    private void validateDetails(){
        if(ValidatorUtils.validate(new EditText[]{edName,edEmail,edPhone,edZipCode,edAddress1,edSocialSecurity})){
            String name = edName.getText().toString().trim();
            String email = edEmail.getText().toString().trim();
            String phone = edPhone.getText().toString().trim();
            String address1 = edAddress1.getText().toString().trim();
            String address2 = edAddress2.getText().toString().trim();
            String zipCode = edZipCode.getText().toString().trim();
            String securityCode = edSocialSecurity.getText().toString().trim();

            String requestData =
                    "Name :"+name +",Email :"+ email +",Phone : "+ phone +",Address1 : "+ address1 +",Address2 : "+ address2 +",ZipCode : "+ zipCode +",securityCode : "+ securityCode;
            sendRequestForm(requestData);

        }else{
            ToastUtills.showErrorToast(this," All details required ...");

        }
    }

    private void sendRequestForm(String data){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        String[] asEmailList = {"dozdemir663@gmail.com"};
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL,asEmailList);
        String feedback_msg = "Pet Finder";
        emailIntent.putExtra(
                Intent.EXTRA_TEXT,
                Html.fromHtml("<i> Client Details: " + data +" Pet Details : "+ petDetails+"</i>")
        );
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, feedback_msg);


        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        }else{
            ToastUtills.showInfoToast(this, "Email App not Installed");

        }


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}