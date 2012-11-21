package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider
import org.eclipse.xtext.xbase.compiler.IElementIssueProvider
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.junit.Test
import java.util.regex.Pattern

class XtendCompilerErrorHandlingTest extends AbstractXtendTestCase {
	
	@Inject JvmModelGenerator generator
	
	@Inject IResourceValidator validator
	
	@Inject ElementIssueProvider$Factory issueProviderFactory
	
	@Inject OnChangeEvictingCache cache

	@Test
	def testUnresolvedSuperclass() {
		'''
			class Foo extends Unresolved {
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo /* implements Unresolved  */{
			}
		''', false)
	}
		
	@Test
	def testUnresolvedInterface() {
		'''
			class Foo implements Unresolved {
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo /* implements Unresolved  */{
			}
		''', false)
	}
		
	@Test
	def testUnresolvedInterface_1() {
		'''
			class Foo implements Cloneable, Unresolved {
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo implements Cloneable/* , Unresolved */ {
			}
		''', false)
	}
		
	@Test
	def testUnresolvedInterface_2() {
		'''
			class Foo implements Unresolved, Cloneable {
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo implements /* Unresolved */Cloneable {
			}
		''', false)
	}
		
	@Test
	def testUnresolvedAnnotation() {
		'''
			@Unresolved
			class Foo {
			}
		'''.assertCompilesTo( '''
			/* @Unresolved */@SuppressWarnings("all")
			public class Foo {
			}
		''', false)
	}
		
	@Test
	def testUnresolvedAnnotation_1() {
		'''
			@Deprecated
			@Unresolved
			class Foo {
			}
		'''.assertCompilesTo( '''
			@Deprecated/* 
			@Unresolved */
			@SuppressWarnings("all")
			public class Foo {
			}
		''', false)
	}
		
	@Test
	def testUnresolvedFieldType() {
		'''
			class Foo {
				Unresolved bar
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo {
			  private /* Unresolved */Object bar;
			}
		''', false)
	}
		
	@Test
	def testUnresolvedReturnType() {
		'''
			class Foo {
				def Unresolved bar() {
					null
				}
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo {
			  public /* Unresolved */Object bar() {/* 
			    return null; */throw new Error("Unresolved compilation problem");
			  }
			}
		''', false)
	}
		
	@Test
	def testUnresolvedParameterType() {
		'''
			class Foo {
				def void bar(Unresolved p) {
				}
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo {
			  public void bar(final /* Unresolved */Object p) {
			  }
			}
		''', false)
	}
		
	@Test
	def testUnresolvedException() {
		'''
			class Foo {
				def void bar() throws Unresolved {
				}
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo {
			  public void bar()/*  throws Unresolved */ {
			  }
			}
		''', false)
	}
		
	@Test
	def testUnresolvedException_1() {
		'''
			class Foo {
				def void bar() throws Unresolved, RuntimeException {
				}
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo {
			  public void bar() throws /* Unresolved */RuntimeException {
			  }
			}
		''', false)
	}
		
	@Test
	def testUnresolvedException_2() {
		'''
			class Foo {
				def void bar() throws RuntimeException, Unresolved {
				}
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo {
			  public void bar() throws RuntimeException/* , Unresolved */ {
			  }
			}
		''', false)
	}	
	
	@Test
	def testFieldInitializerTypeError() {
		'''
			class Foo {
				val int bar = null
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo {
			  private final int bar;
			}
		''', true)
	}

	@Test
	def testFieldInitializerLinkError() {
		'''
			class Foo {
				val bar = foo()
			}
		'''.assertCompilesTo( '''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;

			@SuppressWarnings("all")
			public class Foo {
			  private final Object bar;
			}
		''', true)
	}

	@Test
	def testMethodBodyTypeError() {
		'''
			class Foo {
				def int bar() {
					null
				}
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo {
			  public int bar() {throw new Error("Unresolved compilation problem");
			  }
			}
		''', true)
	}
	
	@Test
	def testMethodBodyLinkError() {
		'''
			class Foo {
				def int bar() {
					foo()
				}
			}
		'''.assertCompilesTo( '''
			@SuppressWarnings("all")
			public class Foo {
			  public int bar() {throw new Error("Unresolved compilation problem");
			  }
			}
		''', true)
	}
		
	
	def assertCompilesTo(CharSequence input, CharSequence expected, boolean skipComments) {
		val file = file(input.toString(), false)
		val resource = file.eResource
		cache.get(typeof(IElementIssueProvider).name, file.eResource, [|
			val issues = validator.validate(resource, CheckMode::ALL, CancelIndicator::NullImpl)
			issueProviderFactory.create(resource, issues)
		])
		val inferredType = resource.contents.filter(typeof(JvmDeclaredType)).head
		val javaCode = generator.generateType(inferredType);
		if(skipComments) {
			val pattern = Pattern::compile('/\\*.*?\\*/', Pattern::DOTALL)
			assertEquals(expected.toString, pattern.matcher(javaCode.toString).replaceAll(''))
		} else {
			assertEquals(expected.toString, javaCode.toString)
		}
	}
}