package fabian.stomas.aplicacion2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fabian.stomas.aplicacion2.databinding.EditarUsuarioBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class editarUsuario extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        EditarUsuarioBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.editar_usuario);
        binding = EditarUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(editarUsuario.this, Editar.class);
                startActivity(intent);
            }
        });
    }
}
