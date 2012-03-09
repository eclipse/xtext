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
		assertTrue(anno.interface)
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
		op.body = ['''foo''']
		op.body = ['''bar''']
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
		op.body = ['''bar''']
		assertEquals(1, op.eAdapters.size)
		op.body = expr
		assertEquals(op, containerProvider.getLogicalContainer(expr))
		assertEquals(0, op.eAdapters.size)
		op.body = ['''bar''']
		assertEquals(1, op.eAdapters.size)
		assertNull(containerProvider.getLogicalContainer(expr))
	}
}