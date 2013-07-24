package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import java.io.Serializable
import java.util.List
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.xbase.compiler.SourceAppenderBase
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
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.junit.Test
import org.junit.Ignore

class LightweightTypeReferenceSerializerTest extends AbstractXbaseTestCase {
	
	@Inject CommonTypeComputationServices services

	@Inject XtextResourceSet resourceSet
	
	@Inject extension TypesFactory
	
	@Test
	def void testObject() {
		Object.typeRef.assertSerializedAs("java.lang.Object")
	}
	
	@Test
	def void testList() {
		List.typeRef.assertSerializedAs("java.util.List")
	}

	@Test
	def void testListWildcard() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner))
		]).assertSerializedAs("java.util.List<?>")
	}

	@Test
	def void testListUpperBound() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				addUpperBound(CharSequence.typeRef)
			])
		]).assertSerializedAs("java.util.List<? extends java.lang.CharSequence>")
	}

	@Test
	def void testListUpperBoundObject() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				addUpperBound(Object.typeRef)
			])
		]).assertSerializedAs("java.util.List<?>")
	}

	@Test
	def void testListUpperBounds() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				addUpperBound(CharSequence.typeRef)
				addUpperBound(Serializable.typeRef)
			])
		]).assertSerializedAs("java.util.List<? extends java.lang.CharSequence & java.io.Serializable>")
	}

	@Test
	def void testListUpperBoundsIncludingObject() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				addUpperBound(CharSequence.typeRef)
				addUpperBound(Object.typeRef)
				addUpperBound(Serializable.typeRef)
			])
		]).assertSerializedAs("java.util.List<? extends java.lang.CharSequence & java.io.Serializable>")
	}

	@Test
	def void testListLowerBound() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				lowerBound = CharSequence.typeRef
			])
		]).assertSerializedAs("java.util.List<? super java.lang.CharSequence>")
	}

	@Test
	def void testListLowerAndUpperBound() {
		(List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				lowerBound = CharSequence.typeRef
				addUpperBound(Serializable.typeRef)
			])
		]).assertSerializedAs("java.util.List<? super java.lang.CharSequence>")
	}

	@Test
	def void testArray() {
		new ArrayTypeReference(owner, Object.typeRef)
			.assertSerializedAs("java.lang.Object[]")
	}

	@Test
	def void testArray2() {
		new ArrayTypeReference(owner, new ArrayTypeReference(owner, Object.typeRef))
			.assertSerializedAs("java.lang.Object[][]")
	}

	@Test
	def void testArrayGeneric() {
		new ArrayTypeReference(owner, List.typeRef => [
			addTypeArgument(new WildcardTypeReference(owner) => [
				lowerBound = CharSequence.typeRef
			])
		]).assertSerializedAs("java.util.List<? super java.lang.CharSequence>[]")
	}

	@Test
	def void testAnyType() {
		new AnyTypeReference(owner).assertSerializedAs("java.lang.Object")
	}

	@Test
	def void testFunctionType() {
		new FunctionTypeReference(owner, Functions.Function0.type).assertSerializedAs("()=>void")
	}

	@Test
	def void testFunctionType1() {
		(new FunctionTypeReference(owner, Functions.Function0.type) => [
			returnType = String.typeRef
		]).assertSerializedAs("()=>java.lang.String")
	}

	@Test
	def void testFunctionType2() {
		(new FunctionTypeReference(owner, Functions.Function0.type) => [
			addParameterType(String.typeRef)
		]).assertSerializedAs("(java.lang.String)=>void")
	}

	@Test
	def void testFunctionType3() {
		(new FunctionTypeReference(owner, Functions.Function0.type) => [
			addParameterType(String.typeRef)
			returnType = Object.typeRef
		]).assertSerializedAs("(java.lang.String)=>java.lang.Object")
	}

	@Test
	def void testFunctionType4() {
		(new FunctionTypeReference(owner, Functions.Function0.type) => [
			addParameterType(String.typeRef)
			addParameterType(List.typeRef => [
				addTypeArgument(new WildcardTypeReference(owner) => [
					lowerBound = CharSequence.typeRef
				])
			])
			addParameterType(new ArrayTypeReference(owner, Object.typeRef))
			returnType = Object.typeRef
		]).assertSerializedAs("(java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[])=>java.lang.Object")
	}

	@Test
	def void testFunctionType5() {
		new FunctionTypeReference(owner, Procedures.Procedure0.type).assertSerializedAs("()=>void")
	}

	@Test
	def void testFunctionType6() {
		(new FunctionTypeReference(owner, Functions.Function0.type) => [
			addParameterType(String.typeRef)
		]).assertSerializedAs("(java.lang.String)=>void")
	}

	@Test
	def void testFunctionType7() {
		(new FunctionTypeReference(owner, Functions.Function0.type) => [
			addParameterType(String.typeRef)
			addParameterType(List.typeRef => [
				addTypeArgument(new WildcardTypeReference(owner) => [
					lowerBound = CharSequence.typeRef
				])
			])
			addParameterType(new ArrayTypeReference(owner, Object.typeRef))
		]).assertSerializedAs("(java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[])=>void")
	}
	
	@Test@Ignore
	def void testUnboundTypeReference() {
		// ? new UnboundTypeReference(owner)
	}

	@Test
	def void testUnknownTypeReference() {
		new UnknownTypeReference(owner, 'Foo').assertSerializedAs('Foo')
	}

	@Test
	def void testUnknownTypeReference1() {
		new UnknownTypeReference(owner).assertSerializedAs('Object')
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
	
	protected def assertSerializedAs(LightweightTypeReference ref, String expectation) {
		val appender = new TestAppender(0, '\t', '\n', false, createJvmGenericType)
		val serializer = new LightweightTypeReferenceSerializer(appender)
		ref.accept(serializer)
		assertEquals(expectation, appender.toString)
	}
}

class TestAppender extends SourceAppenderBase {
	
	JvmDeclaredType dummy
	
	override protected getImportedType(String simpleName) {
		dummy
	}
	
	new(int baseIndentationLevel, String indentation, String lineSeparator, boolean isJava, JvmDeclaredType dummy) {
		super(baseIndentationLevel, indentation, lineSeparator, isJava)
		this.dummy = dummy
	}
}