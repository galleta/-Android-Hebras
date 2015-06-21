package ejemplocronometro.cronometro;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener
{
    private static Button bIniciar, bReiniciar, bPausar;
    private static TextView tCronometro1;
    private Cronometro cronometro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bIniciar = (Button)findViewById(R.id.bIniciar);
        bReiniciar = (Button)findViewById(R.id.bReiniciar);
        bPausar = (Button)findViewById(R.id.bPausar);
        tCronometro1 = (TextView)findViewById(R.id.tCronometro1);

        bIniciar.setOnClickListener(this);
        bReiniciar.setOnClickListener(this);
        bPausar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bIniciar:
                if( cronometro == null )
                {
                    cronometro = new Cronometro("Cronómetro juego", tCronometro1);
                    new Thread(cronometro).start();
                }
                break;
            case R.id.bReiniciar:
                if( cronometro != null )
                    cronometro.reiniciar();
                break;
            case R.id.bPausar:
                if( cronometro != null )
                    cronometro.pause();
                break;
        }
    }
}
