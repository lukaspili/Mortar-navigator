package com.mortarnav.nav;

import com.mortarnav.DaggerScope;
import com.mortarnav.MainActivity2;
import com.mortarnav.MainActivity2Component;

import autodagger.AutoComponent;
import mortar.MortarScope;
import mortarnav.NavigationScope;
import mortarnav.NavigatorServices;
import mortarnav.autoscope.DaggerService;

/**
 * @author Lukasz Piliszczuk - lukasz.pili@gmail.com
 */
@AutoComponent(dependencies = MainActivity2.class)
@DaggerScope(BannerScope.class)
public class BannerScope implements NavigationScope {

    @Override
    public Services withServices(MortarScope parentScope) {

        // parentScope is not the main activity scope, but the scope of its container (like home scope)
        // retreive the main activity component from the navigator scope
        MainActivity2Component component = NavigatorServices.getService(parentScope, DaggerService.SERVICE_NAME);

        return new Services().with(DaggerService.SERVICE_NAME, DaggerBannerScopeComponent.builder()
                .mainActivity2Component(component)
                .build());
    }
}
