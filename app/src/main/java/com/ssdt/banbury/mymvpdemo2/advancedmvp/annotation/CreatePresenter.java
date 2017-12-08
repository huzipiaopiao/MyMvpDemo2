package com.ssdt.banbury.mymvpdemo2.advancedmvp.annotation;

import com.ssdt.banbury.mymvpdemo2.advancedmvp.base.BaseMvpPresenter;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/12/7_17:34.
 * @description
 */

@Inherited //此注解表示子类可以继承父类的，我们定义的这个注解
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatePresenter {
    Class<? extends BaseMvpPresenter> value();
}
