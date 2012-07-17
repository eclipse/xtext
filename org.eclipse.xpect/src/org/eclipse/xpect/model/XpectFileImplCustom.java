package org.eclipse.xpect.model;

import org.eclipse.xpect.XpectIgnore;
import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.XpectTest;

import com.google.common.collect.Iterables;

public class XpectFileImplCustom extends XpectFileImpl {
	@Override
	public Iterable<XpectInvocation> getInvocations() {
		return Iterables.filter(getMembers(), XpectInvocation.class);
	}

	@Override
	public XpectTest getTest() {
		return Iterables.getFirst(Iterables.filter(getMembers(), XpectTest.class), null);
	}

	@Override
	public boolean isIgnore() {
		return Iterables.isEmpty(Iterables.filter(getMembers(), XpectIgnore.class));
	}
}
