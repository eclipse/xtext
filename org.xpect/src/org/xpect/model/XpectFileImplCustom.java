/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.model;

import org.eclipse.xtext.resource.XtextResource;
import org.xpect.XpectIgnore;
import org.xpect.XpectInvocation;
import org.xpect.XpectTest;

import com.google.common.collect.Iterables;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectFileImplCustom extends XpectFileImpl {

	public String getDocument() {
		return ((XtextResource) eResource()).getParseResult().getRootNode().getText();
	}

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
