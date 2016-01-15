package org.eclipse.xpect.model;


public class XjmTestMethodImplCustom extends XjmTestMethodImpl {
	@Override
	public String toString() {
		return "@Test public void " + getJvmMethod().getSimpleName() + "();";
	}
}
