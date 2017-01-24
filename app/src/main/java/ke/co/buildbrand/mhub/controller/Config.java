package ke.co.buildbrand.mhub.controller;

/**
 * Created by StartappzKE on 17-Oct-16.
 */

public class Config {

    //URL to our login.php file
    public static final String LOGIN_URL = "http://masomohub.com/vegber/login.php";

    //URL to our register.php file
    public static final String REGISTER_URL = "http://masomohub.com/vegber/register.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONE= "phone";
    public static final String KEY_NAMES= "names";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_COUNTRY = "country";


    public static final String LOGIN_SUCCESS = "success";

    public static final String EXISTS = "exists";


    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "mylogindetails";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "email";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";



    //Data URLS
    public static final String DATA_URL = "http://masomohub.com/masomohub/getnotes.php";

    //Tags for my JSON

    /*private String filename;
    private String filepath;
    private String filesize;
    private String filetype;
    private String datecreated;*/

    public static final String TAG_FILE_NAME= "filename";
    public static final String TAG_FILE_PATH = "filepath";
    public static final String TAG_FILE_SIZE = "filesize";
    public static final String TAG_FILE_TYPE = "filetype";
    public static final String TAG_CREATED_AT = "datecreated";

}