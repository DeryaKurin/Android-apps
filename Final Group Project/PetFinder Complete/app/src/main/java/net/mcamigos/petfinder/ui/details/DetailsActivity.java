package net.mcamigos.petfinder.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.mcamigos.petfinder.GlideApp;
import net.mcamigos.petfinder.R;
import net.mcamigos.petfinder.data.api.ApiClient;
import net.mcamigos.petfinder.data.model.OrganizationResponse;
import net.mcamigos.petfinder.data.model.SingleAnimalResponse;
import net.mcamigos.petfinder.data.service.PetService;
import net.mcamigos.petfinder.ui.request.RequestActivity;
import net.mcamigos.petfinder.utils.ShowHideProgressBar;
import net.mcamigos.petfinder.utils.ToastUtills;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {
    private Integer id = null;
    private String petDetails = null;
    private String organizationName = null;
    private TextView tvOrganizationName;
    private TextView tvAnimalDetails;
    private ImageView imageViewPet;
    private Button btnSendEmail;
    private Button btnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvOrganizationName = findViewById(R.id.tvOrganizationName);
        imageViewPet = findViewById(R.id.imageViewPet);
        tvAnimalDetails = findViewById(R.id.tvAnimalDetails);
        btnSendEmail = findViewById(R.id.btnSendEmail);
        btnRequest = findViewById(R.id.btnRequest);
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            id = intent.getIntExtra("data",0);
            fetchAnimalDetails(id);
            clicklistener();
        }else{
            finish();
        }


    }



    private void fetchAnimalDetails(Integer id){
        ShowHideProgressBar.show(true,this," Fetching Pet Details ... ");
        PetService petService = ApiClient.getPetService();
        petService.getSinglePet(id).enqueue(new Callback<SingleAnimalResponse>() {
            @Override
            public void onResponse(Call<SingleAnimalResponse> call, Response<SingleAnimalResponse> response) {

                ShowHideProgressBar.show(false,DetailsActivity.this,"");

                if(response.isSuccessful()) {
                    SingleAnimalResponse.AnimalBean animal = response.body().getAnimal();
                    showPetDetails(animal);
                    fetchOrganizationDetails(animal.getOrganization_id());
                }else{
                    ToastUtills.showErrorToast(DetailsActivity.this, "An error occurred while fetching pets, Please type again later");
                }
            }

            @Override
            public void onFailure(Call<SingleAnimalResponse> call, Throwable t) {
                ShowHideProgressBar.show(false,DetailsActivity.this,"");
                ToastUtills.showErrorToast(DetailsActivity.this, "An error occurred "+t.getLocalizedMessage());

            }
        });
    }


    private void fetchOrganizationDetails(String id){
        PetService petService = ApiClient.getPetService();
        petService.getOrganizationDetails(id).enqueue(new Callback<OrganizationResponse>() {
            @Override
            public void onResponse(Call<OrganizationResponse> call, Response<OrganizationResponse> response) {

                if(response.isSuccessful()) {
                    OrganizationResponse.OrganizationBean organizationDeta = response.body().getOrganization();

                    organizationName = organizationDeta.getName();
                    String organization = "Organization : "+organizationName;
                    tvOrganizationName.setText(organization);
                }
            }

            @Override
            public void onFailure(Call<OrganizationResponse> call, Throwable t) {

            }
        });
    }

    private void showPetDetails(SingleAnimalResponse.AnimalBean animalDetails){


        String petPhoto = null;

        if(animalDetails.getPrimary_photo_cropped() != null ){
            petPhoto = animalDetails.getPrimary_photo_cropped().getMedium();
        }
        String animalName = animalDetails.getName();
        String animalType = animalDetails.getType();
        String animalBreed = animalDetails.getBreeds().getPrimary();
        String animalSize = animalDetails.getSize();
        String animalGender = animalDetails.getGender();
        String animalAge = animalDetails.getAge();
        String animalColor = animalDetails.getColors().getPrimary();
        String animalStatus = animalDetails.getStatus();
        String animalOrg = animalDetails.getOrganization_id();



        petDetails = "Name : " + animalName +
                System.getProperty ("line.separator") +
                "Type : "+animalType +
                System.getProperty ("line.separator") +
                "Breed : "+animalBreed+
                System.getProperty ("line.separator") +
                "Size : "+animalSize +
                System.getProperty ("line.separator") +
                "Gender : "+animalGender +
                System.getProperty ("line.separator") +
                "Age : "+animalAge+
                System.getProperty ("line.separator") +
                "Color : "+animalColor +
                System.getProperty ("line.separator") +
                "Status : "+animalStatus;


        GlideApp.with(this)
                .load(petPhoto)
                .placeholder(R.drawable.image_dog)
                .fitCenter()
                .into(imageViewPet);


        tvAnimalDetails.setText(petDetails);
    }



    private void clicklistener(){
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToEmail(petDetails);
            }
        });

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailsActivity.this, RequestActivity.class).putExtra("data",petDetails));
                finish();
            }
        });

    }



    private void sendToEmail( String details) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        String feedback_msg = "Pet Finder";
        emailIntent.putExtra(
                Intent.EXTRA_TEXT,
                Html.fromHtml("<i>"+details+"</i>")
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