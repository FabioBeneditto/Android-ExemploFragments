package tk.altoscodigos.fragments;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Lista extends ListFragment {

    private AoSelecionarItemEventos eventos;
    private List<DadosDoItem> lista;

    public interface AoSelecionarItemEventos {
        public void aoSelecionarItem( DadosDoItem item );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        carregaDadosLista();
        ArrayAdapter<DadosDoItem> adapter = new ArrayAdapter<DadosDoItem>( getActivity(), R.layout.linha_lista, R.id.txDescricao, lista );
        setListAdapter( adapter );
    }

    private void carregaDadosLista() {
        lista = new ArrayList<DadosDoItem>();

        lista.add( new DadosDoItem( 1, "Memória" ) );
        lista.add( new DadosDoItem( 2, "CPU" ) );
        lista.add( new DadosDoItem( 3, "HD" ) );
        lista.add( new DadosDoItem( 4, "Monitor" ) );
        lista.add( new DadosDoItem( 5, "Teclado" ) );
        lista.add( new DadosDoItem( 6, "Mouse" ) );
        lista.add( new DadosDoItem( 7, "Placa de Rede" ) );
    }

    @Override
    public void onAttach( Activity activity ) {
        super.onAttach(activity);

        try {
            eventos = (AoSelecionarItemEventos) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " precisa implementar AoSelecionarItemEventos");
        }
    }

    @Override
    public void onStart() {

        super.onStart();
        getListView().setChoiceMode( ListView.CHOICE_MODE_SINGLE );
        Detalhes detalhes = (Detalhes) getFragmentManager().findFragmentById( R.id.fragment_detalhes );

        if( detalhes != null && lista != null && lista.size() > 0 ) {
            detalhes.setDetalhes(lista.get(0));
        }
    }

    @Override
    public void onListItemClick( ListView l, View v, int position, long id ) {

        DadosDoItem itemSelecionado = lista.get( position );
        eventos.aoSelecionarItem( itemSelecionado );
        getListView().setItemChecked( position, true );
    }
}