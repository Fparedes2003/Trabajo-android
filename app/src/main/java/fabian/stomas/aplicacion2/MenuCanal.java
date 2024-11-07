package fabian.stomas.aplicacion2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import fabian.stomas.aplicacion2.databinding.MenuCanalBinding;

public class MenuCanal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        MenuCanalBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu_canal);
        binding = MenuCanalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuCanal.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}
