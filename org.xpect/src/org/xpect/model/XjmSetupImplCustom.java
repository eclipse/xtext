package org.xpect.model;

import org.apache.log4j.Logger;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.xpect.setup.IXpectSetup;

public class XjmSetupImplCustom extends XjmSetupImpl {

	private static Logger logger = Logger.getLogger(XjmSetupImplCustom.class);

	@Override
	public JvmDeclaredType getInitializer() {
		JvmDeclaredType setupClass = getJvmClass();
		if (setupClass == null || setupClass.eIsProxy())
			return null;
		if (setupClass.getSuperTypes().size() == 0 || !(setupClass.getSuperTypes().get(0) instanceof JvmParameterizedTypeReference))
			return null;
		JvmParameterizedTypeReference superClass = (JvmParameterizedTypeReference) setupClass.getSuperTypes().get(0);
		if (superClass.getArguments().size() != 4)
			return null;
		JvmTypeReference typeReference = superClass.getArguments().get(3);
		if (typeReference != null && typeReference.getType() != null && !typeReference.getType().eIsProxy())
			return (JvmDeclaredType) typeReference.getType();
		return null;
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

	@Override
	public void setJavaClass(Class<?> newJavaClass) {
		super.setInstance(null);
		super.setJavaClass(newJavaClass);
	}

	@Override
	public String toString() {
		return "setup " + getJvmClass().getQualifiedName();
	}
}
