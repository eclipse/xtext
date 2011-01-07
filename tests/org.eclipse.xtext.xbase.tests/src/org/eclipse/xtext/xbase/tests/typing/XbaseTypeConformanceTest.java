/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.TypesService;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class XbaseTypeConformanceTest extends AbstractXbaseTestCase {

	@Inject
	private TypesService typeService;

	@Inject
	private ITypeProvider<JvmTypeReference> typeProvider;

	@Inject
	private IJvmTypeConformanceComputer typeConformanceComputer;

	public void testEverythingConformsToVoid() throws Exception {
		XExpression nullExpression = expression("null");
		assertIsConformant(TypesService.JAVA_LANG_CLASS, nullExpression);
		assertIsConformant(TypesService.INTEGER_TYPE_NAME, nullExpression);
		assertIsConformant(TypesService.VOID_TYPE_NAME, nullExpression);
		assertIsConformant(TypesService.BOOLEAN_TYPE_NAME, nullExpression);
		assertIsConformant(TypesService.STRING_TYPE_NAME, nullExpression);
		assertIsConformant(TypesService.OBJECT_TYPE_NAME, nullExpression);
		assertIsConformant(TypesService.JAVA_LANG_THROWABLE, nullExpression);
		assertIsConformant(TypesService.JAVA_LANG_ITERABLE, nullExpression);
	}

	protected void assertIsConformant(QualifiedName leftTypeName, XExpression rightExpression) throws Exception {
		JvmTypeReference leftType = typeService.getTypeForName(leftTypeName, rightExpression);
		typeConformanceComputer.isConformant(leftType, typeProvider.getType(rightExpression));
	}

}
