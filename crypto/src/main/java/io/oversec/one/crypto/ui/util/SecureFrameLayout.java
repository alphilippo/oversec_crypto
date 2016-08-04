package io.oversec.one.crypto.ui.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class SecureFrameLayout extends FrameLayout {
    public SecureFrameLayout(Context context) {
        super(context);
    }

    public SecureFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SecureFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean requestSendAccessibilityEvent(View view,
                                                 AccessibilityEvent event) {
        // Never send accessibility events.
        return false;
    }

    @SuppressLint("InlinedApi")
    @Override
    public int getImportantForAccessibility() {
        return IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS;
    }

    @Override
    public void addChildrenForAccessibility(ArrayList<View> outChildren) {
        //nothing
    }
}
