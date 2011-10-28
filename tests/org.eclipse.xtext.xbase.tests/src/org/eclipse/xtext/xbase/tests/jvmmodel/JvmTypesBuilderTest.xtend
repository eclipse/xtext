package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmStringAnnotationValue
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsFactory
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase

import static junit.framework.Assert.*

class JvmTypesBuilderTest extends AbstractXbaseTestCase {
	
	@Inject TypeReferences references
	
	@Inject extension JvmTypesBuilder
	
	def void testEmptyAnnotation() {
		val f = XAnnotationsFactory::eINSTANCE
		val typesFactory = TypesFactory::eINSTANCE
		val e = expression("'Foo'");
		
		val anno = f.createXAnnotation;
		anno.annotationType = references.findDeclaredType(typeof(Inject), e) as JvmAnnotationType
		val type = typesFactory.createJvmGenericType
		newArrayList(anno).translateAnnotationsTo(type)
		
		assertEquals(anno.annotationType, type.annotations.head.annotation)
	}
	
	def void testStringAnnotation() {
		val f = XAnnotationsFactory::eINSTANCE
		val typesFactory = TypesFactory::eINSTANCE
		val e = expression("'Foo'");
		
		val anno = f.createXAnnotation;
		anno.annotationType = references.findDeclaredType(typeof(Inject), e) as JvmAnnotationType
		anno.value = e
		val type = typesFactory.createJvmGenericType
		newArrayList(anno).translateAnnotationsTo(type)
		
		assertEquals(anno.annotationType, type.annotations.head.annotation)
		assertEquals("Foo", (type.annotations.head.values.head as JvmStringAnnotationValue).values.head)
	}
	
	def void testStringAnnotationWithNullExpression() {
		val f = XAnnotationsFactory::eINSTANCE
		val typesFactory = TypesFactory::eINSTANCE
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
	
	def void testStringArrayAnnotation() {
		val f = XAnnotationsFactory::eINSTANCE
		val typesFactory = TypesFactory::eINSTANCE
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
	
	def void testStringArrayAnnotationWithNullExpression() {
		val f = XAnnotationsFactory::eINSTANCE
		val typesFactory = TypesFactory::eINSTANCE
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
	
	def void testAnnotationCreation() {
		val e = expression("'foo'")
		val anno = e.toAnnotationType("foo.bar.MyAnnotation") [
			documentation = "Foo"
		]
		assertEquals("foo.bar", anno.packageName)
		assertEquals("MyAnnotation", anno.simpleName)
		assertEquals("Foo", anno.documentation)
	}
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
	def void testEnumCreation() {
		val e = expression("'foo'")
		val anno = e.toEnumerationType("MyEnum") [
			documentation = "Foo"
		]
		assertNull(anno.packageName)
		assertEquals("MyEnum", anno.simpleName)
		assertEquals("Foo", anno.documentation)
	}
}