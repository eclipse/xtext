/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.validation.IssueSeverities;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes;
import org.eclipse.xtext.xbase.scoping.batch.AbstractFeatureScopeSession;
import org.eclipse.xtext.xbase.scoping.batch.ConstructorScopes;
import org.eclipse.xtext.xbase.scoping.batch.FeatureScopes;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.scoping.batch.TypeScopes;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTestData.ListFunction1;
import org.eclipse.xtext.xbase.typesystem.computation.ClosureTypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeExpectation;
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.TypeExpectation;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClosureTypeComputerUnitTest extends AbstractXbaseTestCase {
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private ParseHelper<XExpression> parseHelper;
	
	@Inject
	private Provider<PublicReentrantTypeResolver> reentrantResolverProvider;
	
	private PublicReentrantTypeResolver reentrantResolver;
	
	private TestableState state;
	
	private ResourceSet contextResourceSet;
	
//	private ITypeReferenceOwner owner;
	
	interface IntFunction {
		int apply(int i, int j);
	}
	interface StringIterable extends Iterable<String> {}
	interface CharSequenceIterable<C extends CharSequence> extends Iterable<C> {}
	@SuppressWarnings("rawtypes")
	interface StrangeIterable<C> extends Iterable {}
	interface StrangeStringIterable<C> extends Iterable<String> {}
	interface ListIteratorIterable<E> extends Iterable<E> {
		@Override
		ListIterator<E> iterator();
	}
	class IterableContainer<E> {
		abstract class Iter implements Iterable<E> {}
	}
	
	@Test
	public void testPrepareComputation_01() throws Exception {
		JvmType iterableType = getTypeForName(Iterable.class, state);
		JvmTypeParameter typeParameter = createTypeParameter("ELEMENT", state);
		ParameterizedTypeReference iterableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(iterableType);
		iterableTypeReference.addTypeArgument(createTypeReference(typeParameter, state));
		assertFalse(iterableTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(iterableTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.lang.Iterable.iterator()", computer.getOperation().getIdentifier());
		assertEquals("Iterable<Unbound[T]>", getEquivalentSimpleName(closureType));
		assertEquals("()=>Iterator<Unbound[T]>", closureType.getSimpleName());
	}
	
	@Test
	public void testPrepareComputation_02() throws Exception {
		JvmType iterableType = getTypeForName(StringIterable.class, state);
		ParameterizedTypeReference iterableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(iterableType);
		assertTrue(iterableTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(iterableTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.lang.Iterable.iterator()", computer.getOperation().getIdentifier());
		assertEquals("StringIterable", getEquivalentSimpleName(closureType));
		assertEquals("()=>Iterator<String>", closureType.getSimpleName());
	}
	
	@Test
	public void testPrepareComputation_03() throws Exception {
		JvmType iterableType = getTypeForName(CharSequenceIterable.class, state);
		JvmTypeParameter typeParameter = createTypeParameter("STRING", state);
		ParameterizedTypeReference iterableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(iterableType);
		iterableTypeReference.addTypeArgument(createTypeReference(typeParameter, state));
		assertFalse(iterableTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(iterableTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.lang.Iterable.iterator()", computer.getOperation().getIdentifier());
		assertEquals("CharSequenceIterable<Unbound[C]>", getEquivalentSimpleName(closureType));
		assertEquals("()=>Iterator<Unbound[C]>", closureType.getSimpleName());
	}
	
	@Test
	public void testPrepareComputation_04() throws Exception {
		JvmType iterableType = getTypeForName(ListIteratorIterable.class, state);
		JvmTypeParameter typeParameter = createTypeParameter("STRING", state);
		ParameterizedTypeReference iterableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(iterableType);
		iterableTypeReference.addTypeArgument(createTypeReference(typeParameter, state));
		assertFalse(iterableTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(iterableTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest$ListIteratorIterable.iterator()", computer.getOperation().getIdentifier());
		assertEquals("ListIteratorIterable<Unbound[E]>", getEquivalentSimpleName(closureType));
		assertEquals("()=>ListIterator<Unbound[E]>", closureType.getSimpleName());
	}
	
	@Test
	public void testPrepareComputation_05() throws Exception {
		JvmType iterableType = getTypeForName(Iterable.class, state);
		JvmType elementType = getTypeForName(String.class, state);
		ParameterizedTypeReference iterableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(iterableType);
		iterableTypeReference.addTypeArgument(state.getReferenceOwner().newParameterizedTypeReference(elementType));
		assertTrue(iterableTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(iterableTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.lang.Iterable.iterator()", computer.getOperation().getIdentifier());
		assertEquals("Iterable<Unbound[T]>", getEquivalentSimpleName(closureType));
		assertEquals("()=>Iterator<Unbound[T]>", closureType.getSimpleName());
	}
	
	@Test
	public void testPrepareComputation_06() throws Exception {
		JvmType stringType = getTypeForName(String.class, state);
		ParameterizedTypeReference stringTypeReference = state.getReferenceOwner().newParameterizedTypeReference(stringType);
		assertTrue(stringTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(stringTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("org.eclipse.xtext.xbase.lib.Procedures$Procedure1.apply(Param)", computer.getOperation().getIdentifier());
		assertEquals("Procedure1<Unbound[Param]>", getEquivalentSimpleName(closureType));
	}
	
	@Test
	public void testPrepareComputation_07() throws Exception {
		TypeExpectation expectation = new TypeExpectation(null, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("org.eclipse.xtext.xbase.lib.Procedures$Procedure1.apply(Param)", computer.getOperation().getIdentifier());
		assertEquals("Procedure1<Unbound[Param]>", getEquivalentSimpleName(closureType));
	}
	
	@Test
	public void testPrepareComputation_08() throws Exception {
		JvmType iterableType = getTypeForName(Iterable.class, state);
		JvmTypeParameter typeParameter = createTypeParameter("ELEMENT", state);
		ParameterizedTypeReference iterableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(iterableType);
		iterableTypeReference.addTypeArgument(createTypeReference(typeParameter, state));
		assertFalse(iterableTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(iterableTypeReference, state, false);
		// closure indicates Function1 but Iterable is Function0 - type is Function1
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.lang.Iterable.iterator()", computer.getOperation().getIdentifier());
		assertEquals("Iterable<Unbound[T]>", getEquivalentSimpleName(closureType));
	}
	
	@Test
	public void testPrepareComputation_09() throws Exception {
		JvmType runnableType = getTypeForName(Runnable.class, state);
		ParameterizedTypeReference runnableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(runnableType);
		assertTrue(runnableTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(runnableTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.lang.Runnable.run()", computer.getOperation().getIdentifier());
		assertEquals("Runnable", getEquivalentSimpleName(closureType));
		assertEquals("()=>void", closureType.getSimpleName());
	}
	
	@Test
	public void testPrepareComputation_10() throws Exception {
		JvmType runnableType = getTypeForName(Runnable.class, state);
		// type with illegal type parameters
		JvmTypeParameter typeParameter = createTypeParameter("ILLEGAL", state);
		ParameterizedTypeReference runnableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(runnableType);
		runnableTypeReference.addTypeArgument(createTypeReference(typeParameter, state));
		assertFalse(runnableTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(runnableTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.lang.Runnable.run()", computer.getOperation().getIdentifier());
		assertEquals("Runnable", getEquivalentSimpleName(closureType));
		assertEquals("()=>void", closureType.getSimpleName());
	}
	
	@Test
	public void testPrepareComputation_11() throws Exception {
		JvmType listFunctionType = getTypeForName(ListFunction1.class, state);
		// type with illegal type parameters
		JvmTypeParameter singleTypeParameter = createTypeParameter("InAndOut", state);
		ParameterizedTypeReference listFunctionTypeReference = state.getReferenceOwner().newParameterizedTypeReference(listFunctionType);
		listFunctionTypeReference.addTypeArgument(createTypeReference(singleTypeParameter, state));
		assertFalse(listFunctionTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(listFunctionTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTestData$ListFunction1.apply(java.util.List)", computer.getOperation().getIdentifier());
		assertEquals("ListFunction1<Unbound[T], Unbound[R]>", getEquivalentSimpleName(closureType));
		assertEquals("(List<Unbound[T]>)=>List<Unbound[R]>", closureType.getSimpleName());
	}
	
	@Test
	public void testPrepareComputation_12() throws Exception {
		JvmType comparatorType = getTypeForName(Comparator.class, state);
		// type with illegal type parameters
		JvmTypeParameter typeParameter = createTypeParameter("COMPARABLE", state);
		ParameterizedTypeReference comparatorTypeReference = state.getReferenceOwner().newParameterizedTypeReference(comparatorType);
		comparatorTypeReference.addTypeArgument(createTypeReference(typeParameter, state));
		assertFalse(comparatorTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(comparatorTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[x, y|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.util.Comparator.compare(T,T)", computer.getOperation().getIdentifier());
		assertEquals("Comparator<Unbound[T]>", getEquivalentSimpleName(closureType));
		assertEquals("(Unbound[T], Unbound[T])=>int", closureType.getSimpleName());
	}
	
	@Test
	public void testPrepareComputation_13() throws Exception {
		JvmType functionType = getTypeForName(IntFunction.class, state);
		ParameterizedTypeReference functionTypeReference = state.getReferenceOwner().newParameterizedTypeReference(functionType);
		assertTrue(functionTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(functionTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[x, y|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("org.eclipse.xtext.xbase.tests.typesystem.ClosureTypeComputerUnitTest$IntFunction.apply(int,int)", computer.getOperation().getIdentifier());
		assertEquals("IntFunction", getEquivalentSimpleName(closureType));
		assertEquals("(int, int)=>int", closureType.getSimpleName());
	}
	
	@Test
	public void testPrepareComputation_14() throws Exception {
		JvmType iterableType = getTypeForName(Iterable.class, state);
		JvmType elementType = getTypeForName(String.class, state);
		ParameterizedTypeReference iterableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(iterableType);
		WildcardTypeReference wildcard = state.getReferenceOwner().newWildcardTypeReference();
		wildcard.addUpperBound(state.getReferenceOwner().newParameterizedTypeReference(elementType));
		iterableTypeReference.addTypeArgument(wildcard);
		assertTrue(iterableTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(iterableTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.lang.Iterable.iterator()", computer.getOperation().getIdentifier());
		assertEquals("Iterable<Unbound[T]>", getEquivalentSimpleName(closureType));
		assertEquals("()=>Iterator<Unbound[T]>", closureType.getSimpleName());
	}
	
	@Test
	public void testPrepareComputation_15() throws Exception {
		JvmType runnableType = getTypeForName(Runnable.class, state);
		ParameterizedTypeReference runnableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(runnableType);
		assertTrue(runnableTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(runnableTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.lang.Runnable.run()", computer.getOperation().getIdentifier());
		assertEquals("Runnable", getEquivalentSimpleName(closureType));
		assertEquals("()=>void", closureType.getSimpleName());
	}
	
	@Test
	public void testPrepareComputation_16() throws Exception {
		JvmType iterableType = getTypeForName(Iterable.class, state);
		JvmTypeParameter typeParameter = createTypeParameter("ELEMENT", state);
		ParameterizedTypeReference iterableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(iterableType);
		iterableTypeReference.addTypeArgument(createTypeReference(typeParameter, state));
		assertFalse(iterableTypeReference.isResolved());
		
		TypeExpectation expectation = new TypeExpectation(iterableTypeReference, state, false);
		// closure indicates Function1 but Iterable is Function0 - type is Function1
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[it|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		LightweightTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("org.eclipse.xtext.xbase.lib.Procedures$Procedure1.apply(Param)", computer.getOperation().getIdentifier());
		assertEquals("Procedure1<Unbound[Param]>", getEquivalentSimpleName(closureType));
	}
	
	@Test
	public void testHintsAfterPrepareComputation_01() throws Exception {
		JvmType iterableType = getTypeForName(Iterable.class, state);
		JvmTypeParameter typeParameter = createTypeParameter("ELEMENT", state);
		ParameterizedTypeReference iterableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(iterableType);
		UnboundTypeReference elementReference = (UnboundTypeReference) createTypeReference(typeParameter, state);
		iterableTypeReference.addTypeArgument(elementReference);

		assertTrue(state.getResolvedTypes().getHints(elementReference.getHandle()).isEmpty());
		
		TypeExpectation expectation = new TypeExpectation(iterableTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		FunctionTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.lang.Iterable.iterator()", computer.getOperation().getIdentifier());
		assertEquals("Iterable<Unbound[T]>", getEquivalentSimpleName(closureType));
		assertEquals("()=>Iterator<Unbound[T]>", closureType.getSimpleName());
		
		assertEquals(1, state.getResolvedTypes().getHints(elementReference.getHandle()).size());
		UnboundTypeReference closureTypeArgument = (UnboundTypeReference) closureType.getTypeArguments().get(0);
		assertEquals(1, state.getResolvedTypes().getHints(closureTypeArgument.getHandle()).size());
	}
	
	@Test
	public void testHintsAfterPrepareComputation_02() throws Exception {
		JvmType iterableType = getTypeForName(Iterable.class, state);
		JvmType appendableType = getTypeForName(Appendable.class, state);
		JvmType charSequenceType = getTypeForName(CharSequence.class, state);
		ParameterizedTypeReference iterableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(iterableType);
		CompoundTypeReference typeArgument = state.getReferenceOwner().newCompoundTypeReference(false);
		typeArgument.addComponent(state.getReferenceOwner().newParameterizedTypeReference(appendableType));
		typeArgument.addComponent(state.getReferenceOwner().newParameterizedTypeReference(charSequenceType));
		iterableTypeReference.addTypeArgument(typeArgument);
		
		TypeExpectation expectation = new TypeExpectation(iterableTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		FunctionTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.lang.Iterable.iterator()", computer.getOperation().getIdentifier());
		assertEquals("Iterable<Unbound[T]>", getEquivalentSimpleName(closureType));
		assertEquals("()=>Iterator<Unbound[T]>", closureType.getSimpleName());
		
		UnboundTypeReference closureTypeArgument = (UnboundTypeReference) closureType.getTypeArguments().get(0);
		List<LightweightBoundTypeArgument> hints = state.getResolvedTypes().getHints(closureTypeArgument.getHandle());
		assertEquals(hints.toString(), 1, hints.size());
	}
	
	@Test
	public void testHintsAfterPrepareComputation_03() throws Exception {
		JvmType iterableType = getTypeForName(Iterable.class, state);
		JvmType appendableType = getTypeForName(Appendable.class, state);
		JvmType charSequenceType = getTypeForName(CharSequence.class, state);
		ParameterizedTypeReference iterableTypeReference = state.getReferenceOwner().newParameterizedTypeReference(iterableType);
		WildcardTypeReference typeArgument = state.getReferenceOwner().newWildcardTypeReference();
		typeArgument.addUpperBound(state.getReferenceOwner().newParameterizedTypeReference(appendableType));
		typeArgument.addUpperBound(state.getReferenceOwner().newParameterizedTypeReference(charSequenceType));
		iterableTypeReference.addTypeArgument(typeArgument);
		
		TypeExpectation expectation = new TypeExpectation(iterableTypeReference, state, false);
		ClosureTypeComputer computer = new ClosureTypeComputer(closure("[|]", getContextResourceSet()), expectation, state);
		computer.selectStrategy();
		FunctionTypeReference closureType = computer.getExpectedClosureType();
		assertEquals("java.lang.Iterable.iterator()", computer.getOperation().getIdentifier());
		assertEquals("Iterable<Unbound[T]>", getEquivalentSimpleName(closureType));
		assertEquals("()=>Iterator<Unbound[T]>", closureType.getSimpleName());
		
		UnboundTypeReference closureTypeArgument = (UnboundTypeReference) closureType.getTypeArguments().get(0);
		List<LightweightBoundTypeArgument> hints = state.getResolvedTypes().getHints(closureTypeArgument.getHandle());
		assertEquals(hints.toString(), 2, hints.size());
	}
	
	protected XClosure closure(String string, ResourceSet contextResourceSet) throws Exception {
		return (XClosure) expression(string, contextResourceSet);
	}
	
	protected String getEquivalentSimpleName(LightweightTypeReference type) {
		assertTrue("Expected FunctionTypeRef but was: " + type.getSimpleName(), type instanceof FunctionTypeReference);
		// NPE would be ok here since the test would fail
		String typeSimpleName = type.getType().getSimpleName();
		List<LightweightTypeReference> typeArguments = ((ParameterizedTypeReference) type).getTypeArguments();
		if (typeArguments.isEmpty())
			return typeSimpleName;
		return typeSimpleName + "<" + Joiner.on(", ").join(Iterables.transform(typeArguments, LightweightTypeReference.SimpleNameFunction.INSTANCE)) + ">";
	}

	protected LightweightTypeReference createTypeReference(JvmType type, ITypeComputationState state) {
		if (type instanceof JvmTypeParameter) {
			return this.state.createUnboundTypeReference((JvmTypeParameter) type);
		}
		return state.getReferenceOwner().newParameterizedTypeReference(type);
	}
	
	@After
	public void discardComputationState() {
		this.state = null;
	}
	
	protected TestableState createTypeComputationState() {
		return new TestableState(new PublicResolvedTypes(reentrantResolver) {
		}, new NullFeatureScopeSession());
	}
	
	public void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		state.getResolvedTypes().acceptHint(handle, boundTypeArgument);
	}
	
	/* @NonNull */
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		return state.getResolvedTypes().getDeclaredTypeParameters();
	}
	
	public List<LightweightBoundTypeArgument> getAllHints(Object handle) {
		return state.getResolvedTypes().getAllHints(handle);
	}
	
	public boolean isResolved(/* @NonNull */ Object handle) {
		return state.getResolvedTypes().isResolved(handle);
	}
	
	protected JvmType getTypeForName(Class<?> clazz, ITypeComputationState state) {
		ResourceSet resourceSet = state.getReferenceOwner().getContextResourceSet();
		return services.getTypeReferences().findDeclaredType(clazz, resourceSet);
	}
	
	protected JvmTypeParameter createTypeParameter(String name, ITypeComputationState state) {
		JvmTypeParameter result = TypesFactory.eINSTANCE.createJvmTypeParameter();
		result.setName(name);
		return result;
	}
	
	@Before
	public void obtainResourceSet() throws Exception {
		XExpression expression = expression("null");
		assertNotNull(contextResourceSet);
		reentrantResolver = reentrantResolverProvider.get();
		reentrantResolver.initializeFrom(EcoreUtil.getRootContainer(expression));
		state = createTypeComputationState();
	}
	
	@After
	public void tearDown() {
		contextResourceSet = null;
		reentrantResolver = null;
	}
	
	protected XExpression expression(String string) throws Exception {
		XExpression result = super.expression(string);
		contextResourceSet = result.eResource().getResourceSet();
		return result;
	}
	
	protected XExpression expression(String string, ResourceSet resourceSet) throws Exception {
		return parseHelper.parse(string, resourceSet);
	}

	public ResourceSet getContextResourceSet() {
		return contextResourceSet;
	}
	
	public CommonTypeComputationServices getServices() {
		return services;
	}

	class TestableState extends AbstractTypeComputationState {

		protected TestableState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession) {
			super(resolvedTypes, featureScopeSession);
		}

		@Override
		protected LightweightTypeReference acceptType(ResolvedTypes types, AbstractTypeExpectation expectation,
				LightweightTypeReference type, boolean returnType, int conformanceHint) {
			throw new UnsupportedOperationException();
		}
		
		@Override
		protected LightweightTypeReference acceptType(XExpression alreadyHandled, ResolvedTypes types,
				AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType,
				int conformanceHint) {
			throw new UnsupportedOperationException();
		}

		@Override
		protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState) {
			throw new UnsupportedOperationException();
		}

		@Override
		protected List<AbstractTypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState, boolean asActualExpectation) {
			throw new UnsupportedOperationException();
		}
		
		protected UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type) {
			PublicResolvedTypes resolvedTypes = getResolvedTypes();
			return resolvedTypes.createUnboundTypeReference(XbaseFactory.eINSTANCE.createXNullLiteral(), type);
		}
		
		@Override
		public PublicResolvedTypes getResolvedTypes() {
			return (PublicResolvedTypes) super.getResolvedTypes();
		}

		@Override
		public List<LightweightTypeReference> getExpectedExceptions() {
			throw new UnsupportedOperationException();
		}

		@Override
		protected IssueSeverities getSeverities() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	class NullFeatureScopeSession extends AbstractFeatureScopeSession {

		@Override
		public boolean isVisible(JvmMember member) {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public boolean isVisible(JvmMember member, /* @Nullable */ LightweightTypeReference receiverType, /* @Nullable */ JvmIdentifiableElement receiverFeature) {
			throw new UnsupportedOperationException();
		}

		/* @Nullable */
		@Override
		public IEObjectDescription getLocalElement(QualifiedName name) {
			throw new UnsupportedOperationException();
		}
		
		@Override
		protected FeatureScopes getFeatureScopes() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		protected IResolvedFeatures.Provider getResolvedFeaturesProvider() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public boolean isInstanceContext() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public boolean isConstructorContext() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		protected ConstructorScopes getConstructorScopes() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		protected TypeScopes getTypeScopes() {
			throw new UnsupportedOperationException();
		}

		@Override
		protected IScopeProvider getDefaultScopeProvider() {
			throw new UnsupportedOperationException();
		}

		@Override
		protected int getId() {
			throw new UnsupportedOperationException();
		}
		
	}
	
}
