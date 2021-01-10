package net.mcamigos.petfinder.data.model;

import java.util.List;

public class OrganizationResponse {


    /**
     * organization : {"id":"CA1566","name":"Marley's Mutts Dog Rescue","email":"adoptions@marleysmutts.com","phone":"(661) 556-7178","address":{"address1":null,"address2":null,"city":"Tehachapi","state":"CA","postcode":"93561","country":"US"},"hours":{"monday":null,"tuesday":null,"wednesday":null,"thursday":null,"friday":null,"saturday":null,"sunday":null},"url":"https://www.petfinder.com/member/us/ca/tehachapi/marleys-mutts-dog-rescue-ca1566/?referrer_id=3a7479dd-ded8-433e-9b9f-52cc8b1d5032","website":null,"mission_statement":"Mission Statement:\r\n\r\nMarley\u2019s Mutts is a non-profit organization that rescues, rehabilitates, trains and re-homes death row dogs from Kern County\u2019s...","adoption":{"policy":"Every dog that comes through Marley&#039;s Mutts lives in a foster home. We do not have a physical facility where...","url":"https://www.marleysmutts.org/the-adoption-process/"},"social_media":{"facebook":"http://www.facebook.com/MarleysMuttsDogRescue","twitter":null,"youtube":null,"instagram":null,"pinterest":null},"photos":[{"small":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/1/?bust=1511941375&width=100","medium":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/1/?bust=1511941375&width=300","large":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/1/?bust=1511941375&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/1/?bust=1511941375"},{"small":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/2/?bust=1521507263&width=100","medium":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/2/?bust=1521507263&width=300","large":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/2/?bust=1521507263&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/2/?bust=1521507263"},{"small":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/3/?bust=1574374508&width=100","medium":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/3/?bust=1574374508&width=300","large":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/3/?bust=1574374508&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/3/?bust=1574374508"},{"small":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/4/?bust=1574374509&width=100","medium":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/4/?bust=1574374509&width=300","large":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/4/?bust=1574374509&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/4/?bust=1574374509"},{"small":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/5/?bust=1574374509&width=100","medium":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/5/?bust=1574374509&width=300","large":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/5/?bust=1574374509&width=600","full":"https://dl5zpyw5k3jeb.cloudfront.net/organization-photos/27314/5/?bust=1574374509"}],"distance":null,"_links":{"self":{"href":"/v2/organizations/ca1566"},"animals":{"href":"/v2/animals?organization=ca1566"}}}
     */

    private OrganizationBean organization;

    public OrganizationBean getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationBean organization) {
        this.organization = organization;
    }

    public static class OrganizationBean {
        /**
         * id : CA1566
         * name : Marley's Mutts Dog Rescue
         * Potentially the data fields below about Organization could have been added to the app but not used in our app for the simplicity
         * email : adoptions@marleysmutts.com
         * phone : (661) 556-7178
         * address : {"address1":null,"address2":null,"city":"Tehachapi","state":"CA","postcode":"93561","country":"US"}
         * hours : {"monday":null,"tuesday":null,"wednesday":null,"thursday":null,"friday":null,"saturday":null,"sunday":null}
         * url : https://www.petfinder.com/member/us/ca/tehachapi/marleys-mutts-dog-rescue-ca1566/?referrer_id=3a7479dd-ded8-433e-9b9f-52cc8b1d5032
         * website : null
         * distance : null
         */

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
