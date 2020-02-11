/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IAmbiguousLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractAmbiguousLinkingCandidate<Candidate extends AbstractPendingLinkingCandidate<?>> implements ILinkingCandidate, IAmbiguousLinkingCandidate {
	
	private final LinkedList<AbstractPendingLinkingCandidate<?>> candidates;
	
	protected AbstractAmbiguousLinkingCandidate(Candidate first, AbstractPendingLinkingCandidate<?> second) {
		this.candidates = Lists.newLinkedList();
		addCandidate(first);
		addCandidate(second);
	}
	
	@Override
	public List<? extends ILinkingCandidate> getAlternatives() {
		return Collections.unmodifiableList(candidates);
	}
	
	protected final void addCandidate(AbstractPendingLinkingCandidate<?> next) {
		this.candidates.add(next);
	}
	
	@Override
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		if (other instanceof AbstractPendingLinkingCandidate) {
			AbstractPendingLinkingCandidate<?> right = (AbstractPendingLinkingCandidate<?>) other;
			CandidateCompareResult candidateCompareResult = compareTo(right);
			switch(candidateCompareResult) {
				case AMBIGUOUS:
					addCandidate(right);
				case EQUALLY_INVALID:
				case THIS:
					return this;
				default:
					return other;
				
			}
		}
		throw new IllegalArgumentException("other was " + other);
	}
	
	protected CandidateCompareResult compareTo(AbstractPendingLinkingCandidate<?> right) {
		Candidate primaryCandidate = getPrimaryCandidate();
		CandidateCompareResult result = primaryCandidate.compareTo(right);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	protected final Candidate getPrimaryCandidate() {
		return (Candidate) candidates.getFirst();
	}

	@Override
	public void applyToComputationState() {
		Candidate candidate = getPrimaryCandidate();
		candidate.getState().getResolvedTypes().reassignLinkingInformation(candidate.getExpression(), this);
		candidate.applyToComputationState();
	}

	@Override
	public void applyToModel(IResolvedTypes resolvedTypes) {
		getPrimaryCandidate().applyToModel(resolvedTypes);
	}

	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		Candidate candidate = getPrimaryCandidate();
		if (candidate.validate(result)) {
			StringBuilder messageBuilder = new StringBuilder("Ambiguous ").append(getSyntaxDescriptions()).append(".\n");
			messageBuilder.append("The ").append(getFeatureTypeName()).append("s");
			Iterator<AbstractPendingLinkingCandidate<?>> iter = candidates.iterator();
			boolean first = true;
			while(iter.hasNext()) {
				AbstractPendingLinkingCandidate<?> next = iter.next();
				if (!first) {
					if (iter.hasNext()) {
						messageBuilder.append(",");
					} else {
						messageBuilder.append(" and");
					}
				} else {
					first = false;
				}
				messageBuilder.append("\n\t");
				if (!next.getDeclaredTypeParameters().isEmpty()) {
					messageBuilder.append(next.getFeatureTypeParametersAsString(true)).append(' ');
				}
				JvmIdentifiableElement feature = next.getFeature();
				messageBuilder.append(feature.getSimpleName());
				messageBuilder.append(next.getFeatureParameterTypesAsString());
				String declarator = getDeclaratorSimpleName(feature);
				if (declarator != null) {
					messageBuilder.append(" in ").append(declarator);
				}
			}
			if (candidates.size() == 2) {
				messageBuilder.append("\nboth match.");
			} else {
				messageBuilder.append("\nall match.");
			}
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
					IssueCodes.AMBIGUOUS_FEATURE_CALL, messageBuilder.toString(), getExpression(),
					getFeatureToMark(), -1, getDiagnosticData());
			result.accept(diagnostic);
			return false;
		}
		return false;
	}
	
	protected abstract String[] getDiagnosticData();

	protected String getFeatureTypeName() {
		return getPrimaryCandidate().getFeatureTypeName();
	}

	protected abstract String getSyntaxDescriptions();
	
	/* @Nullable */
	protected String getDeclaratorSimpleName(JvmIdentifiableElement element) {
		if (element instanceof JvmConstructor) {
			return null;
		}
		if (element instanceof JvmMember) {
			return ((JvmMember) element).getDeclaringType().getSimpleName();
		}
		return null;
	}
	
	protected abstract EStructuralFeature getFeatureToMark();
	
	/* @Nullable */
	@Override
	public JvmIdentifiableElement getFeature() {
		return getPrimaryCandidate().getFeature();
	}

	@Override
	public XExpression getExpression() {
		return getPrimaryCandidate().getExpression();
	}

	@Override
	public List<LightweightTypeReference> getTypeArguments() {
		return getPrimaryCandidate().getTypeArguments();
	}

}
