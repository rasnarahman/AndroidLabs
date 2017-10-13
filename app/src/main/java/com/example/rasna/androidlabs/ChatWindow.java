package com.example.rasna.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;


@SuppressWarnings("ALL")
public class ChatWindow extends Activity {
    String TAG = "activity_chat_window.xml";
    ListView listView;
    EditText editText;
    Button sendButton;
    ArrayList<String> messages = new ArrayList<String> ();
    ChatAdapter messageAdapter;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        sendButton = (Button) findViewById(R.id.sendButton);
        editText = (EditText) findViewById(R.id.editText);


        ListView listView = (ListView) findViewById(R.id.listViewChat);

        messages = new ArrayList<String>();
        messageAdapter = new ChatAdapter(this);
        listView.setAdapter(messageAdapter);
        onClick();
    }


    public void onClick( ) {
        sendButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Log.v("EditText", editText.getText().toString());
                String chatString = editText.getText().toString();
                messages.add(chatString);
                messageAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
    }

    private class ChatAdapter extends ArrayAdapter<String> {

        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        @Override
        public int getCount() {

            return messages.size();
        }

        @Override
        public String getItem(int position) {
            return messages.get(position);
        }


        @Override
         public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

            View result = null ;
            if(position%2 == 0){
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            }
            else {
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            }

            message = (TextView)result.findViewById(R.id.message_text);
            message.setText(getItem(position));

            return result;
        }
    }
}
