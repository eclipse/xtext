/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Predicate;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Ignore("This tests obsolete implementation details")
@SuppressWarnings("deprecation")
public class XbaseScopeProviderTest extends AbstractXbaseTestCase {
	
	@Test public void testStaticMethods() throws Exception {
		XbaseScopeProvider provider = get(XbaseScopeProvider.class);
		XExpression expression = expression("'x' != 'y'", true);
		IScope scope = provider.getScope(expression, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		final List<IEObjectDescription> allElements = newArrayList(scope.getAllElements());
		try {
			find(allElements, new Predicate<IEObjectDescription>(){
				public boolean apply(IEObjectDescription input) {
					return input.getName().toString().equals("!=");
				}});
		} catch (NoSuchElementException e) {
			fail("operator not found : "+allElements.toString());
		}
		try {
			find(allElements, new Predicate<IEObjectDescription>(){
				public boolean apply(IEObjectDescription input) {
					return input.getName().toString().equals("-");
				}});
			fail("operator + is not defined for type string");
		} catch (NoSuchElementException e) {
			//expected
		}
	}
	
	@Test public void testOverriddenExtensionMethods_01() throws Exception {
		XbaseScopeProvider provider = get(XbaseScopeProvider.class);
		XExpression expression = expression("(null as java.util.List<String>).map(null)", true);
		IScope scope = provider.getScope(expression, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		Iterable<IEObjectDescription> elements = scope.getElements(QualifiedName.create("map"));
		assertEquals(elements.toString(), 2, size(elements));
		IEObjectDescription description = elements.iterator().next();
		JvmFeature feature = (JvmFeature) description.getEObjectOrProxy();
		assertEquals(ListExtensions.class.getCanonicalName(), feature.getDeclaringType().getIdentifier());
	}
	
	@Test public void testOverriddenExtensionMethods_02() throws Exception {
		XbaseScopeProvider provider = get(XbaseScopeProvider.class);
		XExpression expression = expression("(null as java.util.Collection<String>).map(null)", true);
		IScope scope = provider.getScope(expression, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		Iterable<IEObjectDescription> elements = scope.getElements(QualifiedName.create("map"));
		assertEquals(elements.toString(), 1, size(elements));
		IEObjectDescription description = elements.iterator().next();
		JvmFeature feature = (JvmFeature) description.getEObjectOrProxy();
		assertEquals(IterableExtensions.class.getCanonicalName(), feature.getDeclaringType().getIdentifier());
	}
}
