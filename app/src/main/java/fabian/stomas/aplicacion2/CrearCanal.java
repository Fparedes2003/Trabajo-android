package fabian.stomas.aplicacion2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import fabian.stomas.aplicacion2.databinding.CrearCanalBinding;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class CrearCanal extends AppCompatActivity {
    Canal canal = new Canal();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        CrearCanalBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.crear_canal);
        binding = CrearCanalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name;
                String tipo_canal;
                int tipo_canalId = 0;
                String descripcion;
                name = binding.nombreCanal.getText().toString();
                canal.setNombre(name);
                tipo_canal = binding.tipo.getSelectedItem().toString();
                if(tipo_canal == "Seleccione un tipo de canal"){
                    Toast.makeText(CrearCanal.this, "No se ha seleccionado un tipo de canal", Toast.LENGTH_SHORT).show();

                }else if(tipo_canal == "Estudio"){
                    tipo_canalId = 1;
                } else if(tipo_canal == "Trabajo grupal"){
                    tipo_canalId = 2;
                }else if(tipo_canal == "Apuntes"){
                    tipo_canalId = 3;
                }
                System.out.println(tipo_canalId);
                canal.setTipo_canal(tipo_canalId);
                descripcion = binding.descripcion.getText().toString();
                canal.setDescripcion(descripcion);
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