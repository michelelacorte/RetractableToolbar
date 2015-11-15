package it.michelelacorte.exampleretractabletoolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

import it.michelelacorte.retractabletoolbar.RetractableToolbarUtil;

public class MainActivity extends AppCompatActivity {
    private RetractableToolbarUtil.ShowHideToolbarOnScrollingListener showHideToolbarListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.myList);
        List<ItemData> itemsData = new ArrayList<ItemData>();
        for(int i = 0; i < 50; i++)
        {
            itemsData.add(new ItemData("Text " + i));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter mAdapter = new MyAdapter(itemsData);
        recyclerView.setAdapter(mAdapter);

        //Set scroll listener
        recyclerView.addOnScrollListener(showHideToolbarListener = new RetractableToolbarUtil.ShowHideToolbarOnScrollingListener(toolbar));

        //Check state
        if (savedInstanceState != null) {
            showHideToolbarListener.onRestoreInstanceState((RetractableToolbarUtil.ShowHideToolbarOnScrollingListener.State) savedInstanceState
                    .getParcelable(RetractableToolbarUtil.ShowHideToolbarOnScrollingListener.SHOW_HIDE_TOOLBAR_LISTENER_STATE));
        }
    }
}
