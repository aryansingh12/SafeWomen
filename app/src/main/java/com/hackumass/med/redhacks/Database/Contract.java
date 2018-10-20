package com.hackumass.med.redhacks.Database;


/**
 * Created by Aryan Singh on 10/13/2018.
 */

public class Contract {

    public class User{
        // THESE ARE NAMES OF COLUMNS
        public static final String TABLE_NAME = "user_only";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_SMOKING = "smoking";
        public static final String COLUMN_ALCOHOL = "drinking";
        public static final String COLUMN_PAIN = "pain";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_MEDICATIONS = "medications";
        public static final String COLUMN_SYMPTOMS = "conditions";

    }

    public class Contacts{
        public static final String TABLE_NAME = "contacts";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "number";
    }
}
