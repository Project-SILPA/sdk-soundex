package org.silpa.soundex;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.silpa.render.IndicEditText;

/**
 * Created by sujith on 17/6/14.
 */
public class SoundexEditText extends IndicEditText implements SoundexInterface {

    /**
     * Soundex object
     */
    private Soundex soundex;

    /**
     * Compare with view resource id
     */
    private int mCompareWithResourceId;

    /**
     * Resource id to ouptput soundex code
     */
    private int mSoundexCodeOutputResourceId;

    /**
     * Soundex code of current view
     */
    private String mSoundexCode;

    /**
     * Compare value
     */
    private int mCompareValue;

    /**
     * View to output soundex code
     */
    private View mSoundexCodeOutputView;

    /**
     * View to compare soundex
     */
    private View mCompareWithView;

    // LOG TAG
    private static final String LOG_TAG = "SoundexEditText";

    /**
     * Constructor
     *
     * @param context context of application
     */
    public SoundexEditText(Context context) {
        super(context);
        init(null, 0);
        initView();
    }

    /**
     * Constructor
     *
     * @param context context of application
     * @param attrs   attribute set
     */
    public SoundexEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
        initView();
    }

    /**
     * Constructor
     *
     * @param context  context of application
     * @param attrs    attribute set
     * @param defStyle default style
     */
    public SoundexEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
        initView();
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
                R.styleable.SoundexEditText,
                defStyle, defStyle
        );

        try {
            this.mCompareWithResourceId = a.getResourceId(R.styleable.SoundexEditText_soundexCompareWith, -1);
            this.mSoundexCodeOutputResourceId = a.getResourceId(R.styleable.SoundexEditText_soundexCodeOutputTo, -1);
            this.soundex = new Soundex();
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error : " + e.getMessage());
        } finally {
            a.recycle();
        }
    }

    /**
     * Initialize view
     */
    private void initView() {
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                // for outputting soundex code
                if (mSoundexCodeOutputView == null) {
                    mSoundexCodeOutputView = getRootView().findViewById(mSoundexCodeOutputResourceId);
                }
                if (mSoundexCodeOutputView != null) {
                    mSoundexCode = soundex.soundex(getText().toString());
                    if (mSoundexCodeOutputView instanceof EditText) {
                        ((EditText) mSoundexCodeOutputView).setText(mSoundexCode);
                    } else if (mSoundexCodeOutputView instanceof TextView) {
                        ((TextView) mSoundexCodeOutputView).setText(mSoundexCode);
                    }
                }
            }
        });
    }

    /**
     * Function to compare  Soundex values
     */
    private void soundexCompare() {
        // for comparing soundex values
        if (mCompareWithView == null) {
            mCompareWithView = getRootView().findViewById(mCompareWithResourceId);
        }
        if (mCompareWithView != null) {
            if (mCompareWithView instanceof EditText) {
                mCompareValue = soundex.compare(getText().toString(),
                        ((EditText) mCompareWithView).getText().toString());
            } else if (mCompareWithView instanceof TextView) {
                mCompareValue = soundex.compare(getText().toString(),
                        ((TextView) mCompareWithView).getText().toString());
            }
        }
    }

    /**
     * This is used to explicitly set resource id for outputting soundex code
     *
     * @param resourceId resource id
     */
    public void setSoundexCodeResourceId(int resourceId) {
        this.mSoundexCodeOutputResourceId = resourceId;
    }

    /**
     * This is used to explicitly set resource id for comparing soundex
     *
     * @param resourceId resource id
     */
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
        return this.mSoundexCode;
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
        soundexCompare();
        return this.mCompareValue;
    }
}
