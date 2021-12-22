package com.mycompany.myapp.bframework;

import android.app.Dialog;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeFragment.onregister, HomeFragment.unlocki, LoaderManager.LoaderCallbacks<Cursor>, HomeFragment.onlogin {
    SharedPreferences ourSharedPreference;
    SharedPreferences.Editor myeditor;
    Toolbar toolbarx;
    int keynameindex, keyaddressindex, keyphonenumberindex, keypasswordindex, keyemailindex;
    Uri processi, processo, processor;
    MyFragmentAdapter madapter;
    ViewPager mViewPager;
    Dialog hiy, aboute, wtt;
    public static  String iname, iemail, inumber , iaddress;
    public static int itransaction = -1;
    public static int  ibusiness = -1;
    public static int iadvert = -1;
    RelativeLayout mwhole;
    String monitor;
   static ActionBar myBar;
    RelativeLayout leecomet;
    TextView weee, wename;
    ListView rlistview;
    String userod;
    TextView yoyor;
    AlphaAnimation anima, animb;
    FirebaseAuth mAuth;
    TranslateAnimation translateat;
    FirebaseDatabase Fdb;
    TabLayout tabss;
    private FirebaseAuth.AuthStateListener mAuthListener;
    FloatingActionButton commentdone;
    EditText mycomment;
    NavigationView navview;
    private DatabaseReference mDatabase, mldatabase;
    private int[] tabIcons = {
            R.drawable.home,
            R.drawable.craft,
            R.drawable.info,
            R.drawable.framespice,
            R.drawable.chatw
    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        toolbarx = (Toolbar) findViewById(R.id.toolbarn);
        setSupportActionBar(toolbarx);
        monitor = "cool";
        ourSharedPreference = getSharedPreferences(HomeFragment.DATA, MODE_PRIVATE);
        myeditor = ourSharedPreference.edit();
        madapter = new MyFragmentAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(madapter);
        myBar = getSupportActionBar();
        myBar.setDisplayShowHomeEnabled(true);
        animb = new AlphaAnimation(1,0);
        animb.setDuration(9000);
        Intent j = this.getIntent();

        userod = j.getStringExtra("theid");
        anima =new AlphaAnimation(0,1);
        anima.setDuration(6000);
        translateat = new TranslateAnimation(0,500,0,0);
        translateat.setDuration(1500);
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
       Fdb = FirebaseDatabase.getInstance();
        mDatabase = Fdb.getReference("Users");
        mldatabase = Fdb.getReference("EconValue");
         tabss = (TabLayout) findViewById(R.id.tabss);
        tabss.setupWithViewPager(mViewPager);
        hiy = new Dialog(this);
        navview = (NavigationView)findViewById(R.id.nav_view);

        hiy.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        hiy.setContentView(R.layout.comments);
        aboute = new Dialog(this);
        aboute.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        aboute.setContentView(R.layout.about);
        wtt = new Dialog(this);
        wtt.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        wtt.setContentView(R.layout.welcomet);
        leecomet = (RelativeLayout)wtt.findViewById(R.id.leecomet);
        weee = (TextView)wtt.findViewById(R.id.weee);
        wename = (TextView)wtt.findViewById(R.id.wename);
       rlistview = (ListView)findViewById(R.id.rlistView);

//       wtt.show();
        mAuth = FirebaseAuth.getInstance();
        CountDownTimer timern = new CountDownTimer(13500,500) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                weee.startAnimation(translateat);
                CountDownTimer timern = new CountDownTimer(1500,500) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        weee.setVisibility(View.GONE);
                        wename.setVisibility(View.VISIBLE);
                        wename.startAnimation(anima);
                        leecomet.startAnimation(animb);

                        CountDownTimer timere = new CountDownTimer(8600,500) {
                            @Override
                            public void onTick(long l) {
                            }

                            @Override
                            public void onFinish() {

                                leecomet.setVisibility(View.GONE);
                                wtt.cancel();


                            }
                        }.start();
                    }
                }.start();
            }
        }.start();

        commentdone = (FloatingActionButton) hiy.findViewById(R.id.commentdone);
        commentdone.setOnClickListener(commentdoneListener);
        mycomment = (EditText) hiy.findViewById(R.id.mycomment);
        tabss.setSelectedTabIndicatorColor(Color.parseColor("#eee6a4"));
        tabss.setTabGravity(TabLayout.GRAVITY_CENTER);

        tabss.setTabTextColors(Color.parseColor("#afafaf"), Color.parseColor("#eee6a4"));
   setupTabIcons();
       getLoaderManager().initLoader(0, null,this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbarx, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
   stratup();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        yoyor = (TextView)navigationView.findViewById(R.id.yoyor);
        mAuth.addAuthStateListener(Authstate);
    }
   FirebaseAuth.AuthStateListener Authstate = new FirebaseAuth.AuthStateListener() {
       @Override
       public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
           FirebaseUser user = firebaseAuth.getCurrentUser();
           if (user != null) {
// User is signed
               String tyid = mAuth.getUid();
               mDatabase.child(tyid).addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                       User user = dataSnapshot.getValue(User.class);
//                       Transaction trans = dataSnapshot.getValue(Transaction.class);
//                       iname =  dataSnapshot.child("username").getValue().toString();
//                       iemail = dataSnapshot.child("email").getValue().toString();
//                       inumber =   dataSnapshot.child("mobile").getValue().toString();
//                       iaddress = dataSnapshot.child("address").getValue().toString();
//                       iadvert = trans.getAdvertnumber();
//                       itransaction = trans.getTransactionnumber();
//                       ibusiness = trans.getBusinessnumber();
//                     yoyor.setText(iname);
                   }

                   @Override
                   public void onCancelled(DatabaseError databaseError) {
                       displayo("failed to read");
                   }
               });
               mldatabase.child(tyid).addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                       Transaction transc = dataSnapshot.getValue(Transaction.class);

