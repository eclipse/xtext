package org.xpect.model;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.xpect.XjmFactory;
import org.xpect.XjmMethod;
import org.xpect.XjmSetup;
import org.xpect.XpectJavaModelFactory;
import org.xpect.setup.XpectSetup;
import org.xpect.util.JvmAnnotationUtil;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class XjmTestImplCustom extends XjmTestImpl {

	public void addMethod(XjmMethod op) {
		super.getMethods().add(op);
	}

	@Override
	public EList<XjmFactory> getFactories() {
		if (super.factories == null) {
			EList<XjmFactory> facts = super.getFactories();
			for (JvmDeclaredType type : JvmAnnotationUtil.getAnnotationTypeValue(getJvmClass(), XpectSetup.class)) {
				XjmFactory factory = XpectJavaModelFactory.eINSTANCE.createXjmFactory();
				factory.setJvmClass(type);
				facts.add(factory);
			}
		}
		return super.getFactories();
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
	public void setJvmClass(JvmDeclaredType newJvmClass) {
		super.factories = null;
		super.setJvmClass(newJvmClass);
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
