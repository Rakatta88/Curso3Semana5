package com.example.curso3semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactForm extends AppCompatActivity {

    EditText etTo, etName, etMessage, etEmail;
    Button btnSend;
    String sEmail, sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);

        androidx.appcompat.widget.Toolbar myActionBar2 = (Toolbar) findViewById(R.id.myactionbar);
        setSupportActionBar(myActionBar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etName = findViewById(R.id.etNombre);
        etMessage = findViewById(R.id.etMensaje);
        etEmail = findViewById(R.id.etEmail);
        btnSend = findViewById(R.id.btnSend);

        //TODO Hide Password if not needed anymore
        sEmail = "justtosendemail88@gmail.com";
        sPassword = "********";

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Properties properties = new Properties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                //properties.put("mail.smtp.port", "587");

                //Anternative configuration
                properties.put("mail.smtp.port", "465");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sEmail, sPassword);
                    }
                });

                try {
                    // Initialize email content
                    Message message = new MimeMessage(session);
                    //Sender email
                    message.setFrom(new InternetAddress(sEmail));
                    //Recipient email
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse("rakatta88@gmail.com"));
                    //Email subject
                    message.setSubject("Android Pet App");
                    //Email message
                    message.setText(etMessage.getText().toString().trim());
                    //Send email
                    new SendMail().execute(message);

                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private class SendMail extends AsyncTask<Message,String, String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Create and show progress dialog
            progressDialog = ProgressDialog.show(ContactForm.this, "Please Wait", "Sending Mail...", true, false);
                    }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                //When success
                Transport.send(messages[0]);
                return "Success";
            } catch (MessagingException e) {
                //When error
                e.printStackTrace();
                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Dismiss progress dialog
            progressDialog.dismiss();
            if (s.equals("Success")){
                //When Success

                //Initialize alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ContactForm.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color = '#509324'>Success</font>"));
                builder.setMessage("Mail send successfully.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //Clear all edit text
                        etEmail.setText("");
                        etMessage.setText("");
                        etName.setText("");
                    }
                });
                builder.show();
            } else {
                //When error
                Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_LONG).show();
            }
        }
    }

}