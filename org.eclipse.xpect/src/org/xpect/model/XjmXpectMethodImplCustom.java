package org.xpect.model;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.util.Strings;

public class XjmXpectMethodImplCustom extends XjmXpectMethodImpl {

	@Override
	public int getParameterCount() {
		JvmOperation method = getJvmMethod();
		if (method != null && !method.eIsProxy())
			return method.getParameters().size();
		return 0;
	}

	@Override
	public String toString() {
		String contributions = getImportedContributions();
		String body = "@Xpect public void " + getJvmMethod().getSimpleName() + "();";
		if (Strings.isEmpty(contributions))
			return body;
		return body + " // Imports: " + contributions;
	}

}
