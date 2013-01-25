/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import static com.google.common.collect.Iterables.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.tests.ClasspathBasedModule;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class TypeArgumentContextProviderTest extends Assert {

	public static class ExposedTypeArgumentContextProvider extends TypeArgumentContextProvider {
		@Override
		protected ITypeArgumentContext getParameterContext(JvmExecutable executable,
				List<JvmTypeReference> argumentTypes) {
			return super.getParameterContext(executable, argumentTypes);
		}
	}
	
	private IJvmTypeProvider typeProvider;
	
	private Resource resource;
	
	@Inject
	private ExposedTypeArgumentContextProvider contextProvider;
	
	@Inject
	private XtextResourceSet resourceSet;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private TypesFactory factory;
	
	@Before
	public void setUp() throws Exception {
		Injector injector = createInjector();
		injector.injectMembers(this);
		resource = new XMLResourceImpl(URI.createURI("http://synthetic.resource"));
		resourceSet.getResources().add(resource);
		typeProvider = injector.getInstance(IJvmTypeProvider.Factory.class).findOrCreateTypeProvider(resourceSet);
	}

	protected Injector createInjector() {
		Injector injector = Guice.createInjector(new ClasspathBasedModule());
		return injector;
	}
	
	@After
	public void tearDown() throws Exception {
		resourceSet = null;
		resource = null;
		contextProvider = null;
		typeProvider = null;
		typeReferences = null;
		factory = null;
	}
	
	/*
	 * <T> foo(T t) { foo(CharSequence) }
	 */
	@Test public void testParameterContext_SingleParamPlain() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		JvmTypeReference paramType = createTypeRef(typeParameter);
		parameterFor(operation, paramType);
		JvmTypeReference actualType = typeReferences.getTypeForName(CharSequence.class, operation);
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Collections.singletonList(actualType));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.CharSequence", boundArgument.getIdentifier());
	}
	
//	<T> void foo(Iterable<T> it) {
//		Iterable<? extends CharSequence> iter = null;
//		this.foo(iter);
//	}
	
	/*
	 * <T> foo(Iterable<T> t) { foo(Iterable<? extends CharSequence>) }
	 */
	@Test public void testParameterContext_SingleParamExtends() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference actual = createTypeRef(Iterable.class, wildCardExtends(createTypeRef(CharSequence.class)));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(actual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("? extends java.lang.CharSequence", boundArgument.getIdentifier());
	}
	
//	<T> void foo(Iterable<Iterable<T>> it) {
//		Iterable<Iterable<? extends CharSequence>> iter = null;
//		this.foo(iter);
//	}
	
	/*
	 * <T> foo(Iterable<IterableT>> t) { foo(Iterable<Iterable<? extends CharSequence>>) }
	 */
	@Test public void testParameterContext_SingleParamNestedExtends() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(Iterable.class, createTypeRef(typeParameter))));
		JvmTypeReference actual = createTypeRef(Iterable.class, createTypeRef(Iterable.class, wildCardExtends(createTypeRef(CharSequence.class))));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(actual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("? extends java.lang.CharSequence", boundArgument.getIdentifier());
	}

	/*
	 * <T> foo(Iterable<T> t) { foo(Iterable<Iterable<? extends CharSequence>>) }
	 */
	@Test public void testParameterContext_SingleParamIterableExtends() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference actual = createTypeRef(Iterable.class, createTypeRef(Iterable.class, wildCardExtends(createTypeRef(CharSequence.class))));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(actual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.Iterable<? extends java.lang.CharSequence>", boundArgument.getIdentifier());
	}
	
//	<T> void foo(Iterable<T> it) {
//		Iterable<? super CharSequence> iter = null;
//		this.foo(iter);
//	}

	/*
	 * <T> foo(Iterable<T> t) { foo(Iterable<? super CharSequence>) }
	 */
	@Test public void testParameterContext_SingleParamSuper() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference actual = createTypeRef(Iterable.class, wildCardSuper(createTypeRef(CharSequence.class)));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(actual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("? extends java.lang.Object & super java.lang.CharSequence", boundArgument.getIdentifier());
	}

