/*******************************************************************************
 * Copyright (c) 2010, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	
		
		final IQualifiedNameConverter qualifiedNameConverterSpace = new IQualifiedNameConverter.DefaultImpl() {
			@Override
			public String getDelimiter() {
				return " ";
			}
		};
		assertEquals("foo bar baz", qualifiedNameConverterSpace.toString(qn));
		assertEquals(qn, qualifiedNameConverterSpace.toQualifiedName("foo bar baz"));
		
		IllegalArgumentException e1 = assertThrows(IllegalArgumentException.class, ()->qualifiedNameConverterSpace.toQualifiedName(null));
		assertEquals("Qualified name cannot be null", e1.getMessage());
		
		IllegalArgumentException e2 = assertThrows(IllegalArgumentException.class, ()->qualifiedNameConverterSpace.toQualifiedName(""));
		assertEquals("Qualified name cannot be empty", e2.getMessage());
	}

	@Test public void testQualifiedNameConverter_emptyDelimiter() throws Exception {
		IQualifiedNameConverter qualifiedNameConverter = new IQualifiedNameConverter.DefaultImpl() {
			@Override
			public String getDelimiter() {
				return "";
			}
		};

		QualifiedName qn = QualifiedName.create("foo", "bar", "baz");
		assertEquals("foobarbaz", qualifiedNameConverter.toString(qn));
		assertEquals(QualifiedName.create("foobarbaz"), qualifiedNameConverter.toQualifiedName("foobarbaz"));
	}

	@Test public void testQualifiedNameConverter_nullDelimiter() throws Exception {
		IQualifiedNameConverter qualifiedNameConverter = new IQualifiedNameConverter.DefaultImpl() {
			@Override
			public String getDelimiter() {
				return null;
			}
		};
		QualifiedName qn = QualifiedName.create("foo", "bar", "baz");
		assertEquals("foonullbarnullbaz", qualifiedNameConverter.toString(qn));
		assertEquals(QualifiedName.create("foobarbaz"), qualifiedNameConverter.toQualifiedName("foobarbaz"));
		
	}

}
