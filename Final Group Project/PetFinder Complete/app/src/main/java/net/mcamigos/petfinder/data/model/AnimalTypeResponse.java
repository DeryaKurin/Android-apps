package net.mcamigos.petfinder.data.model;

import java.util.List;

public class AnimalTypeResponse {

    private List<TypesBean> types;

    public List<TypesBean> getTypes() {
        return types;
    }

    public void setTypes(List<TypesBean> types) {
        this.types = types;
    }

    public static class TypesBean {
        /**
         * name : Rabbit
         */

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}

