package fabian.stomas.aplicacion2;
import static fabian.stomas.aplicacion2.Usuarios.usuarios;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import fabian.stomas.aplicacion2.databinding.CrearCanalBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CrearCanal extends AppCompatActivity {
    Canal canal = new Canal();
    DatabaseManager dtbsmng = new DatabaseManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        CrearCanalBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.crear_canal);
        binding = CrearCanalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        System.out.println("holaaaa");
        ArrayList<Canal> canales = dtbsmng.getAllCanales();
        for(Canal i: canales){
            System.out.println("ID: "+i.Id);
            System.out.println("Nombre: "+i.Nombre);
            System.out.println("Descripcion: "+i.Descripcion);
            System.out.println("Tipo canal id: "+i.Tipo_canal);
            System.out.println("Admin: "+i.admin);
        }
        binding.crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name;
                String descripcion;
                String tipo_canal;
                int tipo_canalId = 0;
                int admin = 0;

                name = binding.nombreCanal.getText().toString();
                descripcion = binding.descripcion.getText().toString();
                tipo_canal = binding.tipo.getSelectedItem().toString();
                if(tipo_canal.equals("Seleccione un tipo de canal")){
                    Toast.makeText(CrearCanal.this, "No se ha seleccionado ningun canal", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(tipo_canal.equals("Estudio")){
                        tipo_canalId = 1;
                    }else if(tipo_canal.equals("Trabajo grupal")){
                        tipo_canalId = 2;
                    }else if(tipo_canal.equals("Apuntes")){
                        tipo_canalId = 3;
                    }
                    canal.setNombre(name);
                    canal.setDescripcion(descripcion);
                    canal.setTipo_canal(tipo_canalId);
                    admin = Usuario.idActual;
                    canal.setAdmin(admin);
                    dtbsmng.insertCanal(canal);
                    Toast.makeText(CrearCanal.this, "SE HA CREADO TU CANAL", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrearCanal.this, Menu.class);
                startActivity(intent);
            }
        });

    }

}