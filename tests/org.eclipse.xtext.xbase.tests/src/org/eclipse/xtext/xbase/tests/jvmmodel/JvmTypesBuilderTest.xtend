package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmStringAnnotationValue
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsFactory
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.emf.common.util.BasicEList
import java.util.List
import org.eclipse.xtext.util.Wrapper
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmEnumerationType
import com.google.inject.name.Named
import foo.TestAnnotation3
import org.eclipse.xtext.common.types.JvmIntAnnotationValue

class JvmTypesBuilderTest extends AbstractXbaseTestCase {
	
	@Inject TypesFactory typesFactory
	
	@Inject TypeReferences references
	
	@Inject extension JvmTypesBuilder
	
	@Inject ILogicalContainerProvider containerProvider
	
	@Test
	def void testEmptyAnnotation() {
		val f = XAnnotationsFactory::eINSTANCE
		val e = expression("'Foo'");
		
		val anno = f.createXAnnotation;
		anno.annotationType = references.findDeclaredType(typeof(Inject), e) as JvmAnnotationType
		val type = typesFactory.createJvmGenericType
		newArrayList(anno).translateAnnotationsTo(type)
		
		assertEquals(anno.annotationType, type.annotations.head.annotation)
	}
	
	@Test
	def void testStringAnnotation() {
		val f = XAnnotationsFactory::eINSTANCE
		val e = expression("'Foo'");
		
		val anno = f.createXAnnotation;
		anno.annotationType = references.findDeclaredType(typeof(Inject), e) as JvmAnnotationType
		anno.value = e
		val type = typesFactory.createJvmGenericType
		newArrayList(anno).translateAnnotationsTo(type)
		
		assertEquals(anno.annotationType, type.annotations.head.annotation)
		assertEquals("Foo", (type.annotations.head.values.head as JvmStringAnnotationValue).values.head)
	}
	
	@Test
	def void testAnnotationDefaultValue() {
		val f = XAnnotationsFactory::eINSTANCE
		val e = expression("'Foo'");
		
		val anno = f.createXAnnotation;
		anno.annotationType = references.findDeclaredType(typeof(Named), e) as JvmAnnotationType
		anno.value = e
		val type = typesFactory.createJvmGenericType
		newArrayList(anno).translateAnnotationsTo(type)
		
		assertEquals(anno.annotationType, type.annotations.head.annotation)
		assertEquals("Foo", (type.annotations.head.values.head as JvmStringAnnotationValue).values.head)
		assertEquals("value", type.annotations.head.values.head.operation.simpleName)
	}
	
	@Test
	def void testStringAnnotationWithNullExpression() {
		val f = XAnnotationsFactory::eINSTANCE
		val context = expression("'Foo'");
		
		val anno = f.createXAnnotation;
		anno.annotationType = references.findDeclaredType(typeof(Inject), context) as JvmAnnotationType
		val pair = f.createXAnnotationElementValuePair
		anno.elementValuePairs += pair
		val type = typesFactory.createJvmGenericType
		newArrayList(anno).translateAnnotationsTo(type)
		
		assertEquals(anno.annotationType, type.annotations.head.annotation)
		assertTrue(type.annotations.head.values.empty)
	}
	
	@Test
	def void testIntegerAnnotation(){
		val f = XAnnotationsFactory::eINSTANCE
		val e = expression("'Foo'")

		val anno = f.createXAnnotation;
		val annotatiomType = references.findDeclaredType(typeof(TestAnnotation3), e)  as JvmAnnotationType
		anno.annotationType = annotatiomType
		val pair = f.createXAnnotationElementValuePair
		pair.element = annotatiomType.declaredOperations.head
		pair.value = expression("10")
		anno.elementValuePairs += pair
		val type = typesFactory.createJvmGenericType
		newArrayList(anno).translateAnnotationsTo(type)

		assertEquals(anno.annotationType, type.annotations.head.annotation)
		assertEquals(1,type.annotations.head.values.size)
		val value = type.annotations.head.values.head as JvmIntAnnotationValue
		assertEquals(10, value.values.head)
	}

	@Test
	def void testStringArrayAnnotation() {
		val f = XAnnotationsFactory::eINSTANCE
		val e = expression("'Foo'");
		val e2 = expression("'Bar'");
		
		val anno = f.createXAnnotation
		anno.annotationType = references.findDeclaredType(typeof(Inject), e) as JvmAnnotationType
		val array = f.createXAnnotationValueArray
		anno.value = array
		array.values += e
		array.values += e2
		
		val type = typesFactory.createJvmGenericType
		newArrayList(anno).translateAnnotationsTo(type)
		
		assertEquals(anno.annotationType, type.annotations.head.annotation)
		assertEquals("Foo", (type.annotations.head.values.head as JvmStringAnnotationValue).values.head)
		assertEquals("Bar", (type.annotations.head.values.head as JvmStringAnnotationValue).values.get(1))
	}
	
	@Test
	def void testStringArrayAnnotationWithNullExpression() {
		val f = XAnnotationsFactory::eINSTANCE
		val context = expression('"foo"')
		
		val anno = f.createXAnnotation
		anno.annotationType = references.findDeclaredType(typeof(Inject), context) as JvmAnnotationType
		val array = f.createXAnnotationValueArray
		anno.value = array
		
		val type = typesFactory.createJvmGenericType
		newArrayList(anno).translateAnnotationsTo(type)
		
		assertEquals(anno.annotationType, type.annotations.head.annotation)
		assertTrue(type.annotations.head.values.empty)
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
			superTypes += e.newTypeRef(typeof(Iterable))
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
	def void testSetBody() {
		val op = typesFactory.createJvmOperation
		op.body = [append('''foo''')]
		op.body = [append('''bar''')]
		assertEquals(1, op.eAdapters.size)
	}
	
	@Test
	def void testSetBody_02() {
		val expr = XbaseFactory::eINSTANCE.createXNullLiteral;
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
	def void testAddNull() {
		val list = new BasicEList<String>();
		list += null
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
	def void testInitializeSafely_0() {
		genericTestInitializeSafely([EObject expr, String name, (JvmGenericType)=>void init 
			| expr.toClass(name, init)
		])
	}
	
	@Test
	def void testInitializeSafely_1() {
		genericTestInitializeSafely([EObject expr, String name, (JvmConstructor)=>void init 
			| expr.toConstructor(init)
		])
	}
	
	@Test
	def void testInitializeSafely_2() {
		genericTestInitializeSafely([EObject expr, String name, (JvmField)=>void init 
			| expr.toField(name, null, init)
		])
	}
	
	@Test
	def void testInitializeSafely_3() {
		genericTestInitializeSafely([EObject expr, String name, (JvmOperation)=>void init 
			| expr.toMethod(name, null, init)
		])
	}
	
	@Test
	def void testInitializeSafely_4() {
		genericTestInitializeSafely([EObject expr, String name, (JvmAnnotationType)=>void init 
			| expr.toAnnotationType(name, init)
		])
	}
	
	@Test
	def void testInitializeSafely_5() {
		genericTestInitializeSafely([EObject expr, String name, (JvmEnumerationType)=>void init 
			| expr.toEnumerationType(name, init)
		])
	}
	
	def protected <T> genericTestInitializeSafely((EObject, String, (T)=>void)=>EObject create) {
		val expr = XbaseFactory::eINSTANCE.createXNullLiteral;
		val Wrapper<Boolean> initialized = new Wrapper(false)
		val element = create.apply(expr, "foo", [T it| initialized.set(true) throw new RuntimeException();]);
		assertTrue(initialized.get())
		assertNotNull(element);
	}
}