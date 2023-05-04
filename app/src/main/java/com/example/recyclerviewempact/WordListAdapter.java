package com.example.recyclerviewempact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{
    private final LinkedList<String> mWordlist;
    private LayoutInflater mInflater;
    public WordListAdapter(Context context, LinkedList<String> wordlist){
        mInflater = LayoutInflater.from(context);
        this.mWordlist = wordlist;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
    String mCurrent = mWordlist.get(position);
    holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordlist.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        public final WordListAdapter mAdapter;

        public WordViewHolder(@NonNull View itemView , WordListAdapter adapter ) {
            super(itemView);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
            wordItemView = itemView.findViewById(R.id.word);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = mWordlist.get(mPosition);
            // Change the word in the mWordList.
            mWordlist.set(mPosition, "Clicked! " + element);
            // Notify the adapter that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }

}