//	<T> void foo(Iterable<Iterable<T>> it) {
//		Iterable<Iterable<? super CharSequence>> iter = null;
//		this.foo(iter);
//	}

	/*
	 * <T> foo(Iterable<IterableT>> t) { foo(Iterable<Iterable<? super CharSequence>>) }
	 */
	@Test public void testParameterContext_SingleParamNestedSuper() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation,	createTypeRef(Iterable.class, createTypeRef(Iterable.class, createTypeRef(typeParameter))));
		JvmTypeReference actual = createTypeRef(Iterable.class,	createTypeRef(Iterable.class, wildCardSuper(createTypeRef(CharSequence.class))));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(actual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("? extends java.lang.Object & super java.lang.CharSequence", boundArgument.getIdentifier());
	}

	/*
	 * <T> foo(Iterable<T> t) { foo(Iterable<Iterable<? super CharSequence>>) }
	 */
	@Test public void testParameterContext_SingleParamIterableSuper() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference actual = createTypeRef(Iterable.class,
				createTypeRef(Iterable.class, wildCardSuper(createTypeRef(CharSequence.class))));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(actual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.Iterable<? extends java.lang.Object & super java.lang.CharSequence>", boundArgument.getIdentifier());
	}
	
	/*
	 * <T> foo(T t, T t2) { foo(CharSequence, CharSequence) }
	 */
	@Test public void testParameterContext_TwoEqualParams() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(typeParameter));
		parameterFor(operation, createTypeRef(typeParameter));
		JvmTypeReference actualType = typeReferences.getTypeForName(CharSequence.class, operation);
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(actualType, actualType));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.CharSequence", boundArgument.getIdentifier());
	}
	
	/*
	 * <T> foo(T t, T t2) { foo(CharSequence, String) }
	 */
	@Test public void testParameterContext_TwoInheritingParams() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(typeParameter));
		parameterFor(operation, createTypeRef(typeParameter));
		JvmTypeReference firstActual = typeReferences.getTypeForName(CharSequence.class, operation);
		JvmTypeReference secondActual = typeReferences.getTypeForName(String.class, operation);
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.CharSequence", boundArgument.getIdentifier());
	}
	
	/*
	 * <T> foo(T t, T t2) { foo(String, CharSequence) }
	 */
	@Test public void testParameterContext_TwoInheritingParamsReverse() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(typeParameter));
		parameterFor(operation, createTypeRef(typeParameter));
		JvmTypeReference firstActual = typeReferences.getTypeForName(String.class, operation);
		JvmTypeReference secondActual = typeReferences.getTypeForName(CharSequence.class, operation);
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.CharSequence", boundArgument.getIdentifier());
	}
	
	/*
	 * <T, T2 extends T> foo(T t, T2 t) { foo(CharSequence, null) }
	 */
	@Test public void testParameterContext_MissingSecondArgument() {
		JvmOperation operation = operation();
		JvmTypeParameter firstTypeParameter = typeParameterFor(operation);
		JvmTypeParameter secondTypeParameter = typeParameterFor(operation);
		upper(secondTypeParameter, createTypeRef(firstTypeParameter));
		parameterFor(operation, createTypeRef(firstTypeParameter));
		parameterFor(operation, createTypeRef(secondTypeParameter));
		JvmTypeReference firstActual = typeReferences.getTypeForName(CharSequence.class, operation);
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual));
		JvmTypeReference firstBoundArgument = context.getBoundArgument(firstTypeParameter);
		assertEquals("java.lang.CharSequence", firstBoundArgument.getIdentifier());
		JvmTypeReference secondBoundArgument = context.getBoundArgument(secondTypeParameter);
		assertEquals("java.lang.CharSequence", secondBoundArgument.getIdentifier());
	}
	
	/*
	 * <T> foo(T t, Iterable<T> it) { foo(String, Iterable<String>) }
	 */
	@Test public void testParameterContext_ExactIterable() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(typeParameter));
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference firstActual = createTypeRef(String.class);
		JvmTypeReference secondActual = createTypeRef(Iterable.class, createTypeRef(String.class));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.String", boundArgument.getIdentifier());
	}
	
	/*
	 * <T> foo(T t, Iterable<T> it) { foo(String, Iterable<CharSequence>) }
	 */
	@Test public void testParameterContext_ExactIterableMatch() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(typeParameter));
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference firstActual = createTypeRef(String.class);
		JvmTypeReference secondActual = createTypeRef(Iterable.class, createTypeRef(CharSequence.class));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.CharSequence", boundArgument.getIdentifier());
	}
	
	/*
	 * <T> foo(T t, Iterable<T> it) { foo(CharSequence, Iterable<String>) }
	 */
	@Test public void testParameterContext_ExactIterableMismatch() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(typeParameter));
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference firstActual = createTypeRef(CharSequence.class);
		JvmTypeReference secondActual = createTypeRef(Iterable.class, createTypeRef(String.class));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.String", boundArgument.getIdentifier());
	}
	
	/*
	 * <T> foo(Iterable<T> t, Iterable<T> it) { foo(Iterable<CharSequence>, Iterable<String>) }
	 */
	@Test public void testParameterContext_TwoExactIterableMismatch() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference firstActual = createTypeRef(Iterable.class, createTypeRef(CharSequence.class));
		JvmTypeReference secondActual = createTypeRef(Iterable.class, createTypeRef(String.class));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.CharSequence", boundArgument.getIdentifier());
	}
	
	/*
	 * <T> foo(Iterable<T> t, Iterable<T> it) { foo(Iterable<String>, Iterable<CharSequence>) }
	 */
	@Test public void testParameterContext_TwoExactIterableMismatch_FirstWins() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference firstActual = createTypeRef(Iterable.class, createTypeRef(String.class));
		JvmTypeReference secondActual = createTypeRef(Iterable.class, createTypeRef(CharSequence.class));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.String", boundArgument.getIdentifier());
	}
	
