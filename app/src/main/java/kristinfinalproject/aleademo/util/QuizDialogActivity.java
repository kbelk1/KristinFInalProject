package kristinfinalproject.aleademo.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kristinfinalproject.aleademo.BaseActivity;
import kristinfinalproject.aleademo.ListViewActivity;
import kristinfinalproject.aleademo.MainActivity;
import kristinfinalproject.aleademo.R;
import kristinfinalproject.aleademo.bean.Book;
import kristinfinalproject.aleademo.dialog.CustomDialog;

public class QuizDialogActivity extends BaseActivity {

    private int checkedID;


    @BindView(R.id.rdg_quiz)
    RadioGroup radioGroup;
    @OnClick(R.id.okay_bt)
    public void okClick(){
        switch (checkedID){
            case R.id.ex_rb1:
                bt1Dialog();
                break;
            case R.id.ex_rb2:
                bt2Dialog();
                break;
            case R.id.ex_rb3:
              bt3Dialog();
                break;
            case R.id.ex_rb4:
              bt4Dialog();
                break;
            case R.id.ex_rb5:
               bt5Dialog();
                break;
            default:
        }
    }

    @OnClick(R.id.cancel_bt)
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), MainActivity.class); //make view pager squat guide
            intent.putExtra("key", "value");
            Bundle bundle = new Bundle();
            bundle.putInt("Integer", 12345);
            Book book = new Book();
            book.setName("Android");
            book.setAuthor("Alea");
            bundle.putSerializable("book", book);
            intent.putExtras(bundle);
            startActivityForResult(intent, 1);
        }


/*    @OnClick(R.id.cancel_bt)
public void onClick(View v) {
    Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
    intent.putExtra("key", "value");
    Bundle bundle = new Bundle();
    bundle.putInt("Integer", 12345);
    Book book = new Book();
    book.setName("Android");
    book.setAuthor("Alea");
    bundle.putSerializable("book", book);
    intent.putExtras(bundle);
    startActivityForResult(intent, 1);
}
*/ //use this in a slide show

    private void bt2Dialog() {
        toActivity(ListViewActivity.class);
    } //movel list view


    private void bt1Dialog() {
        toActivity(ListViewActivity.class);
    }

    private void QuizDialog(){
        CustomDialog quizDialog = new CustomDialog(this, new CustomDialog.ICustomDialogEventListener() {
            @Override
            public void OnClickListener() {
                toastShort("Okay button was clicked");
            }
        });
        quizDialog.show();
    }


    private void bt3Dialog() {
        toActivity(ListViewActivity.class);
    } //movel list view

    private void bt4Dialog() {
        toActivity(ListViewActivity.class);
    } //movel list view

    private void bt5Dialog() {
        toActivity(ListViewActivity.class);
    } //movel list view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dialog);
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
