package fabian.stomas.aplicacion2;
import static fabian.stomas.aplicacion2.Usuarios.usuarios;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import fabian.stomas.aplicacion2.databinding.Ventana2Binding;

public class ventana_2 extends AppCompatActivity {
    String email;
    String pass;
    DatabaseManager dtbmng = new DatabaseManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Ventana2Binding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ventana2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ventana2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<Tipo_canal> tipo_canal = dtbmng.getAllTipoCanales();
        for(Tipo_canal i: tipo_canal){
            System.out.println(i.ID);
            System.out.println(i.Nombre);
        }
        binding = Ventana2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = binding.editCorreo.getText().toString();
                pass = binding.editPass.getText().toString();
                Usuario usuario = dtbmng.getUsuarioByPassEmail(email, pass);
                if(usuario != null){
                    usuarios.add(usuario);
                    Usuario.idActual = usuario.getIdUsuarioActual(usuario.ID);
                    Intent intent = new Intent(ventana_2.this, Menu.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(ventana_2.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }


            }
        });
        binding.enlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ventana_2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        binding.contra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ventana_2.this, Password.class);
                startActivity(intent);
            }
        });

    }
}