//	<T> void foo(Iterable<T> it, Iterable<T> it2) {
//		Iterable<? extends CharSequence> iter = null;
//		this.foo(iter, iter);
//	}
	
	/*
	 * <T> foo(Iterable<T> t, Iterable<T> t) { foo(Iterable<? extends CharSequence>, Iterable<? extends CharSequence>) }
	 */
	@Test public void testParameterContext_TwoExtendIterables() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference firstActual = createTypeRef(Iterable.class, wildCardExtends(createTypeRef(CharSequence.class)));
		JvmTypeReference secondActual = createTypeRef(Iterable.class, wildCardExtends(createTypeRef(CharSequence.class)));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.CharSequence", boundArgument.getIdentifier());
	}
	
//	<T> void foo(T t, Iterable<T> it) {
//		String s = null;
//		Iterable<? extends CharSequence> iter = null;
//		this.<CharSequence>foo(s, iter);
//	}

	/*
	 * <T> foo(T t, Iterable<T> it) { foo(String, Iterable<? extends CharSequence>) } // invalid but should be CharSequence
	 */
	@Test public void testParameterContext_UpperIterableMismatch() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(typeParameter));
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference firstActual = createTypeRef(String.class);
		JvmTypeReference secondActual = createTypeRef(Iterable.class, wildCardExtends(createTypeRef(CharSequence.class)));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.CharSequence", boundArgument.getIdentifier());
	}
	
	
//	<T> void foo(T t, Iterable<? extends T> it) {
//		CharSequence s = null;
//		Iterable<String> iter = null;
//		this.<CharSequence>foo(s, iter);
//	}
	
	/*
	 * <T> foo(T t, Iterable<? extends T> it) { foo(CharSequence, Iterable<String>) }
	 */
	@Test public void testParameterContext_UpperIterableMatch() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(typeParameter));
		parameterFor(operation, createTypeRef(Iterable.class, wildCardExtends(createTypeRef(typeParameter))));
		JvmTypeReference firstActual = createTypeRef(CharSequence.class);
		JvmTypeReference secondActual = createTypeRef(Iterable.class, createTypeRef(String.class));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.CharSequence", boundArgument.getIdentifier());
	}
	
//	<T> void foo(T t, Iterable<? super T> it) {
//		CharSequence s = null;
//		Iterable<String> iter = null;
//		this.<CharSequence>foo(s, iter);
//	}
	
	/*
	 * <T> foo(T t, Iterable<? super T> it) { foo(CharSequence, Iterable<String>) } // invalid but should be CharSequence
	 */
	@Test public void testParameterContext_LowerIterableMismatch() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(typeParameter));
		parameterFor(operation, createTypeRef(Iterable.class, wildCardSuper(createTypeRef(typeParameter))));
		JvmTypeReference firstActual = createTypeRef(CharSequence.class);
		JvmTypeReference secondActual = createTypeRef(Iterable.class, createTypeRef(String.class));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.CharSequence", boundArgument.getIdentifier());
	}

//	<T> void foo(T t, Iterable<? super T> it) {
//		String s = null;
//		Iterable<CharSequence> iter = null;
//		this.<String>foo(s, iter);
//	}
	
	/*
	 * <T> foo(T t, Iterable<? super T> it) { foo(String, Iterable<CharSequence>) }
	 */
	@Test public void testParameterContext_LowerIterableMatch() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(typeParameter));
		parameterFor(operation, createTypeRef(Iterable.class, wildCardSuper(createTypeRef(typeParameter))));
		JvmTypeReference firstActual = createTypeRef(String.class);
		JvmTypeReference secondActual = createTypeRef(Iterable.class, createTypeRef(CharSequence.class));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.String", boundArgument.getIdentifier());
	}

