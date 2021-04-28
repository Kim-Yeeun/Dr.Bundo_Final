package org.techtown.drbundo;

import android.content.Context;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LocalAdapter extends RecyclerView.Adapter<LocalAdapter.LocalViewHolder> {

    private ArrayList<LocalItem> list;
    private Context context;

    public class LocalViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        protected TextView local;
        protected TextView result;


        public LocalViewHolder(View view) {
            super(view);

            this.local = (TextView) view.findViewById(R.id.local);
            this.result = (TextView) view.findViewById(R.id.result);

            view.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Edit = menu.add(Menu.NONE, 1, 1, "수정");
            MenuItem Delete = menu.add(Menu.NONE, 2, 2, "삭제");

            Edit.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);
        }

        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case 1:
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        View view = LayoutInflater.from(context).inflate(R.layout.edit_question, null, false);
                        builder.setView(view);

                        Button completebutton = (Button) view.findViewById(R.id.complete);
                        final EditText editquest = (EditText) view.findViewById(R.id.edit_quest);
                        final EditText editanswer = (EditText) view.findViewById(R.id.edit_answer);

                        editquest.setText(list.get(getAdapterPosition()).getLocal());
                        editanswer.setText(list.get(getAdapterPosition()).getResult());

                        final AlertDialog dialog = builder.create();

                        completebutton.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                String quest = editquest.getText().toString();
                                String answer = editanswer.getText().toString();

                                LocalItem li = new LocalItem();

                                list.set(getAdapterPosition(), li);

                                notifyItemChanged(getAdapterPosition());

                                dialog.dismiss();
                            }
                        });

                        dialog.show();

                        break;

                    case 2:
                        list.remove(getAdapterPosition());

                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(), list.size());

                        break;
                }
                return true;
            }
        };

    }

    public LocalAdapter(Context context, ArrayList<LocalItem> arrayList) {
        this.context = context;
        this.list = arrayList;
    }

    @Override
    public LocalViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.local_item_list, viewGroup, false);

        LocalViewHolder viewHolder = new LocalViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LocalViewHolder viewholder, int position) {

        viewholder.local.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        viewholder.result.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

        viewholder.local.setGravity(Gravity.CENTER);
        viewholder.result.setGravity(Gravity.CENTER);

        viewholder.local.setText(list.get(position).getLocal());
        viewholder.result.setText(list.get(position).getResult());
    }

    @Override
    public int getItemCount() {
        return (null != list ? list.size() : 0);
    }

}

