/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler

import com.google.inject.Inject
import foo.TestAnnotation
import foo.TestAnnotation2
import foo.TestAnnotations
import java.lang.reflect.Modifier
import java.util.AbstractList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.TemporaryFolder
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler2
import org.eclipse.xtext.xbase.jvmmodel.JvmModelCompleter
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.tests.typesystem.XbaseWithLogicalContainerInjectorProvider
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseWithLogicalContainerInjectorProvider))
class JvmModelGeneratorTest extends AbstractXbaseTestCase {
	
	@Rule
	@Inject public TemporaryFolder temporaryFolder
	@Inject extension JvmTypesBuilder builder
	@Inject TypeReferences references
	@Inject ValidationTestHelper helper
	@Inject JvmModelGenerator generator
	@Inject OnTheFlyJavaCompiler2 javaCompiler
	@Inject TypesFactory typesFactory;
	@Inject JvmModelCompleter completer
	
	@Test
	def void bug390290InnerClassMemberImport() {
		val expression = expression("null")
		val clazz = expression.toClass("my.test.Outer") [
			val innerClass = toClass('InnerClass')
			val innerClassString = toClass('String')
			members += innerClass
			members += innerClassString
			members += toMethod('foo', references.getTypeForName(typeof(String), expression), [fooMethod |
				fooMethod.parameters += toParameter('p1', references.createTypeRef(innerClass))
				fooMethod.parameters += toParameter('p2', references.createTypeRef(innerClassString))
				fooMethod.setBody(expression)
			])
		]
		expression.eResource.eSetDeliver(false)
		expression.eResource.contents += clazz
		expression.eResource.eSetDeliver(true)
		val fsa = new InMemoryFileSystemAccess()
		generator.doGenerate(expression.eResource, fsa)
		val code = fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + clazz.identifier.replace('.','/')+".java").toString
		assertFalse(code.contains("import"))
		assertTrue(code, code.contains("java.lang.String foo"))
		val compiledClass = javaCompiler.compileToClass(clazz.identifier, code)
		helper.assertNoErrors(expression.eResource.contents.head)
		assertEquals(2, compiledClass.declaredClasses.size)
		assertNotNull(compiledClass.getMethod("foo",compiledClass.declaredClasses.head,compiledClass.declaredClasses.last))
	}

	@Test
	def void testSimple() {
		val expression = expression("return s.toUpperCase", false);
		val clazz = expression.toClass("my.test.Foo") [
			members += expression.toMethod("doStuff", references.getTypeForName(typeof(String), expression)) [
				parameters += expression.toParameter("s", references.getTypeForName(typeof(String), expression))
				setBody(expression)
			]
		]
		
		val compiledClass = compile(expression.eResource, clazz)
		val instance = compiledClass.newInstance
		assertEquals("FOO", compiledClass.getMethod("doStuff",typeof(String)).invoke(instance,"foo"))
	}
	@Test
	def void testAnnotation_1() {
		val expression = expression("42", false);
		val clazz = expression.toAnnotationType("my.test.Foo") [
			members += expression.toMethod("theTruth", references.getTypeForName(typeof(int), expression)) [
				setBody(expression)
			]
		]
		val compiledClass = compile(expression.eResource, clazz)
		assertTrue(compiledClass.annotation)
		val method = compiledClass.methods.head
		assertEquals('theTruth', method.name)
		assertEquals(42, method.defaultValue)
	}
	
	@Test
	def void testAnnotation_2() {
		val expression = expression("typeof(String)", false);
		val clazz = expression.toAnnotationType("my.test.Foo") [
			members += expression.toMethod("value", references.getTypeForName(typeof(Class), expression, references.wildCard)) [
				setBody(expression)
			]
			members += expression.toMethod("otherValue", references.getTypeForName(typeof(int), expression)) []
		]
		val compiledClass = compile(expression.eResource, clazz)
		assertTrue(compiledClass.annotation)
		assertEquals(typeof(String), compiledClass.methods.findFirst[name == 'value'].defaultValue)
		assertNull(compiledClass.methods.findFirst[name == 'otherValue'].defaultValue)
	}
	
	@Test
	def void testImplements() {
		val expression = expression("null", false);
		val clazz = expression.toClass("my.test.Foo") [
			^abstract = true
			superTypes += expression.typeRef(typeof(Iterable), typeof(String))
		]
		val compiled = compile(expression.eResource, clazz)
		assertTrue(typeof(Iterable).isAssignableFrom(compiled))
	}
	
	@Test
	def void testExtends() {
		val expression = expression("null", false);
		val clazz = expression.toClass("my.test.Foo") [
			^abstract = true
			superTypes += expression.typeRef(typeof(AbstractList), typeof(String))
		]
		val compiled = compile(expression.eResource, clazz)
		assertTrue(typeof(Iterable).isAssignableFrom(compiled))
		assertTrue(typeof(AbstractList).isAssignableFrom(compiled))
	}
	
	@Test
	def void testCompilationStrategy() {
		val expression = expression("null", false);
		val clazz = expression.toClass("my.test.Foo") [
			members += expression.toField("x", expression.typeRef(typeof(String)))
			members += expression.toGetter("x", expression.typeRef(typeof(String)))
			members += expression.toSetter("x", expression.typeRef(typeof(String)))
		]
		val compiled = compile(expression.eResource, clazz)
		
		val inst = compiled.newInstance
		val getter = compiled.getMethod("getX")
		val setter = compiled.getMethod("setX", typeof(String))
		setter.invoke(inst, "FOO")
		assertEquals("FOO", getter.invoke(inst))
	}
		
	@Test
	def void testEnumeration() {
		val expression = expression("null", false);
		val enumeration = expression.toEnumerationType("my.test.Foo") [
			members += expression.toEnumerationLiteral("BAR") [ literal |
				literal.type = references.createTypeRef(it)
			]
			members += expression.toEnumerationLiteral("BAZ") [ literal |
				literal.type = references.createTypeRef(it)
			]
		]
		val compiled = compile(expression.eResource, enumeration)
		
		val valuesMethod = compiled.getMethod("values")
		val values = valuesMethod.invoke(null) as Object[]
		assertEquals("BAR", values.get(0).toString())
		assertEquals("BAZ", values.get(1).toString())
	}
	
	@Test
	def void testEnumeration2() {
		val expression = expression("null", false);
		/* explicitly use => here */
		val enumeration = expression.toEnumerationType("my.test.Foo") => [
			members += expression.toEnumerationLiteral("BAR") [ literal |
				literal.type = references.createTypeRef(it)
			]
			members += expression.toEnumerationLiteral("BAZ") [ literal |
				literal.type = references.createTypeRef(it)
			]
		]
		val compiled = compile(expression.eResource, enumeration)
		
		val valuesMethod = compiled.getMethod("values")
		val values = valuesMethod.invoke(null) as Object[]
		assertEquals("BAR", values.get(0).toString())
		assertEquals("BAZ", values.get(1).toString())
	}
	
	@Test
	def void testEnumerationWithCompleter() {
		val expression = expression("null", false);
		val enumeration = expression.toEnumerationType("my.test.Foo") [
			members += expression.toEnumerationLiteral("BAR")
			members += expression.toEnumerationLiteral("BAZ")
		]
		expression.eResource.contents.add(enumeration)
		completer.complete(enumeration)
		val compiled = compile(expression.eResource, enumeration)
		
		val valuesMethod = compiled.getMethod("values")
		val values = valuesMethod.invoke(null) as Object[]
		assertEquals("BAR", values.get(0).toString())
		assertEquals("BAZ", values.get(1).toString())
	}
	
	@Test
	def void testBug377925No_Nullpointer(){
		val expression = expression("[Object o| null]")
		val clazz = expression.toClass("my.test.Foo") [
			members += expression.toMethod("doStuff", references.getTypeForName("java.lang.Object", expression)) [
				setBody(expression)
			]
		]
		compile(expression.eResource,clazz);
	}

	@Test
	def void testBug380754(){
		val expression = expression("null")
		val clazz = expression.toClass("my.test.Foo") [
			members += expression.toMethod("doStuff",references.getTypeForName("java.lang.Object", expression)) [
				setBody(expression)
				val annotation = expression.toAnnotation(typeof(TestAnnotations))
				val annotationAnnotationValue = typesFactory.createJvmAnnotationAnnotationValue

				annotationAnnotationValue.values += expression.toAnnotation(typeof(TestAnnotation))
				annotationAnnotationValue.values += expression.toAnnotation(typeof(TestAnnotation))
				annotationAnnotationValue.values += expression.toAnnotation(typeof(TestAnnotation))
				annotation.explicitValues += annotationAnnotationValue
				annotations += annotation
			]
		]
		compile(expression.eResource, clazz)

	}
	
	@Test
	def void testBug380754_2() {
		val expression = expression("null")
		val clazz = expression.toClass("my.test.Foo") [
			members += expression.toMethod("doStuff",references.getTypeForName("java.lang.Object", expression)) [
				setBody(expression)
				val parameter = expression.toParameter("s", references.getTypeForName(typeof(String), expression))
				parameters += parameter
				parameter.annotations += expression.toAnnotation(typeof(TestAnnotation))
				parameter.annotations += expression.toAnnotation(typeof(TestAnnotation2))
			]
		]
		compile(expression.eResource, clazz)
	}
	
	@Test
	def void testBug419430() {
		val expression = expression("null")
		val clazz = expression.toClass("my.test.Foo") [
			members += expression.toMethod("doStuff", references.getTypeForName("java.lang.Object", expression)) [
				setBody(expression)
				val annotation = expression.toAnnotation(typeof(TestAnnotations))
				val annotationAnnotationValue = typesFactory.createJvmAnnotationAnnotationValue
				annotationAnnotationValue.values += expression.toAnnotation(typeof(TestAnnotation))
				annotationAnnotationValue.values += expression.toAnnotation(typeof(TestAnnotation))
				annotationAnnotationValue.values += expression.toAnnotation(typeof(TestAnnotation))
				annotation.explicitValues += annotationAnnotationValue
				annotations += annotation
			]
		]
		val code = expression.eResource.generate(clazz)
		assertTrue(code, code.contains("@TestAnnotations({ @TestAnnotation, @TestAnnotation, @TestAnnotation })"))
		
		val compiledClazz = expression.eResource.compileToClass(clazz, code)
		val method = compiledClazz.getMethod("doStuff")
		val methodAnnotation = method.getAnnotation(TestAnnotations)
		assertEquals(3, methodAnnotation.value.size)
	}
    
    @Test
    def void testBug377002(){
        val expression = expression("null")
        val clazz = expression.toEnumerationType("my.test.Level") [
            members += expression.toEnumerationLiteral("WARN") [ literal |
				literal.type = references.createTypeRef(it)
			]
            members += expression.toEnumerationLiteral("ERROR") [ literal |
				literal.type = references.createTypeRef(it)
			]
            members += expression.toEnumerationLiteral("DEBUG") [ literal |
				literal.type = references.createTypeRef(it)
			]
            members += expression.toMethod("doStuff", references.getTypeForName("java.lang.Object", expression)) [
                setBody(expression)
            ]
        ]
        val compiled = compile(expression.eResource, clazz)
        assertNotNull(compiled.getField("WARN"))
        assertNotNull(compiled.getField("ERROR"))
        assertNotNull(compiled.getField("DEBUG"))
        assertNotNull(compiled.getMethod("doStuff"))
    }
    
    @Test
    def void testBug426442_EnclosingClassMethodCall() {
	val expression = expression("enclosingClassMethod", false);

	val enclosingClass = expression.toClass("my.test.EnclosingClass") [
		members += expression.toMethod("enclosingClassMethod", references.getTypeForName(String, expression)) [
				body = [append('''return "enclosingClassMethodResult";''')]
			]
		members += expression.toClass(qualifiedName + ".InnerClass") [
			members += expression.toMethod("enclosingClassMethodCall", references.getTypeForName(String, expression)) [
				body = expression
			]
		]
	]

	val compiledEnclosingClass = compile(expression.eResource, enclosingClass)
	assertNotNull(compiledEnclosingClass)
	val compiledInnerClass = compiledEnclosingClass.declaredClasses.findFirst[simpleName == "InnerClass"]
	assertNotNull(compiledInnerClass)
	val enclosingClassInstance = compiledEnclosingClass.newInstance
	assertNotNull(enclosingClassInstance)
	val innerClassConstructor = compiledInnerClass.getDeclaredConstructor(compiledEnclosingClass);
	assertNotNull(innerClassConstructor)
	val innerClassInstance = innerClassConstructor.newInstance(enclosingClassInstance)
	assertNotNull(innerClassInstance)
	val enclosingClassMethodCallMethod = compiledInnerClass.getMethod("enclosingClassMethodCall")
	assertNotNull(enclosingClassMethodCallMethod)
	val invocationResult = enclosingClassMethodCallMethod.invoke(innerClassInstance)
	assertNotNull(invocationResult)

	assertEquals("enclosingClassMethodResult", invocationResult)
    }

    @Test
    def void testBug426442_InnerClassLocalMethodCall() {
	val expression = expression("innerClassMethod", false);

	val enclosingClass = expression.toClass("my.test.EnclosingClass") [
		members += expression.toClass(qualifiedName + ".InnerClass") [
			members += expression.toMethod("innerClassMethod", references.getTypeForName(String, expression)) [
				body = [append('''return "innerClassMethodResult";''')]
			]
			members += expression.toMethod("innerClassMethodCall", references.getTypeForName(String, expression)) [
				body = expression
			]
		]
	]

	val compiledEnclosingClass = compile(expression.eResource, enclosingClass)
	assertNotNull(compiledEnclosingClass)
	val compiledInnerClass = compiledEnclosingClass.declaredClasses.findFirst[simpleName == "InnerClass"]
	assertNotNull(compiledInnerClass)
	val enclosingClassInstance = compiledEnclosingClass.newInstance
	assertNotNull(enclosingClassInstance)
	val innerClassConstructor = compiledInnerClass.getDeclaredConstructor(compiledEnclosingClass);
	assertNotNull(innerClassConstructor)
	val innerClassInstance = innerClassConstructor.newInstance(enclosingClassInstance)
	assertNotNull(innerClassInstance)
	val enclosingClassMethodCallMethod = compiledInnerClass.getMethod("innerClassMethodCall")
	assertNotNull(enclosingClassMethodCallMethod)
	val invocationResult = enclosingClassMethodCallMethod.invoke(innerClassInstance)
	assertNotNull(invocationResult)

	assertEquals("innerClassMethodResult", invocationResult)

    }

    @Test
    def void testBug426442_InnerStaticClassLocalMethodCall() {
	val expression = expression("innerStaticClassMethod", false);

	val enclosingClass = expression.toClass("my.test.EnclosingClass") [
		members += expression.toClass(qualifiedName + ".InnerStaticClass") [
			static = true
			members += expression.toMethod("innerStaticClassMethod", references.getTypeForName(String, expression)) [
				body = [append('''return "innerStaticClassMethodResult";''')]
			]
			members += expression.toMethod("innerStaticClassMethodCall", references.getTypeForName(String, expression)) [
				body = expression
			]
		]
	]

	val compiledEnclosingClass = compile(expression.eResource, enclosingClass)
	assertNotNull(compiledEnclosingClass)
	val compiledInnerStaticClass = compiledEnclosingClass.declaredClasses.findFirst[simpleName == "InnerStaticClass"]
	assertNotNull(compiledInnerStaticClass)
	val innerStaticClassInstance = compiledInnerStaticClass.newInstance
	assertNotNull(innerStaticClassInstance)
	val enclosingClassMethodCallMethod = compiledInnerStaticClass.getMethod("innerStaticClassMethodCall")
	assertNotNull(enclosingClassMethodCallMethod)
	val invocationResult = enclosingClassMethodCallMethod.invoke(innerStaticClassInstance)
	assertNotNull(invocationResult)

	assertEquals("innerStaticClassMethodResult", invocationResult)

    }

    @Test
    def void testNestedAnnotationType(){
        val expression = expression("42")
        val outerClass = expression.toClass('my.outer.Clazz')
        outerClass.members += expression.toAnnotationType("MyAnnotation") [
        	members += expression.toMethod("theTruth", references.getTypeForName(typeof(int), expression)) [
				setBody(expression)
			]
        ]
        
        val compiled = compile(expression.eResource, outerClass).declaredClasses.head
        assertEquals('my.outer.Clazz.MyAnnotation',compiled.canonicalName)
        assertEquals(42, compiled.declaredMethods.head.defaultValue)
    }
    
    @Test
    def void testNestedEnumerationType(){
        val expression = expression("null")
        val outerClass = expression.toClass('my.outer.Clazz')
        outerClass.members += expression.toEnumerationType("Level") [
            members += expression.toEnumerationLiteral("WARN") [ literal |
				literal.type = references.createTypeRef(it)
			]
            members += expression.toEnumerationLiteral("ERROR") [ literal |
				literal.type = references.createTypeRef(it)
			]
            members += expression.toEnumerationLiteral("DEBUG") [ literal |
				literal.type = references.createTypeRef(it)
			]
            members += expression.toMethod("doStuff", references.getTypeForName("java.lang.Object", expression)) [
                setBody(expression)
            ]
        ]
        
        val compiled = compile(expression.eResource, outerClass).declaredClasses.head
        assertNotNull(compiled.getField("WARN"))
        assertNotNull(compiled.getField("ERROR"))
        assertNotNull(compiled.getField("DEBUG"))
        assertNotNull(compiled.getMethod("doStuff"))
    }

	@Test def void testClassModifiers() {
		val expression = expression("null")
		val clazz = expression.toClass("my.test.Foo") [
	        members += expression.toClass("AbstractClass") [
    	    	abstract = true
       		]
	        members += expression.toClass("StaticClass") [
    	    	static = true
       		]
	        members += expression.toClass("FinalClass") [
    	    	final = true
       		]
	        members += expression.toClass("StrictFpClass") [
    	    	strictFloatingPoint = true
       		]
		]
        val compiled = compile(expression.eResource, clazz)
		val classes = compiled.classes
		assertTrue(Modifier::isAbstract(classes.findFirst[name.endsWith("AbstractClass")].modifiers))
		assertTrue(Modifier::isStatic(classes.findFirst[name.endsWith("StaticClass")].modifiers))
		assertTrue(Modifier::isFinal(classes.findFirst[name.endsWith("FinalClass")].modifiers))
		// according to the JavaDocs and empirical tests, Class.getModifiers() does not reflect strictfp
		//assertTrue(Modifier::isStrict(classes.findFirst[name.endsWith("StrictFpClass")].modifiers))
	}

	@Test def void testFieldModifiers() {
		val expression = expression("null")
        val clazz = expression.toClass("my.test.Foo") [
        	members += expression.toField("staticField", expression.typeRef(Integer::TYPE)) [
        		static = true
        		visibility = JvmVisibility::PUBLIC
        	]
        	members += expression.toField("finalField", expression.typeRef(Integer::TYPE)) [
        		final = true
        		initializer = [append("0")]
        		visibility = JvmVisibility::PUBLIC
        	]
        	members += expression.toField("volatileField", expression.typeRef(Integer::TYPE)) [
        		volatile = true
        		visibility = JvmVisibility::PUBLIC
        	]
        	members += expression.toField("transientField", expression.typeRef(Integer::TYPE)) [
        		transient = true
        		visibility = JvmVisibility::PUBLIC
        	]
        ]
        val compiled = compile(expression.eResource, clazz)
		assertTrue(Modifier::isStatic(compiled.getField("staticField").modifiers))
		assertTrue(Modifier::isFinal(compiled.getField("finalField").modifiers))
		assertTrue(Modifier::isVolatile(compiled.getField("volatileField").modifiers))
		assertTrue(Modifier::isTransient(compiled.getField("transientField").modifiers))
	}

	@Test def void testMethodModifiers() {
		val expression = expression("null")
        val clazz = expression.toClass("my.test.Foo") [
        	members += expression.toMethod("staticMethod", expression.typeRef(Void::TYPE)) [
        		static = true
        		body = [ append("") ]
        	]
        	members += expression.toMethod("finalMethod", expression.typeRef(Void::TYPE)) [
        		final = true
        		body = [ append("") ]
        	]
        	members += expression.toMethod("abstractMethod", expression.typeRef(Void::TYPE)) [
        		abstract = true
        	]
        	members += expression.toMethod("synchronizedMethod", expression.typeRef(Void::TYPE)) [
        		synchronized = true
        		body = [ append("") ]
        	]
        	members += expression.toMethod("strictFpMethod", expression.typeRef(Void::TYPE)) [
        		strictFloatingPoint = true
        		body = [ append("") ]
        	]
        	members += expression.toMethod("nativeMethod", expression.typeRef(Void::TYPE)) [
        		native = true
        	]
        	abstract = true
        ]
        val compiled = compile(expression.eResource, clazz)
		assertTrue(Modifier::isStatic(compiled.getMethod("staticMethod").modifiers))
		assertTrue(Modifier::isFinal(compiled.getMethod("finalMethod").modifiers))
		assertTrue(Modifier::isAbstract(compiled.getMethod("abstractMethod").modifiers))
		assertTrue(Modifier::isSynchronized(compiled.getMethod("synchronizedMethod").modifiers))
		assertTrue(Modifier::isStrict(compiled.getMethod("strictFpMethod").modifiers))
		assertTrue(Modifier::isNative(compiled.getMethod("nativeMethod").modifiers))
	}

	def JvmTypeReference typeRef(EObject ctx, Class<?> clazz) {
		return references.getTypeForName(clazz, ctx)
	}
	def JvmTypeReference typeRef(EObject ctx, Class<?> clazz, Class<?> param) {
		return references.getTypeForName(clazz, ctx, ctx.typeRef(param))
	}
	
	def Class<?> compile(Resource res, JvmDeclaredType type) {
		res.compileToClass(type, res.generate(type))
	}
	
	def generate(Resource res, JvmDeclaredType type) {
		res.eSetDeliver(false)
		res.contents += type
		res.eSetDeliver(true)
		val fsa = new InMemoryFileSystemAccess()
		generator.doGenerate(res, fsa)
		fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + type.identifier.replace('.','/')+".java").toString
	}
	
	def compileToClass(Resource res, JvmDeclaredType type, String code) {
		val compiledClass = javaCompiler.compileToClass(type.identifier, code)
		helper.assertNoErrors(res.contents.head)
		compiledClass
	}
}

