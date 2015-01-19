package org.arguman.app.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import org.arguman.app.util.FontCache;

public class ArgumanTextView extends TextView {

	public ArgumanTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.setTypeface(new FontCache().get("fonts/american_typewriter.ttf", context));
	}
	
}
