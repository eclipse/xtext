/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.naming;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DeclarativeQualifiedNameConverterTest extends Assert {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

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
	
		
		qualifiedNameConverter = new IQualifiedNameConverter.DefaultImpl() {
			@Override
			public String getDelimiter() {
				return " ";
			}
		};
		assertEquals("foo bar baz", qualifiedNameConverter.toString(qn));
		assertEquals(qn, qualifiedNameConverter.toQualifiedName("foo bar baz"));
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Qualified name cannot be null");
		qualifiedNameConverter.toQualifiedName(null);
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Qualified name cannot be empty");
		qualifiedNameConverter.toQualifiedName("");
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
