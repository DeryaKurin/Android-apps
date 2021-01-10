package net.mcamigos.petfinder.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import net.mcamigos.petfinder.R;
import net.mcamigos.petfinder.data.Config;
import net.mcamigos.petfinder.data.api.ApiClient;
import net.mcamigos.petfinder.data.model.AnimalResponse;
import net.mcamigos.petfinder.data.model.AnimalTypeResponse;
import net.mcamigos.petfinder.data.model.OauthResponse;
import net.mcamigos.petfinder.data.service.PetService;
import net.mcamigos.petfinder.ui.result.ResultActivity;
import net.mcamigos.petfinder.utils.PrefManager;
import net.mcamigos.petfinder.utils.ShowHideProgressBar;
import net.mcamigos.petfinder.utils.ToastUtills;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AnimalTypeResponse animalType;
    private List<String> typeList = new ArrayList<>();
    private List<String> sizeList = new ArrayList<>();
    private String selectedType;
    private String selectedSize;
    private String zipCode;
    private Spinner sType;
    private Spinner sSize;
    private EditText edZipCode;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSetView();
        clickListener();
        getToken();
    }

    private void getSetView(){
        sType = findViewById(R.id.sType);
        sSize = findViewById(R.id.sSize);
        edZipCode = findViewById(R.id.edZipCode);
        btnSearch = findViewById(R.id.btnSearch);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllPets();
            }
        });
    }


    private void getToken(){
         String url = Config.OUATH_URL;
         String grant_type = Config.GRANT_TYPE;
         String client_secret = Config.secret;
         String client_id = Config.api_key;

        PetService petService = ApiClient.getPetService();

        petService.oauth(
                url,
                client_id,
                client_secret,
                grant_type
        ).enqueue(new Callback<OauthResponse>() {
            @Override
            public void onResponse(Call<OauthResponse> call, Response<OauthResponse> response) {

                //successful response
                if(response.isSuccessful()){
                    PrefManager.saveTokenDetails(response.body());
                    getAnimalType();
                }else{
                    ToastUtills.showErrorToast(MainActivity.this,"Unable to fetch token, Please try again later ...");
                }

            }

            @Override
            public void onFailure(Call<OauthResponse> call, Throwable t) {

                ToastUtills.showErrorToast(MainActivity.this,"An error occurred "+t.getLocalizedMessage());

            }
        });



    }


    private void getAnimalType(){
        ShowHideProgressBar.show(true,this,"Fetching available pet types");
        PetService petService = ApiClient.getPetService();

        petService.getAllAnimalType().enqueue(new Callback<AnimalTypeResponse>() {
            @Override
            public void onResponse(Call<AnimalTypeResponse> call, Response<AnimalTypeResponse> response) {
                ShowHideProgressBar.show(false, MainActivity.this,"");
                if(response.isSuccessful()){
                    animalType = response.body();
                    populateSpinner();
                }else{
                    ToastUtills.showErrorToast(MainActivity.this, "An error occurred while fetching pet types, Please type again later");
                }
            }

            @Override
            public void onFailure(Call<AnimalTypeResponse> call, Throwable t) {
                ShowHideProgressBar.show(false,MainActivity.this," Fetching available pet types");
                ToastUtills.showErrorToast(MainActivity.this, "An error occurred "+t.getLocalizedMessage());
            }
        });

    }

    private void populateSpinner(){
        List<AnimalTypeResponse.TypesBean> petType = animalType.getTypes();
        typeList.add("-- Select Pet Type --");
        for(AnimalTypeResponse.TypesBean typesBean: petType){
            typeList.add((typesBean.getName()));
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.spinner_item,typeList);
        sType.setAdapter(arrayAdapter);


        sizeList.add("-- Select pet --");
        sizeList.add("small");
        sizeList.add("medium");
        sizeList.add("large");
        sizeList.add("xlarge");

    }

    private  void getAllPets() {
        ShowHideProgressBar.show(true, this, " Processing request ...");
        PetService petService = ApiClient.getPetService();
        petService.getAllPet(selectedType, selectedSize, zipCode).enqueue(new Callback<AnimalResponse>() {
            @Override
            public void onResponse(Call<AnimalResponse> call, Response<AnimalResponse> response) {
                ShowHideProgressBar.show(false, MainActivity.this, "");
                if (response.isSuccessful()) {

                    AnimalResponse petResponse = response.body();
                    assert petResponse != null;
                    if (petResponse.getAnimals().isEmpty()) {
                        ToastUtills.showInfoToast(MainActivity.this, "No pets found ...");
                    } else {
                        startActivity(new Intent(MainActivity.this, ResultActivity.class).putExtra("data", petResponse));
                    }


                } else {
                    ToastUtills.showErrorToast(MainActivity.this, "An error occurred while fetching pets, Please type again later");
                }

            }

            @Override
            public void onFailure(Call<AnimalResponse> call, Throwable t) {
                ShowHideProgressBar.show(false, MainActivity.this, "");
                ToastUtills.showErrorToast(MainActivity.this, "An error occurred " + t.getLocalizedMessage());

            }
        });
    }


    private void clickListener(){

        sType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(i != 0){
                    selectedType = typeList.get(i);
                }else{
                    selectedType = null;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //type

        sSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i != 0){
                    selectedSize = sizeList.get(i);

                }else{
                    selectedSize = null;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //button
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zipCode = edZipCode.getText().toString().trim();
                getAllPets();
            }
        });

    }



}