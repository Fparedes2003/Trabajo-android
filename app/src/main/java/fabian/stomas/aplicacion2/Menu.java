package fabian.stomas.aplicacion2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import fabian.stomas.aplicacion2.databinding.MenuBinding;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
    DatabaseManager dbmng = new DatabaseManager(this);
    String nombreCanal;
    String descripcionCanal;
    String tipoCanal;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        MenuBinding binding;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu);
        binding = MenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<Canal> canales = dbmng.getAllCanalesDelUsuario(Usuario.idActual);
        System.out.println("hola");
        binding.buttonCrearCanales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, CrearCanal.class);
                startActivity(intent);
            }
        });
        RecyclerView recyclerView = binding.recycler;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Item> itemList = new ArrayList<>();
        for(Canal i: canales){
            itemList.add(new Item(i.Nombre,i.Descripcion,i.Tipo_canaldb));
        }
        MyAdapter adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);
        binding.usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Editar.class);
                startActivity(intent);
            }
        });

    }
}
