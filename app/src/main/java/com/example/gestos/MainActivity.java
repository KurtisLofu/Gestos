package com.example.gestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gestos.database.Carta;
import com.example.gestos.database.CartaLab;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Equipo> equipos = new ArrayList<>();
    EditText etSegundosPorRonda;
    EditText etNumeroDeRondas;

    CartaLab cartaLab;
    int idEquipo = 0;

    ListView equiposListView;
    ArrayAdapter<Equipo> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cartaLab = CartaLab.get(this);

        cartaLab.setIsUsedFalseAllCartas();

        etSegundosPorRonda = findViewById(R.id.etSegundosRonda);
        etNumeroDeRondas = findViewById(R.id.etNumeroRondas);

        equiposListView = findViewById(R.id.equiposListView);

        arrayAdapter = new ArrayAdapter<>(this, R.layout.list_white_text, equipos);
        equiposListView.setAdapter(arrayAdapter);

        addEditTextListener();
        addHandlers();

        DebugAddWords();

    }

    private void addHandlers() {
        equiposListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {

                equipos.remove(equipos.get(pos));
                arrayAdapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    private void DebugAddWords() {
        ArrayList<Carta> cartaList = new ArrayList<>();

        /** Fáciles */

        cartaList.add(new Carta( "labios", 1));
        cartaList.add(new Carta( "fuego", 1));
        cartaList.add(new Carta( "uvas", 1));
        cartaList.add(new Carta( "moneda", 1));
        cartaList.add(new Carta( "taza", 1));
        cartaList.add(new Carta( "mosca", 1));
        cartaList.add(new Carta( "margarita", 1));
        cartaList.add(new Carta( "bolígrafo", 1));
        cartaList.add(new Carta( "cereza", 1));
        cartaList.add(new Carta( "cuello", 1));
        cartaList.add(new Carta( "Mickey Mouse", 1));
        cartaList.add(new Carta( "escritorio", 1));
        cartaList.add(new Carta( "barco", 1));
        cartaList.add(new Carta( "vaca", 1));
        cartaList.add(new Carta( "jirafa", 1));
        cartaList.add(new Carta( "maleta", 1));
        cartaList.add(new Carta( "pies", 1));
        cartaList.add(new Carta( "peine", 1));
        cartaList.add(new Carta( "oveja", 1));
        cartaList.add(new Carta( "cebra", 1));
        cartaList.add(new Carta( "dragón", 1));
        cartaList.add(new Carta( "puente", 1));
        cartaList.add(new Carta( "persona", 1));
        cartaList.add(new Carta( "ordenador", 1));
        cartaList.add(new Carta( "estrella", 1));
        cartaList.add(new Carta( "uña", 1));
        cartaList.add(new Carta( "tarta", 1));
        cartaList.add(new Carta( "mono", 1));
        cartaList.add(new Carta( "bandera", 1));
        cartaList.add(new Carta( "monstruo", 1));
        cartaList.add(new Carta( "lazo", 1));
        cartaList.add(new Carta( "naranja", 1));
        cartaList.add(new Carta( "coche", 1));
        cartaList.add(new Carta( "cárcel", 1));
        cartaList.add(new Carta( "escoba", 1));
        cartaList.add(new Carta( "círculo", 1));
        cartaList.add(new Carta( "conejo", 1));
        cartaList.add(new Carta( "ratón", 1));
        cartaList.add(new Carta( "agua", 1));
        cartaList.add(new Carta( "mochila", 1));
        cartaList.add(new Carta( "cuchara", 1));
        cartaList.add(new Carta( "hipopótamo", 1));
        cartaList.add(new Carta( "bicicleta", 1));
        cartaList.add(new Carta( "rizo", 1));
        cartaList.add(new Carta( "rana", 1));
        cartaList.add(new Carta( "tambor", 1));
        cartaList.add(new Carta( "oval", 1));
        cartaList.add(new Carta( "horquilla", 1));
        cartaList.add(new Carta( "cuadrado", 1));
        cartaList.add(new Carta( "agujero", 1));
        cartaList.add(new Carta( "familia", 1));
        cartaList.add(new Carta( "bolso", 1));
        cartaList.add(new Carta( "león", 1));
        cartaList.add(new Carta( "caramelo", 1));
        cartaList.add(new Carta( "piruleta", 1));
        cartaList.add(new Carta( "gafas de sol", 1));
        cartaList.add(new Carta( "línea", 1));
        cartaList.add(new Carta( "muñeca", 1));
        cartaList.add(new Carta( "reloj", 1));
        cartaList.add(new Carta( "insecto", 1));
        cartaList.add(new Carta( "campana", 1));
        cartaList.add(new Carta( "bebé", 1));
        cartaList.add(new Carta( "Tierra", 1));
        cartaList.add(new Carta( "Copo de nieve", 1));
        cartaList.add(new Carta( "sombrero", 1));
        cartaList.add(new Carta( "gato", 1));
        cartaList.add(new Carta( "pulsera", 1));
        cartaList.add(new Carta( "mano", 1));
        cartaList.add(new Carta( "oruga", 1));
        cartaList.add(new Carta( "escalera", 1));
        cartaList.add(new Carta( "pluma", 1));
        cartaList.add(new Carta( "cama", 1));
        cartaList.add(new Carta( "lámpara", 1));
        cartaList.add(new Carta( "murciélago", 1));
        cartaList.add(new Carta( "corazón", 1));
        cartaList.add(new Carta( "vivo", 1));
        cartaList.add(new Carta( "río", 1));
        cartaList.add(new Carta( "hueso", 1));
        cartaList.add(new Carta( "globo", 1));
        cartaList.add(new Carta( "baloncesto", 1));
        cartaList.add(new Carta( "banco", 1));
        cartaList.add(new Carta( "pez", 1));
        cartaList.add(new Carta( "autobús", 1));
        cartaList.add(new Carta( "rueda", 1));
        cartaList.add(new Carta( "caimán", 1));
        cartaList.add(new Carta( "brazo", 1));
        cartaList.add(new Carta( "corteza", 1));
        cartaList.add(new Carta( "mar", 1));
        cartaList.add(new Carta( "araña", 1));
        cartaList.add(new Carta( "elefante", 1));
        cartaList.add(new Carta( "hoja", 1));
        cartaList.add(new Carta( "tobogán", 1));
        cartaList.add(new Carta( "ballena", 1));
        cartaList.add(new Carta( "pájaro", 1));
        cartaList.add(new Carta( "magdalena", 1));
        cartaList.add(new Carta( "mariquita", 1));
        cartaList.add(new Carta( "plátano", 1));
        cartaList.add(new Carta( "huevo", 1));
        cartaList.add(new Carta( "gatito", 1));
        cartaList.add(new Carta( "béisbol", 1));
        cartaList.add(new Carta( "océano", 1));
        cartaList.add(new Carta( "botón", 1));
        cartaList.add(new Carta( "cerdo", 1));
        cartaList.add(new Carta( "lluvia", 1));
        cartaList.add(new Carta( "hierba", 1));
        cartaList.add(new Carta( "planta", 1));
        cartaList.add(new Carta( "flotador", 1));
        cartaList.add(new Carta( "baño", 1));
        cartaList.add(new Carta( "camisa", 1));
        cartaList.add(new Carta( "manta", 1));
        cartaList.add(new Carta( "chaqueta", 1));
        cartaList.add(new Carta( "montañas", 1));
        cartaList.add(new Carta( "puerta", 1));
        cartaList.add(new Carta( "camión", 1));
        cartaList.add(new Carta( "arco iris", 1));
        cartaList.add(new Carta( "oso", 1));
        cartaList.add(new Carta( "rebote", 1));
        cartaList.add(new Carta( "lagarto", 1));
        cartaList.add(new Carta( "sonrisa", 1));
        cartaList.add(new Carta( "piscina", 1));
        cartaList.add(new Carta( "chica", 1));
        cartaList.add(new Carta( "volar", 1));
        cartaList.add(new Carta( "caracol", 1));
        cartaList.add(new Carta( "fútbol", 1));
        cartaList.add(new Carta( "pollo", 1));
        cartaList.add(new Carta( "niño", 1));
        cartaList.add(new Carta( "ojo", 1));
        cartaList.add(new Carta( "oreja", 1));
        cartaList.add(new Carta( "hombre", 1));
        cartaList.add(new Carta( "motocicleta", 1));
        cartaList.add(new Carta( "noche", 1));
        cartaList.add(new Carta( "rey", 1));
        cartaList.add(new Carta( "medusa", 1));
        cartaList.add(new Carta( "paleta", 1));
        cartaList.add(new Carta( "isla", 1));
        cartaList.add(new Carta( "montaña", 1));
        cartaList.add(new Carta( "sueño", 1));
        cartaList.add(new Carta( "gafas", 1));
        cartaList.add(new Carta( "caja", 1));
        cartaList.add(new Carta( "nube", 1));
        cartaList.add(new Carta( "búho", 1));
        cartaList.add(new Carta( "ojos", 1));
        cartaList.add(new Carta( "avión", 1));
        cartaList.add(new Carta( "zoo", 1));
        cartaList.add(new Carta( "monopatín", 1));
        cartaList.add(new Carta( "música", 1));
        cartaList.add(new Carta( "libro", 1));
        cartaList.add(new Carta( "árbol", 1));
        cartaList.add(new Carta( "luna", 1));
        cartaList.add(new Carta( "bicho", 1));
        cartaList.add(new Carta( "vela", 1));
        cartaList.add(new Carta( "perro", 1));
        cartaList.add(new Carta( "zapato", 1));
        cartaList.add(new Carta( "litera", 1));
        cartaList.add(new Carta( "zigzag", 1));
        cartaList.add(new Carta( "casa", 1));
        cartaList.add(new Carta( "cámara", 1));
        cartaList.add(new Carta( "pastel", 1));
        cartaList.add(new Carta( "abeja", 1));
        cartaList.add(new Carta( "maíz", 1));
        cartaList.add(new Carta( "mariposa", 1));
        cartaList.add(new Carta( "abrigo", 1));
        cartaList.add(new Carta( "cangrejo", 1));
        cartaList.add(new Carta( "rodilla", 1));
        cartaList.add(new Carta( "bola", 1));
        cartaList.add(new Carta( "mesa", 1));
        cartaList.add(new Carta( "silla", 1));
        cartaList.add(new Carta( "silla", 1));
        cartaList.add(new Carta( "triángulo", 1));
        cartaList.add(new Carta( "manzana", 1));
        cartaList.add(new Carta( "flor", 1));
        cartaList.add(new Carta( "galleta", 1));
        cartaList.add(new Carta( "dedo", 1));
        cartaList.add(new Carta( "bloques", 1));
        cartaList.add(new Carta( "columpio", 1));
        cartaList.add(new Carta( "helado", 1));
        cartaList.add(new Carta( "tortuga", 1));
        cartaList.add(new Carta( "conejito", 1));
        cartaList.add(new Carta( "ángel", 1));
        cartaList.add(new Carta( "anillo", 1));
        cartaList.add(new Carta( "cara", 1));
        cartaList.add(new Carta( "flotar", 1));
        cartaList.add(new Carta( "gancho", 1));
        cartaList.add(new Carta( "diamante", 1));
        cartaList.add(new Carta( "pescado", 1));
        cartaList.add(new Carta( "muñeco de nieve", 1));
        cartaList.add(new Carta( "estrella de mar", 1));
        cartaList.add(new Carta( "hormiga", 1));
        cartaList.add(new Carta( "nariz", 1));
        cartaList.add(new Carta( "chimenea", 1));
        cartaList.add(new Carta( "cometa", 1));
        cartaList.add(new Carta( "cubo", 1));
        cartaList.add(new Carta( "hamburguesa", 1));
        cartaList.add(new Carta( "abejorro", 1));
        cartaList.add(new Carta( "amor", 1));
        cartaList.add(new Carta( "gorro", 1));
        cartaList.add(new Carta( "manopla", 1));
        cartaList.add(new Carta( "moto", 1));
        cartaList.add(new Carta( "helicóptero", 1));
        cartaList.add(new Carta( "clavo", 1));
        cartaList.add(new Carta( "mujer", 1));
        cartaList.add(new Carta( "leche", 1));
        cartaList.add(new Carta( "sol", 1));
        cartaList.add(new Carta( "rama", 1));

        /** Intermedias */

        cartaList.add(new Carta( "mejilla", 2));
        cartaList.add(new Carta( "pepinillo", 2));
        cartaList.add(new Carta( "mascota", 2));
        cartaList.add(new Carta( "jabón", 2));
        cartaList.add(new Carta( "piloto", 2));
        cartaList.add(new Carta( "rodilla", 2));
        cartaList.add(new Carta( "rompecabezas", 2));
        cartaList.add(new Carta( "punto", 2));
        cartaList.add(new Carta( "río", 2));
        cartaList.add(new Carta( "cohete", 2));
        cartaList.add(new Carta( "saco", 2));
        cartaList.add(new Carta( "delfín", 2));
        cartaList.add(new Carta( "renacuajo", 2));
        cartaList.add(new Carta( "barro", 2));
        cartaList.add(new Carta( "tigre", 2));
        cartaList.add(new Carta( "comida", 2));
        cartaList.add(new Carta( "iPad", 2));
        cartaList.add(new Carta( "duende", 2));
        cartaList.add(new Carta( "tostada", 2));
        cartaList.add(new Carta( "cinta", 2));
        cartaList.add(new Carta( "cara", 2));
        cartaList.add(new Carta( "labio", 2));
        cartaList.add(new Carta( "polvo", 2));
        cartaList.add(new Carta( "balancín", 2));
        cartaList.add(new Carta( "teléfono", 2));
        cartaList.add(new Carta( "suelo", 2));
        cartaList.add(new Carta( "ecuador", 2));
        cartaList.add(new Carta( "órgano", 2));
        cartaList.add(new Carta( "efectivo", 2));
        cartaList.add(new Carta( "habitación", 2));
        cartaList.add(new Carta( "contener", 2));
        cartaList.add(new Carta( "remo", 2));
        cartaList.add(new Carta( "guisante", 2));
        cartaList.add(new Carta( "princesa", 2));
        cartaList.add(new Carta( "helio", 2));
        cartaList.add(new Carta( "panadería", 2));
        cartaList.add(new Carta( "carretera", 2));
        cartaList.add(new Carta( "garra", 2));
        cartaList.add(new Carta( "leer", 2));
        cartaList.add(new Carta( "verdura", 2));
        cartaList.add(new Carta( "huérfano", 2));
        cartaList.add(new Carta( "cumpleaños", 2));
        cartaList.add(new Carta( "fuga", 2));
        cartaList.add(new Carta( "tenedor", 2));
        cartaList.add(new Carta( "torre", 2));
        cartaList.add(new Carta( "agua salada", 2));
        cartaList.add(new Carta( "champú", 2));
        cartaList.add(new Carta( "enfermera", 2));
        cartaList.add(new Carta( "edredón", 2));
        cartaList.add(new Carta( "horno", 2));
        cartaList.add(new Carta( "hilo", 2));
        cartaList.add(new Carta( "regalo", 2));
        cartaList.add(new Carta( "gancho", 2));
        cartaList.add(new Carta( "objetivo", 2));
        cartaList.add(new Carta( "animadora", 2));
        cartaList.add(new Carta( "hierro", 2));
        cartaList.add(new Carta( "zorro", 2));
        cartaList.add(new Carta( "gigante", 2));
        cartaList.add(new Carta( "corcho", 2));
        cartaList.add(new Carta( "sentarse", 2));
        cartaList.add(new Carta( "ciudad", 2));
        cartaList.add(new Carta( "medallón", 2));
        cartaList.add(new Carta( "máscara", 2));
        cartaList.add(new Carta( "granizo", 2));
        cartaList.add(new Carta( "apio", 2));
        cartaList.add(new Carta( "fresa", 2));
        cartaList.add(new Carta( "gráfico", 2));
        cartaList.add(new Carta( "consejo", 2));
        cartaList.add(new Carta( "aeropuerto", 2));
        cartaList.add(new Carta( "pino", 2));
        cartaList.add(new Carta( "despertador", 2));
        cartaList.add(new Carta( "colmena", 2));
        cartaList.add(new Carta( "molécula", 2));
        cartaList.add(new Carta( "marioneta", 2));
        cartaList.add(new Carta( "bacteria", 2));
        cartaList.add(new Carta( "criada", 2));
        cartaList.add(new Carta( "sistema solar", 2));
        cartaList.add(new Carta( "regazo", 2));
        cartaList.add(new Carta( "insecticida", 2));
        cartaList.add(new Carta( "marco", 2));
        cartaList.add(new Carta( "acuario", 2));
        cartaList.add(new Carta( "cepillo", 2));
        cartaList.add(new Carta( "fundición", 2));
        cartaList.add(new Carta( "camión", 2));
        cartaList.add(new Carta( "cuarto", 2));
        cartaList.add(new Carta( "vaqueros", 2));
        cartaList.add(new Carta( "TV", 2));
        cartaList.add(new Carta( "rana", 2));
        cartaList.add(new Carta( "tarta de manzana", 2));
        cartaList.add(new Carta( " caballito de mar", 2));
        cartaList.add(new Carta( "meteorito", 2));
        cartaList.add(new Carta( "caballete", 2));
        cartaList.add(new Carta( "piscina", 2));
        cartaList.add(new Carta( "pajarita", 2));
        cartaList.add(new Carta( "dibujar", 2));
        cartaList.add(new Carta( "castor", 2));
        cartaList.add(new Carta( "estómago", 2));
        cartaList.add(new Carta( "pipa", 2));
        cartaList.add(new Carta( "águila calva", 2));
        cartaList.add(new Carta( "mesa", 2));
        cartaList.add(new Carta( "camión de la basura", 2));
        cartaList.add(new Carta( "granero", 2));
        cartaList.add(new Carta( "parka", 2));
        cartaList.add(new Carta( "cerebro", 2));
        cartaList.add(new Carta( "corbata", 2));
        cartaList.add(new Carta( "sombra", 2));
        cartaList.add(new Carta( "forma", 2));
        cartaList.add(new Carta( "barbilla", 2));
        cartaList.add(new Carta( "pared", 2));
        cartaList.add(new Carta( "tulipán", 2));
        cartaList.add(new Carta( "cascada", 2));
        cartaList.add(new Carta( "raíz", 2));
        cartaList.add(new Carta( "diente", 2));
        cartaList.add(new Carta( "maíz", 2));
        cartaList.add(new Carta( "oro", 2));
        cartaList.add(new Carta( "jarrón", 2));
        cartaList.add(new Carta( "patatas fritas", 2));
        cartaList.add(new Carta( "pegamento", 2));
        cartaList.add(new Carta( "diadema", 2));
        cartaList.add(new Carta( "gratis", 2));
        cartaList.add(new Carta( "casco", 2));
        cartaList.add(new Carta( "falda", 2));
        cartaList.add(new Carta( "tijeras", 2));
        cartaList.add(new Carta( "astronauta", 2));
        cartaList.add(new Carta( "vaquero", 2));
        cartaList.add(new Carta( "arena", 2));
        cartaList.add(new Carta( "móvil", 2));
        cartaList.add(new Carta( "zoo", 2));
        cartaList.add(new Carta( "faro", 2));
        cartaList.add(new Carta( "molde", 2));
        cartaList.add(new Carta( "casarse", 2));
        cartaList.add(new Carta( "calabaza", 2));
        cartaList.add(new Carta( "piano", 2));
        cartaList.add(new Carta( "colmillo", 2));
        cartaList.add(new Carta( " parque infantil", 2));
        cartaList.add(new Carta( "tía", 2));
        cartaList.add(new Carta( "hermana", 2));
        cartaList.add(new Carta( "tarta de cumpleaños", 2));
        cartaList.add(new Carta( "ciervo", 2));
        cartaList.add(new Carta( "mancha", 2));
        cartaList.add(new Carta( "tocón", 2));
        cartaList.add(new Carta( "cepillo de dientes", 2));
        cartaList.add(new Carta( "flauta", 2));
        cartaList.add(new Carta( "babero", 2));
        cartaList.add(new Carta( "raya", 2));
        cartaList.add(new Carta( "germen", 2));
        cartaList.add(new Carta( "colchón", 2));
        cartaList.add(new Carta( "cabaña", 2));
        cartaList.add(new Carta( "molinete", 2));
        cartaList.add(new Carta( "profesor", 2));
        cartaList.add(new Carta( "hamburguesa con queso", 2));
        cartaList.add(new Carta( "nube", 2));
        cartaList.add(new Carta( "periódico", 2));
        cartaList.add(new Carta( "rayuela", 2));
        cartaList.add(new Carta( "punta", 2));
        cartaList.add(new Carta( "vaso", 2));
        cartaList.add(new Carta( "pan", 2));
        cartaList.add(new Carta( "contraseña", 2));
        cartaList.add(new Carta( "linterna", 2));
        cartaList.add(new Carta( "mamut", 2));
        cartaList.add(new Carta( "profundo", 2));
        cartaList.add(new Carta( "muelle", 2));
        cartaList.add(new Carta( "asta", 2));
        cartaList.add(new Carta( "pop", 2));
        cartaList.add(new Carta( "tanque", 2));
        cartaList.add(new Carta( "restaurante", 2));
        cartaList.add(new Carta( "carne", 2));
        cartaList.add(new Carta( "botella", 2));
        cartaList.add(new Carta( "nuez", 2));
        cartaList.add(new Carta( "paja", 2));
        cartaList.add(new Carta( "tesoro", 2));
        cartaList.add(new Carta( "espada", 2));
        cartaList.add(new Carta( "pulgada", 2));
        cartaList.add(new Carta( "sal y pimienta", 2));
        cartaList.add(new Carta( "cola", 2));
        cartaList.add(new Carta( "gofre", 2));
        cartaList.add(new Carta( "parche en el ojo", 2));
        cartaList.add(new Carta( "oveja", 2));
        cartaList.add(new Carta( "conserje", 2));
        cartaList.add(new Carta( "penny", 2));
        cartaList.add(new Carta( "vertido", 2));
        cartaList.add(new Carta( "gravedad", 2));
        cartaList.add(new Carta( "pulgar", 2));
        cartaList.add(new Carta( "billete", 2));
        cartaList.add(new Carta( " cesto de la ropa", 2));
        cartaList.add(new Carta( "vela", 2));
        cartaList.add(new Carta( "cena", 2));
        cartaList.add(new Carta( "gasolina", 2));
        cartaList.add(new Carta( "ascensor", 2));
        cartaList.add(new Carta( "limón", 2));
        cartaList.add(new Carta( "coco", 2));
        cartaList.add(new Carta( "pistola de agua", 2));
        cartaList.add(new Carta( "leche", 2));
        cartaList.add(new Carta( "cubierta", 2));
        cartaList.add(new Carta( "guepardo", 2));
        cartaList.add(new Carta( "corona", 2));
        cartaList.add(new Carta( "golf", 2));
        cartaList.add(new Carta( "tobogán", 2));
        cartaList.add(new Carta( "tractor", 2));
        cartaList.add(new Carta( "correa", 2));
        cartaList.add(new Carta( "uva", 2));
        cartaList.add(new Carta( "telaraña", 2));
        cartaList.add(new Carta( "bota", 2));
        cartaList.add(new Carta( "ventilador de techo", 2));
        cartaList.add(new Carta( "desierto", 2));
        cartaList.add(new Carta( "estado", 2));
        cartaList.add(new Carta( "cebra", 2));
        cartaList.add(new Carta( "pañuelo", 2));
        cartaList.add(new Carta( "panda", 2));
        cartaList.add(new Carta( "equipaje", 2));
        cartaList.add(new Carta( "boca", 2));
        cartaList.add(new Carta( "tallo", 2));
        cartaList.add(new Carta( "metro", 2));
        cartaList.add(new Carta( "cavar", 2));
        cartaList.add(new Carta( "servilleta", 2));
        cartaList.add(new Carta( "derretir", 2));
        cartaList.add(new Carta( "escuela", 2));
        cartaList.add(new Carta( "abrir", 2));
        cartaList.add(new Carta( "cubo de basura", 2));
        cartaList.add(new Carta( "tapa", 2));
        cartaList.add(new Carta( "lavadora", 2));
        cartaList.add(new Carta( "triciclo", 2));
        cartaList.add(new Carta( "semilla", 2));
        cartaList.add(new Carta( "calendario", 2));
        cartaList.add(new Carta( "pimiento", 2));
        cartaList.add(new Carta( "camaleón", 2));
        cartaList.add(new Carta( "cadera", 2));
        cartaList.add(new Carta( "coche de carreras", 2));
        cartaList.add(new Carta( "cuerda floja", 2));
        cartaList.add(new Carta( "mapa", 2));
        cartaList.add(new Carta( "hula hoop", 2));
        cartaList.add(new Carta( "tostadas", 2));
        cartaList.add(new Carta( "feliz", 2));
        cartaList.add(new Carta( "pez de colores", 2));
        cartaList.add(new Carta( "cucaracha", 2));
        cartaList.add(new Carta( "caja", 2));
        cartaList.add(new Carta( "lápiz de color", 2));
        cartaList.add(new Carta( "tabla de planchar", 2));
        cartaList.add(new Carta( "bocina", 2));
        cartaList.add(new Carta( "anguila", 2));
        cartaList.add(new Carta( "hipopótamo", 2));
        cartaList.add(new Carta( "piel", 2));
        cartaList.add(new Carta( "seguro", 2));
        cartaList.add(new Carta( "gallina", 2));
        cartaList.add(new Carta( "desván", 2));
        cartaList.add(new Carta( "este", 2));
        cartaList.add(new Carta( "cortacésped", 2));
        cartaList.add(new Carta( "caballo", 2));
        cartaList.add(new Carta( "hielo", 2));
        cartaList.add(new Carta( "rastrillo", 2));
        cartaList.add(new Carta( "arte", 2));
        cartaList.add(new Carta( "águila", 2));
        cartaList.add(new Carta( "lago", 2));
        cartaList.add(new Carta( "toalla", 2));
        cartaList.add(new Carta( "callejón sin salida", 2));
        cartaList.add(new Carta( "bolígrafo", 2));
        cartaList.add(new Carta( "taza", 2));
        cartaList.add(new Carta( "cicatriz", 2));
        cartaList.add(new Carta( "pedir disculpas", 2));
        cartaList.add(new Carta( "béisbol", 2));
        cartaList.add(new Carta( "cuello", 2));
        cartaList.add(new Carta( "beso", 2));
        cartaList.add(new Carta( "monopatín", 2));
        cartaList.add(new Carta( "curva", 2));
        cartaList.add(new Carta( "submarino", 2));
        cartaList.add(new Carta( "tormenta", 2));
        cartaList.add(new Carta( "arpa", 2));
        cartaList.add(new Carta( "frigorífico", 2));
        cartaList.add(new Carta( "lápiz", 2));
        cartaList.add(new Carta( "bolsillo", 2));
        cartaList.add(new Carta( "trapecio", 2));
        cartaList.add(new Carta( "ping pong", 2));
        cartaList.add(new Carta( "esquí", 2));
        cartaList.add(new Carta( "bacterias", 2));
        cartaList.add(new Carta( "pintalabios", 2));
        cartaList.add(new Carta( "cortinas", 2));
        cartaList.add(new Carta( "dirigible", 2));
        cartaList.add(new Carta( "helicóptero", 2));
        cartaList.add(new Carta( "medio", 2));
        cartaList.add(new Carta( "eclipse", 2));
        cartaList.add(new Carta( "tetera", 2));
        cartaList.add(new Carta( "manta", 2));
        cartaList.add(new Carta( "escritorio", 2));
        cartaList.add(new Carta( "funda de almohada", 2));
        cartaList.add(new Carta( "luna llena", 2));
        cartaList.add(new Carta( "familia", 2));
        cartaList.add(new Carta( "bibliotecario", 2));
        cartaList.add(new Carta( "aspersor", 2));
        cartaList.add(new Carta( "Júpiter", 2));
        cartaList.add(new Carta( "unir", 2));
        cartaList.add(new Carta( "electricidad", 2));
        cartaList.add(new Carta( "lanza", 2));

        /** Difíciles */

        cartaList.add(new Carta( "mito", 3));
        cartaList.add(new Carta( "novio", 3));
        cartaList.add(new Carta( "giro", 3));
        cartaList.add(new Carta( "DJ", 3));
        cartaList.add(new Carta( "aguacate", 3));
        cartaList.add(new Carta( "bolsillo", 3));
        cartaList.add(new Carta( "enchufe", 3));
        cartaList.add(new Carta( "empresa", 3));
        cartaList.add(new Carta( "boa constrictor", 3));

        cartaList.add(new Carta( "zócalo", 3));
        cartaList.add(new Carta( "costilla", 3));
        cartaList.add(new Carta( "apático", 3));
        cartaList.add(new Carta( "piel", 3));
        cartaList.add(new Carta( "paz", 3));
        cartaList.add(new Carta( "acróbata", 3));
        cartaList.add(new Carta( "atlas", 3));
        cartaList.add(new Carta( "macho", 3));
        cartaList.add(new Carta( "miedo escénico", 3));

        cartaList.add(new Carta( "marca", 3));
        cartaList.add(new Carta( "pintalabios", 3));
        cartaList.add(new Carta( "valla", 3));
        cartaList.add(new Carta( "minero", 3));
        cartaList.add(new Carta( "carámbano", 3));
        cartaList.add(new Carta( "nave espacial", 3));
        cartaList.add(new Carta( "sala de estar", 3));


        cartaList.add(new Carta( "trombón", 3));
        cartaList.add(new Carta( "trueno", 3));
        cartaList.add(new Carta( "punto", 3));
        cartaList.add(new Carta( "zoo", 3));
        cartaList.add(new Carta( "broca", 3));
        cartaList.add(new Carta( "aguacero", 3));
        cartaList.add(new Carta( "gasolinera", 3));
        cartaList.add(new Carta( "inventar", 3));
        cartaList.add(new Carta( "acantilado", 3));
        cartaList.add(new Carta( "fugarse", 3));
        cartaList.add(new Carta( "vestido", 3));
        cartaList.add(new Carta( "ganado", 3));
        cartaList.add(new Carta( "jersey", 3));
        cartaList.add(new Carta( "chimenea", 3));
        cartaList.add(new Carta( "germen", 3));
        cartaList.add(new Carta( "bulldog", 3));
        cartaList.add(new Carta( "religión", 3));
        cartaList.add(new Carta( "salmón", 3));
        cartaList.add(new Carta( "salve", 3));
        cartaList.add(new Carta( "calvo", 3));
        cartaList.add(new Carta( "pulmón", 3));
        cartaList.add(new Carta( "balón prisionero", 3));
        cartaList.add(new Carta( "corte de pelo", 3));


        cartaList.add(new Carta( "crucero", 3));
        cartaList.add(new Carta( "proponer", 3));
        cartaList.add(new Carta( "tablón", 3));
        cartaList.add(new Carta( "inicio", 3));
        cartaList.add(new Carta( "disfraz", 3));
        cartaList.add(new Carta( "estornudar", 3));
        cartaList.add(new Carta( "deberes", 3));
        cartaList.add(new Carta( "barra de equilibrio", 3));


        cartaList.add(new Carta( "dolor de cabeza", 3));
        cartaList.add(new Carta( "niebla", 3));
        cartaList.add(new Carta( "carga", 3));
        cartaList.add(new Carta( "cubículo", 3));
        cartaList.add(new Carta( "vegetariano", 3));
        cartaList.add(new Carta( "farmacia", 3));
        cartaList.add(new Carta( "baile", 3));
        cartaList.add(new Carta( "rodeo", 3));
        cartaList.add(new Carta( "detergente", 3));
        cartaList.add(new Carta( "niñera", 3));
        cartaList.add(new Carta( "callejón sin salida", 3));

        cartaList.add(new Carta( "frontera", 3));
        cartaList.add(new Carta( "láser", 3));
        cartaList.add(new Carta( "violín", 3));
        cartaList.add(new Carta( "búfalo de agua", 3));

        cartaList.add(new Carta( "economía", 3));
        cartaList.add(new Carta( "voleibol", 3));
        cartaList.add(new Carta( "corteza", 3));
        cartaList.add(new Carta( "medalla de oro", 3));

        cartaList.add(new Carta( "calentador", 3));
        cartaList.add(new Carta( "cuento", 3));
        cartaList.add(new Carta( "estaño", 3));
        cartaList.add(new Carta( "cura", 3));
        cartaList.add(new Carta( "caballero", 3));
        cartaList.add(new Carta( "adorno", 3));
        cartaList.add(new Carta( "lana", 3));
        cartaList.add(new Carta( "sushi", 3));
        cartaList.add(new Carta( "atrapado", 3));
        cartaList.add(new Carta( "géiser", 3));
        cartaList.add(new Carta( "ganar", 3));
        cartaList.add(new Carta( "juguetería", 3));
        cartaList.add(new Carta( "sendero", 3));
        cartaList.add(new Carta( "piloto", 3));
        cartaList.add(new Carta( "concurso", 3));
        cartaList.add(new Carta( "pistola de pegamento", 3));

        cartaList.add(new Carta( "capó", 3));
        cartaList.add(new Carta( "galería de arte", 3));

        cartaList.add(new Carta( "profundo", 3));
        cartaList.add(new Carta( "peón", 3));
        cartaList.add(new Carta( "medio", 3));
        cartaList.add(new Carta( "toma de corriente", 3));

        cartaList.add(new Carta( "correos", 3));
        cartaList.add(new Carta( "descongelar", 3));
        cartaList.add(new Carta( "portero", 3));
        cartaList.add(new Carta( "canción", 3));
        cartaList.add(new Carta( "pista de patinaje", 3));
        cartaList.add(new Carta( "bombero", 3));
        cartaList.add(new Carta( "aprender", 3));
        cartaList.add(new Carta( "conexión", 3));
        cartaList.add(new Carta( "sueño", 3));
        cartaList.add(new Carta( "peluche", 3));
        cartaList.add(new Carta( "bata", 3));
        cartaList.add(new Carta( "oscuridad", 3));
        cartaList.add(new Carta( "monzón", 3));
        cartaList.add(new Carta( "azúcar", 3));
        cartaList.add(new Carta( "nana", 3));
        cartaList.add(new Carta( "castaño", 3));
        cartaList.add(new Carta( "peluca", 3));
        cartaList.add(new Carta( "Aparcamiento de camiones", 3));

        cartaList.add(new Carta( "hospital", 3));
        cartaList.add(new Carta( "cera", 3));
        cartaList.add(new Carta( "presa", 3));
        cartaList.add(new Carta( "vitamina", 3));
        cartaList.add(new Carta( "viento", 3));
        cartaList.add(new Carta( "pocilga", 3));
        cartaList.add(new Carta( "vacaciones", 3));
        cartaList.add(new Carta( "socio", 3));
        cartaList.add(new Carta( "músico", 3));
        cartaList.add(new Carta( "plantación", 3));
        cartaList.add(new Carta( "asiento", 3));
        cartaList.add(new Carta( "gripe", 3));
        cartaList.add(new Carta( "anuncio", 3));
        cartaList.add(new Carta( "barandilla", 3));
        cartaList.add(new Carta( "órgano", 3));
        cartaList.add(new Carta( "yate", 3));
        cartaList.add(new Carta( "molde", 3));
        cartaList.add(new Carta( "comprometido", 3));
        cartaList.add(new Carta( "capitán", 3));
        cartaList.add(new Carta( "marioneta", 3));
        cartaList.add(new Carta( "mango", 3));
        cartaList.add(new Carta( "tela", 3));
        cartaList.add(new Carta( "molar", 3));
        cartaList.add(new Carta( "lesión", 3));
        cartaList.add(new Carta( "judía", 3));
        cartaList.add(new Carta( "rodear", 3));
        cartaList.add(new Carta( "pinza", 3));
        cartaList.add(new Carta( "vainilla", 3));
        cartaList.add(new Carta( "imaginar", 3));
        cartaList.add(new Carta( "gruñir", 3));
        cartaList.add(new Carta( "Swing", 3));
        cartaList.add(new Carta( "mimo", 3));
        cartaList.add(new Carta( "taxi", 3));
        cartaList.add(new Carta( "galón", 3));
        cartaList.add(new Carta( "laca", 3));
        cartaList.add(new Carta( "parque de atracciones", 3));

        cartaList.add(new Carta( "enjambre", 3));
        cartaList.add(new Carta( "castaña", 3));
        cartaList.add(new Carta( "alargador", 3));
        cartaList.add(new Carta( "vapor", 3));
        cartaList.add(new Carta( "estofado", 3));
        cartaList.add(new Carta( "librería", 3));
        cartaList.add(new Carta( "ritmo", 3));
        cartaList.add(new Carta( "tragaespadas", 3));
        cartaList.add(new Carta( "efervescencia", 3));
        cartaList.add(new Carta( "tienda de segunda mano", 3));

        cartaList.add(new Carta( "floristería", 3));
        cartaList.add(new Carta( "imprimir", 3));
        cartaList.add(new Carta( "mundo", 3));
        cartaList.add(new Carta( "avergonzado", 3));
        cartaList.add(new Carta( "centímetro", 3));
        cartaList.add(new Carta( "recibo", 3));
        cartaList.add(new Carta( "campesino", 3));
        cartaList.add(new Carta( "yak", 3));
        cartaList.add(new Carta( "portaaviones", 3));
        cartaList.add(new Carta( "parodia", 3));
        cartaList.add(new Carta( "neutrón", 3));
        cartaList.add(new Carta( "villano", 3));
        cartaList.add(new Carta( "agujero de gusano", 3));

        cartaList.add(new Carta( "caos", 3));
        cartaList.add(new Carta( "incisivo", 3));
        cartaList.add(new Carta( "plano", 3));
        cartaList.add(new Carta( "preadolescente", 3));
        cartaList.add(new Carta( "grava", 3));
        cartaList.add(new Carta( "transponer", 3));
        cartaList.add(new Carta( "acorde", 3));
        cartaList.add(new Carta( "gurú", 3));
        cartaList.add(new Carta( "declaración", 3));
        cartaList.add(new Carta( "al azar", 3));

        cartaList.add(new Carta( "beneficio", 3));
        cartaList.add(new Carta( "escala", 3));
        cartaList.add(new Carta( "licencia", 3));
        cartaList.add(new Carta( "duda", 3));
        cartaList.add(new Carta( "reembolso", 3));
        cartaList.add(new Carta( "telepatía", 3));
        cartaList.add(new Carta( "agua dulce", 3));

        cartaList.add(new Carta( "parcela", 3));
        cartaList.add(new Carta( "representante", 3));
        cartaList.add(new Carta( "piragua", 3));
        cartaList.add(new Carta( "liquen", 3));
        cartaList.add(new Carta( "arrepentimiento", 3));
        cartaList.add(new Carta( "coche fúnebre", 3));
        cartaList.add(new Carta( "textura", 3));
        cartaList.add(new Carta( "opinión", 3));
        cartaList.add(new Carta( "humedales", 3));
        cartaList.add(new Carta( "figment", 3));
        cartaList.add(new Carta( "organización", 3));
        cartaList.add(new Carta( "accionista", 3));
        cartaList.add(new Carta( "mortificado", 3));
        cartaList.add(new Carta( "educación", 3));
        cartaList.add(new Carta( "alma gemela", 3));
        cartaList.add(new Carta( "ingresos", 3));
        cartaList.add(new Carta( "vapor de agua", 3));
        cartaList.add(new Carta( "crujiente", 3));
        cartaList.add(new Carta( "remolcador", 3));
        cartaList.add(new Carta( "carro de mina", 3));
        cartaList.add(new Carta( "pánico", 3));
        cartaList.add(new Carta( "kilogramo", 3));
        cartaList.add(new Carta( "descifrar", 3));
        cartaList.add(new Carta( "dud", 3));
        cartaList.add(new Carta( "herrero", 3));
        cartaList.add(new Carta( "título", 3));
        cartaList.add(new Carta( "destrucción", 3));
        cartaList.add(new Carta( "VIP", 3));
        cartaList.add(new Carta( "error", 3));
        cartaList.add(new Carta( "sensación", 3));
        cartaList.add(new Carta( "reino", 3));
        cartaList.add(new Carta( "memoria", 3));
        cartaList.add(new Carta( "presidente", 3));
        cartaList.add(new Carta( "stout", 3));
        cartaList.add(new Carta( "navegar", 3));
        cartaList.add(new Carta( "pesca en hielo", 3));
        cartaList.add(new Carta( "semestre", 3));
        cartaList.add(new Carta( "holgazán", 3));
        cartaList.add(new Carta( "código postal", 3));
        cartaList.add(new Carta( "voz", 3));
        cartaList.add(new Carta( "ligamento", 3));
        cartaList.add(new Carta( "pompa", 3));
        cartaList.add(new Carta( "diversión", 3));
        cartaList.add(new Carta( "latigazo", 3));
        cartaList.add(new Carta( "entrada", 3));
        cartaList.add(new Carta( "deseo", 3));
        cartaList.add(new Carta( "smidgen", 3));
        cartaList.add(new Carta( "quilate", 3));
        cartaList.add(new Carta( "grupo", 3));
        cartaList.add(new Carta( "descubrimiento", 3));
        cartaList.add(new Carta( "irónico", 3));
        cartaList.add(new Carta( "casa de empeños", 3));
        cartaList.add(new Carta( "creador", 3));
        cartaList.add(new Carta( "traducir", 3));
        cartaList.add(new Carta( "consentimiento", 3));
        cartaList.add(new Carta( "infectar", 3));
        cartaList.add(new Carta( "limo", 3));
        cartaList.add(new Carta( "tinte", 3));
        cartaList.add(new Carta( "tribu", 3));
        cartaList.add(new Carta( "protestante", 3));
        cartaList.add(new Carta( "grapa", 3));
        cartaList.add(new Carta( "vehículo", 3));
        cartaList.add(new Carta( "hiedra", 3));
        cartaList.add(new Carta( "desagüe", 3));
        cartaList.add(new Carta( "tortuoso", 3));
        cartaList.add(new Carta( "enano", 3));
        cartaList.add(new Carta( "boletín", 3));
        cartaList.add(new Carta( "arcade", 3));
        cartaList.add(new Carta( "página", 3));
        cartaList.add(new Carta( "remo", 3));
        cartaList.add(new Carta( "comida rápida", 3));
        cartaList.add(new Carta( "reloj de cuco", 3));
        cartaList.add(new Carta( "zanja", 3));
        cartaList.add(new Carta( "videojuego", 3));
        cartaList.add(new Carta( "misterioso", 3));
        cartaList.add(new Carta( "zoom", 3));
        cartaList.add(new Carta( "cuadrante", 3));
        cartaList.add(new Carta( "estancia", 3));
        cartaList.add(new Carta( "optometrista", 3));
        cartaList.add(new Carta( "dolor", 3));
        cartaList.add(new Carta( "billete", 3));
        cartaList.add(new Carta( "cuidador de zoo", 3));

        cartaLab.insertAll(cartaList);
    }

    public void startActivityTablero(View view) {
        try {
            Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vb.vibrate(100);

            int segundosPorRonda = Integer.valueOf(etSegundosPorRonda.getText().toString());
            int numeroDeRondas = Integer.valueOf(etNumeroDeRondas.getText().toString());

            if (segundosPorRonda > 0 && numeroDeRondas > 0) {
                Intent i = new Intent(this, Tablero.class);
                i.putParcelableArrayListExtra("equipos", equipos);
                i.putExtra("segundosPorRonda", segundosPorRonda);
                i.putExtra("numeroDeRondas", numeroDeRondas);
                startActivity(i);
            }
        } catch (Exception ex) {
            Log.i("ppppp", ex.getMessage());
        }
    }

    public void addEditTextListener() {
        final EditText edittext = findViewById(R.id.etNombreEquipo);
        edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Log.i("ppppp", "Entra if");

                    String nombreEquipo = edittext.getText().toString();

                    Toast.makeText(MainActivity.this, nombreEquipo, Toast.LENGTH_SHORT).show();

                    if (!nombreEquipo.equals("")) {
                        Equipo eq = new Equipo(nombreEquipo);
                        eq.id = idEquipo;
                        eq.puntos = 0;
                        equipos.add(eq);
                        idEquipo++;

                        Log.i("ppppp", "Entra añadir equipo");

                        arrayAdapter.notifyDataSetChanged();

                        edittext.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.BtnMenuAddPalabra) {
            //startCreatePlayerActivity();
        } else if (item.getItemId() == R.id.BtnMenuGestionarPalabra) {
            Intent intent = new Intent(this, ManageCarta.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.BtnMenuConfig) {
            //checkAllCtv();
        } else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }
}