package org.eclipse.xtext.xbase.tests.compiler

import org.junit.Test

class CompilerTests2 extends AbstractOutputComparingCompilerTests {

	@Test def void testVariableDeclaration() throws Exception {
		'''
			{
				val x = 42
			}
		'''.compilesTo('''
			final int x = 42;
		''')
	}
		
	@Test def void testVariableDeclaration1() throws Exception {
		'''
			{
				val a = 'foo'
				val x = a
			}
		'''.compilesTo('''
			final String a = "foo";
			final String x = a;
		''')
	}
	
	@Test def void testVariableDeclaration2() throws Exception {
		'''
			{
				val x = 'foo'.toUpperCase
			}
		'''.compilesTo('''
			final String x = "foo".toUpperCase();
		''')
	}
		
	@Test def void testBug367144() throws Exception {
		'''
			foo::bar::SubOfClassWithStatics::MY_STATIC_FIELD
		'''.compilesTo('''
			return foo.bar.SubOfClassWithStatics.MY_STATIC_FIELD;
		''')
	}
	
	@Test def void testBug367144_1() throws Exception {
		'''
			foo::bar::SubOfClassWithStatics::MY_STATIC_METHOD
		'''.compilesTo('''
			String _MY_STATIC_METHOD = foo.bar.SubOfClassWithStatics.MY_STATIC_METHOD();
			return _MY_STATIC_METHOD;
		''')
	}
}