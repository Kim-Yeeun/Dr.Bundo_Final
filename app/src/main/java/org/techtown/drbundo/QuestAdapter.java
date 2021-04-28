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

public class QuestAdapter extends RecyclerView.Adapter<QuestAdapter.QuestViewHolder> {

    private ArrayList<QuestionItem> list;
    private Context context;

    public class QuestViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        protected TextView question;
        protected TextView answer;


        public QuestViewHolder(View view) {
            super(view);

            this.question = (TextView) view.findViewById(R.id.question);
            this.answer = (TextView) view.findViewById(R.id.answer);

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

                        editquest.setText(list.get(getAdapterPosition()).getQuestion());
                        editanswer.setText(list.get(getAdapterPosition()).getAnswer());

                        final AlertDialog dialog = builder.create();

                        completebutton.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                String quest = editquest.getText().toString();
                                String answer = editanswer.getText().toString();

                                QuestionItem qi = new QuestionItem();

                                list.set(getAdapterPosition(), qi);

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

    public QuestAdapter(Context context, ArrayList<QuestionItem> arrayList) {
        this.list = arrayList;
        this.context = context;
    }

    @Override
    public QuestViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.question_item_list, viewGroup, false);

        QuestViewHolder viewHolder = new QuestViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestViewHolder viewholder, int position) {

        viewholder.question.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        viewholder.answer.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);

        viewholder.question.setGravity(Gravity.LEFT);
        viewholder.answer.setGravity(Gravity.LEFT);

        viewholder.question.setText(list.get(position).getQuestion());
        viewholder.answer.setText(list.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return (null != list ? list.size() : 0);
    }

}

