package vn.apcs.npkhoa.a2359test.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.apcs.npkhoa.a2359test.Presenter;
import vn.apcs.npkhoa.a2359test.PresenterImpl;
import vn.apcs.npkhoa.a2359test.R;
import vn.apcs.npkhoa.a2359test.entities.Combination;
import vn.apcs.npkhoa.a2359test.ui.adapter.Adapter;

public class MainActivity extends Activity implements View{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private Presenter presenter;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //settingDI();

        //setting up RecyclerView
        adapter = new Adapter(this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        presenter = new PresenterImpl(this);
        presenter.getItems();
    }

//    private void settingDI() {
//        AppClient app = (AppClient) getApplication();
//        Components components = app.getComponents(this);
//        components.inject(this);
//    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        presenter.onResume();
//    }
//
//    @Override
//    public void onPause() {
//        presenter.onPause();
//        super.onPause();
//    }
//
//    @Override
//    public void onDestroy() {
//        presenter.onDestroy();
//        super.onDestroy();
//    }

    @Override
    public void showElements() {
        recyclerView.setVisibility(android.view.View.VISIBLE);
    }

    @Override
    public void hideElements() {
        recyclerView.setVisibility(android.view.View.GONE);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(android.view.View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(android.view.View.GONE);
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setContent(List<Combination> items) {
        adapter.setItems(items);
    }
}
