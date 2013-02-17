package org.xpect.model;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.xpect.Environment;
import org.xpect.XjmMethod;
import org.xpect.XjmModule;
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
	public EMap<Environment, XjmModule> getModules() {
		((XpectJavaModelImplCustom) eContainer()).initModules();
		return super.getModules();
	}

	@Override
	public EMap<Environment, XjmSetup> getSetups() {
		((XpectJavaModelImplCustom) eContainer()).initSetups();
		return super.getSetups();
	}

	public void putModule(Environment env, XjmModule module) {
		super.getModules().put(env, module);
	}

	public void putSetup(Environment env, XjmSetup setup) {
		super.getSetups().put(env, setup);
	}

	@Override
	public String toString() {
		List<Object> items = Lists.newArrayList();
		for (Map.Entry<Environment, XjmModule> module : getModules())
			items.add(module.getKey() + " " + module.getValue().getJvmClass().getSimpleName());
		for (Map.Entry<Environment, XjmSetup> setup : getSetups())
			items.add(setup.getKey() + " " + setup.getValue().getJvmClass().getSimpleName());
		items.addAll(getMethods());
		String body = items.isEmpty() ? " {}" : " {\n  " + Joiner.on("\n").join(items).replace("\n", "\n  ") + "\n}";
		return "test " + getJvmClass().getQualifiedName() + body;
	}

}