//	<T> void foo( Iterable<? super T> it, Iterable<? super T> it2) {
//		Iterable<String> iter1 = null;
//		Iterable<CharSequence> iter2 = null;
//		this.<String>foo(iter1, iter2);
//	}
	
	/*
	 * <T> foo(Iterable<? super T> it, Iterable<? super T> it2) { foo(Iterable<String>, Iterable<CharSequence>) }
	 */
	@Test public void testParameterContext_TwoLowerIterableMatch() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, wildCardSuper(createTypeRef(typeParameter))));
		parameterFor(operation, createTypeRef(Iterable.class, wildCardSuper(createTypeRef(typeParameter))));
		JvmTypeReference firstActual = createTypeRef(Iterable.class, createTypeRef(String.class));
		JvmTypeReference secondActual = createTypeRef(Iterable.class, createTypeRef(CharSequence.class));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.String", boundArgument.getIdentifier());
	}
	
	/*
	 * <T> foo(Iterable<? super T> it, Iterable<? super T> it2) { foo(Iterable<CharSequence>, Iterable<String>) }
	 */
	@Test public void testParameterContext_TwoLowerIterableMatch_Reverse() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, wildCardSuper(createTypeRef(typeParameter))));
		parameterFor(operation, createTypeRef(Iterable.class, wildCardSuper(createTypeRef(typeParameter))));
		JvmTypeReference firstActual = createTypeRef(Iterable.class, createTypeRef(CharSequence.class));
		JvmTypeReference secondActual = createTypeRef(Iterable.class, createTypeRef(String.class));
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(firstActual, secondActual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.String", boundArgument.getIdentifier());
	}
	
	/*
	 * <T> foo(Iterable<T> iterable, Iterable<? super T> function)
	 */
	@Test public void testParameterContext_forEach_01() {
//		List<? extends String> strings = null;
//		Functions.Function1<String, Void> fun = null;
//		IterableExtensions.forEach(strings, null);
		final JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference functionReference = createTypeRef(Function.class, 
				wildCardSuper(createTypeRef(typeParameter)), 
				wildCardExtends(createTypeRef(Object.class)));
		parameterFor(operation, functionReference);
		final JvmTypeReference firstActual = createTypeRef(List.class, wildCardExtends(createTypeRef(String.class)));
		final JvmTypeReference secondActual = createTypeRef(Function.class);
		((JvmParameterizedTypeReference)secondActual).getArguments().clear();
		ITypeArgumentContext context = contextProvider. getTypeArgumentContext(new TypeArgumentContextProvider.AbstractRequest() {
			@Override
			public JvmFeature getFeature() {
				return operation;
			}
			@Override
			public List<JvmTypeReference> getArgumentTypes() {
				return Lists.newArrayList(firstActual, secondActual);
			}
		}); 
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("? extends java.lang.String", boundArgument.getIdentifier());
		JvmTypeReference lowerBound = context.getLowerBound(functionReference);
		assertEquals("com.google.common.base.Function<? extends java.lang.Object & super java.lang.String, ? extends java.lang.Object>", lowerBound.getIdentifier());
	}
	
	/*
	 * <T> foo(Iterable<T> iterable, Iterable<? super T> function)
	 */
	@Test public void testParameterContext_forEach_02() {
//		List<? extends String> strings = null;
//		Functions.Function1<String, Void> fun = null;
//		IterableExtensions.forEach(strings, null);
		final JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference functionReference = createTypeRef(Function.class, 
				wildCardSuper(createTypeRef(typeParameter)), 
				wildCardExtends(createTypeRef(Object.class)));
		parameterFor(operation, functionReference);
		final JvmTypeReference firstActual = createTypeRef(List.class, wildCardExtends(createTypeRef(String.class)));
		final JvmTypeReference secondActual = createTypeRef(Function.class);
		ITypeArgumentContext context = contextProvider. getTypeArgumentContext(new TypeArgumentContextProvider.AbstractRequest() {
			@Override
			public JvmFeature getFeature() {
				return operation;
			}
			@Override
			public List<JvmTypeReference> getArgumentTypes() {
				return Lists.newArrayList(firstActual, secondActual);
			}
		}); 
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("? extends java.lang.String", boundArgument.getIdentifier());
		JvmTypeReference lowerBound = context.getLowerBound(functionReference);
		assertEquals("com.google.common.base.Function<? extends java.lang.Object & super java.lang.String, ? extends java.lang.Object>", lowerBound.getIdentifier());
	}
	
	/*
	 * <T> foo(Iterable<T> iterable, Iterable<? super T> function)
	 */
	@Test public void testParameterContext_forEach_03() {
//		List<? extends String> strings = null;
//		Functions.Function1<String, Void> fun = null;
//		IterableExtensions.forEach(strings, null);
		final JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(Iterable.class, createTypeRef(typeParameter)));
		JvmTypeReference functionReference = createTypeRef(Function.class, 
				wildCardSuper(createTypeRef(typeParameter)), 
				wildCardExtends(createTypeRef(Object.class)));
		parameterFor(operation, functionReference);
		final JvmTypeReference firstActual = createTypeRef(List.class, wildCardExtends(createTypeRef(String.class)));
		final JvmTypeReference secondActual = createTypeRef(Function.class, 
				createTypeRef(String.class), 
				createTypeRef(String.class));
		ITypeArgumentContext context = contextProvider. getTypeArgumentContext(new TypeArgumentContextProvider.AbstractRequest() {
			@Override
			public JvmFeature getFeature() {
				return operation;
			}
			@Override
			public List<JvmTypeReference> getArgumentTypes() {
				return Lists.newArrayList(firstActual, secondActual);
			}
		}); 
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("? extends java.lang.String", boundArgument.getIdentifier());
		JvmTypeReference lowerBound = context.getLowerBound(functionReference);
		assertEquals("com.google.common.base.Function<? extends java.lang.Object & super java.lang.String, ? extends java.lang.Object>", lowerBound.getIdentifier());
	}
	
	protected JvmTypeReference createTypeRef(JvmType type, JvmTypeReference... argumentTypes) {
		if (type == null)
			throw new NullPointerException("type");
		if (type instanceof JvmTypeParameter) {
			if (((JvmTypeParameter) type).getConstraints().isEmpty()) {
				JvmUpperBound upperBound = factory.createJvmUpperBound();
				upperBound.setTypeReference(typeReferences.getTypeForName(Object.class, type));
				((JvmTypeParameter) type).getConstraints().add(upperBound);
			}
		}
		return typeReferences.createTypeRef(type, argumentTypes);
	}
	
	protected JvmTypeReference wildCardExtends(JvmTypeReference reference) {
		return typeReferences.wildCardExtends(reference);
	}
	
	protected JvmTypeReference wildCardSuper(JvmTypeReference reference) {
		JvmWildcardTypeReference result = factory.createJvmWildcardTypeReference();
		JvmLowerBound lowerBound = factory.createJvmLowerBound();
		lowerBound.setTypeReference(reference);
		JvmUpperBound upperBound = factory.createJvmUpperBound();
		upperBound.setTypeReference(typeReferences.getTypeForName(Object.class, resource.getContents().get(0)));
		result.getConstraints().add(upperBound);
		result.getConstraints().add(lowerBound);
		return result;
	}
	
	protected JvmTypeReference createTypeRef(Class<?> type, JvmTypeReference... argumentTypes) {
		return typeReferences.getTypeForName(type.getCanonicalName(), resource, argumentTypes);
	}
	
	protected JvmTypeParameter typeParameterFor(JvmTypeParameterDeclarator declarator) {
		JvmTypeParameter result = factory.createJvmTypeParameter();
		result.setName("T" + declarator.getTypeParameters().size());
		declarator.getTypeParameters().add(result);
		return result;
	}
	
	protected JvmFormalParameter parameterFor(JvmExecutable executable, JvmTypeReference type) {
		JvmFormalParameter result = factory.createJvmFormalParameter();
		result.setName("parameter" + executable.getParameters().size());
		executable.getParameters().add(result);
		result.setParameterType(type);
		return result;
	}
	
	protected void upper(JvmTypeParameter parameter, JvmTypeReference upperBound) {
		JvmUpperBound upper = factory.createJvmUpperBound();
		upper.setTypeReference(upperBound);
		parameter.getConstraints().add(upper);
	}
	
	protected JvmOperation operation() {
		JvmGenericType genericType = factory.createJvmGenericType();
		genericType.setSimpleName("TestContainer");
		resource.getContents().add(genericType);
		JvmOperation result = factory.createJvmOperation();
		result.setSimpleName("operation");
		genericType.getMembers().add(result);
		return result;
	}
	
	/**
	 * test case: "Iterable<? extends String> = newArrayList();"
	 */
	@Test public void testInferredMethodContext_00() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		JvmParameterizedTypeReference lists = typeRefs.typeReference(Lists.class.getCanonicalName()).create();
		final JvmOperation operation = find(((JvmDeclaredType)lists.getType()).getDeclaredOperations(), new Predicate<JvmOperation>(){
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("newArrayList") && input.getParameters().isEmpty();
			}
		});
		final JvmTypeReference expected = typeRefs.typeReference("java.lang.Iterable").wildCardExtends("java.lang.String").create();
		ITypeArgumentContext argumentContext = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public JvmFeature getFeature() {
						return operation;
					}
					@Override
					public JvmTypeReference getExpectedType() {
						return expected;
					}
					@Override
					public JvmTypeReference getDeclaredType() {
						return operation.getReturnType();
					}
				});
		JvmGenericType iterableType = (JvmGenericType) expected.getType();
		JvmTypeReference boundArgument = argumentContext.getBoundArgument(iterableType.getTypeParameters().get(0));
		assertEquals("java.lang.String", boundArgument.getIdentifier());
		// former expectation was not exact - see tooltip of #newArrayList in Iterable<? extends String> iter = Lists.newArrayList();