//                       iadvert = Integer.parseInt(dataSnapshot.child("advertnumber").getValue().toString());
//                       itransaction = Integer.parseInt(dataSnapshot.child("transactionnumber").getValue().toString());
//                       ibusiness = Integer.parseInt(dataSnapshot.child("businessnumber").getValue().toString());
////                       yoyor.setText(iname);
                   }

                   @Override
                   public void onCancelled(DatabaseError databaseError) {
                       displayo("failed to read");
                   }
               });
               displayo("signed in");
           } else {
// User is signed out
               displayo("sign in failed");

           }
       }
   };
    public  void tripoyio(String nu){

    }
    private void setupTabIcons() {
        tabss.getTabAt(0).setIcon(tabIcons[0]);
        tabss.getTabAt(1).setIcon(tabIcons[1]);
        tabss.getTabAt(2).setIcon(tabIcons[2]);
        tabss.getTabAt(3).setIcon(tabIcons[3]);
        tabss.getTabAt(4).setIcon(tabIcons[4]);
    }
 ValueEventListener vrew = new ValueEventListener() {
     @Override
     public void onDataChange(DataSnapshot dataSnapshot) {
         User user = dataSnapshot.getValue(User.class);
         Transaction trans = dataSnapshot.getValue(Transaction.class);
         iname = user.getUsername();
         iemail = user.getEmail();
         inumber = user.getMobile();
         iaddress = user.getAddress();
         iadvert = trans.getAdvertnumber();
         itransaction = trans.getTransactionnumber();
         ibusiness = trans.getBusinessnumber();
     }

     @Override
     public void onCancelled(DatabaseError databaseError) {
     displayo("failed to read");
     }
 };
    @Override
    public void unlock(String a, String b) {

         mAuth.signInWithEmailAndPassword(a,b).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful()){

                     displayo("good");


                     }

                 else {
 displayo("couldn,t sign in details could be faulty");

                 }
             }
         });
    }
    public void stratup(){

        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        ContentValues vralues = new ContentValues();
        ContentValues vrolues = new ContentValues();
        values.put(AnnContentProvider.KEY_COMMENT_IMAGE, 0);
        values.put(AnnContentProvider.KEY_THE_NAME, "framee");
      values.put(AnnContentProvider.KEY_TO_WHO, "you");
        values.put(AnnContentProvider.KEY_FROM_WHO, "framee");
        values.put(AnnContentProvider.KEY_TYPI, 0);
        values.put(AnnContentProvider.KEY_BODY, "hi hope you are doing good please do not fear, take care");
        values.put(AnnContentProvider.KEY_DATE, "23 23 23");
        values.put(AnnContentProvider.KEY_TIME, "23 04");
        vralues.put(AnnContentProvider.KEY_COMMENT_IMAGE, 0);
        vralues.put(AnnContentProvider.KEY_THE_NAME, "framees");
        vralues.put(AnnContentProvider.KEY_TO_WHO, "you");
        vralues.put(AnnContentProvider.KEY_FROM_WHO, "framees");
        vralues.put(AnnContentProvider.KEY_TYPI, 0);
        vralues.put(AnnContentProvider.KEY_BODY, "hi hope you are doing good please do not fear, take care");
        vralues.put(AnnContentProvider.KEY_DATE, "23 23 23");
        vralues.put(AnnContentProvider.KEY_TIME, "23 04");
        vrolues.put(AnnContentProvider.KEY_COMMENT_IMAGE, 0);
        vrolues.put(AnnContentProvider.KEY_THE_NAME, "framees");
        vrolues.put(AnnContentProvider.KEY_TO_WHO, "you");
        vrolues.put(AnnContentProvider.KEY_FROM_WHO, "framees");
        vrolues.put(AnnContentProvider.KEY_TYPI, 0);
        vrolues.put(AnnContentProvider.KEY_BODY, "hi hope you are doing good please do not fear, take care");
        vrolues.put(AnnContentProvider.KEY_DATE, "23 23 23");
        vrolues.put(AnnContentProvider.KEY_TIME, "23 04");
        processi = cr.insert(AnnContentProvider.CONTENT_URI, values);
        processo = cr.insert(AnnContentProvider.CONTENT_URI, vralues);
        processor = cr.insert(AnnContentProvider.CONTENT_URI, vrolues);
        getLoaderManager().restartLoader(0, null, this);
        displayo(values.toString());
        monitor = "happy";


    }
    View.OnClickListener commentdoneListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mycomment.getText() == null || mycomment.getText().toString().equals("")) {
                displayo("you have not entered any comment");
                mycomment.setHintTextColor(Color.RED);
                mycomment.setHint("please enter your comment");
            } else {
                displayo("comment sent");
                hiy.cancel();
                mycomment.setText(null);
            }
        }
    };

    @Override
     public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader loader = new CursorLoader(this,
                AnnContentProvider.CONTENT_URI, null, null, null, null);
        return loader;
    }

    @Override
    public void trylogin() {
        String namecopi = HomeFragment.nname;
        String passicopi = HomeFragment.npassword;

    }

    @Override
    public void registered() {



//        ContentResolver cr = getContentResolver();
//        ContentValues values = new ContentValues();
//        values.put(AnnContentProvider.KEY_USER_NAME, Signupe.mname);
//        values.put(AnnContentProvider.KEY_ADDRESS, Signupe.maddress);
//      values.put(AnnContentProvider.KEY_PHONE_NUMBER, Signupe.mnumber);
//        values.put(AnnContentProvider.KEY_EMAIL, Signupe.memail);
//        values.put(AnnContentProvider.KEY_PASSWORD, Signupe.mpassword);
//        processi = cr.insert(AnnContentProvider.CONTENT_URI, values);
//        getLoaderManager().restartLoader(0, null, this);
//        displayo(values.toString());
//        monitor = "happy";


    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

    /*  int keynameindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_USER_NAME);
      int keyaddressindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_ADDRESS);
        int keyemailindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_EMAIL);
     int keyphonenumberindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_PHONE_NUMBER);
        int keypasswordindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_PASSWORD);
//       int keyadertnumberindex= cursor.getColumnIndexOrThrow(MyContentProvider.KEY_AVDERT_NUMBER);
//        int keybusinessnumberindex = cursor.getColumnIndexOrThrow(MyContentProvider.KEY_BUSINESS_NUMBER);
//        int keytransactionindex = cursor.getColumnIndexOrThrow(MyContentProvider.KEY_TRANSACTIONS);
        displayo(String.valueOf(keyaddressindex));
        displayo(String.valueOf(keynameindex));
        displayo(String.valueOf(keyemailindex));
        displayo(String.valueOf(keypasswordindex));
        displayo(String.valueOf(keyphonenumberindex));

/*if(monitor.equals("happy")){
    myeditor.putString("youraddress",cursor.getString(keyaddressindex));
    myeditor.putString("youremail",cursor.getString(keyemailindex));
   myeditor.putString("yournumber",cursor.getString(keyphonenumberindex));
    myeditor.putString("yourpassword",cursor.getString(keypasswordindex));
//    myeditor.putString("youradvertnumber",cursor.getString(keyadertnumberindex));
//    myeditor.putString("yourbusinessnumber",cursor.getString(keybusinessnumberindex));
//    myeditor.putString("yourtransactionnumber",cursor.getString(keytransactionindex));

myeditor.putString("yourname",cursor.getString(keynameindex));
    myeditor.commit();

    Toast.makeText(getApplicationContext(),ourSharedPreference.getString("yourname","madnesoo"),Toast.LENGTH_LONG).show();*/
        int keythenameindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_THE_NAME);
        int keyfromwhoindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_FROM_WHO);
        int keytowhoindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_TO_WHO);
        int keybodyindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_BODY);
        int keytheimageindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_COMMENT_IMAGE);
        int dateindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_DATE);
        int timeindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_TIME);
        int keytypiindex = cursor.getColumnIndexOrThrow(AnnContentProvider.KEY_TYPI);
        if (cursor != null) {
            cursor.moveToFirst();
            displayo(cursor.getString(keythenameindex));
            CommentFragment.cemmentList.clear();
            while (cursor.moveToNext()) {
                String thenamen = cursor.getString(keythenameindex);
                String fromwhon = cursor.getString(keyfromwhoindex);
                String towhon = cursor.getString(keytowhoindex);
                String bodon = cursor.getString(keybodyindex);
                String daton = cursor.getString(dateindex);
                String timon = cursor.getString(timeindex);
                int typon = cursor.getInt(keytypiindex);
                int imanen = cursor.getInt(keytheimageindex);

                Comment homen = new Comment(towhon, fromwhon, typon, bodon, daton, timon);
                CommentHolder houlder = new CommentHolder(thenamen, imanen, homen);
                CommentFragment.sortit(houlder, CommentFragment.cemmentList);

            }
            CommentFragment.running();
        }
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    @Override
    protected void onResume() {
        super.onResume();
  getLoaderManager().restartLoader(0, null, this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("sure to leave the framework?")
                    .setCancelable(false)
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MainActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
//            super.onBackPressed();
        }
    }

    public void displayo(String ji) {
        Toast.makeText(this, ji, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.recent) {
            // Handle the camera action


        } else if (id == R.id.businees) {
            mViewPager.setCurrentItem(1);

        } else if (id == R.id.informatione) {

            mViewPager.setCurrentItem(2);
        } else if (id == R.id.commente) {

            hiy.show();
        } else if (id == R.id.nav_share) {
            String puto = "Hi! are you on the Bframework?\nif you aren't, you better do\nits a wondeful world of its own\n";
            Intent shareit = new Intent(Intent.ACTION_SEND);
            shareit.putExtra(Intent.EXTRA_TEXT, puto);
            shareit.setType("text/plain");
            startActivity(Intent.createChooser(shareit, "share using .."));

        } else if (id == R.id.about) {
            aboute.show();
        }
        else if (id == R.id.framespice) {
            mViewPager.setCurrentItem(3);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://com.mycompany.myapp.bframework/http/host/path")
//        );
//        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Main Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://com.mycompany.myapp.bframework/http/host/path")
//        );
//        AppIndex.AppIndexApi.end(client, viewAction);
//        client.disconnect();
//    }
    }
}
