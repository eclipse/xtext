/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.serializer;

import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class SerializerTest extends AbstractXtend2TestCase {

	@Inject
	private ISerializer serializer;

	public void testSerializer() {
		assertTrue(serializer instanceof Serializer);
	}

	public void testSimple() throws Exception {
		StringBuilder expected = new StringBuilder();
		expected.append("package org.eclipse.xtext.xtend2.tests.compiler\n");
		expected.append("\n");
		expected.append("class TestClass1 {\n");
		expected.append("\n");
		expected.append("	testFunction1() {\n");
		expected.append("		42\n");
		expected.append("	}\n");
		expected.append("	\n");
		expected.append("	testFunction2() {\n");
		expected.append("		return 42\n");
		expected.append("	}\n");
		expected.append("		\n");
		expected.append("	Integer testFunction3() {\n");
		expected.append("		40 + 2\n");
		expected.append("	}\n");
		expected.append("	\n");
		expected.append("	Integer testFunction4() {\n");
		expected.append("		return 6 * 7\n");
		expected.append("	}	\n");
		expected.append("}");
		assertEquals(expected.toString(), serializer.serialize(file(expected.toString())));
	}
}
