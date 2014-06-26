package org.silpa.soundex;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.silpa.render.IndicTextView;

/**
 * Created by sujith on 17/6/14.
 */
public class SoundexTextView extends IndicTextView implements SoundexInterface {

    /**
     * Soundex object
     */
    private Soundex soundex;

    /**
     * Compare with view resource id
     */
    private int mCompareWithResourceId;

    /**
     * View to compare soundex
     */
    private View mCompareWithView;

    // LOG TAG
    private static final String LOG_TAG = "SoundexTextView";

    /**
     * Constructor
     *
     * @param context context of application
     */
    public SoundexTextView(Context context) {
        super(context);
        init(null, 0);
    }

    /**
     * Constructor
     *
     * @param context context of application
     * @param attrs   attribute set
     */
    public SoundexTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    /**
     * Constructor
     *
     * @param context  context of application
     * @param attrs    attribute set
     * @param defStyle default style
     */
    public SoundexTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    /**
     * Initialize data members
     *
     * @param attrs    attribute set
     * @param defStyle default style
     */
    private void init(AttributeSet attrs, int defStyle) {

        this.soundex = new Soundex();

        // Init attrs
        initAttrs(attrs, defStyle);
    }

    /**
     * Initialize attributes used
     *
     * @param attrs    attribute set
     * @param defStyle default style
     */
    private void initAttrs(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.SoundexTextView,
                defStyle, defStyle
        );

        try {
            this.mCompareWithResourceId = a.getResourceId(R.styleable.SoundexTextView_soundexCompareWith, -1);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error : " + e.getMessage());
        } finally {
            a.recycle();
        }
    }

    public void setCompareWithResourceId(int resourceId) {
        this.mCompareWithResourceId = resourceId;
    }

    /**
     * This function is used to get soundex code from a given view
     *
     * @return soundex code
     */
    @Override
    public String getSoundexCode() {
        return this.soundex.soundex(getText().toString());
    }

    /**
     * This function is used to get compare result
     *
     * @return int compare value
     * 0 if both strings are same
     * 1 if strings sound phonetically same
     * 2 if strings are phonetically not same
     */
    @Override
    public int getCompareValue() {
        if (mCompareWithView == null) {
            mCompareWithView = getRootView().findViewById(mCompareWithResourceId);
        }
        if (mCompareWithView != null) {
            if (mCompareWithView instanceof EditText) {
                return soundex.compare(getText().toString(),
                        ((EditText) mCompareWithView).getText().toString());
            } else if (mCompareWithView instanceof TextView) {
                return soundex.compare(getText().toString(),
                        ((TextView) mCompareWithView).getText().toString());
            }
        }
        return -1;
    }
}
