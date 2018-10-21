package com.hackumass.med.redhacks.Database;


/**
 * Created by Aryan Singh on 10/13/2018.
 */

public class Contract {

    public class Alarms{
        // THESE ARE NAMES OF COLUMNS
        public static final String TABLE_NAME = "alarms";
        public static final String TIME_MILLIS = "time";
    }

    public class Caller{
        public static final String TABLE_NAME = "callers";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "number";
    }

    public class Messenger{
        public static final String TABLE_NAME = "messenger";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "number";
    }
}
