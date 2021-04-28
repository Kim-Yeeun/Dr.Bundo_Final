package org.techtown.drbundo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuestionItemView extends LinearLayout {

    private TextView q;
    private TextView a;

    public QuestionItemView(Context context) {
        super(context);
        init(context);
    }

    public QuestionItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.question_item_list,this,true);

        q = (TextView)findViewById(R.id.question);
        a = (TextView)findViewById(R.id.answer);
    }

    public void setQuestion(String question) {
        q.setText(question);
    }

    public void setAnswer(String answer) {
        a.setText(answer);
    }
}

