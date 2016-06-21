package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import com.google.inject.name.Named
import foo.TestAnnotation3
import java.util.List
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.testing.logging.LoggingTester
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.Wrapper
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsFactory
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test
import org.apache.log4j.Level
import org.junit.Ignore

class JvmTypesBuilderTest extends AbstractXbaseTestCase {
	
	@Inject TypesFactory typesFactory
	
	@Inject TypeReferences references
	
	@Inject extension JvmTypesBuilder
		
	@Inject ILogicalContainerProvider containerProvider
	
	extension JvmTypeReferenceBuilder
	
	XtextResourceSet resourceSet
	
	@Inject def setJvmTypeReferenceBuilder(JvmTypeReferenceBuilder.Factory factory, XtextResourceSet resourceSet) {
		this.resourceSet = resourceSet
		this._jvmTypeReferenceBuilder = factory.create(resourceSet)
	}
	
	@Test
	def void testEmptyAnnotation() {
		val f = XAnnotationsFactory.eINSTANCE
		val e = expression("'Foo'");
		
		val anno = f.createXAnnotation;
		anno.annotationType = references.findDeclaredType(typeof(Inject), e) as JvmAnnotationType
		val type = typesFactory.createJvmGenericType
		type.addAnnotations(#[anno])
		
		assertEquals(anno.annotationType, type.annotations.head.annotation)
	}
	
	@Test
	def void testStringAnnotation() {
		val f = XAnnotationsFactory.eINSTANCE
		val e = expression("'Foo'");
		
		val anno = f.createXAnnotation;
		anno.annotationType = references.findDeclaredType(typeof(Inject), e) as JvmAnnotationType
		anno.value = e
		val type = typesFactory.createJvmGenericType
		type.addAnnotation(anno)
		
		assertEquals(anno.annotationType, type.annotations.head.annotation)
		assertTrue((type.annotations.head.values.head as JvmCustomAnnotationValue).values.head instanceof XStringLiteral)
	}
	
	@Test
	def void testAnnotationDefaultValue() {
		val f = XAnnotationsFactory.eINSTANCE
		val e = expression("'Foo'");
		
		val anno = f.createXAnnotation;
		anno.annotationType = references.findDeclaredType(typeof(Named), e) as JvmAnnotationType
		anno.value = e
		val type = typesFactory.createJvmGenericType
		type.addAnnotation(anno)
		
		assertEquals(anno.annotationType, type.annotations.head.annotation)
		assertTrue((type.annotations.head.values.head as JvmCustomAnnotationValue).values.head instanceof XStringLiteral)
		assertNull(type.annotations.head.values.head.operation)
	}
	
	@Test
	def void testStringAnnotationWithNullExpression() {
		val f = XAnnotationsFactory.eINSTANCE
		val context = expression("'Foo'");
		
		val anno = f.createXAnnotation;
		anno.annotationType = references.findDeclaredType(typeof(Inject), context) as JvmAnnotationType
		val pair = f.createXAnnotationElementValuePair
		anno.elementValuePairs += pair
		val type = typesFactory.createJvmGenericType
		type.addAnnotation(anno)
		
		assertEquals(anno.annotationType, type.annotations.head.annotation)
		assertTrue(type.annotations.head.explicitValues.empty)
		assertFalse(type.annotations.head.values.empty)
	}
	
	@Test
	def void testIntegerAnnotation(){
		val f = XAnnotationsFactory.eINSTANCE
		val e = expression("'Foo'")

		val anno = f.createXAnnotation;
		val annotatiomType = references.findDeclaredType(typeof(TestAnnotation3), e)  as JvmAnnotationType
		anno.annotationType = annotatiomType
		val pair = f.createXAnnotationElementValuePair
		pair.element = annotatiomType.declaredOperations.head
		pair.value = expression("10")
		anno.elementValuePairs += pair
		val type = typesFactory.createJvmGenericType
		type.addAnnotation(anno)

		assertEquals(anno.annotationType, type.annotations.head.annotation)
		assertEquals(1,type.annotations.head.values.size)
		val value = type.annotations.head.values.head as JvmCustomAnnotationValue
		assertTrue(value.values.head instanceof XNumberLiteral)
	}

	@Test
	def void testAnnotationCreation() {
		val e = expression("'foo'")
		val anno = e.toAnnotationType("foo.bar.MyAnnotation") [
			documentation = "Foo"
		]
		assertEquals("foo.bar", anno.packageName)
		assertEquals("MyAnnotation", anno.simpleName)
		assertEquals("Foo", anno.documentation)
	}
	
	@Test
	def void testInterfaceCreation() {
		val e = expression("'foo'")
		val anno = e.toInterface("foo.bar.MyAnnotation") [
			superTypes += typeRef(Iterable)
		]
		assertTrue(anno.isInterface)
		assertEquals("foo.bar", anno.packageName)
		assertEquals("MyAnnotation", anno.simpleName)
		assertEquals(1, anno.superTypes.size)
	}
	
	@Test
	def void testEnumCreation() {
		val e = expression("'foo'")
		val myEnum = e.toEnumerationType("MyEnum") [
			documentation = "Foo"
			members += toEnumerationLiteral(e, "LITERAL0")
			members += toEnumerationLiteral(e, "LITERAL1")
		]
		assertNull(myEnum.packageName)
		assertEquals("MyEnum", myEnum.simpleName)
		assertEquals("Foo", myEnum.documentation)
		assertArrayEquals(newArrayList("LITERAL0", "LITERAL1"), myEnum.literals.map[simpleName]);
	}
	
	@Test
	def void testEnumCreation2() {
		val e = expression("'foo'")
		/* explicitly use => here */
		val myEnum = e.toEnumerationType("MyEnum") => [
			documentation = "Foo"
			members += toEnumerationLiteral(e, "LITERAL0")
			members += toEnumerationLiteral(e, "LITERAL1")
		]
		assertNull(myEnum.packageName)
		assertEquals("MyEnum", myEnum.simpleName)
		assertEquals("Foo", myEnum.documentation)
		assertArrayEquals(newArrayList("LITERAL0", "LITERAL1"), myEnum.literals.map[simpleName]);
	}
	
	@Test
	def void testSetBody() {
		val op = typesFactory.createJvmOperation
		op.body = [append('''foo''')]
		op.body = [append('''bar''')]
		assertEquals(1, op.eAdapters.size)
	}
	
	@Test
	def void testSetBody_02() {
		val expr = XbaseFactory.eINSTANCE.createXNullLiteral;
		val res = new XtextResource()
		res.languageName = 'org.eclipse.xtext.xbase.Xbase'
		val op = typesFactory.createJvmOperation
		res.contents += op
		res.contents += expr
		op.body = [append('''bar''')]
		assertEquals(1, op.eAdapters.size)
		op.body = expr
		assertEquals(op, containerProvider.getLogicalContainer(expr))
		assertEquals(0, op.eAdapters.size)
		op.body = [append('''bar''')]
		assertEquals(1, op.eAdapters.size)
		assertNull(containerProvider.getLogicalContainer(expr))
	}
	
	@Test
	def void testSetBody_03() {
		val op = typesFactory.createJvmOperation
		op.body = '''foo'''
		op.body = '''bar'''
		assertEquals(1, op.eAdapters.size)
	}
	
	@Test
	def void testSetBody_04() {
		val expr = XbaseFactory.eINSTANCE.createXNullLiteral;
		val res = new XtextResource()
		res.languageName = 'org.eclipse.xtext.xbase.Xbase'
		val op = typesFactory.createJvmOperation
		res.contents += op
		res.contents += expr
		op.body = '''bar'''
		assertEquals(1, op.eAdapters.size)
		op.body = expr
		assertEquals(op, containerProvider.getLogicalContainer(expr))
		assertEquals(0, op.eAdapters.size)
		op.body = '''bar'''
		assertEquals(1, op.eAdapters.size)
		assertNull(containerProvider.getLogicalContainer(expr))
	}
	
	@Test @Ignore
	def void testAddNull() {
		val list = new BasicEList<String>();
		//FIXME list += null
		assertTrue(list.empty)
	}

	@Test
	def void testAddAllNull() {
		val list = new BasicEList<String>();
		val List<String> otherList = newArrayList(null, null, null) 
		list += otherList
		assertTrue(list.empty)
	}
	
	@Test
	def void testAddAllNull_1() {
		val list = new BasicEList<String>();
		val List<String> otherList = null 
		list += otherList
		assertTrue(list.empty)
	}

	@Test
	def void testToGetterWithNullTypeRef() {
		val e = expression("''")
		// there should be no NPE
		e.toGetter("foo", null)
	}

	@Test
	def void testInitializeSafely_0() {
		expectErrorLogging(2) [
			genericTestInitializeSafely([EObject expr, String name, (JvmGenericType)=>void init 
				| expr.toClass(name, init)
			])
		]
	}
	
	@Test
	def void testInitializeSafely_1() {
		expectErrorLogging(2) [
			genericTestInitializeSafely([EObject expr, String name, (JvmConstructor)=>void init 
				| expr.toConstructor(init)
			])
		]
	}
	
	@Test
	def void testInitializeSafely_2() {
		expectErrorLogging(2) [
			genericTestInitializeSafely([EObject expr, String name, (JvmField)=>void init 
				| expr.toField(name, null, init)
			])
		]
	}
	
	@Test
	def void testInitializeSafely_3() {
		expectErrorLogging(2) [
			genericTestInitializeSafely([EObject expr, String name, (JvmOperation)=>void init 
				| expr.toMethod(name, null, init)
			])
		]
	}
	
	@Test
	def void testInitializeSafely_4() {
		expectErrorLogging(2) [
			genericTestInitializeSafely([EObject expr, String name, (JvmAnnotationType)=>void init 
				| expr.toAnnotationType(name, init)
			])
		]
	}
	
	@Test
	def void testInitializeSafely_5() {
		expectErrorLogging(2) [
			genericTestInitializeSafely([EObject expr, String name, (JvmEnumerationType)=>void init 
				| expr.toEnumerationType(name, init)
			])
		]
	}
	
	def protected <T> genericTestInitializeSafely((EObject, String, (T)=>void)=>EObject create) {
		val expr = XbaseFactory.eINSTANCE.createXNullLiteral;
		val Wrapper<Boolean> initialized = new Wrapper(false)
		val element = create.apply(expr, "foo", [T it| initialized.set(true) throw new RuntimeException();]);
		assertTrue(initialized.get())
		assertNotNull(element);
	}
	
	def protected expectErrorLogging(Runnable block) {
		expectErrorLogging(1,block) 
	}
	
	def protected expectErrorLogging(int numberOfloggings, Runnable block) {
		val loggings = LoggingTester.captureLogging(Level.ERROR, JvmTypesBuilder, block)
		loggings.assertNumberOfLogEntries(numberOfloggings)
	}
	
	@Test def void testErrorLogging_01() throws Exception {
		expectErrorLogging [
			val source = typesFactory.createJvmGenericType
			source.toClass("foo.bar")
		]
	}
	
	@Test def void testErrorLogging_02() throws Exception {
		expectErrorLogging [
			val source = typesFactory.createJvmGenericType
			source.toClass("foo.bar")
		]
	}
}