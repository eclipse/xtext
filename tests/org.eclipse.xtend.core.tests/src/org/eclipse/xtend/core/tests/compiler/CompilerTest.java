/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompilerTest extends AbstractCompilerTest {

	@Override
	@Ignore("Fails with old impl")
	@Test
	public void testRecursiveTypeParameter_01() throws Exception {
		super.testRecursiveTypeParameter_01();
	}
	
	@Override
	@Ignore("Fails with old impl")
	@Test
	public void testRecursiveTypeParameter_02() throws Exception {
		super.testRecursiveTypeParameter_02();
	}
	
	@Override
	@Ignore("Fails with old impl")
	@Test
	public void testRecursiveTypeParameter_03() throws Exception {
		super.testRecursiveTypeParameter_03();
	}
	
	@Override
	@Ignore("Fails with old impl")
	@Test
	public void testRecursiveTypeParameter_04() throws Exception {
		super.testRecursiveTypeParameter_04();
	}
	
	@Override
	@Test
	@Ignore("Fails with old impl")
	public void testBug_396879_04() throws Exception {
		super.testBug_396879_04();
	}
	
	@Override
	@Test
	@Ignore("Fails with old impl")
	public void testBug_396879_05() throws Exception {
		super.testBug_396879_05();
	}
	
	@Override
	@Test
	@Ignore("TODO this one should be valid, too since we could infer the CharSequence from the expected type")
	public void testBug_352849_06_b() throws Exception {
		super.testBug_352849_06_b();
	}
	
	@Override
	@Test
	@Ignore("TODO this one should be valid, too since we could infer the CharSequence from the expected type")
	public void testBug_352849_06_d() throws Exception {
		super.testBug_352849_06_d();
	}
	
	@Override
	@Test
	@Ignore("TODO these used to cause a stackoverflow " + 
			"currently they fail with dangling references which is a lot better but " +
			"there's still room for improvements")
	public void testBug343096_01() throws Exception {
		super.testBug343096_01();
	}
	
	@Override
	@Test
	@Ignore("TODO these used to cause a stackoverflow " + 
			"currently they fail with dangling references which is a lot better but " +
			"there's still room for improvements")
	public void testBug343096_02() throws Exception {
		super.testBug343096_02();
	}
	
	@Override
	@Test
	@Ignore("TODO Produces code that cannot be compiled")
	public void testBug343096_03() throws Exception {
		super.testBug343096_03();
	}
	
	@Override
	@Test
	@Ignore("TODO Fix this case - see also deactivated tests in XbaseIdentifiableTypeProviderTest and XbaseTypeProviderTest")
	public void testBug346763_07() throws Exception {
		super.testBug346763_07();
	}
	
	@Override
	@Test
	@Ignore("TODO Validation complains that local var x may not have type void though it should be 'any'")
	public void testBug_350932_13() throws Exception {
		super.testBug_350932_13();
	}
	
	@Override
	@Test
	@Ignore("TODO Currently there is no validation issue but it produces code that does not compile")
	public void testBug_350932_14() throws Exception {
		super.testBug_350932_14();
	}
}
