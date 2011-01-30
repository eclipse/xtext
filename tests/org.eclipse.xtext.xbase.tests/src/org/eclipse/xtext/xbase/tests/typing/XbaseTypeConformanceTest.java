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
import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.XExpressionTypeProvider;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XbaseTypeConformanceTest extends AbstractXbaseTestCase {

	@Inject
	private IJvmTypeConformanceComputer typeConformanceComputer;
	
	@Inject
	private XExpressionTypeProvider typeProvider;
	
	@Inject
	private ParseHelper<XExpression> parseHelper;

	public void testVoidConformsWithEverything() throws Exception {
		assertIsConformant(Class.class.getName(),Void.class.getName());
		assertIsConformant(Integer.TYPE.getName(),Void.class.getName());
		assertIsConformant(Object.class.getName(),Void.class.getName());
		assertIsConformant(Void.class.getName(),Void.class.getName());
		assertIsConformant(CharSequence.class.getName(),Void.class.getName());
		assertIsConformant(XbaseTypeConformanceTest.class.getName(),Void.class.getName());
	}
	
	public void testFunctionConformance_00() throws Exception {
		assertIsConformant(Function.class.getName()+"<String,String>", "(String)=>String");
	}
	
	protected void assertIsConformant(String left, String right) throws Exception {
		boolean conformant = isConformant(left, right);
		assertTrue(left+" <= "+right+" is not conformant",conformant);
	}
	
	protected void assertNotConformant(String left, String right) throws Exception {
		boolean conformant = isConformant(left, right);
		assertFalse(left+" <= "+right+" is conformant",conformant);
	}

	protected boolean isConformant(String left, String right) throws Exception {
		final XExpression parse = parseHelper.parse("null as "+left);
		JvmTypeReference leftType = typeProvider.getConvertedType(parse);
		JvmTypeReference rightType = typeProvider.getConvertedType(parseHelper.parse("null as "+right,parse.eResource().getResourceSet()));
		boolean conformant = typeConformanceComputer.isConformant(leftType, rightType);
		return conformant;
	}

}
