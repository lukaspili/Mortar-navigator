package com.mortarnav.mvp.slides.page;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.mortarnav.R;
import com.mortarnav.mvp.slides.page.screen.SlidePageScreenComponent;

import architect.commons.view.PresentedFrameLayout;
import architect.robot.DaggerService;
import autodagger.AutoInjector;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Lukasz Piliszczuk - lukasz.pili@gmail.com
 */
@AutoInjector(SlidePagePresenter.class)
public class SlidePageView extends PresentedFrameLayout<SlidePagePresenter> {

    @Bind(R.id.page_title)
    public TextView titleTextView;

    public SlidePageView(Context context) {
        super(context);
        DaggerService.<SlidePageScreenComponent>get(context).inject(this);

        View view = View.inflate(context, R.layout.slide_page_view, this);
        ButterKnife.bind(view);
    }

    public void configure(String title) {
        titleTextView.setText(title);
    }
}
