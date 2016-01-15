package org.eclipse.xpect.model;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xpect.XjmClass;
import org.eclipse.xtext.common.types.JvmDeclaredType;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class XjmElementImplCustom extends XjmElementImpl {

	private void collectImports(XjmClass ctx, List<String> result, Set<XjmClass> visited) {
		if (!visited.add(ctx))
			return;
		JvmDeclaredType jvmClass = ctx.getJvmClass();
		if (jvmClass != null) {
			if (jvmClass.eIsProxy())
				result.add("Proxy: " + ((InternalEObject) jvmClass).eProxyURI());
			else
				result.add(jvmClass.getSimpleName());
		}
		for (XjmClass imp : ctx.getImports())
			collectImports(imp, result, visited);
	}

	public String getImportedContributions() {
		List<String> result = Lists.newArrayList();
		Set<XjmClass> visited = Sets.newHashSet();
		for (XjmClass imp : getImports())
			collectImports(imp, result, visited);
		return Joiner.on(", ").join(result);
	}
}
