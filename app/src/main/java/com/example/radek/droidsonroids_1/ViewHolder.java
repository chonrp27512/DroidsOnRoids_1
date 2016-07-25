package com.example.radek.droidsonroids_1;

import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Radek on 2016-07-25.
 */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mFriendName;
        private int mOriginalHeight = 0;
        private boolean mIsViewExpanded = false;


        public ViewHolder(RelativeLayout v) {
            super(v);
            mFriendName = (TextView) v.findViewById(R.id.TextView_parent);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(final View view) {
            if (mOriginalHeight == 0) {
                mOriginalHeight = view.getHeight();
            }
            ValueAnimator valueAnimator;
            if (!mIsViewExpanded) {
                mIsViewExpanded = true;
                valueAnimator = ValueAnimator.ofInt(mOriginalHeight, mOriginalHeight + (int) (mOriginalHeight * 1.5));
            } else {
                mIsViewExpanded = false;
                valueAnimator = ValueAnimator.ofInt(mOriginalHeight + (int) (mOriginalHeight * 1.5), mOriginalHeight);
            }
            valueAnimator.setDuration(300);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    Integer value = (Integer) animation.getAnimatedValue();
                    view.getLayoutParams().height = value.intValue();
                    view.requestLayout();
                }
            });
            valueAnimator.start();
        }
}
