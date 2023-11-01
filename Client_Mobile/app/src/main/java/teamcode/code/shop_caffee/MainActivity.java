package teamcode.code.shop_caffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (ImageView) findViewById(R.id.logo);
        slogan = (TextView) findViewById(R.id.slogan);

        Animation top_anim = (Animation) AnimationUtils.loadAnimation(this, R.anim.top_anim);
        Animation bot_anim = (Animation) AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        logo.setAnimation(top_anim);
        slogan.setAnimation(bot_anim);

        new Handler().postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      Intent intent = new Intent(MainActivity.this, order_product.class);
                      startActivity(intent);
                  }
              }, 1500);

    }
}