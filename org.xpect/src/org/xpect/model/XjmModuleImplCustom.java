package org.xpect.model;

public class XjmModuleImplCustom extends XjmModuleImpl {
	@Override
	public String toString() {
		return "module " + getJvmClass().getQualifiedName();
	}
}
