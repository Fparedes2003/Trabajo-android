package fabian.stomas.aplicacion2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
                String descripcion;
                String tipo;
                String integrantes;
                name = binding.nombreCanal.getText().toString();
                canal.setNombre(name);
                descripcion = binding.descripcion.getText().toString();
                canal.setDescripcion(descripcion);
                tipo = binding.tipo.getSelectedItem().toString();
                canal.setTipo_canal(tipo);
                CanalInterm.canales.add(canal);


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