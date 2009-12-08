/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.Issue.Severity;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
public class ResourceValidatorImpl implements IResourceValidator {

	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	protected static class ListBasedMarkerAcceptor implements IDiagnosticConverter.Acceptor {
		private final List<Issue> result;

		protected ListBasedMarkerAcceptor(List<Issue> result) {
			this.result = result;
		}

		public void accept(Issue issue) {
			if (issue != null)
				result.add(issue);
		}
	}

	private static final Logger log = Logger.getLogger(ResourceValidatorImpl.class);

	@Inject
	private Diagnostician diagnostician;

	@Inject
	private IDiagnosticConverter converter;

	public List<Issue> validate(Resource resource, final CheckMode mode, CancelIndicator mon) {
		final CancelIndicator monitor = mon == null ? new CancelIndicator.NullImpl() : mon;
		resolveProxies(resource, monitor);
		if (monitor.isCanceled())
			return null;

		final List<Issue> markers = Lists.newArrayListWithExpectedSize(resource.getErrors().size()
				+ resource.getWarnings().size());
		IDiagnosticConverter.Acceptor acceptor = createAcceptor(markers);
		try {
			// Syntactical and linking errors
			// Collect EMF Resource Diagnostics
			if (mode.shouldCheck(CheckType.FAST)) {
				for (int i = 0; i < resource.getErrors().size(); i++) {
					if (monitor.isCanceled())
						return null;
					markerFromXtextResourceDiagnostic(resource.getErrors().get(i), Severity.ERROR, acceptor);
				}

				for (int i = 0; i < resource.getWarnings().size(); i++) {
					if (monitor.isCanceled())
						return null;
					markerFromXtextResourceDiagnostic(resource.getWarnings().get(i), Severity.WARNING, acceptor);
				}
			}

			if (monitor.isCanceled())
				return null;
			boolean syntaxDiagFail = !markers.isEmpty();
			logCheckStatus(resource, syntaxDiagFail, "Syntax");

			// Validation errors
			// Collect validator Diagnostics
			for (EObject ele : resource.getContents()) {
				try {
					if (monitor.isCanceled())
						return null;
					Map<Object, Object> options = Maps.newHashMap();
					options.put(CheckMode.KEY, mode);
					options.put(CancelableDiagnostician.CANCEL_INDICATOR, monitor);
					// see EObjectValidator.getRootEValidator(Map<Object, Object>)
					options.put(EValidator.class, diagnostician);
					Diagnostic diagnostic = diagnostician.validate(ele, options);
					if (!diagnostic.getChildren().isEmpty()) {
						for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
							markerFromEValidatorDiagnostic(childDiagnostic, acceptor);
						}
					} else {
						markerFromEValidatorDiagnostic(diagnostic, acceptor);
					}
				} catch (RuntimeException e) {
					log.error(e.getMessage(), e);
				}
			}
		} catch (RuntimeException e) {
			log.error(e.getMessage(), e);
		}
		return markers;
	}

	protected void resolveProxies(final Resource resource, final CancelIndicator monitor) {
		EcoreUtil2.resolveAll(resource, monitor);
	}

	protected IDiagnosticConverter.Acceptor createAcceptor(final List<Issue> result) {
		return new ListBasedMarkerAcceptor(result);
	}

	private void logCheckStatus(final Resource resource, boolean parserDiagFail, String string) {
		if (log.isDebugEnabled()) {
			log.debug(string + " check " + (parserDiagFail ? "FAIL" : "OK") + "! Resource: " + resource.getURI());
		}
	}

	protected void markerFromXtextResourceDiagnostic(org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic,
			Severity severity, IDiagnosticConverter.Acceptor acceptor) {
		converter.convertResourceDiagnostic(diagnostic, severity, acceptor);
	}

	protected void markerFromEValidatorDiagnostic(Diagnostic diagnostic, IDiagnosticConverter.Acceptor acceptor) {
		converter.convertValidatorDiagnostic(diagnostic, acceptor);
	}

	public void setDiagnostician(Diagnostician diagnostician) {
		this.diagnostician = diagnostician;
	}

	public Diagnostician getDiagnostician() {
		return diagnostician;
	}

	public void setDiagnosticConverter(IDiagnosticConverter converter) {
		this.converter = converter;
	}

	public IDiagnosticConverter getDiagnosticConverter() {
		return converter;
	}

}
