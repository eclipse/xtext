/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.TypeConverter;
import org.eclipse.xtext.xbase.typing.TypesService;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeConverterTest extends AbstractXbaseTestCase {
	@Inject
	private TypeConverter converter;
	@Inject
	private TypesService typesService;
	
	public void testConvertPrimitives() throws Exception {
		XExpression ctx = expression("foo");
		assertEquals("java.lang.Integer", converter.convert(typesService.getTypeForName("int", ctx), null, ctx).getCanonicalName());
		assertEquals("java.lang.Long", converter.convert(typesService.getTypeForName("long", ctx), null, ctx).getCanonicalName());
		assertEquals("java.lang.Character", converter.convert(typesService.getTypeForName("char", ctx), null, ctx).getCanonicalName());
		assertEquals("java.lang.Byte", converter.convert(typesService.getTypeForName("byte", ctx), null, ctx).getCanonicalName());
		assertEquals("java.lang.Short", converter.convert(typesService.getTypeForName("short", ctx), null, ctx).getCanonicalName());
		assertEquals("java.lang.Float", converter.convert(typesService.getTypeForName("float", ctx), null, ctx).getCanonicalName());
		assertEquals("java.lang.Double", converter.convert(typesService.getTypeForName("double", ctx), null, ctx).getCanonicalName());
	}
	
	public void testConvertArrays() throws Exception {
		XExpression ctx = expression("foo");
		assertEquals("java.util.List<java.lang.Integer>", converter.convert(typesService.getTypeForName("int[]", ctx), null, ctx).getCanonicalName());
		assertEquals("java.util.List<java.util.List<java.util.List<java.lang.Object>>>", converter.convert(typesService.getTypeForName("java.lang.Object[][][]", ctx), null, ctx).getCanonicalName());
	}
}
