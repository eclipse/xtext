/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import java.io.IOException;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.TypeConverter;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeConverterTest extends AbstractXbaseTestCase {
	@Inject
	private TypeConverter converter;
	
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;
	
	public void testConvertPrimitives() throws Exception {
		XExpression ctx = expression("foo", false);
		assertMappedTypeCanonicalNameEquals("int", "java.lang.Integer", ctx);		
		assertMappedTypeCanonicalNameEquals("long", "java.lang.Long",ctx);
		assertMappedTypeCanonicalNameEquals("char", "java.lang.Character", ctx);
		assertMappedTypeCanonicalNameEquals("byte", "java.lang.Byte", ctx);
		assertMappedTypeCanonicalNameEquals("short", "java.lang.Short", ctx);
		assertMappedTypeCanonicalNameEquals("float", "java.lang.Float", ctx);
		assertMappedTypeCanonicalNameEquals("double", "java.lang.Double", ctx);
		assertMappedTypeCanonicalNameEquals("void", "java.lang.Void", ctx);
	}
	
	public void testConvertArrays() throws Exception {
		XExpression ctx = expression("foo", false);
		assertMappedTypeCanonicalNameEquals("int[]", "java.util.List<java.lang.Integer>", ctx);
		assertMappedTypeCanonicalNameEquals("java.lang.Object[][][]", "java.util.List<java.util.List<java.util.List<java.lang.Object>>>", ctx);
	}
	
	protected void assertMappedTypeCanonicalNameEquals(String typeName, String expectedMappedCanonicalName, XExpression ctx) throws IOException {
		IJvmTypeProvider provider = typeProviderFactory.createTypeProvider(ctx.eResource().getResourceSet());
		JvmType type = provider.findTypeByName(typeName);
		JvmParameterizedTypeReference reference = null;
		if (type instanceof JvmTypeReference) {
			reference = (JvmParameterizedTypeReference) type;
		} else {
			reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			reference.setType(type);
		}
		assertEquals(expectedMappedCanonicalName, converter.convert(reference, ctx).getCanonicalName());
	}
}
