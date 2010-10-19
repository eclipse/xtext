/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.naming;

import junit.framework.TestCase;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DeclarativeQualifiedNameProviderTest extends TestCase {

	public void testQualifiedNameSupport() throws Exception {
		DefaultDeclarativeQualifiedNameProvider qualifiedNameProvider = new DefaultDeclarativeQualifiedNameProvider() {
			@Override
			public String getDelimiter() {
				return "!";
			}
		};
		QualifiedName qn = QualifiedName.create("foo", "bar", "baz");
		assertEquals("foo!bar!baz", qualifiedNameProvider.toString(qn));
		assertEquals(qn, qualifiedNameProvider.toValue("foo!bar!baz"));
	}
}
