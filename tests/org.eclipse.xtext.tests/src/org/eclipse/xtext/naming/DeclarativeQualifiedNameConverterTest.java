/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.naming;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DeclarativeQualifiedNameConverterTest extends Assert {

	@Test public void testQualifiedNameConverter() throws Exception {
		IQualifiedNameConverter qualifiedNameConverter = new IQualifiedNameConverter.DefaultImpl() {
			@Override
			public String getDelimiter() {
				return "!";
			}
		};
		QualifiedName qn = QualifiedName.create("foo", "bar", "baz");
		assertEquals("foo!bar!baz", qualifiedNameConverter.toString(qn));
		assertEquals(qn, qualifiedNameConverter.toQualifiedName("foo!bar!baz"));
		try {
			qualifiedNameConverter.toQualifiedName(null);
			fail("Exception expected");
		} catch(IllegalArgumentException e) {}
		try {
			qualifiedNameConverter.toQualifiedName("");
			fail("Exception expected");
		} catch(IllegalArgumentException e) {}
	}
}
