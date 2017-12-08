package com.ssdt.banbury.mymvpdemo2.advancedmvp.factory;

import com.ssdt.banbury.mymvpdemo2.advancedmvp.annotation.CreatePresenter;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.BaseMvpPresenter;
import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.IMvpBaseView;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_17:38.
 * @description
 */

public class PresenterMvpFactoryImpl<V extends IMvpBaseView, P extends BaseMvpPresenter<V>> implements PresenterMvpFactory<V, P> {
    private Class<P> mPresenterClass;

    private PresenterMvpFactoryImpl(Class<P> mPresenterClass) {
        this.mPresenterClass = mPresenterClass;
    }

    public static <V extends IMvpBaseView, P extends BaseMvpPresenter<V>> PresenterMvpFactoryImpl<V, P> createFactory(Class<?> viewClass) {
        CreatePresenter annotation = viewClass.getAnnotation(CreatePresenter.class);
        Class<P> clazz = null;
        if (annotation != null) {
            clazz = (Class<P>) annotation.value();
        }
        return clazz == null ? null : new PresenterMvpFactoryImpl<V, P>(clazz);
    }

    @Override
    public P createPresenter() {
        try {
            return mPresenterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Presenter创建失败!，检查是否声明了@CreatePresenter(xx.class)注解");
        }
    }

}
