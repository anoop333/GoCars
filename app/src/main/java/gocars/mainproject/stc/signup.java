package gocars.mainproject.stc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {
EditText uid,email,pass,confpass;
Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        uid=findViewById(R.id.editText2);
        email=findViewById(R.id.editText3);
        pass=findViewById(R.id.editText4);
        confpass=findViewById(R.id.editText5);
        signup=findViewById(R.id.button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {



                if(uid.getText().toString().isEmpty()||email.getText().toString().isEmpty()||pass.getText().toString().isEmpty()||confpass.getText().toString().isEmpty())
                {
                    Toast.makeText(signup.this,"empty",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://boss-jewel.000webhostapp.com/signup.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    Toast.makeText(signup.this,response,Toast.LENGTH_LONG).show();

                                    Intent j=new Intent(signup.this,Main2Activity.class);
                                    startActivity(j);
                                }
                            },

                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
//You can handle error here if you want
                                }

                            }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
//Adding parameters to request

                            params.put("uname",uid.getText().toString());
                            params.put("email",email.getText().toString() );
                            params.put("pass",pass.getText().toString());

// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                            return params;
                        }

                    };


// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(signup.this);
                    requestQueue.add(stringRequest);
                }



            }



        });
                }

}
