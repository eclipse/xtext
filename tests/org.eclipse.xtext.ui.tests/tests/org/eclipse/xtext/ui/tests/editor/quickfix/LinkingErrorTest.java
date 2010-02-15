/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.tests.linking.ImportUriUiTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.linking.importUriUi.Main;
import org.eclipse.xtext.ui.tests.linking.importUriUi.Type;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.DiagnosticConverterImpl;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.IssueResolution;
import org.eclipse.xtext.validation.IDiagnosticConverter.Acceptor;
import org.eclipse.xtext.validation.IssueContext.IssueContextImpl;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class LinkingErrorTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ImportUriUiTestLanguageStandaloneSetup.class);
	}
	
	public void testQuickfixRoundtrip() throws Exception {
		String input = "type Foo extends Ba\n" +
			"type Bar extends Bar\n";
		XtextResource res = getResourceAndExpect(new StringInputStream(input), 1);
		assertEquals(1, res.getErrors().size());
		EcoreUtil2.resolveAll(res, new CancelIndicator.NullImpl());

		Main g = (Main) getModel(res);
		Type fooType = g.getTypes().get(0);
		assertEquals("Foo", fooType.getName());
		Type extendsObj = fooType.getExtends();
		assertTrue(extendsObj.eIsProxy());
		Type barType = g.getTypes().get(1);
		assertEquals("Bar", barType.getName());
		
		// ensure "ba" cannot be linked 
		Diagnostic firstError = res.getErrors().get(0);
		DiagnosticConverterImpl converter = new DiagnosticConverterImpl();
		final List<Issue> l = new ArrayList<Issue>();
		Acceptor acceptor = new IDiagnosticConverter.Acceptor() {
			public void accept(Issue issue) {
				l.add(issue);
			}};
			
		converter.convertResourceDiagnostic(firstError, null, acceptor);
		Issue firstIssue = l.get(0);
		assertEquals(Issue.LINKING_ISSUE, firstIssue.getCode());

		// single quickfix is change
		IssueContextImpl context = new IssueContextImpl(fooType, firstIssue, input);
		DefaultQuickfixProvider resolutionProvider = new DefaultQuickfixProvider();
		resolutionProvider.setScopeProvider(getInjector().getInstance(IScopeProvider.class));
		List<IssueResolution> resolutions = resolutionProvider.getResolutions(context);
		
		assertEquals(1, resolutions.size());
		IssueResolution resolution = resolutions.get(0);
		assertEquals("Change to 'Bar'", resolution.getLabel());
		
		// apply quickfix
		assertNotSame(barType, fooType.getExtends());
		resolution.run();
		assertSame(barType, fooType.getExtends());
		
	}
	
}
