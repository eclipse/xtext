package org.xpect.model;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.xpect.XpectConstants;
import org.xpect.registry.ILanguageInfo;
import org.xpect.util.IJavaReflectAccess;

import com.google.inject.Injector;

public class XjmClassImplCustom extends XjmClassImpl {

	@Override
	public void setJvmClass(JvmDeclaredType newJvmClass) {
		super.setJavaClass(null);
		super.setJvmClass(newJvmClass);
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

}
