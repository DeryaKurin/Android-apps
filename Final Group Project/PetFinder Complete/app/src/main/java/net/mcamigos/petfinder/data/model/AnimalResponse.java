package net.mcamigos.petfinder.data.model;

import java.io.Serializable;
import java.util.List;

public class AnimalResponse implements Serializable {


    /**
     * animals : [{"id":124,"organization_id":"NJ333","url":"https://www.petfinder.com/cat/nebula-124/nj/jersey-city/nj333-petfinder-test-account/?referrer_id=d7e3700b-2e07-11e9-b3f3-0800275f82b1","type":"Cat","species":"Cat","breeds":{"primary":"American Shorthair","secondary":null,"mixed":false,"unknown":false},"colors":{"primary":"Tortoiseshell","secondary":null,"tertiary":null},"age":"Young","gender":"Female","size":"Medium","coat":"Short","name":"Nebula","description":"Nebula is a shorthaired, shy cat. She is very affectionate once she warms up to you.","photos":[{"small":"https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081&width=100","medium":"https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081&width=300","large":"https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081&width=600","full":"https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081"}],"videos":[{"embed":"<iframe src=\"https://www.youtube.com/embed/xaXbs1fRFRM\" frameborder=\"0\" allowfullscreen><\/iframe>"}],"status":"adoptable","attributes":{"spayed_neutered":true,"house_trained":true,"declawed":false,"special_needs":false,"shots_current":true},"environment":{"children":false,"dogs":true,"cats":true},"tags":["Cute","Intelligent","Playful","Happy","Affectionate"],"contact":{"email":"petfindertechsupport@gmail.com","phone":"555-555-5555","address":{"address1":null,"address2":null,"city":"Jersey City","state":"NJ","postcode":"07097","country":"US"}},"published_at":"2018-09-04T14:49:09+0000","distance":0.4095,"_links":{"self":{"href":"/v2/animals/124"},"type":{"href":"/v2/types/cat"},"organization":{"href":"/v2/organizations/nj333"}}}]
     */

    private List<AnimalsBean> animals;

    public List<AnimalsBean> getAnimals() {
        return animals;
    }

    public void setAnimals(List<AnimalsBean> animals) {
        this.animals = animals;
    }

    public static class AnimalsBean implements Serializable {


        /**
         *
         * The data fields below could be retrieved from PetFinder API service but for simplicity, we did not use all the potential extra data.
         * Only data used for AnimalBean model object: id, name, and photos.
         * id : 124
         * organization_id : NJ333
         * url : https://www.petfinder.com/cat/nebula-124/nj/jersey-city/nj333-petfinder-test-account/?referrer_id=d7e3700b-2e07-11e9-b3f3-0800275f82b1
         * type : Cat
         * species : Cat
         * breeds : {"primary":"American Shorthair","secondary":null,"mixed":false,"unknown":false}
         * colors : {"primary":"Tortoiseshell","secondary":null,"tertiary":null}
         * age : Young
         * gender : Female
         * size : Medium
         * coat : Short
         * name : Nebula
         * description : Nebula is a shorthaired, shy cat. She is very affectionate once she warms up to you.
         * photos : [{"small":"https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081&width=100","medium":"https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081&width=300","large":"https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081&width=600","full":"https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081"}]
         * videos : [{"embed":"<iframe src=\"https://www.youtube.com/embed/xaXbs1fRFRM\" frameborder=\"0\" allowfullscreen><\/iframe>"}]
         * status : adoptable
         * attributes : {"spayed_neutered":true,"house_trained":true,"declawed":false,"special_needs":false,"shots_current":true}
         * environment : {"children":false,"dogs":true,"cats":true}
         * tags : ["Cute","Intelligent","Playful","Happy","Affectionate"]
         * contact : {"email":"petfindertechsupport@gmail.com","phone":"555-555-5555","address":{"address1":null,"address2":null,"city":"Jersey City","state":"NJ","postcode":"07097","country":"US"}}
         * published_at : 2018-09-04T14:49:09+0000
         * distance : 0.4095
         * _links : {"self":{"href":"/v2/animals/124"},"type":{"href":"/v2/types/cat"},"organization":{"href":"/v2/organizations/nj333"}}
         */

        private int id;
        private String name;
        private List<PhotosBean> photos;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }


        public static class PhotosBean implements Serializable {
            /**
             * small : https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081&width=100
             * medium : https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081&width=300
             * large : https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081&width=600
             * full : https://photos.petfinder.com/photos/pets/124/1/?bust=1546042081
             * Only medium-size photos are used in this app
             */

            private String medium;

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }
}
