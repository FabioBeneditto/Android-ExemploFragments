package tk.altoscodigos.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Detalhes extends Fragment {

    private TextView campoCodigo;
    private TextView campoDescricao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View result = inflater.inflate( R.layout.tela_detalhes, container, false );

        campoCodigo = (TextView) result.findViewById( R.id.txCodigo );
        campoDescricao = (TextView) result.findViewById( R.id.txDescricao );

        return result;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        DadosDoItem dado = null;

        if( args != null ) {
            dado = (DadosDoItem) args.getSerializable( "ItemSelecionado" );
        }

        if( dado != null ) {
            setDetalhes(dado);
        }
    }

    public void setDetalhes( DadosDoItem detalhes ) {

        campoCodigo.setText( detalhes.getCodigo().toString() );
        campoDescricao.setText( detalhes.getDescricao() );
    }
}