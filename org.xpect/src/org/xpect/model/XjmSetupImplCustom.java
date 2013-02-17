package org.xpect.model;

public class XjmSetupImplCustom extends XjmSetupImpl {
	@Override
	public String toString() {
		return "setup " + getJvmClass().getQualifiedName();
	}
}
