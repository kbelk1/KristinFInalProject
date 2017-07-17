package kristinfinalproject.aleademo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import kristinfinalproject.aleademo.R;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CustomDialog extends Dialog {

    @OnClick(R.id.dialog_ok2)
    public void okClick(){
        listener.OnClickListener();
        dismiss();
    }


    private ICustomDialogEventListener listener;


    public interface ICustomDialogEventListener{
        public void OnClickListener();
        }


    public CustomDialog(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);

    }
}
