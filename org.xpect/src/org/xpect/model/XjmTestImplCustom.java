package org.xpect.model;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.xpect.XjmMethod;
import org.xpect.XjmSetup;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class XjmTestImplCustom extends XjmTestImpl {

	public void addMethod(XjmMethod op) {
		super.getMethods().add(op);
	}

	@Override
	public EList<XjmMethod> getMethods() {
		((XpectJavaModelImplCustom) eContainer()).initTestClassMethods();
		return super.getMethods();
	}

	@Override
	public EList<XjmSetup> getSetups() {
		((XpectJavaModelImplCustom) eContainer()).initSetups();
		return super.getSetups();
	}

	public void putSetup(XjmSetup setup) {
		super.getSetups().add(setup);
	}

	@Override
	public String toString() {
		List<Object> items = Lists.newArrayList();
		for (XjmSetup setup : getSetups())
			items.add(setup.getJvmClass().getSimpleName());
		items.addAll(getMethods());
		String body = items.isEmpty() ? " {}" : " {\n  " + Joiner.on("\n").join(items).replace("\n", "\n  ") + "\n}";
		return "test " + getJvmClass().getQualifiedName() + body;
	}

}
