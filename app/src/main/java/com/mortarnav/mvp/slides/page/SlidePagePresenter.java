package com.mortarnav.mvp.slides.page;

import android.os.Bundle;

import com.mortarnav.DaggerScope;
import com.mortarnav.deps.WithActivityDependencies;
import com.mortarnav.mvp.slides.SlidesPresenter;

import architect.robot.AutoScreen;
import architect.robot.NavigationParam;
import autodagger.AutoComponent;
import mortar.ViewPresenter;

/**
 * @author Lukasz Piliszczuk - lukasz.pili@gmail.com
 */
@AutoScreen(
        component = @AutoComponent(dependencies = SlidesPresenter.class, superinterfaces = WithActivityDependencies.class),
        pathView = SlidePageView.class
)
@DaggerScope(SlidePagePresenter.class)
public class SlidePagePresenter extends ViewPresenter<SlidePageView> {

    @NavigationParam
    private final String name;

    public SlidePagePresenter(String name) {
        this.name = name;
    }

    @Override
    protected void onLoad(Bundle savedInstanceState) {
        getView().configure(name);
    }
}
