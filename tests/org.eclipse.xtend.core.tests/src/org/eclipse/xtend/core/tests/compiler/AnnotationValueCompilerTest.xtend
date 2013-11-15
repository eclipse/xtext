/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class AnnotationValueCompilerTest extends AbstractXtendCompilerTest {

	@Test
	def testAnnotationValues_1() {
		assertCompilesTo('''
			package foo
			@test.Annotation(
				booleanValue = true,
				intValue = 1,
				longValue = 42,
				stringValue = 'foo',
				booleanArrayValue = #[true],
				intArrayValue = #[1],
				longArrayValue = #[42],
				stringArrayValue = #['foo'],
				typeValue = String,
				typeArrayValue = #[String],
				annotation2Value = @test.Annotation2('foo'),
				annotation2ArrayValue = #[@test.Annotation2('foo')]
				) class Bar {
			}
		''', '''
			package foo;
			
			import test.Annotation;
			import test.Annotation2;
			
			@Annotation(booleanValue = true, intValue = 1, longValue = 42, stringValue = "foo", booleanArrayValue = true, intArrayValue = 1, longArrayValue = 42, stringArrayValue = "foo", typeValue = String.class, typeArrayValue = String.class, annotation2Value = @Annotation2("foo"), annotation2ArrayValue = @Annotation2("foo"))
			@SuppressWarnings("all")
			public class Bar {
			}
		''')
	}
	
	@Test
	def testAnnotationValues_2() {
		assertCompilesTo('''
			package foo
			@test.Annotation(
				intValue = 1 + 4 + 6 * 42 - 4 / 45,
				longValue = 42 + 4 + 6 * 42 - 4 / 45,
				stringValue = 'foo' + 'baz',
				booleanArrayValue = #[true, false],
				intArrayValue = #[ -1, 34 + 45, 2 - 6 ],
				longArrayValue = #[42, 5 * -3],
				stringArrayValue = #['foo', 'bla' + 'buzz'],
				typeValue = String,
				typeArrayValue = #[String, Integer],
				annotation2Value = @test.Annotation2('foo' + 'wuppa'),
				annotation2ArrayValue = #[@test.Annotation2('foo'), @test.Annotation2('foo'+'wuppa')]
				) class Bar {
			}
		''', '''
			package foo;
			
			import test.Annotation;
			import test.Annotation2;
			
			@Annotation(intValue = (((1 + 4) + (6 * 42)) - (4 / 45)), longValue = (((42 + 4) + (6 * 42)) - (4 / 45)), stringValue = ("foo" + "baz"), booleanArrayValue = { true, false }, intArrayValue = { (-1), (34 + 45), (2 - 6) }, longArrayValue = { 42, (5 * (-3)) }, stringArrayValue = { "foo", ("bla" + "buzz") }, typeValue = String.class, typeArrayValue = { String.class, Integer.class }, annotation2Value = @Annotation2(("foo" + "wuppa")), annotation2ArrayValue = { @Annotation2("foo"), @Annotation2(("foo" + "wuppa")) })
			@SuppressWarnings("all")
			public class Bar {
			}
		''')
	}
	
	@Test
	def testAnnotationValues_constants() {
		assertCompilesTo('''
			package foo
			@test.Annotation(
				intValue = test.Constants1.INT_CONSTANT + 4 + test.Constants1.INT_CONSTANT / 45
				) class Bar {
			}
		''', '''
			package foo;
			
			import test.Annotation;
			import test.Constants1;
			
			@Annotation(intValue = ((Constants1.INT_CONSTANT + 4) + (Constants1.INT_CONSTANT / 45)))
			@SuppressWarnings("all")
			public class Bar {
			}
		''')
	}
	
	@Test
	def testAnnotationValues_enums() {
		assertCompilesTo('''
			package foo
			@test.Annotation(
				enumValue = test.Enum1.RED,
				enumArrayValue = #[test.Enum1.RED, test.Enum1.BLUE]
				) class Bar {
			}
		''', '''
			package foo;
			
			import test.Annotation;
			import test.Enum1;
			
			@Annotation(enumValue = Enum1.RED, enumArrayValue = { Enum1.RED, Enum1.BLUE })
			@SuppressWarnings("all")
			public class Bar {
			}
		''')
	}
	
}