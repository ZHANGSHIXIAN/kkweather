package com.example.zhangshixian.kkweather;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import util.SnackbarUtil;

/**
 * Created by ZHANGSHIXIAN on 2016/7/16.
 */
public class Search extends AppCompatActivity{

    public interface OnItemClickListener{
        void OnItemClick(View view,int position);
    }

    Button mSearchBtn;
    Toolbar toolbar;

    AutoCompleteTextView actextview;
    List<String> citylist;
    InputMethodManager imm;
    ArrayList<String> mList;
    MyAdapter adapter;



    private String[] mBTNNames ={"北京","上海","广州","深圳","天津","重庆","成都","杭州","武汉","长沙","海口","拉萨","厦门","西安","青岛","南宁"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        initData();
        initEvent();
    }

    private void initData() {
        mList=new ArrayList<>();
        for (int i = 0; i < mBTNNames.length; i++) {
            mList.add(mBTNNames[i]);
        }

        actextview= (AutoCompleteTextView) findViewById(R.id.actextview);
        toolbar= (Toolbar) findViewById(R.id.toolbar_search);
        mSearchBtn= (Button) findViewById(R.id.search_btn);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        RecyclerView recylcer = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager mgr=new GridLayoutManager(this,4);
        mgr.setOrientation(LinearLayoutManager.VERTICAL);
        recylcer.setLayoutManager(mgr);
        //设置适配器
        adapter=new MyAdapter();
        adapter.setmOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                searchJudge(view,mBTNNames[position]);
            }
        });
        recylcer.setAdapter(adapter);

    }


    public void initEvent(){
        Intent i=getIntent();
        citylist=i.getStringArrayListExtra("citylist");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(Search.this,android.R.layout.simple_expandable_list_item_1,citylist);
        actextview.setAdapter(adapter);
        // toolbar.inflateMenu(R.menu.toolbarmenu);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchJudge(v,actextview.getText().toString());
            }
        });

    }


    private void searchJudge(View v,String mcityname){
        if (!mcityname.equals("")&&citylist.contains(mcityname)) {
            //imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            Intent intent = new Intent(Search.this, MainActivity.class);
            intent.putExtra("city", mcityname);
            setResult(RESULT_OK, intent);
            finish();
        }else {
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            // Snackbar.make(v,"请重新确认城市名称是否正确", Snackbar.LENGTH_SHORT).show();
            SnackbarUtil.ShortSnackbar(v,"请重新确认城市名称是否正确",SnackbarUtil.Alert).show();
        }
        }






    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        public OnItemClickListener mOnItemClickListener;

        public void setmOnItemClickListener(OnItemClickListener listener){
            this.mOnItemClickListener=listener;
        }



        //RecyclerView显示的子View
        //该方法返回是ViewHolder，当有可复用View时，就不再调用
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = getLayoutInflater().inflate(R.layout.recycler_item, null);
            return new ViewHolder(v);
        }

        //将数据绑定到子View，会自动复用View
        @Override
        public void onBindViewHolder(final ViewHolder viewHolder, final int i) {

                viewHolder.btn.setText(mBTNNames[i]);
            viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener!=null){
                        mOnItemClickListener.OnItemClick(viewHolder.btn,i);
                    }
                }
            });
        }

        //RecyclerView显示数据条数
        @Override
        public int getItemCount() {
            return mList.size();
        }

        //自定义的ViewHolder,减少findViewById调用次数
        class ViewHolder extends RecyclerView.ViewHolder {

            Button btn;
            //在布局中找到所含有的UI组件
            public ViewHolder(View itemView) {
                super(itemView);
                btn= (Button) itemView.findViewById(R.id.item_btn);


            }
        }
    }

}

