/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import java.util.List;

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.RuntimeTestSetup;
import org.eclipse.xtend.core.tests.richstring.RichStringCompilerTest.FewerImportsRuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.util.TemporaryFolder;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedFeatures;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FewerImportsRuntimeInjectorProvider.class)
public class RichStringCompilerTest extends AbstractRichStringEvaluationTest {
	
	@Singleton
	public static class FewerImplicitlyImportedFeatures extends ImplicitlyImportedFeatures {
		@Override
		protected List<Class<?>> getExtensionClasses() {
			return Lists.newArrayList(IterableExtensions.class, ObjectExtensions.class, IntegerExtensions.class);
		}
		
		@Override
		protected List<Class<?>> getStaticImportClasses() {
			return Lists.newArrayList();
		}
	}
	
	public static class FewerImportsRuntimeInjectorProvider extends RuntimeInjectorProvider {
		@Override
		protected Injector internalCreateInjector() {
			
			return new RuntimeTestSetup() {
				@Override
				public Injector createInjector() {
					return Guice.createInjector(new XtendRuntimeTestModule() {
						public Class<? extends ImplicitlyImportedFeatures> bindImplicitlyImportedFeatures() {
							return FewerImplicitlyImportedFeatures.class;
						}
					});
					
				}
			}.createInjectorAndDoEMFRegistration();
		}
	}	
	
	
	@Inject
	private RichStringCompilerTestHelper testHelper;
	
	@Rule
	@Inject public TemporaryFolder tempFolder;
	
	@Before
	public void setUp() throws Exception {
		testHelper.setUp();
	}

	@Override
	public void assertOutput(String expectedOutput, String richString) throws Exception {
		String platformExpectedOutput = expectedOutput.replace("\n", nl());
		testHelper.assertEvaluatesTo(platformExpectedOutput, richString);
	}

	@Test public void testIf_09() throws Exception {
		assertOutput("foobar\n", 
				"'''\n"+
				"  «IF 'a'.charAt(0)!='a'»\n"+
				"	  foobar«ENDIF»\n"+
				"'''");
	}
	
	@Test public void testVariableInString_01() throws Exception {
		assertOutput("1, 2, 3, 4, 5, 6, 7, 8, 9, 10", "'''«var max = 10»«FOR i: 1..max SEPARATOR ', '»«i»«ENDFOR»'''");
	}
	
	@Test public void testForLoop_27() throws Exception {
		assertOutput(
				"foo\n",
				"'''«FOR a: com.google.common.collect.Lists.newArrayList(new testdata.OuterClass$InnerClass())»\n" +
				"   foo\n" +
				"«ENDFOR»'''");
	}
	
	@Test public void testBug343148() throws Exception {
		assertOutput(" zonk a\n\n zonk b\n\n zonk c",
				"'''«com.google.common.collect.Lists.newArrayList('a','b','c').join('\n\n',[e|''' zonk «e»'''])»'''");
	}
	
	@Test public void testBug349762() throws Exception {
		assertOutput("1,2\n2,4\n",
				"''' \n" + 
				"        «FOR i:1..2»\n" + 
				"            «FOR j:(1..2).map(k | k*i) SEPARATOR ','»«j»«ENDFOR»\n" + 
				"        «ENDFOR»\n" + 
				"'''");
	}
	
	@Test public void testBug440006() throws Exception {
		assertOutput("1,2\n",
				"''' \n" + 
						"        «FOR i:#[1..2]»\n" + 
						"            «FOR j:i SEPARATOR ','»«j»«ENDFOR»\n" + 
						"        «ENDFOR»\n" + 
				"'''");
	}
	
	@Test public void testBug440006b() throws Exception {
		assertOutput("1,2\n",
				"''' \n" + 
						"        «FOR i:#{1..2}»\n" + 
						"            «FOR j:i SEPARATOR ','»«j»«ENDFOR»\n" + 
						"        «ENDFOR»\n" + 
				"'''");
	}
}
