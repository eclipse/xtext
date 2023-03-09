/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.util.EmfFormatter;
import org.junit.ComparisonFailure;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EmfAssert {

	static final Pattern SPACE = Pattern.compile("[\\s\\n\\r]+");

	public static void assertTokensEqual(String msg, String expectedP,
			String actualP) {
		if (expectedP == null) {
			fail("expected is null");
			return;
		}
		if (actualP == null) {
			fail("actual is null");
			return;
		}
		String expected = expectedP.trim();
		String actual = actualP.trim();
		Matcher expM = SPACE.matcher(expected);
		Matcher actM = SPACE.matcher(actual);
		int expS = 0, actS = 0;
		boolean equal = true;
		StringBuffer merged = new StringBuffer();
		while (expM.find() && actM.find()) {
			String expToken = expected.substring(expS, expM.start());
			String actToken = actual.substring(actS, actM.start());
			if (!expToken.equals(actToken)) {
				equal = false;
				break;
			}
			expS = expM.end();
			actS = actM.end();

			merged.append(expToken);
			if (actM.group().length() > expM.group().length())
				merged.append(actM.group());
			else
				merged.append(expM.group());
		}
		if (equal) {
			String expToken = expected.substring(expS);
			String actToken = actual.substring(actS);
			equal = expToken.equals(actToken);
		}
		if (!equal) {
			String exp = merged + expected.substring(expS);
			String act = merged + actual.substring(actS);
			throw new ComparisonFailure(msg, exp, act);
		}
	}

	public static void assertEObjectsEqual(EObject expected, EObject actual,
			EStructuralFeature... ignoredFeatures) {
		String e = EmfFormatter.objToStr(expected, ignoredFeatures);
		String a = EmfFormatter.objToStr(actual, ignoredFeatures);
		assertEquals(e, a);
	}

	private static Resource findResource(ResourceSet resources,
			String matchURIpart) {
		for (Resource r : resources.getResources())
			if (r.getURI() != null
					&& r.getURI().toString().contains(matchURIpart))
				return r;
		throw new RuntimeException("No Resource with '" + matchURIpart
				+ "' in it's URI found in ResourceSet.");
	}

	public static void assertResourcesEqual(ResourceSet expected,
			ResourceSet actual, String matchURIpart,
			EStructuralFeature... ignoredFeatures) {
		assertResourcesEqual(findResource(expected, matchURIpart),
				findResource(actual, matchURIpart), ignoredFeatures);
	}

	public static void assertResourcesEqual(Resource expected, Resource actual,
			EStructuralFeature... ignoredFeatures) {
		assertEquals("Resources have different ammounts of root objects.",
				expected.getContents().size(), actual.getContents().size());
		for (int i = 0; i < expected.getContents().size(); i++)
			assertEObjectsEqual(expected.getContents().get(i), actual
					.getContents().get(i), ignoredFeatures);
	}

	public static void assertResourceSetsEqual(ResourceSet expected,
			ResourceSet actual, EStructuralFeature... ignoredFeatures) {
		assertEquals("Resources have different ammounts of root objects.",
				expected.getResources().size(), actual.getResources().size());
		for (int i = 0; i < expected.getResources().size(); i++)
			assertResourcesEqual(expected.getResources().get(i), actual
					.getResources().get(i), ignoredFeatures);
	}

	public static void assertNoCrossRefsLeaveReources(EObject model,
			Resource... allowedResources) {
		assertNoCrossRefsLeaveReources(model, new HashSet<Resource>(Arrays
				.asList(allowedResources)));
	}

	private static void assertObjectResource(EObject parent, EReference ref,
			EObject model, Set<Resource> allowedResources) {
		String id = parent.eClass().getName() + "("
				+ ref.getEContainingClass().getName() + ")." + ref.getName();
		assertNotNull("Has no Resource " + id + ": " + model, model.eResource());
		assertTrue("Resource not Allowed: " + model.eResource().getURI() + "\n"
				+ id + " -> " + model.eClass().getName() + " "
				+ model.eResource().getURIFragment(model), allowedResources
				.contains(model.eResource()));
	}

	@SuppressWarnings("unchecked")
	public static void assertNoCrossRefsLeaveReources(EObject model,
			Set<Resource> allowedResources) {
		assertNotNull(model);
		for (EReference ref : model.eClass().getEAllReferences()) {
			if (ref.isTransient() || !model.eIsSet(ref))
				continue;
			if (ref.isContainment()) {
				if (ref.isMany())
					for (Object o : (EList<Object>) model.eGet(ref))
						assertNoCrossRefsLeaveReources((EObject) o,
								allowedResources);
				else
					assertNoCrossRefsLeaveReources((EObject) model.eGet(ref),
							allowedResources);
			} else {
				if (ref.isMany())
					for (Object o : (EList<Object>) model.eGet(ref))
						assertObjectResource(model, ref, (EObject) o,
								allowedResources);
				else
					assertObjectResource(model, ref, (EObject) model.eGet(ref),
							allowedResources);
			}
		}
	}

}
