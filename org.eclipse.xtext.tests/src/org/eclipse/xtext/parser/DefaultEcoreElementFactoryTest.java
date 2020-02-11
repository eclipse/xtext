/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DefaultEcoreElementFactoryTest extends Assert {

	@Test
	public void testConvertNullInput() throws Exception {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		Function2<String, INode, Object> toValueImpl = new Function2<String, INode, Object>() {

			@Override
			public Object apply(String lexerRule, INode node) {
				if ("foo".equals(lexerRule) ) {
					return "FOO";
				}
				return null;
			}
		};
		DefaultEcoreElementFactory factory = new DefaultEcoreElementFactory();
		factory.setConverterService(new MockedConverterService(toValueImpl));
		factory.set(eClass, "name", null, "foo", null);

		assertEquals("FOO", eClass.getName());
	}

	@Test
	public void testNullInput() throws Exception {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		final ILeafNode node = new LeafNode();
		
		Function2<String, INode, Object> toValueImpl = new Function2<String, INode, Object>() {

			@Override
			public Object apply(String lexerRule, INode nodeParam) {
				if ("foo".equals(lexerRule) && nodeParam.equals(node)) {
					return null;
				}
				fail();
				return null;
			}
		};

		DefaultEcoreElementFactory factory = new DefaultEcoreElementFactory();
		factory.setConverterService(new MockedConverterService(toValueImpl));
		try {
			factory.set(eClass, "abstract", null, "foo", node);
			fail("Expected ValueConverterException");
		} catch (ValueConverterException ex) {
			assertNull(ex.getCause());
			assertTrue(ex.getMessage().indexOf("ValueConverter returned null for") >= 0);
			assertSame(node, ex.getNode());
		}
	}

	@Test
	public void testValueConverterException() throws Exception {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		final ILeafNode node = new LeafNode();
		final ValueConverterException expected = new ValueConverterException("Foo", node, null);
		
		Function2<String, INode, Object> toValueImpl = new Function2<String, INode, Object>() {

			@Override
			public Object apply(String lexerRule, INode nodeParam) {
				if ("foo".equals(lexerRule) && node.equals(nodeParam)) {
					throw expected;
				}
				fail();
				return null;
			}
		};

		DefaultEcoreElementFactory factory = new DefaultEcoreElementFactory();
		factory.setConverterService(new MockedConverterService(toValueImpl));
		try {
			factory.set(eClass, "abstract", null, "foo", node);
			fail("Expected ValueConverterException");
		} catch (ValueConverterException ex) {
			assertSame(expected, ex);
		}
	}

	/**
	 * @author dhuebner - Initial contribution and API
	 */
	private final class MockedConverterService implements IValueConverterService {
		private final Functions.Function2<String, INode, Object> toValueFunction;

		public MockedConverterService(Functions.Function2<String, INode, Object> toValueFunction) {
			this.toValueFunction = toValueFunction;
		}

		@Override
		public Object toValue(String string, String lexerRule, INode nodeParam) throws ValueConverterException {
			return toValueFunction.apply(lexerRule, nodeParam);
		}

		@Override
		public String toString(Object value, String lexerRule) {
			return null;
		}
	}

}
