package com.example.kamionproject1;



import java.util.regex.Matcher;




import java.util.regex.Pattern;

 

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Register extends Activity{
	String phonenumber,username,password;
	private EditText phno,mail,pass;
	DBAdapter dbAdapter;
	private Button b1;
	private ImageView imageview;
	

	 @SuppressLint("NewApi") @Override
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	         setContentView(R.layout.register);
	         ActionBar actionBar = getActionBar();
	         getActionBar().hide();
             actionBar.setDisplayShowHomeEnabled(false);
             actionBar.setDisplayShowTitleEnabled(false);

	        dbAdapter=new DBAdapter(this);
	  	  dbAdapter.open();
	        phno=(EditText)findViewById(R.id.editText1);
	        mail=(EditText)findViewById(R.id.editText2);
	        pass=(EditText)findViewById(R.id.editText3);
	        imageview=(ImageView)findViewById(R.id.imageView1);
	        TranslateAnimation animation=new TranslateAnimation(0.0f, 400.0f,0.0f,0.0f);
	        animation.setDuration(5000);
	        animation.setRepeatCount(10);
	        animation.setRepeatMode(5);
	        imageview.startAnimation(animation);
	        b1=(Button)findViewById(R.id.button1);
	         
	          b1.setOnClickListener(new click());
	          pass.setOnFocusChangeListener(new setOnFocusChangeListener());
	 }
	 public class setOnFocusChangeListener implements android.view.View.OnFocusChangeListener
	 {

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub
			if(hasFocus){
//				var foo = phno.getText().toString();
//				foo.match(new RegExp('.{1,4}$|.{1,3}', 'g')).join("-");
				Pattern sameDigits = Pattern.compile("(\\d)(\\1){3,}");

				String num =  phno.getText().toString();
				    if (sameDigits.matcher(num).matches())
				        System.out.println("Same digits: " + num);
				    else
				        System.out.println("Not same digits: " + num);
		        Toast.makeText(getApplicationContext(), "got the focus", Toast.LENGTH_LONG).show();
		    }else {
		        Toast.makeText(getApplicationContext(), "lost the focus", Toast.LENGTH_LONG).show();
		    }
		}
		};

		 
	 
	 public class click implements android.view.View.OnClickListener{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub 
	  
		 phonenumber=phno.getText().toString();
		 username=mail.getText().toString();
		 password=pass.getText().toString();
		 boolean check=false;
		 Pattern p;
		 Matcher m;
	   
		  String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		    p = Pattern.compile(EMAIL_STRING);

		    m = p.matcher(username);
		    check = m.matches();
		    Pattern sameDigits = Pattern.compile("(\\d)(\\1){3,}");
//		    Boolean sameMobileDigit ;
//			
//			    if (sameDigits.matcher(num).matches())
//			    {
//			    	
//			    	sameMobileDigit =num.matches("(\\d)(?!\\1+$)\\d{10}");
//			    	 
//			    }
//			      else
			 
	
		    String num =  phno.getText().toString();
			 if((!Pattern.matches("[a-zA-Z]+", phonenumber))||(Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", username))||(Pattern.matches("[a-zA-Z0-9]+", password)))
			    {   
			        if((phonenumber.length() >10)||(phonenumber.length() <10))
			        {
			             Toast.makeText(getApplicationContext(), "phno. is not valid...", Toast.LENGTH_LONG).show();
			         
			        } 
			        
			        else if(check == false){
			        	 Toast.makeText(getApplicationContext(), "Email. is not valid...", Toast.LENGTH_LONG).show();
			        }else if((password.length() >6)||(password.length() <6)){
			        	 Toast.makeText(getApplicationContext(), "Password should be 6 characters...", Toast.LENGTH_LONG).show();
			       }else if(sameDigits.matcher(num).matches()){
			         	 Toast.makeText(getApplicationContext(), "mobile no.sbould not nbe same",Toast.LENGTH_LONG).show();
			 	  }
			        else
			        {
			            check = true;
			            long l=dbAdapter.register(phonenumber, username, password);
			            if(l!=-1)
			            Toast.makeText(getApplicationContext(), "Account Created",Toast.LENGTH_LONG).show();
			            Intent i=new Intent(Register.this,BookingPage.class);
			            startActivity(i);
			        }
			    
			    }
	 
			   else 
			    {
			        check=false;
			        
			    }

	 }
	
			  
		
		}
		 
	 
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
}
