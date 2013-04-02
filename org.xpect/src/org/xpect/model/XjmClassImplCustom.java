package org.xpect.model;

import static org.xpect.util.JvmAnnotationUtil.getAnnotationValue;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.xpect.XpectConstants;
import org.xpect.parameter.IParameterAdapter;
import org.xpect.parameter.XpectParameterAdapter;
import org.xpect.registry.ILanguageInfo;
import org.xpect.runner.XpectSuiteClasses;
import org.xpect.util.IJavaReflectAccess;

import com.google.inject.Injector;

public class XjmClassImplCustom extends XjmClassImpl {

	private static Logger logger = Logger.getLogger(XjmClassImplCustom.class);

	@Override
	public void setJvmClass(JvmDeclaredType newJvmClass) {
		super.setJavaClass(null);
		super.setJvmClass(newJvmClass);
		this.parameterAdapters = null;
	}

	@Override
	public Class<?> getJavaClass() {
		Class<?> result = super.getJavaClass();
		if (result != null)
			return result;
		JvmDeclaredType jvmClass = getJvmClass();
		if (jvmClass == null || jvmClass.eIsProxy())
			return null;
		Injector injector = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(XpectConstants.XPECT_FILE_EXT).getInjector();
		Class<?> type = injector.getInstance(IJavaReflectAccess.class).getRawType(jvmClass);
		super.setJavaClass(type);
		return type;
	}

	protected EList<IParameterAdapter> initParameterAdapters() {
		EList<IParameterAdapter> result = new BasicEList<IParameterAdapter>();
		JvmDeclaredType type = getJvmClass();
		if (type != null && !type.eIsProxy()) {
			Injector injector = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(XpectConstants.XPECT_FILE_EXT).getInjector();
			IJavaReflectAccess reflectAccess = injector.getInstance(IJavaReflectAccess.class);
			JvmTypeAnnotationValue typeValue = getAnnotationValue(type, XpectParameterAdapter.class, JvmTypeAnnotationValue.class);
			if (typeValue != null)
				for (JvmTypeReference ref : typeValue.getValues())
					if (ref != null && !ref.eIsProxy() && ref.getType() != null && !ref.getType().eIsProxy()) {
						Class<?> adapter = reflectAccess.getRawType(ref.getType());
						if (adapter != null) {
							try {
								Object instance = adapter.newInstance();
								result.add((IParameterAdapter) instance);
							} catch (InstantiationException e) {
								logger.error(e);
							} catch (IllegalAccessException e) {
								logger.error(e);
							}
						}
					}
		}
		return result;

	}

	@Override
	public EList<IParameterAdapter> getParameterAdapters() {
		if (this.parameterAdapters == null)
			this.parameterAdapters = initParameterAdapters();
		return this.parameterAdapters;
	}

}
