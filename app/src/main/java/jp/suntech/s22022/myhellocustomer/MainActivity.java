package jp.suntech.s22022.myhellocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick = findViewById(R.id.btClick);
        HelloListener listener = new HelloListener();
        btClick.setOnClickListener(listener);

        Button btNameClear = findViewById(R.id.btNameClear);
        btNameClear.setOnClickListener(listener);

        Button btHomeClear = findViewById(R.id.btHomeClear);
        btHomeClear.setOnClickListener(listener);
    }

    private class HelloListener implements View.OnClickListener {
        @Override
        public void onClick(View view){
            EditText input = findViewById(R.id.etName);
            EditText inhome = findViewById(R.id.etHome);

            //タップされた画面部品のidのR値を取得
            int id = view.getId();
            //idのR値に応じて処理を分岐
            if(id==R.id.btClick){
                //入力された名前文字列を取得
                String inputStr = input.getText().toString();
                String home = inhome.getText().toString();
                String show = home + "にお住いの" + inputStr + "さん、こんにちは!";
                //メッセージを表示
                Toast toast = Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }else if(id==R.id.btNameClear){
                //名前入力欄を空文字に設定
                input.setText("");
            }else if(id==R.id.btHomeClear){
                inhome.setText("");
            }
        }
    }
}