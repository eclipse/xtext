/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Triple;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class LazyLinkingResource extends XtextResource {

	private final Logger log = Logger.getLogger(getClass());

	@Inject
	private ILinkingService linkingService;

	@Inject
	private LazyURIEncoder encoder;
	
	@Inject
	private ILinkingDiagnosticMessageProvider diagnosticMessageProvider;
	
	@Inject
	private LinkingHelper linkingHelper;

	private boolean eagerLinking = false;

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		super.doLoad(inputStream, options);
		if (options != null && Boolean.TRUE.equals(options.get(OPTION_RESOLVE_ALL)))
			EcoreUtil.resolveAll(this);
	}

	@Override
	protected void doLinking() {
		super.doLinking();
		if (isEagerLinking())
			EcoreUtil.resolveAll(this);
	}

	private LinkedHashSet<Triple<EObject, EReference, AbstractNode>> resolving = Sets.newLinkedHashSet();

	@Override
	public synchronized EObject getEObject(String uriFragment) {
		try {
			if (getEncoder().isCrossLinkFragment(this, uriFragment)) {
				Triple<EObject, EReference, AbstractNode> triple = getEncoder().decode(this, uriFragment);
				try {
					if (!resolving.add(triple))
						throw new AssertionError("Cyclic resolution of lazy links : "
								+ getReferences(triple, resolving));
					Set<String> unresolveableProxies = getCache().get("UNRESOLVEABLE_PROXIES", this, new Provider<Set<String>>() {
						public Set<String> get() {
							return Sets.newHashSet();
						}
					});
					if (unresolveableProxies.contains(uriFragment))
						return null;
					EReference reference = triple.getSecond();
					List<EObject> linkedObjects = getLinkingService().getLinkedObjects(triple.getFirst(), reference,
							triple.getThird());
					if (linkedObjects.isEmpty()) {
						unresolveableProxies.add(uriFragment);
						createAndAddDiagnostic(triple);
						return null;
					}
					if (linkedObjects.size() > 1)
						throw new IllegalStateException("linkingService returned more than one object for fragment "
								+ uriFragment);
					EObject result = linkedObjects.get(0);
					if (!EcoreUtil2.isAssignableFrom(reference.getEReferenceType(), result.eClass())) {
						unresolveableProxies.add(uriFragment);
						createAndAddDiagnostic(triple);
						return null;
					}
					// remove previously added error markers, since everything should be fine now
					removeDiagnostic(triple);
					return result;
				} finally {
					resolving.remove(triple);
				}
			}
		} catch (RuntimeException e) {
			// wrapped because the javaDoc of this method states that WrappedExceptions are thrown
			// logged because EcoreUtil.resolve will ignore any exceptions.
			log.warn("resolution of uriFragment '" + uriFragment + "' failed.", e);
			throw new WrappedException(e);
		}
		return super.getEObject(uriFragment);
	}

	private String getReferences(Triple<EObject, EReference, AbstractNode> triple,
			LinkedHashSet<Triple<EObject, EReference, AbstractNode>> resolving2) {
		StringBuffer buffer = new StringBuffer();
		boolean found = false;
		for (Triple<EObject, EReference, AbstractNode> triple2 : resolving2) {
			found = found || triple2.equals(triple);
			if (found)
				buffer.append(getQualifiedName(triple2.getSecond())).append("->");
		}
		buffer.append(getQualifiedName(triple.getSecond()));
		return buffer.toString();
	}

	private String getQualifiedName(EReference eReference) {
		return eReference.getEContainingClass().getName() + "." + eReference.getName();
	}

	protected static class DiagnosticMessageContext implements ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext {

		private final Triple<EObject, EReference, AbstractNode> triple;
		private final LinkingHelper linkingHelper;

		protected DiagnosticMessageContext(Triple<EObject, EReference, AbstractNode> triple, LinkingHelper helper) {
			this.triple = triple;
			this.linkingHelper = helper;
		}
		
		@Deprecated
		protected DiagnosticMessageContext(Triple<EObject, EReference, AbstractNode> triple) {
			this.triple = triple;
			this.linkingHelper = null;
		}
		
		public EObject getContext() {
			return triple.getFirst();
		}

		public EReference getReference() {
			return triple.getSecond();
		}

		public String getLinkText() {
			if (linkingHelper != null)
				return linkingHelper.getCrossRefNodeAsString(triple.getThird(), true);
			return deprecatedGetLinkText();
		}

		@Deprecated
		protected String deprecatedGetLinkText() {
			if (triple.getThird() instanceof LeafNode)
				return ((LeafNode) triple.getThird()).getText();
			StringWriter writer = new StringWriter();
			for(LeafNode leafNode: triple.getThird().getLeafNodes()) {
				if(!leafNode.isHidden()) 
					writer.append(leafNode.getText());
			}
			return writer.toString();
		}
	}
	
	protected void createAndAddDiagnostic(Triple<EObject, EReference, AbstractNode> triple) {
		DiagnosticMessage message = createDiagnosticMessage(triple);
		List<Diagnostic> list = getDiagnosticList(message);
		Diagnostic diagnostic = createDiagnostic(triple, message);
		if (!list.contains(diagnostic))
			list.add(diagnostic);
	}
	
	protected void removeDiagnostic(Triple<EObject, EReference, AbstractNode> triple) {
		DiagnosticMessage message = createDiagnosticMessage(triple);
		List<Diagnostic> list = getDiagnosticList(message);
		if (!list.isEmpty()) {
			Diagnostic diagnostic = createDiagnostic(triple, message);
			list.remove(diagnostic);
		}
	}

	protected Diagnostic createDiagnostic(Triple<EObject, EReference, AbstractNode> triple,
			DiagnosticMessage message) {
		Diagnostic diagnostic = new XtextLinkingDiagnostic(triple.getThird(), message.getMessage(), message.getIssueCode(), message.getIssueData());
		return diagnostic;
	}

	protected List<Diagnostic> getDiagnosticList(DiagnosticMessage message) throws AssertionError {
		List<Diagnostic> list = null;
		switch (message.getSeverity()) {
			case ERROR:
				list = getErrors();
				break;
			case WARNING:
				list = getWarnings();
				break;
			default:
				throw new AssertionError("Unexpected severity: " + message.getSeverity());
		}
		return list;
	}

	protected DiagnosticMessage createDiagnosticMessage(Triple<EObject, EReference, AbstractNode> triple) {
		ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context = createDiagnosticMessageContext(triple);
		DiagnosticMessage message = diagnosticMessageProvider.getUnresolvedProxyMessage(context);
		return message;
	}
	
	protected ILinkingDiagnosticContext createDiagnosticMessageContext(Triple<EObject, EReference, AbstractNode> triple) {
		return new DiagnosticMessageContext(triple, linkingHelper);
	}

	public void setLinkingService(ILinkingService linkingService) {
		this.linkingService = linkingService;
	}

	public ILinkingService getLinkingService() {
		return linkingService;
	}

	public void setEncoder(LazyURIEncoder encoder) {
		this.encoder = encoder;
	}

	public LazyURIEncoder getEncoder() {
		return encoder;
	}

	public void setEagerLinking(boolean eagerLinking) {
		this.eagerLinking = eagerLinking;
	}

	public boolean isEagerLinking() {
		return eagerLinking;
	}
	
	public ILinkingDiagnosticMessageProvider getDiagnosticMessageProvider() {
		return diagnosticMessageProvider;
	}
	
	public void setDiagnosticMessageProvider(ILinkingDiagnosticMessageProvider diagnosticMessageProvider) {
		this.diagnosticMessageProvider = diagnosticMessageProvider;
	}
	
	public LinkingHelper getLinkingHelper() {
		return linkingHelper;
	}
	
	public void setLinkingHelper(LinkingHelper linkingHelper) {
		this.linkingHelper = linkingHelper;
	}
}
