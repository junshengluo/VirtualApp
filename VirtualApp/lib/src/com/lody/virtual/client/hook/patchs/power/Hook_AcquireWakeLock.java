package com.lody.virtual.client.hook.patchs.power;

import java.lang.reflect.Method;

import com.lody.virtual.client.hook.base.Hook;
import com.lody.virtual.client.hook.utils.HookUtils;

/**
 * @author Lody
 *
 */
/* package */ class Hook_AcquireWakeLock extends Hook<PowerManagerPatch> {
	/**
	 * 这个构造器必须有,用于依赖注入.
	 *
	 * @param patchObject
	 *            注入对象
	 */
	public Hook_AcquireWakeLock(PowerManagerPatch patchObject) {
		super(patchObject);
	}

	@Override
	public String getName() {
		return "acquireWakeLock";
	}

	@Override
	public Object onHook(Object who, Method method, Object... args) throws Throwable {
		HookUtils.replaceSequenceAppPkg(args, 2);
		return method.invoke(who, args);
	}
}