//		assertEquals("? extends java.lang.String", boundArgument.getIdentifier());
	}
	
	/**
	 * test case: "val x = singleton("foo");"
	 */
	@Test public void testInferredMethodContext_01() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		JvmParameterizedTypeReference lists = typeRefs.typeReference(Collections.class.getCanonicalName()).create();
		final JvmOperation operation = find(((JvmDeclaredType)lists.getType()).getDeclaredOperations(), new Predicate<JvmOperation>(){
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("singleton");
			}
		});
		final JvmTypeReference actualArg = typeRefs.typeReference("java.lang.String").create();
		ITypeArgumentContext argumentContext = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public JvmFeature getFeature() {
						return operation;
					}
					@Override
					public JvmTypeReference getDeclaredType() {
						return operation.getReturnType();
					}
					@Override
					public List<JvmTypeReference> getArgumentTypes() {
						return Collections.singletonList(actualArg);
					}
				});
		JvmTypeReference boundArgument = argumentContext.getBoundArgument(operation.getTypeParameters().get(0));
		assertEquals("java.lang.String",boundArgument.getIdentifier());
	}
	
	/**
	 * test case: "val Object x = getLast(newArrayList("foo"));"
	 */
	@Test public void testInferredMethodContext_02() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		JvmParameterizedTypeReference lists = typeRefs.typeReference(Iterables.class.getCanonicalName()).create();
		final JvmOperation operation = find(((JvmDeclaredType)lists.getType()).getDeclaredOperations(), new Predicate<JvmOperation>(){
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("getLast") && input.getParameters().size() == 1;
			}
		});
		final JvmTypeReference actualArg = typeRefs.typeReference("java.util.List").wildCardExtends("java.lang.String").create();
		final JvmTypeReference expectation = typeRefs.typeReference("java.lang.Object").create();
		
		ITypeArgumentContext argumentContext = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public JvmFeature getFeature() {
						return operation;
					}
					@Override
					public JvmTypeReference getExpectedType() {
						return expectation;
					}
					@Override
					public JvmTypeReference getDeclaredType() {
						return operation.getReturnType();
					}
					@Override
					public List<JvmTypeReference> getArgumentTypes() {
						return Collections.singletonList(actualArg);
					}
				});
		JvmTypeReference boundArgument = argumentContext.getBoundArgument(operation.getTypeParameters().get(0));
		assertEquals("? extends java.lang.String",boundArgument.getIdentifier());
		// former expectation was not exact - see tooltip of #getLast below;
