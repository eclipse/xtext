/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.ui.core.editor.validation.IDiagnosticConverter.Acceptor;
import org.eclipse.xtext.validation.CancelIndicator;
import org.eclipse.xtext.validation.CancellableDiagnostician;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
public class DefaultXtextResourceChecker implements IXtextResourceChecker {

	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	protected static class ListBasedMarkerAcceptor implements IDiagnosticConverter.Acceptor {
		private final List<Map<String, Object>> result;

		protected ListBasedMarkerAcceptor(List<Map<String, Object>> result) {
			this.result = result;
		}

		public void accept(Map<String, Object> marker) {
			if (marker != null)
				result.add(marker);
		}
	}

	private static final Logger log = Logger.getLogger(DefaultXtextResourceChecker.class);

	@Inject
	private Diagnostician diagnostician;
	
	@Inject
	private IDiagnosticConverter converter;
	
	/**
	 * Checks an {@link XtextResource}
	 * 
	 * @param resource
	 * @return a {@link List} of {@link IMarker} attributes
	 */
	public List<Map<String, Object>> check(final Resource resource, Map<?, ?> context, final IProgressMonitor monitor) {
		final List<Map<String, Object>> markers = new ArrayList<Map<String, Object>>(resource.getErrors().size() + resource.getWarnings().size());
		IDiagnosticConverter.Acceptor acceptor = createAcceptor(markers);
		try {
			// Syntactical and linking errors
			// Collect EMF Resource Diagnostics
			for (int i = 0; i < resource.getErrors().size(); i++) {
				markerFromXtextResourceDiagnostic(resource.getErrors().get(i), IMarker.SEVERITY_ERROR, acceptor);
			}

			if (monitor.isCanceled())
				return null;

			for (int i = 0; i < resource.getWarnings().size(); i++) {
				markerFromXtextResourceDiagnostic(resource.getWarnings().get(i), IMarker.SEVERITY_WARNING, acceptor);
			}

			if (monitor.isCanceled())
				return null;

			boolean syntaxDiagFail = !markers.isEmpty();
			logCheckStatus(resource, syntaxDiagFail, "Syntax");

			// Validation errors
			// Collect Validator Diagnostics
			for (EObject ele : resource.getContents()) {
				try {
					Map<Object, Object> options = Maps.newHashMap(context);
					options.put(CancellableDiagnostician.CANCEL_INDICATOR, new CancelIndicator() {
						public boolean isCancelled() {
							return monitor.isCanceled();
						}
					});
					Diagnostic diagnostic = diagnostician.validate(ele, options);
					if (monitor.isCanceled())
						return null;
					if (!diagnostic.getChildren().isEmpty()) {
						for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
							markerFromEValidatorDiagnostic(childDiagnostic, acceptor);
						}
					}
					else {
						markerFromEValidatorDiagnostic(diagnostic, acceptor);
					}
				}
				catch (RuntimeException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		catch (RuntimeException e) {
			log.error(e.getMessage(), e);
		}
		return markers;
	}

	protected IDiagnosticConverter.Acceptor createAcceptor(final List<Map<String, Object>> result) {
		return new ListBasedMarkerAcceptor(result);
	}

	private void logCheckStatus(final Resource resource, boolean parserDiagFail, String string) {
		if (log.isDebugEnabled()) {
			log.debug(string + " check " + (parserDiagFail ? "FAIL" : "OK") + "! Resource: " + resource.getURI());
		}
	}

	protected void markerFromXtextResourceDiagnostic(
			org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic, Object severity, IDiagnosticConverter.Acceptor acceptor) {
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
