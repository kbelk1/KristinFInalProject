package kristinfinalproject.aleademo;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kristinfinalproject.aleademo.dialog.CustomDialog;





public class DialogActivity extends BaseActivity {

    private int checkedID;
    public final int DIALOG = 12345;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case DIALOG:
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    toastShort("Dialog Message: " +s);
                    break;
                default:
            }

            super.handleMessage(msg);
        }
    };

    @BindView(R.id.rdg) RadioGroup radioGroup;
    @OnClick(R.id.dialog_ok)
    public void okClick(){
      switch (checkedID){
          case R.id.rb1:
              healthyDialog();
              break;
          case R.id.rb2:
              drinkupDialog();
              break;
          case R.id.rb4:
             multiChoiceDialog();
              break;
          case R.id.rb7:
              inputDialog();
              break;
          case R.id.rb8:
              customDialog();
              break;

          default:
      }
    }

    private void customDialog() {
        final CustomDialog dialog = new CustomDialog(this, new CustomDialog.ICustomDialogEventListener(){
            @Override
            public void OnClickListener() {
                Intent intent = new Intent();
                intent.putExtra("message", "Dialog");
                setResult(RESULT_OK, intent);
                //super.onBackPressed();
                finish();
            }
        });
        dialog.show();
    }


    //bt7
private void inputDialog(){
    final EditText editText = new EditText(this);
    AlertDialog.Builder inputDialog = new AlertDialog.Builder(this);
    inputDialog.setMessage("What Have You Done Today To Reach Your Health Goals?").setView(editText);
    inputDialog.setPositiveButton("Awesome", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            toastShort(editText.getText().toString());
        }
    });
    inputDialog.setNegativeButton("Cancel", null).show();
}




    //bt4
    ArrayList<Integer> choices = new ArrayList<>();
    private void multiChoiceDialog(){
        final String[] items = {"Endurance", "Strength", "Balance", "Cardio"};
        final boolean initChoiceSets[] = {false, false, false, false};
        choices.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Any That Apply to You");
        builder.setMultiChoiceItems(items, initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    choices.add(which);

                }else{
                    choices.remove(which);
                }
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size = choices.size();
                String str = "";
                for(int i = 0; i < size; i++){
                    str += items[choices.get(i)] + " ";

                }
                toastShort("You chose: " + str);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                toastLong("Cancel was clicked");
            }
        });
        builder.show();
    }


    //bt2
    private void drinkupDialog(){
        final String[] items = {"Children 4–8 years old: 5 Cups", "Children 9–13 years old: 7-8 Cups", "Children 14–18 years old: 8-11 Cups", "Men, 19 years and older: 13 Cups", "Women, 19 years and older: 13 Cups"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Water Recommendation!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toastShort("You clicked: " +items[which]);
            }
        });
        builder.show();
    }



    //bt1
    private void healthyDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Did You Consume More Fruits/Veggies In Your Diet Today? ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toastShort("You clicked Yes");
            }
        });

        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            toastShort("You clicked Neutral");
            }
        });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    toastShort("You clicked Cancel");
                }
            });

            builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){
                toastShort("You checked the RadioButton" +checkedId);
                checkedID = checkedId;
            }
        });
    }
}
