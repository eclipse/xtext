/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.crossref.impl.XtextBuiltinLinkingScopeService;
import org.eclipse.xtext.crossref.impl.XtextBuiltinLinkingService;
import org.eclipse.xtext.crossref.internal.Linker;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.ReferenceGrammarStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PartialLinkingTest extends AbstractGeneratorTest implements ILinkingScopeService {

	private Map<Object, EObject> scope;

	private EObject context;

	private EObject model;

	private XtextResource resource;

	private String modelAsText;

	private ILinkingScopeService scopeService;

	private EReference reference;

	protected void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarStandaloneSetup.class);
		scopeService = new XtextBuiltinLinkingScopeService();
		modelAsText = 
			"spielplatz 1 {\n" + 
			"  kind( Bommel 1)\n" + 
			"  kind( Bommel 2)\n" + 
			"  kind( Bommel 3)\n" +
			"  erwachsener( Bob 4)\n" + 
			"  erwachsener( Joe 5)\n" + 
			"  familie( Familienname Bob Joe Bommel )\n" +
			"}";
		resource = getResourceFromString(modelAsText);
		assertTrue(resource.getErrors().isEmpty());
		model = resource.getParseResult().getRootASTElement();
		final Iterator<EObject> iter = model.eAllContents();
		while (iter.hasNext() && context == null) {
			final EObject candidate = iter.next();
			final String className = candidate.eClass().getName();
			if (className.endsWith("Familie"))
				context = candidate;
		}
		reference = (EReference) context.eClass().getEStructuralFeature("kinder");
	}

	@SuppressWarnings("unchecked")
	public void testPartialLinking() {
		int idx = modelAsText.indexOf("Bommel 2");
		resource.update(idx + 1, 1, "o");
		EList<EObject> content = (EList<EObject>) context.eGet(reference);
		assertEquals(3, content.size());
	}
	
	@SuppressWarnings("unchecked")
	public void testPartialLinkingTwice() {
		int idx = modelAsText.indexOf("Bommel 2");
		resource.update(idx + 1, 1, "o");
		resource.update(idx + 1, 1, "o");
		EList<EObject> content = (EList<EObject>) context.eGet(reference);
		assertEquals(3, content.size());
	}
	
	@SuppressWarnings("unchecked")
	public void testPartialLinkingFakedScope() {
		replaceLinker(resource);
		int idx = modelAsText.indexOf("Bommel 2");
		assertNull(scope);
		resource.update(idx + 1, 1, "o");
		assertNotNull(scope);
		scope.clear();
		resource.update(idx + 1, 1, "o");
		EList<EObject> content = (EList<EObject>) context.eGet(reference);
		assertEquals(0, content.size());
	}
	
	@SuppressWarnings("unchecked")
	public void testLinking() {
		EList<EObject> content = (EList<EObject>) context.eGet(reference);
		assertEquals(3, content.size());
	}

	protected void replaceLinker(XtextResource resource) {
		Linker linker = new Linker();
		XtextBuiltinLinkingService linkingService = new XtextBuiltinLinkingService();
		linkingService.setLinkingScopeService(this);
		linker.setLinkingService(linkingService);
		resource.setLinker(linker);
	}

	/**
	 * We try to emulate a changed scope after a partial parsing so we mock the ScopeService.
	 */
	public Iterable<EObject> getObjectsInScope(EObject context, EReference reference) {
		if ((this.context == context) && (this.reference == reference)) {
			if (scope == null) {
				final Iterator<EObject> iter = scopeService.getObjectsInScope(context, reference).iterator();
				this.scope = new WeakHashMap<Object, EObject>();
				while (iter.hasNext())
					this.scope.put(new Object(), iter.next());
			}
			return scope.values();
		}
		return scopeService.getObjectsInScope(context, reference);
	}

}
