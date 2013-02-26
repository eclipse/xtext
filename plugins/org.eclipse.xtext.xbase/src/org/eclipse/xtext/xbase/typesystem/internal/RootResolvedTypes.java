/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.validation.IssueSeverities;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

import com.google.common.collect.Sets;

/**
 * The root resolved types are the effective result of a type computation.
 * They don't have a parent and should never yield unresolved type references
 * when clients query for types of expressions or identifiables.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Moritz Eysholdt - Configurable issue severity, support for checked exceptions
 * 
 * TODO guard against unresolved type references
 * TODO toString
 */
@NonNullByDefault
public class RootResolvedTypes extends ResolvedTypes {

	private Set<XExpression> toBeInferredRootExpressions;
	
	private IssueSeverities issueSeverities;
	
	protected RootResolvedTypes(DefaultReentrantTypeResolver resolver) {
		super(resolver);
		this.issueSeverities = resolver.getIssueSeverities();
	}

	public void resolveUnboundTypeParameters() {
		for(UnboundTypeReference unbound: basicGetTypeParameters().values()) {
			unbound.resolve();
		}
	}

	public void resolveProxies() {
		Map<XExpression, ILinkingCandidate> candidates = basicGetLinkingCandidates();
		for(ILinkingCandidate candidate: candidates.values()) {
			candidate.applyToModel();
		}
		for(Map.Entry<JvmIdentifiableElement, LightweightTypeReference> entry: basicGetTypes().entrySet()) {
			JvmIdentifiableElement identifiable = entry.getKey();
			if (identifiable instanceof JvmFormalParameter && identifiable.eContainingFeature() == XbasePackage.Literals.XCLOSURE__IMPLICIT_PARAMETER) {
				final JvmFormalParameter implicitLambdaParameter = (JvmFormalParameter) identifiable;
				JvmTypeReference typeReference = entry.getValue().toTypeReference();
				implicitLambdaParameter.setParameterType(typeReference);
				typeReference.eAdapters().add(new AdapterImpl(){
					@Override
					public void notifyChanged(Notification msg) {
						if (msg.getEventType() == Notification.SET && msg.getNewValue() == null) {
							implicitLambdaParameter.setParameterType(null);
						}
					}
				});
			}
		}
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getExpectedTypeForAssociatedExpression(JvmMember member, XExpression expression) {
		if (toBeInferredRootExpressions != null && toBeInferredRootExpressions.contains(expression)) {
			return null;
		}
		return getActualType(member);
	}
	
	@Override
	protected void markToBeInferred(XExpression expression) {
		if (toBeInferredRootExpressions == null) {
			toBeInferredRootExpressions = Sets.newHashSet();
		}
		toBeInferredRootExpressions.add(expression);
	}

	public void addDiagnostics(final Resource resource) {
		class DiagnosticAcceptor implements IAcceptor<AbstractDiagnostic> {

			public void accept(@Nullable AbstractDiagnostic diagnostic) {
				if (diagnostic instanceof EObjectDiagnosticImpl) {
					Severity severity = ((EObjectDiagnosticImpl) diagnostic).getSeverity();
					if (severity == Severity.ERROR) {
						resource.getErrors().add(diagnostic);
					} else if (severity == Severity.WARNING) {
						resource.getWarnings().add(diagnostic);
					}
				} else {
					resource.getErrors().add(diagnostic);
				}
			}
			
		}
		DiagnosticAcceptor acceptor = new DiagnosticAcceptor();
		for(AbstractDiagnostic diagnostic: getQueuedDiagnostics()) {
			acceptor.accept(diagnostic);
		}
		
		Map<XExpression, ILinkingCandidate> candidates = basicGetLinkingCandidates();
		for(ILinkingCandidate candidate: candidates.values()) {
			candidate.validate(acceptor);
		}
	}
	
	@Override
	protected IssueSeverities getSeverities() {
		return issueSeverities;
	}

}
