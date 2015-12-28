package com.example.kamionproject1;





 


import java.util.regex.Pattern;
import android.os.Bundle;
import android.annotation.SuppressLint;
 
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;

/*import android.text.Html;
import android.text.method.LinkMovementMethod;*/
import android.view.Menu;
import android.view.View;
 
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
 
import android.widget.Toast;

@SuppressLint("NewApi") public class Login extends Activity {
	DBAdapter dbAdapter;
 
String phonenumber,password;
private EditText t1,t2;
private Button b1;
 private TextView e1,e2,e3,e4;  
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
                setContentView(R.layout.loginpage);
                ActionBar actionBar = getActionBar();
                getActionBar().hide();
                actionBar.setDisplayShowHomeEnabled(false);
                actionBar.setDisplayShowTitleEnabled(false);
                


                dbAdapter=new DBAdapter(this);
                dbAdapter.open();

        t1=(EditText)findViewById(R.id.editText1);
        t2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button1);
       // b2=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new login_data());
       // b2.setOnClickListener(new register_data());
        e1=(TextView)findViewById(R.id.textView1);
        e2=(TextView)findViewById(R.id.textView2);
        e3=(TextView)findViewById(R.id.textView3);
        e4=(TextView)findViewById(R.id.textView4);
        e4.setOnClickListener(new link());
        e4.setText(R.string.Clickhere);
    
       
   }
    
    
    public class link implements android.view.View.OnClickListener
    {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(Login.this,Register.class);
			startActivity(i);
			
		}
    	
    }
   public class register_data implements android.view.View.OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(Login.this,Register.class);
			startActivity(i);  
		}
	   
   }
   public class login_data implements android.view.View.OnClickListener{

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		phonenumber=t1.getText().toString();
		password=t2.getText().toString();
	 if((!Pattern.matches("[a-zA-Z]+", phonenumber))||(Pattern.matches("[a-zA-Z0-9]+", password)))
	    {    
	        if((phonenumber.length() >10)||(phonenumber.length() <10))
	        {
	             Toast.makeText(getApplicationContext(), "phno. is not valid...", Toast.LENGTH_LONG).show();
	         
	        } else if((password.length() >6)||(password.length() <6)){
	        	 Toast.makeText(getApplicationContext(), "Password should be 6 characters...", Toast.LENGTH_LONG).show();
	        }
	    else
	        {
	        if(dbAdapter.Login(phonenumber,password))
	        {    
	        
	           Toast.makeText(getApplicationContext(), "processing",Toast.LENGTH_LONG).show();
	           Intent i=new Intent(Login.this,BookingPage.class);
	           startActivity(i);
	      }
	        
	       else
	        {
	        	Toast.makeText(getApplicationContext(), "Invalid mobilenumber or password",Toast.LENGTH_LONG).show();
	        }
	        }
	        }
	    }
	    }
 public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}






