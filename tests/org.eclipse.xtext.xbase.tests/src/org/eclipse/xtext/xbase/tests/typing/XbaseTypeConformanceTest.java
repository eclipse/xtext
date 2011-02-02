/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import java.util.List;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.IXExpressionTypeProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XbaseTypeConformanceTest extends AbstractXbaseTestCase {

	@Inject
	private IJvmTypeConformanceComputer typeConformanceComputer;
	
	@Inject
	private IXExpressionTypeProvider typeProvider;
	
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
	
	public void testFunctionConformance_01() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+Iterable.class.getName()+"<"+Iterable.class.getName()+"<Integer>>", "new testdata.ArrayClient().getMultiArray"));
	}
	public void testFunctionConformance_02() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+Iterable.class.getName()+"<"+Iterable.class.getName()+"<int>>", "new testdata.ArrayClient().getMultiArray"));
	}
	public void testFunctionConformance_03() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+Iterable.class.getName()+"<"+Iterable.class.getName()+"<?>>", "new testdata.ArrayClient().getMultiArray"));
	}
	public void testFunctionConformance_04() throws Exception {
		assertFalse(isConformantReturnTypes("null as "+Iterable.class.getName()+"<"+Iterable.class.getName()+"<String>>", "new testdata.ArrayClient().getMultiArray"));
	}
	public void testFunctionConformance_05() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+Iterable.class.getName()+"<?>", "new testdata.ArrayClient().getArray"));
	}
	public void testFunctionConformance_06() throws Exception {
		assertFalse(isConformantReturnTypes("null as "+List.class.getName()+"<?>", "new testdata.ArrayClient().getArray"));
	}
	public void testFunctionConformance_07() throws Exception {
		assertFalse(isConformantReturnTypes("null as "+List.class.getName()+"<String>", "new testdata.ArrayClient().getArray"));
	}
	public void testFunctionConformance_08() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+List.class.getName()+"<Object>", "new testdata.ArrayClient().getArray"));
	}
	public void testFunctionConformance_09() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+List.class.getName(), "new testdata.ArrayClient().getArray"));
	}
	
	public void testArrayConformsToIterable_00() throws Exception {
		assertIsConformant(Iterable.class.getName()+"<?>", "String[]");
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
		final String leftExpression = "null as "+left;
		final String rightExpression = "null as "+right;
		return isConformantReturnTypes(leftExpression, rightExpression);
	}

	protected boolean isConformantReturnTypes(final String leftExpression, final String rightExpression)
			throws Exception {
		final XExpression parse = parseHelper.parse(leftExpression);
		JvmTypeReference leftType = typeProvider.getType(parse);
		JvmTypeReference rightType = typeProvider.getType(parseHelper.parse(rightExpression,parse.eResource().getResourceSet()));
		boolean conformant = typeConformanceComputer.isConformant(leftType, rightType);
		return conformant;
	}

}
