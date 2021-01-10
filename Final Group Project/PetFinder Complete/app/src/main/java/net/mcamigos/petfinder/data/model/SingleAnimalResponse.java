package net.mcamigos.petfinder.data.model;

import java.util.List;

public class SingleAnimalResponse {

    /**
     * animal : {"id":49656243,"organization_id":"NJ398","url":"https://www.petfinder.com/cat/sweet-pea-49656243/nj/asbury-park/three-little-kittens-inc-nj398/?referrer_id=3a7479dd-ded8-433e-9b9f-52cc8b1d5032","type":"Cat","species":"Cat","breeds":{"primary":"Tortoiseshell","secondary":null,"mixed":false,"unknown":false},"colors":{"primary":"Calico","secondary":null,"tertiary":null},"age":"Baby","gender":"Female","size":"Medium","coat":null,"attributes":{"spayed_neutered":false,"house_trained":true,"declawed":false,"special_needs":false,"shots_current":true},"environment":{"children":true,"dogs":null,"cats":true},"tags":[],"name":"Sweet Pea","description":"Age 10-12 wks Meet Sweet Pea! She and her litter were rescued in Freehold. She is part of a bonded-pair...","organization_animal_id":null,"photos":[{"small":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=100","medium":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=300","large":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064"},{"small":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/1/?bust=1604157058&width=100","medium":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/1/?bust=1604157058&width=300","large":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/1/?bust=1604157058&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/1/?bust=1604157058"},{"small":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/2/?bust=1604157061&width=100","medium":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/2/?bust=1604157061&width=300","large":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/2/?bust=1604157061&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/2/?bust=1604157061"}],"primary_photo_cropped":{"small":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=300","medium":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=450","large":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064"},"videos":[],"status":"adoptable","status_changed_at":"2020-10-31T15:11:54+0000","published_at":"2020-10-31T15:11:54+0000","distance":null,"contact":{"email":"kittensthree@optonline.net","phone":"732-988-3024","address":{"address1":null,"address2":null,"city":"Asbury Park","state":"NJ","postcode":"07712","country":"US"}},"_links":{"self":{"href":"/v2/animals/49656243"},"type":{"href":"/v2/types/cat"},"organization":{"href":"/v2/organizations/nj398"}}}
     */

    private AnimalBean animal;

    public AnimalBean getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalBean animal) {
        this.animal = animal;
    }

    public static class AnimalBean {
        /**
         *
         * The data fields below can be retrieved from petfinder api but for simplicity we only used a couple of them in this app.
         * id : 49656243
         * organization_id : NJ398
         * url : https://www.petfinder.com/cat/sweet-pea-49656243/nj/asbury-park/three-little-kittens-inc-nj398/?referrer_id=3a7479dd-ded8-433e-9b9f-52cc8b1d5032
         * type : Cat
         * species : Cat
         * breeds : {"primary":"Tortoiseshell","secondary":null,"mixed":false,"unknown":false}
         * colors : {"primary":"Calico","secondary":null,"tertiary":null}
         * age : Baby
         * gender : Female
         * size : Medium
         * coat : null
         * attributes : {"spayed_neutered":false,"house_trained":true,"declawed":false,"special_needs":false,"shots_current":true}
         * environment : {"children":true,"dogs":null,"cats":true}
         * tags : []
         * name : Sweet Pea
         * description : Age 10-12 wks Meet Sweet Pea! She and her litter were rescued in Freehold. She is part of a bonded-pair...
         * organization_animal_id : null
         * photos : [{"small":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=100","medium":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=300","large":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064"},{"small":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/1/?bust=1604157058&width=100","medium":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/1/?bust=1604157058&width=300","large":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/1/?bust=1604157058&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/1/?bust=1604157058"},{"small":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/2/?bust=1604157061&width=100","medium":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/2/?bust=1604157061&width=300","large":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/2/?bust=1604157061&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/2/?bust=1604157061"}]
         * primary_photo_cropped : {"small":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=300","medium":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=450","large":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064"}
         * videos : []
         * status : adoptable
         * status_changed_at : 2020-10-31T15:11:54+0000
         * published_at : 2020-10-31T15:11:54+0000
         * distance : null
         * contact : {"email":"kittensthree@optonline.net","phone":"732-988-3024","address":{"address1":null,"address2":null,"city":"Asbury Park","state":"NJ","postcode":"07712","country":"US"}}
         * _links : {"self":{"href":"/v2/animals/49656243"},"type":{"href":"/v2/types/cat"},"organization":{"href":"/v2/organizations/nj398"}}
         */

        private int id;
        private String organization_id;
        private String url;
        private String type;
        private String species;
        private BreedsBean breeds;
        private ColorsBean colors;
        private String age;
        private String gender;
        private String size;
        private String name;
        private PrimaryPhotoCroppedBean primary_photo_cropped;
        private String status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrganization_id() {
            return organization_id;
        }

        public String getType() {
            return type;
        }

        public BreedsBean getBreeds() {
            return breeds;
        }

        public ColorsBean getColors() {
            return colors;
        }

        public void setColors(ColorsBean colors) {
            this.colors = colors;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getSize() {
            return size;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public PrimaryPhotoCroppedBean getPrimary_photo_cropped() {
            return primary_photo_cropped;
        }

        public void setPrimary_photo_cropped(PrimaryPhotoCroppedBean primary_photo_cropped) {
            this.primary_photo_cropped = primary_photo_cropped;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }


        public static class BreedsBean {
            /**
             * primary : Tortoiseshell
             * secondary : null
             * mixed : false
             * unknown : false
             */

            private String primary;

            public String getPrimary() {
                return primary;
            }

            public void setPrimary(String primary) {
                this.primary = primary;
            }

        }

        public static class ColorsBean {
            /**
             * primary : Calico
             * secondary : null
             * tertiary : null
             */

            private String primary;

            public String getPrimary() {
                return primary;
            }

            public void setPrimary(String primary) {
                this.primary = primary;
            }

        }


        public static class PrimaryPhotoCroppedBean {
            /**
             * small : https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=300
             * medium : https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=450
             * large : https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064&width=600
             * full : https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49656243/3/?bust=1604157064
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

