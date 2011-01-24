/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.linking;

import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;

/**
 * A brute-force test class to ensure that parsing, linking and validation 
 * don't throw exceptions on invalid models.
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 * 
 * TODO connect all model listeners (highlighting, outline) and compiler to
 * verify that they do not throw any exceptions.
 */
public class LinkingErrornessModelTest extends AbstractXtend2TestCase {
	
	public void testParseErrornessModel_01() throws Exception {
		String string = readXtendFile();
		for (int i = 0; i < string.length(); i++) {
			doParseLinkAndValidate(string.substring(0, i));
		}
	}

	protected String readXtendFile() {
		final String name = "/"+getClass().getName().replace('.', '/')+"Data.xtend";
		final InputStream resourceAsStream = getClass().getResourceAsStream(name);
		String string = Files.readStreamIntoString(resourceAsStream);
		return string;
	}
	
	public void testParseErrornessModel_02() throws Exception {
		String string = readXtendFile();
		for (int i = 0; i < string.length(); i++) {
			doParseLinkAndValidate(string.substring(i));
		}
	}

	//TODO fix me!
//	public void testParseErrornessModel_03() throws Exception {
//		String string = readXtendFile();
//		for (int i = 0; i < string.length() - 1; i++) {
//			doParseLinkAndValidate(string.substring(0, i) + string.substring(i+1));
//		}
//	}

	protected void doParseLinkAndValidate(final String string) throws Exception {
		try {
			XtextResourceSet set = get(XtextResourceSet.class);
			LazyLinkingResource resource = (LazyLinkingResource) set.createResource(URI.createURI("Test.xtend"));
			resource.load(new StringInputStream(string), null);
			resource.resolveLazyCrossReferences(CancelIndicator.NullImpl);
			ResourceValidatorImpl validator = new ResourceValidatorImpl();
			assertNotSame(validator, resource.getResourceServiceProvider().getResourceValidator());
			getInjector().injectMembers(validator);
			validator.setDiagnosticConverter(new IDiagnosticConverter() {
				public void convertValidatorDiagnostic(org.eclipse.emf.common.util.Diagnostic diagnostic, IAcceptor<Issue> acceptor) {
					if (diagnostic instanceof BasicDiagnostic) {
						List<?> data = diagnostic.getData();
						if (!data.isEmpty() && data.get(0) instanceof Throwable) {
							Throwable t = (Throwable) data.get(0);
							// the framework catches runtime exception
							// and AssertionError does not take a throwable as argument
							throw new Error(new RuntimeException("Input was: " + string, t));
						}
					}
				}
				
				public void convertResourceDiagnostic(Diagnostic diagnostic, Severity severity, IAcceptor<Issue> acceptor) {
					if (diagnostic instanceof ExceptionDiagnostic) {
						Exception e = ((ExceptionDiagnostic) diagnostic).getException();
						// the framework catches runtime exception
						// and AssertionError does not take a throwable as argument
						throw new Error(new RuntimeException("Input was: " + string, e));
					}
				}
			});
			validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		} catch (Throwable e) {
			e.printStackTrace();
			fail(e.getMessage()+" : Model was : \n\n"+string);
		}
	}
}
