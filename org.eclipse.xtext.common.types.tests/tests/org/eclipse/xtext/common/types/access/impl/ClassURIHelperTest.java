/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.JavaModelException;
import org.junit.Test;

public class ClassURIHelperTest {
	ClassURIHelper uriHelper = new ClassURIHelper();
	@Test public void testFragmentURI() throws JavaModelException {
		URI fragment = uriHelper.getFullURI(Foo$3.class);
		assertEquals(Foo$3.class.getName(), fragment.fragment().toString());
	}
	
	static class Foo$3 {}
}
