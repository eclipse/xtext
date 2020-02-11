/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testing.typesystem;

import java.net.URL;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.eclipse.xtext.testing.smoketest.ScenarioProcessor;
import org.eclipse.xtext.testing.util.ParseHelper;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class NoJRESmokeTester extends ScenarioProcessor {

	@Inject
	private ParseHelper<EObject> parseHelperNoJRE;
	
	@Inject
	private Provider<ResourceValidatorImpl> resourceValidatorProvider;
	
	@Inject
	private TypeResourceServices typeResourceServices; 
	
	@Override
	public void processFile(String data) throws Exception {
		XtextResourceSet resourceSet = new XtextResourceSet();
		NoOpClassLoader classLoader = new NoOpClassLoader();
		resourceSet.setClasspathURIContext(classLoader);
		ClasspathTypeProviderFactory factory = new ClasspathTypeProviderFactory(classLoader, typeResourceServices);
		factory.createTypeProvider(resourceSet);
		EObject parsed = parseHelperNoJRE.parse(data, resourceSet);
		EcoreUtil.resolveAll(parsed);
		checkNoErrorsInValidator(data, (XtextResource) parsed.eResource());
	}
	
	protected void checkNoErrorsInValidator(final String model, XtextResource resource) {
		ResourceValidatorImpl validator = resourceValidatorProvider.get();
		Assert.assertNotSame(validator, resource.getResourceServiceProvider().getResourceValidator());
		validator.setDiagnosticConverter(new IDiagnosticConverter() {
			@Override
			public void convertValidatorDiagnostic(org.eclipse.emf.common.util.Diagnostic diagnostic, IAcceptor<Issue> acceptor) {
				if (diagnostic instanceof BasicDiagnostic) {
					List<?> data = diagnostic.getData();
					if (!data.isEmpty() && data.get(0) instanceof Throwable) {
						Throwable t = (Throwable) data.get(0);
						throwError(t);
					}
					if (EObjectValidator.DIAGNOSTIC_SOURCE.equals(diagnostic.getSource()) && diagnostic.getCode() == EObjectValidator.EOBJECT__EVERY_REFERENCE_IS_CONTAINED) {
						throwError(new RuntimeException("Dangling reference found."));
					}
				}
			}
			
			private void throwError(Throwable e) {
				ComparisonFailure result = new ComparisonFailure(e.getMessage(), model, "");
				result.setStackTrace(e.getStackTrace());
				throw result;
			}
			
			@Override
			public void convertResourceDiagnostic(Diagnostic diagnostic, Severity severity, IAcceptor<Issue> acceptor) {
				if (diagnostic instanceof ExceptionDiagnostic) {
					Exception e = ((ExceptionDiagnostic) diagnostic).getException();
					throwError(e);
				}
			}
		});
		validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
	}
	
	public static class NoOpClassLoader extends ClassLoader {
		@Override
		public Class<?> loadClass(String name) throws ClassNotFoundException {
			throw new ClassNotFoundException(name);
		}
		
		@Override
		public URL getResource(String name) {
			return null;
		}
	}
}
