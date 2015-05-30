package tk.altoscodigos.fragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity implements Lista.AoSelecionarItemEventos {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.tela_principal );

        if( findViewById( R.id.activity_fragment_container ) != null ) {
            // Ahh, puxa, to num celular!

            if( savedInstanceState != null ) {
                return;
            }

            Lista lista = new Lista();
            lista.setArguments( getIntent().getExtras() );

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add( R.id.activity_fragment_container, lista );
            transaction.commit();
        }
    }

    @Override
    public void aoSelecionarItem( DadosDoItem item ) {

        Detalhes detalhes = (Detalhes) getFragmentManager().findFragmentById( R.id.fragment_detalhes );

        if( detalhes != null ) {
            // Ahh, puxa, to num tablet
            detalhes.setDetalhes( item );
        } else {
            // Ahh, puxa, to no celular

            detalhes = new Detalhes();
            Bundle parametros = new Bundle();
            parametros.putSerializable( "ItemSelecionado", item );
            detalhes.setArguments( parametros );

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace( R.id.activity_fragment_container, detalhes );
            transaction.addToBackStack( null );
            transaction.commit();
        }
    }
}