//		List<? extends String> list = null;
//		Iterables.getLast(list);
//		assertEquals("java.lang.String",boundArgument.getIdentifier());
	}
	
	/**
	 * test case: ''foo,bar,baz'.split(',').getFirst()"
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=347656
	 */
	@Test public void testInferredMethodContext_03() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		JvmParameterizedTypeReference lists = typeRefs.typeReference(Iterables.class.getCanonicalName()).create();
		final JvmOperation operation = find(((JvmDeclaredType)lists.getType()).getDeclaredOperations(), new Predicate<JvmOperation>(){
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().equals("getLast") && input.getParameters().size() == 1;
			}
		});
		final JvmGenericArrayTypeReference actualArg = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
		actualArg.setComponentType(typeRefs.typeReference("java.lang.String").create());
		final JvmTypeReference string = typeRefs.typeReference("java.lang.String").create();
		
		ITypeArgumentContext argumentContextWithExpectation = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public JvmFeature getFeature() {
						return operation;
					}
					@Override
					public JvmTypeReference getExpectedType() {
						return string;
					}
					@Override
					public JvmTypeReference getDeclaredType() {
						return operation.getReturnType();
					}
					@Override
					public List<JvmTypeReference> getArgumentTypes() {
						return Collections.<JvmTypeReference>singletonList(actualArg);
					}
				});
		JvmTypeReference boundArgumentWithExpectation = argumentContextWithExpectation.getBoundArgument(operation.getTypeParameters().get(0));
		assertEquals("java.lang.String", boundArgumentWithExpectation.getIdentifier());
		ITypeArgumentContext argumentContextWithoutExpectation = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public JvmFeature getFeature() {
						return operation;
					}
					@Override
					public JvmTypeReference getDeclaredType() {
						return operation.getReturnType();
					}
					@Override
					public List<JvmTypeReference> getArgumentTypes() {
						JvmSynonymTypeReference synonymTypeReference = factory.createJvmSynonymTypeReference();
						synonymTypeReference.getReferences().add(actualArg);
						synonymTypeReference.getReferences().add(createTypeRef(List.class, string));
						return Collections.<JvmTypeReference>singletonList(synonymTypeReference);
					}
				});
		JvmTypeReference boundArgumentWithoutExpectation = argumentContextWithoutExpectation.getBoundArgument(operation.getTypeParameters().get(0));
		assertEquals("java.lang.String", boundArgumentWithoutExpectation.getIdentifier());
	}
	
	@Test public void testSimple() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		final JvmTypeReference reference = typeRefs.typeReference("java.util.List").wildCardExtends("java.lang.CharSequence").create();
		ITypeArgumentContext typeArgumentContext = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.ReceiverRequest(reference));
		JvmTypeReference argument = typeArgumentContext.getBoundArgument(((JvmGenericType)reference.getType()).getTypeParameters().get(0));
		assertTrue(EcoreUtil.equals(((JvmParameterizedTypeReference)reference).getArguments().get(0), argument));
	}
	
	@Test public void testPrimitive() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		final JvmTypeReference primitiveRef = typeRefs.typeReference("int").create();
		ITypeArgumentContext typeArgumentContext = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.ReceiverRequest(primitiveRef));
		JvmTypeReference reference = typeRefs.typeReference("java.util.List").wildCardExtends("java.lang.CharSequence").create();
		JvmTypeReference argument = typeArgumentContext.getBoundArgument(((JvmGenericType)reference.getType()).getTypeParameters().get(0));
		assertNull(String.valueOf(argument), argument);
	}
	
	@Test public void testTransitive() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		final JvmTypeReference stringList = typeRefs.typeReference("java.util.List").wildCardExtends("java.lang.String").create();
		ITypeArgumentContext stringListContext = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.ReceiverRequest(stringList));
		
		JvmGenericType collection = (JvmGenericType) typeProvider.findTypeByName(Collection.class.getCanonicalName());
		JvmTypeParameter collectionTypeParam = collection.getTypeParameters().get(0);
		JvmTypeReference boundCollectionTypeArgument = stringListContext.getBoundArgument(collectionTypeParam);
		assertEquals("? extends java.lang.String", boundCollectionTypeArgument.getIdentifier());
		
		JvmGenericType iterable = (JvmGenericType) typeProvider.findTypeByName(Iterable.class.getCanonicalName());
		JvmTypeParameter iterableTypeParam = iterable.getTypeParameters().get(0);
		JvmTypeReference boundIterableTypeArgument = stringListContext.getBoundArgument(iterableTypeParam);
		assertEquals("? extends java.lang.String", boundIterableTypeArgument.getIdentifier());
		
		JvmOperation iterator = (JvmOperation) iterable.getMembers().get(0);
		JvmTypeReference iteratorReturnType = iterator.getReturnType();
		JvmTypeReference boundIteratorTypeArgument = stringListContext.resolve(iteratorReturnType);
		assertEquals("java.util.Iterator<? extends java.lang.String>", boundIteratorTypeArgument.getIdentifier());
	}
	
	@Test public void testResolve_0() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		final JvmTypeReference reference = typeRefs.typeReference("java.util.ArrayList").wildCardExtends("java.lang.CharSequence").create();
		ITypeArgumentContext context = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.ReceiverRequest(reference));
		JvmOperation jvmOperation = findOperation("java.util.List", "add(E)");
		
		assertEquals("JvmAnyTypeReference", context.getLowerBound(jvmOperation.getParameters().get(0).getParameterType()).toString());
		JvmOperation get = findOperation("java.util.List", "get(int)");
		assertEquals("java.lang.CharSequence",context.getUpperBound(get.getReturnType(), resourceSet).getIdentifier());
	}
	
	@Test public void testResolve_1() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		final JvmTypeReference reference = typeRefs.typeReference("java.util.ArrayList").wildCardSuper("java.lang.CharSequence").create();
		ITypeArgumentContext context = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.ReceiverRequest(reference));
		JvmOperation jvmOperation = findOperation("java.util.List", "add(E)");
		
		JvmTypeReference resolvedParameter = context.getLowerBound(jvmOperation.getParameters().get(0).getParameterType());
		assertEquals("java.lang.CharSequence", resolvedParameter.getIdentifier());
		JvmOperation get = findOperation("java.util.List", "get(int)");
		assertEquals("java.lang.Object",context.getUpperBound(get.getReturnType(),resourceSet).getIdentifier());
	}
	
	@Test public void testResolve_WithUnResolved() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		final JvmTypeReference reference = typeRefs.typeReference("java.util.ArrayList").create();
		ITypeArgumentContext context = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.ReceiverRequest(reference));
		JvmOperation jvmOperation = findOperation("java.util.List", "add(E)");
		
		JvmTypeReference resolvedParameter = context.getLowerBound(jvmOperation.getParameters().get(0).getParameterType());
