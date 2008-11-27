/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.codecompletion.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.crossref.ILinkingScopeService;
import org.eclipse.xtext.testlanguages.ReferenceGrammarStandaloneSetup;
import org.eclipse.xtext.ui.common.editor.codecompletion.ILinkingCandidatesService;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultLinkingCandidatesServiceTest extends TestCase implements ILinkingScopeService {

	private List<EObject> scope;

	private EObject familie;

	private EReference reference;

	private ILinkingCandidatesService service;

	private EFactory factory;

	private EPackage pack;

	private EClass familieClass;

	private EClass erwachsenerClass;

	private EClass kindClass;

	private EReference kindRef;

	private EReference vaterRef;

	private EReference mutterRef;

	protected void setUp() throws Exception {
		super.setUp();
		service = new DefaultLinkingCandidatesService();
		((DefaultLinkingCandidatesService) service).setScopeService(this);
		ReferenceGrammarStandaloneSetup.doSetup();
		factory = EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/xtext/reference/ReferenceGrammar");
		scope = new ArrayList<EObject>();
		pack = factory.getEPackage();
		familieClass = (EClass) pack.getEClassifier("Familie");
		kindClass = (EClass) pack.getEClassifier("Kind");
		erwachsenerClass = (EClass) pack.getEClassifier("Erwachsener");
		kindRef = (EReference) familieClass.getEStructuralFeature("kinder");
		vaterRef = (EReference) familieClass.getEStructuralFeature("vater");
		mutterRef = (EReference) familieClass.getEStructuralFeature("mutter");
		familie = factory.create(familieClass);
	}

	public List<EObject> getObjectsInScope(EObject context, EReference reference) {
		assertEquals(this.familie, context);
		assertEquals(this.reference, reference);
		return scope;
	}

	public void testGetLinkingCandidates_01() {
		reference = kindRef;
		assertTrue(service.getLinkingCandidates(familie, kindRef).isEmpty());
	}

	public void testGetLinkingCandidates_02() {
		scope.add(factory.create(erwachsenerClass));
		reference = kindRef;
		assertTrue(service.getLinkingCandidates(familie, kindRef).isEmpty());
	}

	public void testGetLinkingCandidates_03() {
		scope.add(factory.create(kindClass));
		reference = kindRef;
		assertEquals(scope, service.getLinkingCandidates(familie, kindRef));
	}

	public void testGetLinkingCandidates_04() {
		scope.add(factory.create(kindClass));
		scope.add(factory.create(erwachsenerClass));
		reference = kindRef;
		final List<EObject> result = service.getLinkingCandidates(familie, kindRef);
		assertEquals(scope.get(0), result.get(0));
		assertEquals(1, result.size());
	}

	public void testGetLinkingCandidates_05() {
		scope.add(factory.create(kindClass));
		scope.add(factory.create(erwachsenerClass));
		scope.add(factory.create(erwachsenerClass));
		reference = vaterRef;
		final List<EObject> vaterCandidates = service.getLinkingCandidates(familie, vaterRef);
		reference = mutterRef;
		final List<EObject> mutterCandidates = service.getLinkingCandidates(familie, mutterRef);
		assertEquals(vaterCandidates, mutterCandidates);
	}
}
