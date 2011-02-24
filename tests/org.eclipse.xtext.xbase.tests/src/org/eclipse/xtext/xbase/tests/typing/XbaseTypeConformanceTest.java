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
import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XbaseTypeConformanceTest extends AbstractXbaseTestCase {

	@Inject
	private XbaseTypeConformanceComputer typeConformanceComputer;
	
	@Inject
	private ITypeProvider typeProvider;
	
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
	
	public void testArrayConformsToIterable_01() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+Iterable.class.getName()+"<? extends "+Iterable.class.getName()+"<Integer>>", "new testdata.ArrayClient().getMultiArray"));
	}
	public void testArrayConformsToIterable_02() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+Iterable.class.getName()+"<? extends "+List.class.getName()+"<Integer>>", "new testdata.ArrayClient().getMultiArray"));
	}
	public void testArrayConformsToIterable_03() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+Iterable.class.getName()+"<? extends "+List.class.getName()+"<?>>", "new testdata.ArrayClient().getMultiArray"));
	}
	public void testArrayConformsToIterable_04() throws Exception {
		assertFalse(isConformantReturnTypes("null as "+Iterable.class.getName()+"<"+List.class.getName()+"<String>>", "new testdata.ArrayClient().getMultiArray"));
	}
	public void testArrayConformsToIterable_05() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+Iterable.class.getName()+"<?>", "new testdata.ArrayClient().getArray"));
	}
	public void testArrayConformsToIterable_06() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+List.class.getName()+"<?>", "new testdata.ArrayClient().getArray"));
	}
	public void testArrayConformsToIterable_07() throws Exception {
		assertFalse(isConformantReturnTypes("null as "+List.class.getName()+"<? extends String>", "new testdata.ArrayClient().getArray"));
	}
	public void testArrayConformsToIterable_08() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+Iterable.class.getName()+"<? extends Object>", "new testdata.ArrayClient().getArray"));
	}
	public void testArrayConformsToIterable_09() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+Iterable.class.getName(), "new testdata.ArrayClient().getArray"));
	}
	public void testArrayConformsToIterable_10() throws Exception {
		assertTrue(isConformantReturnTypes("null as "+List.class.getName()+ "<Integer>", "new testdata.ArrayClient().getArray"));
		assertTrue(isConformantReturnTypes("null as "+Iterable.class.getName()+ "<Integer>", "new testdata.ArrayClient().getArray"));
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
		return isConformantReturnTypes(leftExpression, rightExpression, false);
	}

	protected boolean isConformantReturnTypes(final String leftExpression, final String rightExpression) throws Exception {
		return isConformantReturnTypes(leftExpression, rightExpression, false);
	}
	
	protected boolean isConformantReturnTypes(final String leftExpression, final String rightExpression, boolean ignoreGenerics)
			throws Exception {
		final XExpression parse = parseHelper.parse(leftExpression);
		JvmTypeReference leftType = typeProvider.getType(parse);
		JvmTypeReference rightType = typeProvider.getType(parseHelper.parse(rightExpression,parse.eResource().getResourceSet()));
		boolean conformant = typeConformanceComputer.isConformant(leftType, rightType, ignoreGenerics);
		return conformant;
	}
	
	public void testIgnoreGenerics_00() throws Exception {
		String left = "null as Iterable<String>";
		String right = "null as Iterable<Integer>";
		assertTrue(isConformantReturnTypes(left, right, true));
		assertFalse(isConformantReturnTypes(left, right, false));
	}
	
	public void testIgnoreGenerics_01() throws Exception {
		String left = "null as (String)=>Boolean";
		String right = "null as (Integer)=>Integer";
		assertTrue(isConformantReturnTypes(left, right, true));
		assertFalse(isConformantReturnTypes(left, right, false));
	}
	
	public void testIgnoreGenerics_02() throws Exception {
		String left = "null as (String,String)=>Boolean";
		String right = "null as (String)=>Boolean";
		assertFalse(isConformantReturnTypes(left, right, true));
		assertFalse(isConformantReturnTypes(left, right, false));
	}

}