//		ArrayList list = Lists.newArrayList();
//		list.add(null);
		// raw type - return upper bound of type parameter
		assertEquals("java.lang.Object", resolvedParameter.getIdentifier());
		JvmOperation get = findOperation("java.util.List", "get(int)");
//		ArrayList list = Lists.newArrayList();
//		list.get(1);
		// raw type - return upper bound of type parameter
		assertEquals("java.lang.Object", context.getUpperBound(get.getReturnType(),resourceSet).getIdentifier());
//		assertEquals("E", context.getUpperBound(get.getReturnType(),resourceSet).getIdentifier());
	}
	
	@Test public void testResolveDeeplyNested_Extends() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		final JvmTypeReference reference = typeRefs
			.typeReference("java.util.ArrayList")
				.wildCardExtends("java.util.Map")
					.wildCardSuper("java.lang.String").x()
					.wildCardExtends("java.lang.Number").x()
				.create();
		ITypeArgumentContext context = contextProvider.getTypeArgumentContext(
			new TypeArgumentContextProvider.ReceiverRequest(reference));
//		ArrayList<? extends Map<? super String, ? extends Number>> list = Lists.newArrayList();
//		Map<? super String, ? extends Number> map = list.get(1);
		JvmOperation get = findOperation("java.util.List", "get(int)");
		assertEquals("java.util.Map<? super java.lang.String, ? extends java.lang.Number>", context.getUpperBound(get.getReturnType(),resourceSet).getIdentifier());
		assertEquals("? extends java.util.Map<? super java.lang.String, ? extends java.lang.Number>", context.resolve(get.getReturnType()).getIdentifier());
	}
	
	@Test public void testResolveDeeplyNested_ExtendsWithInvalidExpectation() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		final JvmTypeReference reference = typeRefs
			.typeReference("java.util.ArrayList")
				.wildCardExtends("java.util.Map")
					.wildCardSuper("java.lang.String").x()
					.wildCardExtends("java.lang.Number").x()
				.create();
		ITypeArgumentContext context = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public JvmTypeReference getReceiverType() {
						return reference;
					}
					@Override
					public JvmTypeReference getExpectedType() {
						return reference;
					}
				});
