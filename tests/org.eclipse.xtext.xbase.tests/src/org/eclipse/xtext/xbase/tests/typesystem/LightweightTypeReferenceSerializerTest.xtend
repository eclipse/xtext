package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import java.io.Serializable
import java.util.List
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.xbase.compiler.AbstractStringBuilderBasedAppendable
import org.eclipse.xtext.xbase.lib.Functions
import org.eclipse.xtext.xbase.lib.Procedures
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.junit.Ignore
import org.junit.Test
import java.nio.CharBuffer
import java.util.Iterator

class LightweightTypeReferenceSerializerTest extends AbstractXbaseTestCase {
	
	@Inject CommonTypeComputationServices services

	@Inject XtextResourceSet resourceSet
	
	@Test
	def void testObject() {
		Object.typeRef.assertInXtendAndJava("java.lang.Object")
	}
	
	@Test
	def void testList() {
		List.typeRef.assertInXtendAndJava("java.util.List")
	}

	@Test
	def void testListWildcard() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner))
		]).assertInXtendAndJava("java.util.List<?>")
	}

	@Test
	def void testListUpperBound() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				addUpperBound(CharSequence.typeRef)
			])
		]).assertInXtendAndJava("java.util.List<? extends java.lang.CharSequence>")
	}

	@Test
	def void testListUpperBoundObject() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				addUpperBound(Object.typeRef)
			])
		]).assertInXtendAndJava("java.util.List<?>")
	}

	@Test
	def void testListUpperBounds() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				addUpperBound(CharSequence.typeRef)
				addUpperBound(Serializable.typeRef)
			])
		]).assertInXtendAndJava("java.util.List<? extends java.lang.CharSequence & java.io.Serializable>")
	}

	@Test
	def void testListUpperBoundsIncludingObject() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				addUpperBound(CharSequence.typeRef)
				addUpperBound(Object.typeRef)
				addUpperBound(Serializable.typeRef)
			])
		]).assertInXtendAndJava("java.util.List<? extends java.lang.CharSequence & java.io.Serializable>")
	}

	@Test
	def void testListLowerBound() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				lowerBound = CharSequence.typeRef
			])
		]).assertInXtendAndJava("java.util.List<? super java.lang.CharSequence>")
	}

	@Test
	def void testListLowerAndUpperBound() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				lowerBound = CharSequence.typeRef
				addUpperBound(Serializable.typeRef)
			])
		]).assertInXtendAndJava("java.util.List<? super java.lang.CharSequence>")
	}

	@Test
	def void testArray() {
		new ArrayTypeReference(owner, Object.typeRef)
			.assertInXtendAndJava("java.lang.Object[]")
	}

	@Test
	def void testArray2() {
		new ArrayTypeReference(owner, new ArrayTypeReference(owner, Object.typeRef))
			.assertInXtendAndJava("java.lang.Object[][]")
	}

	@Test
	def void testArrayGeneric() {
		new ArrayTypeReference(owner, List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				lowerBound = CharSequence.typeRef
			])
		]).assertInXtendAndJava("java.util.List<? super java.lang.CharSequence>[]")
	}

	@Test
	def void testAnyType() {
		new AnyTypeReference(owner).assertInXtendAndJava("java.lang.Object")
	}

	@Test
	def void testFunctionType() {
		new FunctionTypeReference(owner, Functions.Function0.type)
			.assertInXtend("()=>void")
			.assertInJava("org.eclipse.xtext.xbase.lib.Functions$Function0")
	}

	@Test
	def void testFunctionType1() {
		(new FunctionTypeReference(owner, Functions.Function0.type) => [
			returnType = String.typeRef
			addTypeArgument(String.typeRef)
		])
			.assertInXtend('()=>java.lang.String')
			.assertInJava("org.eclipse.xtext.xbase.lib.Functions$Function0<java.lang.String>")
	}

	@Test
	def void testFunctionType2() {
		(new FunctionTypeReference(owner, Functions.Function1.type) => [
			addParameterType(String.typeRef)
			addTypeArgument(Void.typeRef)
			addTypeArgument(String.typeRef)
		])
			.assertInXtend("(java.lang.String)=>void")
			.assertInJava("org.eclipse.xtext.xbase.lib.Functions$Function1<java.lang.Void, java.lang.String>")
	}

	@Test
	def void testFunctionType3() {
		(new FunctionTypeReference(owner, Functions.Function1.type) => [
			returnType = Object.typeRef
			addTypeArgument(Object.typeRef)
			addParameterType(String.typeRef)
			addTypeArgument(String.typeRef)
		])
			.assertInXtend("(java.lang.String)=>java.lang.Object")
			.assertInJava("org.eclipse.xtext.xbase.lib.Functions$Function1<java.lang.Object, java.lang.String>")
	}

	@Test
	def void testFunctionType4() {
		(new FunctionTypeReference(owner, Functions.Function3.type) => [
			returnType = Object.typeRef
			addTypeArgument(Object.typeRef)
			addParameterType(String.typeRef)
			addTypeArgument(String.typeRef)
			val listOfCharSequence = List.typeRef => [
				addTypeArgument(new WildcardTypeReference(owner) => [
					lowerBound = CharSequence.typeRef
				])
			]
			addParameterType(listOfCharSequence)
			addTypeArgument(listOfCharSequence)
			val arrayOfObject = new ArrayTypeReference(owner, Object.typeRef)
			addParameterType(arrayOfObject)
			addTypeArgument(arrayOfObject)
		])
			.assertInXtend("(java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[])=>java.lang.Object")
			.assertInJava("org.eclipse.xtext.xbase.lib.Functions$Function3<java.lang.Object, java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[]>")
	}

	@Test
	def void testFunctionType5() {
		new FunctionTypeReference(owner, Procedures.Procedure0.type)
			.assertInXtend("()=>void")
			.assertInJava("org.eclipse.xtext.xbase.lib.Procedures$Procedure0")
	}

	@Test
	def void testFunctionType6() {
		(new FunctionTypeReference(owner, Procedures.Procedure1.type) => [
			addParameterType(String.typeRef)
			addTypeArgument(String.typeRef)
		])
			.assertInXtend("(java.lang.String)=>void")
			.assertInJava("org.eclipse.xtext.xbase.lib.Procedures$Procedure1<java.lang.String>")
	}

	@Test
	def void testFunctionType7() {
		(new FunctionTypeReference(owner, Procedures.Procedure3.type) => [
			addParameterType(String.typeRef)
			addTypeArgument(String.typeRef)
			val listOfCharSequence = List.typeRef => [
				addTypeArgument(new WildcardTypeReference(owner) => [
					lowerBound = CharSequence.typeRef
				])
			]
			addParameterType(listOfCharSequence)
			addTypeArgument(listOfCharSequence)
			val arrayOfObject = new ArrayTypeReference(owner, Object.typeRef)
			addParameterType(arrayOfObject)
			addTypeArgument(arrayOfObject)
		])
			.assertInXtend("(java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[])=>void")
			.assertInJava("org.eclipse.xtext.xbase.lib.Procedures$Procedure3<java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[]>")
	}
	
	@Test
	def void testFunctionType8() {
		new FunctionTypeReference(owner, Runnable.type) 
			.assertInXtend("()=>void")
			.assertInJava("java.lang.Runnable")
	}
	
	@Test
	def void testFunctionType9() {
		(new FunctionTypeReference(owner, Readable.type) => [
			addParameterType(CharBuffer.typeRef)
			returnType = Integer.TYPE.typeRef
		]) 
			.assertInXtend("(java.nio.CharBuffer)=>int")
			.assertInJava("java.lang.Readable")
	}
	
	@Test
	def void testFunctionType10() {
		(new FunctionTypeReference(owner, Iterable.type) => [
			addTypeArgument(String.typeRef)
			returnType = Iterator.typeRef => [
				addTypeArgument(String.typeRef)
			]
		]) 
			.assertInXtend("()=>java.util.Iterator<java.lang.String>")
			.assertInJava("java.lang.Iterable<java.lang.String>")
	}
	
	
	@Test@Ignore
	def void testUnboundTypeReference() {
		UnboundTypeReference.create(null, null, null).assertInXtendAndJava('java.lang.Object')
	}

	@Test
	def void testUnknownTypeReference() {
		new UnknownTypeReference(owner, 'Foo').assertInXtendAndJava('Foo')
	}

	@Test
	def void testUnknownTypeReference1() {
		new UnknownTypeReference(owner).assertInXtendAndJava('Object')
	}


	protected def getOwner() {
		new StandardTypeReferenceOwner(services, resourceSet)
	}	
	
	protected def typeRef(Class<?> type) {
		new ParameterizedTypeReference(owner, type.type)
	}
	
	protected def type(Class<?> type) {
		services.typeReferences.findDeclaredType(type, resourceSet)
	}
	
	protected def assertInXtendAndJava(LightweightTypeReference ref, String expectation) {
		assertInXtend(ref, expectation)
		assertInJava(ref, expectation)
	}
	
	protected def assertInXtend(LightweightTypeReference ref, String expectation) {
		assertIn(ref, expectation, false)
	}
	
	protected def assertInJava(LightweightTypeReference ref, String expectation) {
		assertIn(ref, expectation, true)
	}
	
	protected def assertIn(LightweightTypeReference ref, java.lang.String expectation, boolean isJava) {
		val appender = new TestAppender(isJava)
		val serializer = new LightweightTypeReferenceSerializer(appender)
		ref.accept(serializer)
		assertEquals(expectation, appender.toString)
		ref
	}
}

class TestAppender extends AbstractStringBuilderBasedAppendable {
	
	new(boolean isJava) {
		super('\t', '\n', isJava)
	}
	
	override protected appendType(JvmType type, StringBuilder builder) {
		builder.append(type.identifier)
	}
	
	override protected appendType(Class<?> type, StringBuilder builder) {
		builder.append(type.name)
	}
	
	override getImports() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}