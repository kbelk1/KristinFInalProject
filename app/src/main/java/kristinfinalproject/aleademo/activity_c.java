package kristinfinalproject.aleademo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by aleac on 2/27/2017.
 */

public class activity_c extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
    }
    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId){
            case R.id.bt1a:
                startActivity(new Intent(this, activity_a.class));
                break;
            case R.id.bt2b:
                startActivity(new Intent(this, activity_b.class));
                break;
            case R.id.bt3c:
                startActivity(new Intent(this, activity_c.class));
                break;
            case R.id.bt4d:
                startActivity(new Intent(this, activity_d.class));
                break;
        }
    }

}