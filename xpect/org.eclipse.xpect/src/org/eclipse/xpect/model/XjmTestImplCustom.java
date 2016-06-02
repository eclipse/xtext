package org.eclipse.xpect.model;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xpect.XjmMethod;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class XjmTestImplCustom extends XjmTestImpl {

	public void addMethod(XjmMethod op) {
		super.getMethods().add(op);
	}

	@Override
	public EList<XjmMethod> getMethods() {
		((XpectJavaModelImplCustom) eContainer()).getMethods();
		return super.getMethods();
	}

	@Override
	public String toString() {
		List<String> items = Lists.newArrayList();
		for (XjmMethod method : getMethods())
			items.add(method.toString());
		Collections.sort(items);
		String contributions = getImportedContributions();
		String prefix = "test " + getJvmClass().getQualifiedName();
		if (contributions.isEmpty() && items.isEmpty())
			return prefix + " {}";
		if (items.isEmpty())
			return prefix + " {} // Imports: " + contributions;
		String replace = Joiner.on("\n").join(items).replace("\n", "\n  ");
		if (contributions.isEmpty())
			return prefix + " {\n  " + replace + "\n}";
		return prefix + " { // Imports: " + contributions + "\n  " + replace + "\n}";
	}

}
