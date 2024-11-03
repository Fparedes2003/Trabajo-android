package fabian.stomas.aplicacion2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static fabian.stomas.aplicacion2.Usuarios.usuarios;
import fabian.stomas.aplicacion2.databinding.EditarUsuarioBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class editarUsuario extends AppCompatActivity {
    DatabaseManager dtbsmng = new DatabaseManager(this);
    String emailActual;
    String emaildb;
    String newEmail;
    String passwordActual;
    String passwordActual2;
    String passworddb;
    String newPassword;
    protected void onCreate(Bundle savedInstanceState){
        EditarUsuarioBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.editar_usuario);
        binding = EditarUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        for(Usuario i: usuarios){
            passworddb = i.Password;
            emaildb = i.Correo;
        }
        binding.returnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(editarUsuario.this, Editar.class);
                startActivity(intent);
            }
        });
        binding.EditarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailActual = binding.emailACTUAL.getText().toString();
                passwordActual = binding.contraseAACTUAL.getText().toString();
                if(emailActual.equals(emaildb) && passwordActual.equals(passworddb)){
                    newEmail = binding.emailNUEVO.getText().toString();
                    dtbsmng.updateEmailUsuario(newEmail, passwordActual, emailActual);
                    Toast.makeText(editarUsuario.this, "SE HA ACTUALIZADO TU CORREO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(editarUsuario.this, "TU CORREO O CONTRASEÑA NO COINCIDEN CON LOS ACTUALES", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.editarPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordActual2 = binding.passwordActual.getText().toString();
                if(passwordActual2.equals(passworddb)){
                    newPassword = binding.newPassword.getText().toString();
                    dtbsmng.updatePassUsuario(passwordActual2, newPassword);
                    Toast.makeText(editarUsuario.this, "SE HA ACTUALIZADO TU CONTRASEÑA CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(editarUsuario.this, "LA CONTRASEÑA ACTUAL NO COINCIDE", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
