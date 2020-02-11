/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.util.JavaVersion
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.compiler.GeneratorConfigProvider
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.xbase.testing.TemporaryFolder
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest
import org.junit.Rule
import org.junit.Test

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
class CompilationTestHelperTest extends AbstractJvmModelTest {
	
	@Rule
	@Inject public TemporaryFolder temporaryFolder
	@Inject extension CompilationTestHelper compilationTestHelper
	@Inject GeneratorConfigProvider generatorConfigProvider
	@Inject FileExtensionProvider extensionProvider;

	@Test def void testSwitchJavaVersion6() {
		compilationTestHelper.javaVersion = JavaVersion.JAVA6
		'''
		{
			val s = ""
			switch (s) {
				case "foo": "foo"
				default: "bar"
			}
		}
		'''.compile[
			'''
			import com.google.common.base.Objects;
			
			@SuppressWarnings("all")
			public class Test {
			  public String doStuff(final String s) {
			    String _xblockexpression = null;
			    {
			      final String s_1 = "";
			      String _switchResult = null;
			      boolean _matched = false;
			      if (Objects.equal(s_1, "foo")) {
			        _matched=true;
			        _switchResult = "foo";
			      }
			      if (!_matched) {
			        _switchResult = "bar";
			      }
			      _xblockexpression = _switchResult;
			    }
			    return _xblockexpression;
			  }
			}
			'''.toString.assertEquals(singleGeneratedCode)
			compiledClass
		]
	}

	@Test def void testSwitchJavaVersion7() {
		compilationTestHelper.javaVersion = JavaVersion.JAVA7
		'''
		{
			val s = ""
			switch (s) {
				case "foo": "foo"
				default: "bar"
			}
		}
		'''.compile[
			'''
			@SuppressWarnings("all")
			public class Test {
			  public String doStuff(final String s) {
			    String _xblockexpression = null;
			    {
			      final String s_1 = "";
			      String _switchResult = null;
			      if (s_1 != null) {
			        switch (s_1) {
			          case "foo":
			            _switchResult = "foo";
			            break;
			          default:
			            _switchResult = "bar";
			            break;
			        }
			      } else {
			        _switchResult = "bar";
			      }
			      _xblockexpression = _switchResult;
			    }
			    return _xblockexpression;
			  }
			}
			'''.toString.assertEquals(singleGeneratedCode)
			compiledClass
		]
	}

	@Test def void testLambdaJavaVersion6() {
		compilationTestHelper.javaVersion = JavaVersion.JAVA6
		'''
		{
			val f = [ int i | i + 1 ]
		}
		'''.compile[
			'''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Test {
			  public String doStuff(final String s) {
			    final Function1<Integer, Integer> _function = new Function1<Integer, Integer>() {
			      @Override
			      public Integer apply(final Integer i) {
			        return Integer.valueOf((i + 1));
			      }
			    };
			    final Function1<Integer, Integer> f = _function;
			    return null;
			  }
			}
			'''.toString.assertEquals(singleGeneratedCode)
			compiledClass
		]
	}

	@Test def void testLambdaJavaVersion8() {
		compilationTestHelper.javaVersion = JavaVersion.JAVA8
		'''
		{
			val f = [ int i | i + 1 ]
		}
		'''.compile[
			'''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Test {
			  public String doStuff(final String s) {
			    final Function1<Integer, Integer> _function = (Integer i) -> {
			      return Integer.valueOf((i + 1));
			    };
			    final Function1<Integer, Integer> f = _function;
			    return null;
			  }
			}
			'''.toString.assertEquals(singleGeneratedCode)
			compiledClass
		]
	}

	@Test def void testCustomConfigIsNotLost() {
		compilationTestHelper.javaVersion = JavaVersion.JAVA8
		val resourceSet = resourceSet(
			#[
			"MyFile." + extensionProvider.primaryFileExtension
			->
			'''
			{
				val f = [ int i | i + 1 ]
			}
			'''
			]
		)
		generatorConfigProvider.install(resourceSet,
			new GeneratorConfig => [
				generateSyntheticSuppressWarnings = false
			]
		)
		resourceSet.compile[
			'''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			public class Test {
			  public String doStuff(final String s) {
			    final Function1<Integer, Integer> _function = (Integer i) -> {
			      return Integer.valueOf((i + 1));
			    };
			    final Function1<Integer, Integer> f = _function;
			    return null;
			  }
			}
			'''.toString.assertEquals(singleGeneratedCode)
		]
	}

}

