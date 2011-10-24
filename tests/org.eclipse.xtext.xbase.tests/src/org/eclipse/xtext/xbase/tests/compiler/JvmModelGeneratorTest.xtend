package org.eclipse.xtext.xbase.tests.compiler

import com.google.common.base.Supplier
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.AbstractList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.junit.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler$EclipseRuntimeDependentJavaCompiler
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.lib.Functions
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase

import static junit.framework.Assert.*

class JvmModelGeneratorTest extends AbstractXbaseTestCase {
	
	@Inject extension JvmTypesBuilder builder
	@Inject TypeReferences references
	@Inject ValidationTestHelper helper
	@Inject JvmModelGenerator generator
	@Inject EclipseRuntimeDependentJavaCompiler javaCompiler
	@Inject TypeReferences typeReferences

	override void setUp() {
		super.setUp();
		injector.injectMembers(this);
		javaCompiler.clearClassPath();
		javaCompiler.addClassPathOfClass(getClass());
		javaCompiler.addClassPathOfClass(typeof(AbstractXbaseEvaluationTest));
		javaCompiler.addClassPathOfClass(typeof(Functions));
		javaCompiler.addClassPathOfClass(typeof(Provider));
		javaCompiler.addClassPathOfClass(typeof(Supplier));
	} 
	
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
	
	def void testImplements() {
		val expression = expression("null", false);
		val clazz = expression.toClass("my.test.Foo") [
			abstract = true
			superTypes += expression.typeRef(typeof(Iterable), typeof(String))
		]
		val compiled = compile(expression.eResource, clazz)
		assertTrue(typeof(Iterable).isAssignableFrom(compiled))
	}
	
	def void testExtends() {
		val expression = expression("null", false);
		val clazz = expression.toClass("my.test.Foo") [
			abstract = true
			superTypes += expression.typeRef(typeof(AbstractList), typeof(String))
		]
		val compiled = compile(expression.eResource, clazz)
		assertTrue(typeof(Iterable).isAssignableFrom(compiled))
		assertTrue(typeof(AbstractList).isAssignableFrom(compiled))
	}
	
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
		
	def JvmTypeReference typeRef(EObject ctx, Class<?> clazz) {
		return references.getTypeForName(clazz, ctx)
	}
	def JvmTypeReference typeRef(EObject ctx, Class<?> clazz, Class<?> param) {
		return references.getTypeForName(clazz, ctx, ctx.typeRef(param))
	}
	
	def Class<?> compile(Resource res, JvmDeclaredType type) {
		res.eSetDeliver(false)
		res.contents += type
		res.eSetDeliver(true)
		val fsa = new InMemoryFileSystemAccess()
		generator.doGenerate(res, fsa)
		val code = fsa.files.get(IFileSystemAccess::DEFAULT_OUTPUT + type.identifier.replace('.','/')+".java").toString
		val compiledClass = javaCompiler.compileToClass(type.identifier, code)
		helper.assertNoErrors(res.contents.head)
		return compiledClass
	}
}