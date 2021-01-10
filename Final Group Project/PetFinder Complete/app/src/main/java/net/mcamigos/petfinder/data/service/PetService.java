package net.mcamigos.petfinder.data.service;

import net.mcamigos.petfinder.data.model.AnimalResponse;
import net.mcamigos.petfinder.data.model.AnimalTypeResponse;
import net.mcamigos.petfinder.data.model.OauthResponse;
import net.mcamigos.petfinder.data.model.OrganizationResponse;
import net.mcamigos.petfinder.data.model.SingleAnimalResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PetService {

    //OAUTH2 Endpoints
    @POST("")
    @FormUrlEncoded
    Call<OauthResponse> oauth(
             @Url String url,
             @Field("client_id")String client_id,
             @Field("client_secret")String client_secret,
             @Field("grant_type")String grantType

    );

    //get all pets
    @GET("/v2/animals")
    Call<AnimalResponse> getAllPet(
            @Query("type") String type,
            @Query("size") String size,
            @Query("postcode") String zipCode);

    //get single pet details
    @GET("/v2/animals/{id}")
    Call<SingleAnimalResponse> getSinglePet(@Path("id") Integer id);

    //get pet organization
    @GET("/v2/organizations/{id}")
    Call<OrganizationResponse> getOrganizationDetails(@Path("id") String id);

    //get available pet types
    @GET("/v2/types/")
    Call<AnimalTypeResponse> getAllAnimalType();

}
