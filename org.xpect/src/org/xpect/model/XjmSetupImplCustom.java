package org.xpect.model;

import org.apache.log4j.Logger;
import org.xpect.setup.IXpectSetup;

public class XjmSetupImplCustom extends XjmSetupImpl {

	private static Logger logger = Logger.getLogger(XjmSetupImplCustom.class);

	@Override
	public String toString() {
		return "setup " + getJvmClass().getQualifiedName();
	}

	@Override
	public void setJavaClass(Class<?> newJavaClass) {
		super.setInstance(null);
		super.setJavaClass(newJavaClass);
	}

	@Override
	public IXpectSetup getInstance() {
		IXpectSetup result = super.getInstance();
		if (result != null)
			return result;
		Class<?> cls = getJavaClass();
		if (cls == null)
			return null;
		try {
			result = (IXpectSetup) cls.newInstance();
			setInstance(result);
		} catch (InstantiationException e) {
			logger.error(e);
		} catch (IllegalAccessException e) {
			logger.error(e);
		}
		return result;
	}
}
