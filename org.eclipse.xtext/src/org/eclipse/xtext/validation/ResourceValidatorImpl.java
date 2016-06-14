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
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.eclipse.xtext.validation.impl.ConcreteSyntaxEValidator;

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
	protected static class ListBasedMarkerAcceptor implements IAcceptor<Issue> {
		private final List<Issue> result;

		protected ListBasedMarkerAcceptor(List<Issue> result) {
			this.result = result;
		}

		@Override
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
	
	@Inject
	private OperationCanceledManager operationCanceledManager;
	
	@Override
	public List<Issue> validate(Resource resource, final CheckMode mode, CancelIndicator mon) throws OperationCanceledError {
		StoppedTask task = Stopwatches.forTask("ResourceValidatorImpl.validation");
		try {
			task.start();
			final CancelIndicator monitor = mon == null ? CancelIndicator.NullImpl : mon;
			resolveProxies(resource, monitor);
			operationCanceledManager.checkCanceled(monitor);

			final List<Issue> result = Lists.newArrayListWithExpectedSize(resource.getErrors().size()
					+ resource.getWarnings().size());
			try {
				IAcceptor<Issue> acceptor = createAcceptor(result);

				if (mode.shouldCheck(CheckType.FAST)) {
					collectResourceDiagnostics(resource, monitor, acceptor);
				}

				operationCanceledManager.checkCanceled(monitor);
				boolean syntaxDiagFail = !result.isEmpty();
				logCheckStatus(resource, syntaxDiagFail, "Syntax");

				validate(resource, mode, monitor, acceptor);
				operationCanceledManager.checkCanceled(monitor);
			} catch (RuntimeException e) {
				operationCanceledManager.propagateAsErrorIfCancelException(e);
				log.error(e.getMessage(), e);
			}
			return result;
		} finally {
			task.stop();
		}
	}

	/**
	 * @since 2.7
	 */
	protected void collectResourceDiagnostics(Resource resource, final CancelIndicator monitor, IAcceptor<Issue> acceptor) {
		for (int i = 0; i < resource.getErrors().size(); i++) {
			operationCanceledManager.checkCanceled(monitor);
			issueFromXtextResourceDiagnostic(resource.getErrors().get(i), Severity.ERROR, acceptor);
		}

		for (int i = 0; i < resource.getWarnings().size(); i++) {
			operationCanceledManager.checkCanceled(monitor);
			issueFromXtextResourceDiagnostic(resource.getWarnings().get(i), Severity.WARNING, acceptor);
		}
	}

	/**
	 * @since 2.4
	 */
	protected void validate(Resource resource, final CheckMode mode, final CancelIndicator monitor,
			IAcceptor<Issue> acceptor) {
		for (EObject ele : resource.getContents()) {
			operationCanceledManager.checkCanceled(monitor);
			validate(resource, ele, mode, monitor, acceptor);
		}
	}

	/**
	 * @since 2.4
	 */
	protected void validate(Resource resource, EObject element, final CheckMode mode, final CancelIndicator monitor,
			IAcceptor<Issue> acceptor) {
		try {
			Map<Object, Object> options = Maps.newHashMap();
			options.put(CheckMode.KEY, mode);
			options.put(CancelableDiagnostician.CANCEL_INDICATOR, monitor);
			// disable concrete syntax validation, since a semantic model that has been parsed 
			// from the concrete syntax always complies with it - otherwise there are parse errors.
			options.put(ConcreteSyntaxEValidator.DISABLE_CONCRETE_SYNTAX_EVALIDATOR, Boolean.TRUE);
			// see EObjectValidator.getRootEValidator(Map<Object, Object>)
			options.put(EValidator.class, diagnostician);
			if (resource instanceof XtextResource) {
				options.put(AbstractInjectableValidator.CURRENT_LANGUAGE_NAME,
						((XtextResource) resource).getLanguageName());
			}
			Diagnostic diagnostic = diagnostician.validate(element, options);
			if (!diagnostic.getChildren().isEmpty()) {
				for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
					issueFromEValidatorDiagnostic(childDiagnostic, acceptor);
				}
			} else {
				issueFromEValidatorDiagnostic(diagnostic, acceptor);
			}
		} catch (RuntimeException e) {
			operationCanceledManager.propagateAsErrorIfCancelException(e);
			log.error(e.getMessage(), e);
		}
	}

	protected void resolveProxies(final Resource resource, final CancelIndicator monitor) {
		EcoreUtil2.resolveLazyCrossReferences(resource, monitor);
	}

	protected IAcceptor<Issue> createAcceptor(final List<Issue> result) {
		return new ListBasedMarkerAcceptor(result);
	}

	private void logCheckStatus(final Resource resource, boolean parserDiagFail, String string) {
		if (log.isDebugEnabled()) {
			log.debug(string + " check " + (parserDiagFail ? "FAIL" : "OK") + "! Resource: " + resource.getURI());
		}
	}

	protected void issueFromXtextResourceDiagnostic(org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic,
			Severity severity, IAcceptor<Issue> acceptor) {
		converter.convertResourceDiagnostic(diagnostic, severity, acceptor);
	}

	protected void issueFromEValidatorDiagnostic(Diagnostic diagnostic, IAcceptor<Issue> acceptor) {
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
	
	/**
	 * @since 2.9
	 */
	protected OperationCanceledManager getOperationCanceledManager() {
		return operationCanceledManager;
	}

}
