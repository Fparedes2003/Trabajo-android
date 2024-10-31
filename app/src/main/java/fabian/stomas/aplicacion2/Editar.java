package fabian.stomas.aplicacion2;
import static fabian.stomas.aplicacion2.Usuarios.usuarios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fabian.stomas.aplicacion2.databinding.EditarBinding;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Editar extends AppCompatActivity {
    String usuarioNombre;
    String usuarioApellido;
    String usuarioCorreo;
    String usuarioTelefono;
    protected void onCreate(Bundle savedInstanceState){
        EditarBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.editar);
        binding = EditarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        for(Usuario i: usuarios){
            binding.profileText.setText(i.Nombre);
            binding.emailText.setText(i.Correo);
        }
        binding.usereditBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Editar.this, editarUsuario.class);
                startActivity(intent);
            }
        });
        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Editar.this, Menu.class);
                startActivity(intent);
            }
        });
    }

}
