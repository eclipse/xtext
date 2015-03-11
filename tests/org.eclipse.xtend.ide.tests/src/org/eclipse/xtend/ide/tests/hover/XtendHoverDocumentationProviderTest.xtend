package org.eclipse.xtend.ide.tests.hover

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.text.Region
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider
import org.junit.After
import org.junit.Test
import org.eclipse.xtext.common.types.JvmAnnotationTarget

class XtendHoverDocumentationProviderTest extends AbstractXtendUITestCase {
	
	@Inject
	private ParseHelper<XtendFile> parseHelper
	
	@Inject
	private WorkbenchTestHelper testHelper
	
	@Inject
	private IEObjectHoverDocumentationProvider documentationProvider
	
	@Inject
	private TestingXbaseHoverProvider hoverProvider
	
	@Inject
	private IXtendJvmAssociations jvmModelAssociations
	
	/**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=390429
     */
    @Test
    def bug390429WithoutDeclaringTypeAndOneTargetMethod(){
        val xtendFile = parseHelper.parse('''
        package testpackage
        
        import java.util.List
        
        class Foo {
            
            def foo() {
            }

            /**
            * {@link #foo}
            */
            def bar(String a, String b) {
            }
            
        }
        ''',resourceSet)
        val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
        val function = clazz.members.last as XtendFunction
        val docu = documentationProvider.getDocumentation(function)
        assertEquals('''<code><a href="eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.1">#foo</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString, docu)
    }
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=390429
	 */
	@Test
    def bug390429WithoutDeclaringType(){
        val xtendFile = parseHelper.parse('''
        package testpackage
        
        import java.util.List
        
        class Foo {
            
            def foo(String string) {
            }
            
            def foo(Object object) {
            }

            /**
            * {@link #foo(Object)}
            */
            def bar(String a, String b) {
            }
            
        }
        ''',resourceSet)
        val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
        val function = clazz.members.last as XtendFunction
        val docu = documentationProvider.getDocumentation(function)
        assertEquals('''<code><a href="eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.2">#foo(Object)</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString, docu)
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=390429
     */
    @Test
    def bug390429WithoutDeclaringTypeAndParameters(){
        val xtendFile = parseHelper.parse('''
        package testpackage
        
        import java.util.List
        
        class Foo {
            
            def foo(String string) {
            }
            
            def foo(Object object) {
            }

            /**
            * {@link #foo}
            */
            def bar(String a, String b) {
            }
            
        }
        ''',resourceSet)
        val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
        val function = clazz.members.last as XtendFunction
        val docu = documentationProvider.getDocumentation(function)
        assertEquals('''<code><a href="eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.1">#foo</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString, docu)
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=390429
     */
    @Test
    def bug390429WithoutDeclaringTypeAndMissingClosingParenthesis(){
        val xtendFile = parseHelper.parse('''
        package testpackage
        
        import java.util.List
        
        class Foo {
            
            def foo(String string) {
            }
            
            def foo(Object object) {
            }

            /**
            * {@link #foo(}
            */
            def bar(String a, String b) {
            }
            
        }
        ''',resourceSet)
        val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
        val function = clazz.members.last as XtendFunction
        val docu = documentationProvider.getDocumentation(function)
        // Due to a bug in JDT (3.5) the org.eclipse.jdt.core.dom.ASTParser would introduce a } after foo( 
        // So we can only check that the documentation gets computed and starts with foo(
        assertTrue(docu.startsWith('''<code><a href="eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.1"> #foo('''))
        assertTrue(docu.endsWith('''</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''))
    }
	
	@Test
	def testSimpleJavaDocWithMixedParameters(){
	
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* @param a something
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)
		val member = xtendFile.firstMethod
		val docu = documentationProvider.getDocumentation(member)
		assertEquals("SimpleJavaDoc<dl><dt>Parameters:</dt><dd><b>a</b>  something</dd><dd><b>b</b> </dd></dl>",docu)
	}
	
	def getFirstMethod(XtendFile file) {
		file.eAllContents.filter(typeof(XtendFunction)).head
	}
	
	@Test
	def testSimpleJavaDocWithSeeAndAuthor(){
	
		val xtendFile = parseHelper.parse('''
		package testpackage
		import java.util.Collections
		class Foo {
			
			/**
			* SimpleJavaDoc
			* @see Collections
			* @see java.util.List
			* @author FooBar
			* @since 2.3
			* @deprecated
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)
		val member = xtendFile.firstMethod
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''<p><b>Deprecated.</b> <i></i></p>SimpleJavaDoc<dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd><dt>Since:</dt><dd> 2.3</dd><dt>Author:</dt><dd> FooBar</dd><dt>See Also:</dt><dd><a href="eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections">Collections</a></dd><dd><a href="eclipse-xtext-doc:java:/Objects/java.util.List%23java.util.List">java.util.List</a></dd></dl>'''.toString, docu)
	}
	
	@Test
	def testSimpleJavaDocWithMixedExceptions(){
	
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* @throws NullPointerException not so good
			*/
			def bar(String a, String b) throws NullPointerException, RuntimeException{
			}
		}
		''',resourceSet)
		val member = xtendFile.firstMethod
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc<dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd><dt>Throws:</dt><dd><a href="eclipse-xtext-doc:java:/Objects/java.lang.NullPointerException%23java.lang.NullPointerException">NullPointerException</a> -  not so good</dd><dd><a href="eclipse-xtext-doc:java:/Objects/java.lang.RuntimeException%23java.lang.RuntimeException">RuntimeException</a></dd></dl>'''.toString,docu)
	
	}
	
	@Test
	def testJavaDocWithLinkWithOutLabel(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link java.util.Collections}
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)

		val member = xtendFile.firstMethod
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc
<code><a href="eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections">java.util.Collections</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString,docu)
	}
	
	@Test
	def testJavaDocWithLinkWithLabel(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link java.util.Collections label foo bar}
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)
		val member = xtendFile.firstMethod
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc
<code><a href="eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections"> label foo bar</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString,docu)
	}
	
	@Test
	def testJavaDocWithBrokenLink(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link Collections}
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)
		val member = xtendFile.firstMethod
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc
<code>Collections</code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString,docu)
	}
	
	@Test
	def testJavaDocWithLinkToMethodWithoutLabel(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link java.util.Collections#sort(java.util.List)}
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)
		val member = xtendFile.firstMethod
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc
<code><a href="eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections.sort(java.util.List)">java.util.Collections#sort(java.util.List)</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString,docu)
	}
	
	@Test
	def testJavaDocWithLinkToMethodWithLabel(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link java.util.Collections#sort(java.util.List) label foo bar}
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)
		val member = xtendFile.firstMethod
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc
<code><a href="eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections.sort(java.util.List)"> label foo bar</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString,docu)
	}
	
	@Test
	def testJavaDocWithLinkToXtendFunction(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		import java.util.List
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link testpackage.Foo#foo(java.util.List)}
			*/
			def bar(String a, String b){
			}
			
			def foo(List a)
		}
		''',resourceSet)
		val member = xtendFile.firstMethod
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc
<code><a href="eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.2">testpackage.Foo#foo(java.util.List)</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString, docu)
	}
	
	@Test
	def testJavaDocWithLinkToXtendFunctionOnReference(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		import java.util.List
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link testpackage.Foo#foo(java.util.List)}
			*/
			def bar(String a, String b){
			}
			
			def foo(List a){
				bar("42","43")
		}
		''',resourceSet)
		val function = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head.members.get(1) as XtendFunction
		val call = (function.expression as XBlockExpression).expressions.get(0) as XAbstractFeatureCall
		val docu = documentationProvider.getDocumentation(call.feature)
		assertEquals('''SimpleJavaDoc
<code><a href="eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.2">testpackage.Foo#foo(java.util.List)</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString, docu)
	}
	
	@Test
    def bug380551(){
        val xtendFile = parseHelper.parse('''
        package testpackage
        @A
        class Foo {
        }
        
        annotation A {}
        ''',resourceSet)
        val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
        val docu = documentationProvider.getDocumentation(clazz)
        assertEquals('''@<a href="eclipse-xtext-doc:__synthetic0.xtend%23/2">A</a><br>'''.toString, docu)
    }
    
    	
	@Test
    def bug380551_2(){
        val xtendFile = parseHelper.parse('''
        package testpackage
        @A
        class Foo {
        	def bar(Foo x){}
        }
        
        annotation A {}
        ''',resourceSet)
        val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
        val func = clazz.members.head as XtendFunction
        val docu = documentationProvider.getDocumentation(func.parameters.head.parameterType.type)
        assertEquals('''@<a href="eclipse-xtext-doc:__synthetic0.xtend%23/2">A</a><br>'''.toString, docu)
    }
    // This test makes sure that a Java URI to a native Java type in JavaDoc can be resolved
    // Normally the invocation would be done through org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider.addLinkListener(...).new ILinkHandler() {...}.handleInlineXtextdocLink(URI)
    // The necessary change was in org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider.isValidationDisabled(EObject)
    @Test
    def bug380551_TestLinkToNativeJavaType(){
        val xtendFile = parseHelper.parse('''
        package testpackage
        import javax.annotation.Resource
        @Resource
        class Foo {
        }
        ''',resourceSet)
        val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
        val target = jvmModelAssociations.getInferredType(clazz) as JvmAnnotationTarget
      	assertNotNull(hoverProvider.getHoverInfo(target.annotations.head.annotation))
    }
    
   
	
	
	def getResourceSet(){
		getInjector.getInstance(typeof(IResourceSetProvider)).get(testHelper.project)
	}
	
	@After
	def void cleanup(){
		testHelper.tearDown
	}
}

 class TestingXbaseHoverProvider extends XbaseHoverProvider {
		
   def getHoverInfo(EObject element) {
		super.getHoverInfo(element, new Region(0,0) , null)
	}
}