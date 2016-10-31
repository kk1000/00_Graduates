package com.xpple.graduates.view;

import com.xpple.graduates.view.effects.BaseEffects;
import com.xpple.graduates.view.effects.DialogCancel;
import com.xpple.graduates.view.effects.Shake;

public enum Effectstype {
    DialogCancel(DialogCancel.class), Shake(
            Shake.class);
    private Class<? extends BaseEffects> effectsClazz;

    Effectstype(Class<? extends BaseEffects> mClass) {
        effectsClazz = mClass;
    }

    public BaseEffects getAnimator() {
        BaseEffects bEffects;
        try {
            bEffects = effectsClazz.newInstance();
        } catch (ClassCastException | InstantiationException | IllegalAccessException e) {
            throw new Error("Can not init animatorClazz instance");
        }
        return bEffects;
    }
}
