package br.ucs.android.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private ListView listaSensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        String[] lista = new String[sensores.size()];

        for (int i = 0; i < sensores.size(); i++){
            lista[i] = sensores.get(i).getName();
        }

        listaSensores = (ListView) findViewById( R.id.listaSensores );
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.linha_sensor, R.id.txtNome, lista);

        listaSensores.setAdapter(adapter);
    }
}