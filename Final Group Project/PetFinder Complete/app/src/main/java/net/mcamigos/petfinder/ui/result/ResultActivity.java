package net.mcamigos.petfinder.ui.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import net.mcamigos.petfinder.GlideApp;
import net.mcamigos.petfinder.R;
import net.mcamigos.petfinder.data.model.AnimalResponse;
import net.mcamigos.petfinder.ui.details.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private CustomAdapter customAdapter = null;
    private AnimalResponse petResponse = null;
    private List<AnimalResponse.AnimalsBean> animalList = new ArrayList();
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gridView = findViewById(R.id.gridView);
        getSetData();
        viewSelectedAnimal();

    }

    private void getSetData(){
        Intent intent = getIntent();
        if(intent.getExtras() != null){
            petResponse = (AnimalResponse) intent.getSerializableExtra("data");
            animalList = petResponse.getAnimals();
            customAdapter = new CustomAdapter(animalList, ResultActivity.this);
            gridView.setAdapter(customAdapter);
        }else{
            finish();
        }
    }

    private void viewSelectedAnimal(){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(ResultActivity.this, DetailsActivity.class).putExtra("data",animalList.get(i).getId()));
            }
        });
    }

    private static class CustomAdapter extends BaseAdapter {

        private List<AnimalResponse.AnimalsBean> animalResponse;
        private Context context;

        public CustomAdapter(List<AnimalResponse.AnimalsBean> animalsBeans, Context context) {
            this.animalResponse = animalsBeans;
            this.context = context;
        }

        @Override
        public int getCount() {
            return animalResponse.size();
        }

        @Override
        public Object getItem(int i) {
            return animalResponse.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = view;
            if(view1 == null){
                view1 = LayoutInflater.from(context).inflate(R.layout.row_pet,viewGroup,false);
            }

            ImageView imageView = view1.findViewById(R.id.imageName);
            TextView tvName = view1.findViewById(R.id.tvName);

            AnimalResponse.AnimalsBean animalsBean = animalResponse.get(i);
            List<AnimalResponse.AnimalsBean.PhotosBean> photosBeanList = animalsBean.getPhotos();
            String petPhoto = null;
            for(AnimalResponse.AnimalsBean.PhotosBean pet : photosBeanList){
                petPhoto = pet.getMedium();
            }

            GlideApp.with(context)
                    .load(petPhoto)
                    .placeholder(R.drawable.no_image)
                    .fitCenter()
                    .into(imageView);
            tvName.setText(animalsBean.getName());

            return view1;

        }
    }


}