//		ArrayList<? extends Map<? super String, ? extends Number>> list = Lists.newArrayList();
//		Map<? super String, ? extends Number> map = list.get(1);
		JvmOperation get = findOperation("java.util.List", "get(int)");
		assertEquals("java.util.Map<? super java.lang.String, ? extends java.lang.Number>", context.getUpperBound(get.getReturnType(),resourceSet).getIdentifier());
		assertEquals("? extends java.util.Map<? super java.lang.String, ? extends java.lang.Number>", context.resolve(get.getReturnType()).getIdentifier());
	}
	
	@Test public void testResolveDeeplyNested_Super() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		final JvmTypeReference reference = typeRefs
			.typeReference("java.util.ArrayList")
				.wildCardSuper("java.util.Map")
					.wildCardSuper("java.lang.String").x()
					.wildCardExtends("java.lang.Number").x()
				.create();
		ITypeArgumentContext context = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.ReceiverRequest(reference));
//		ArrayList<? super Map<? super String, ? extends Number>> list = Lists.newArrayList();
//		Object object = list.get(1);
		JvmOperation get = findOperation("java.util.List", "get(int)");
		assertEquals("java.lang.Object", context.getUpperBound(get.getReturnType(),resourceSet).getIdentifier());
		assertEquals("? super java.util.Map<? super java.lang.String, ? extends java.lang.Number>", context.resolve(get.getReturnType()).getIdentifier());
	}
	
	@Test public void testResolveDeeplyNested_SuperWithInvalidExpectation() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		final JvmTypeReference reference = typeRefs
			.typeReference("java.util.ArrayList")
				.wildCardSuper("java.util.Map")
					.wildCardSuper("java.lang.String").x()
					.wildCardExtends("java.lang.Number").x()
				.create();
		ITypeArgumentContext context = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public JvmTypeReference getReceiverType() {
						return reference;
					}
					@Override
					public JvmTypeReference getExpectedType() {
						return reference;
					}
				});
//		ArrayList<? super Map<? super String, ? extends Number>> list = Lists.newArrayList();
//		Object object = list.get(1);
		JvmOperation get = findOperation("java.util.List", "get(int)");
		assertEquals("java.lang.Object", context.getUpperBound(get.getReturnType(),resourceSet).getIdentifier());
		assertEquals("? super java.util.Map<? super java.lang.String, ? extends java.lang.Number>", context.resolve(get.getReturnType()).getIdentifier());
	}
	
	@Test public void testIterableWildcard_01() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		final JvmParameterizedTypeReference iterableWildcard = typeRefs.typeReference("java.lang.Iterable").create();
		assertEquals("java.lang.Iterable", iterableWildcard.getIdentifier());
		iterableWildcard.getArguments().add(typeReferences.wildCard());
		assertEquals("java.lang.Iterable<?>", iterableWildcard.getIdentifier());
		ITypeArgumentContext typeArgumentContext = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.ReceiverRequest(iterableWildcard));
		JvmTypeReference wildcard = iterableWildcard.getArguments().get(0);
		assertEquals("?", typeArgumentContext.resolve(wildcard).getIdentifier());
		assertEquals("java.lang.Object", typeArgumentContext.getUpperBound(wildcard, iterableWildcard.getType()).getIdentifier());
		assertEquals("null", typeArgumentContext.getLowerBound(wildcard).getIdentifier());
	}
	
	@Test public void testIterableWildcard_02() throws Exception {
		JvmTypeReferences typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		final JvmParameterizedTypeReference iterableWildcard = typeRefs.typeReference("java.lang.Iterable").wildCard().create();
		assertEquals("java.lang.Iterable<? extends java.lang.Object>", iterableWildcard.getIdentifier());
		ITypeArgumentContext typeArgumentContext = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.ReceiverRequest(iterableWildcard));
		JvmTypeReference wildcard = iterableWildcard.getArguments().get(0);
		assertEquals("? extends java.lang.Object", typeArgumentContext.resolve(wildcard).getIdentifier());
		assertEquals("java.lang.Object", typeArgumentContext.getUpperBound(wildcard, iterableWildcard.getType()).getIdentifier());
		assertEquals("null", typeArgumentContext.getLowerBound(wildcard).getIdentifier());
	}
	
	@Test public void testIterableMultitype() {
		JvmOperation operation = operation();
		JvmTypeParameter typeParameter = typeParameterFor(operation);
		parameterFor(operation, createTypeRef(typeParameter));
		JvmTypeReference actual = typeReferences.createMultiTypeReference(operation, createTypeRef(Number.class), createTypeRef(Serializable.class));
		assertEquals("java.lang.Number & java.io.Serializable", actual.getIdentifier());
		ITypeArgumentContext context = contextProvider.getParameterContext(operation, Lists.newArrayList(actual));
		JvmTypeReference boundArgument = context.getBoundArgument(typeParameter);
		assertEquals("java.lang.Number & java.io.Serializable", boundArgument.getIdentifier());
	}
	
	protected JvmOperation findOperation(String typeName, String methodSignature) {
		JvmType type = typeProvider.findTypeByName(typeName);
		return (JvmOperation) type.eResource().getEObject(typeName+"."+methodSignature);
	}

}
