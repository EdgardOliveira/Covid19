package br.com.technologies.venom.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Switch swtFebre, swtDorCabeca, swtSecrecaoEspirros, swtDorGarganta, swtTosseSeca,
                   swtDificuldadeResp, swtDorCorpo, swtDiarreia, swtPerdaAlfato, swtContatoCovid19;
    private TextView txtvwTotalPontos, txtvwRisco;
    private int total[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swtFebre = findViewById(R.id.swtFebre);
        swtDorCabeca = findViewById(R.id.swtDorCabeca);
        swtSecrecaoEspirros = findViewById(R.id.swtSecrecaoEspirros);
        swtDorGarganta = findViewById(R.id.swtGarganta);
        swtTosseSeca = findViewById(R.id.swtTosseSeca);
        swtDificuldadeResp = findViewById(R.id.swtDificuldadeResp);
        swtDorCorpo = findViewById(R.id.swtDorCorpo);
        swtDiarreia = findViewById(R.id.swtDiarreia);
        swtPerdaAlfato = findViewById(R.id.swtPerdaAlfato);
        swtContatoCovid19 = findViewById(R.id.swtContatoCOVID19);
        txtvwTotalPontos = findViewById(R.id.txtvwTotalPontos);
        txtvwRisco = findViewById(R.id.txtvwRisco);

        swtFebre.setOnClickListener(this);
        swtDorCabeca.setOnClickListener(this);
        swtSecrecaoEspirros.setOnClickListener(this);
        swtDorGarganta.setOnClickListener(this);
        swtTosseSeca.setOnClickListener(this);
        swtDificuldadeResp.setOnClickListener(this);
        swtDorCorpo.setOnClickListener(this);
        swtDiarreia.setOnClickListener(this);
        swtPerdaAlfato.setOnClickListener(this);
        swtContatoCovid19.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.swtFebre:
                total[0] = swtFebre.isChecked() == true ? 5 : 0;
                break;
            case R.id.swtDorCabeca:
                total[1] = swtDorCabeca.isChecked() == true ? 1 : 0;
                break;
            case R.id.swtSecrecaoEspirros:
                total[2] = swtSecrecaoEspirros.isChecked() == true ? 1 : 0;
                break;
            case R.id.swtGarganta:
                total[3] = swtDorGarganta.isChecked() == true ? 1 : 0;
                break;
            case R.id.swtTosseSeca:
                total[4] = swtTosseSeca.isChecked() == true ? 3 : 0;
                break;
            case R.id.swtDificuldadeResp:
                total[5] = swtDificuldadeResp.isChecked() == true ? 10 : 0;
                break;
            case R.id.swtDorCorpo:
                total[6] = swtDorCorpo.isChecked() == true ? 1 : 0;
                break;
            case R.id.swtDiarreia:
                total[7] = swtDiarreia.isChecked() == true ? 1 : 0;
                break;
            case R.id.swtPerdaAlfato:
                total[8] = swtPerdaAlfato.isChecked() == true ? 3 : 0;
                break;
            case R.id.swtContatoCOVID19:
                total[9] = swtContatoCovid19.isChecked() == true ? 10 : 0;
                break;
        }

        atualizarTotal();
    }

    private void atualizarTotal(){
        int totalPontos = 0;

        String risco = "Risco: ";

        for(int i = 0; i<total.length;i++)
            totalPontos += total[i];

        if ((totalPontos >= 1) && (totalPontos <=9)){
            risco += "Baixo";
            txtvwRisco.setBackgroundColor(Color.parseColor("#FFEB3B"));
        }else if ((totalPontos >= 10) && (totalPontos <=19)) {
            risco += "Médio";
            txtvwRisco.setBackgroundColor(Color.parseColor("#FFC107"));
        }else if ((totalPontos >= 19) && (totalPontos <=36)) {
            risco += "Alto";
            txtvwRisco.setBackgroundColor(Color.parseColor("#FF3D00"));
        }else {
            risco += "Nenhum";
            txtvwRisco.setBackgroundColor(Color.parseColor("#8BC34A"));
        }

        txtvwTotalPontos.setText("Total de pontos: " + String.valueOf(totalPontos));
        txtvwRisco.setText(risco);
        txtvwTotalPontos.setVisibility(View.VISIBLE);
        txtvwRisco.setVisibility(View.VISIBLE);
    }
}