/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractPendingLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractResolvedReference;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractUnresolvableReferenceWithNode;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * A linking candidate encapsulates a linked feature. The link may be broken, e.g. the proxy
 * cannot be resolved. It may even be the case that no suitable feature exists. 
 * 
 * Key to this abstraction is the possibility to compare two possible candidates with each other,
 * apply the best match to the AST, and resolve the link on the EMF level.
 * Furthermore it is possible to trigger the validation of an established link.
 * 
 * @see IFeatureLinkingCandidate
 * @see IConstructorLinkingCandidate
 * @see AbstractPendingLinkingCandidate
 * @see AbstractUnresolvableReferenceWithNode
 * @see AbstractResolvedReference
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ILinkingCandidate extends IApplicableCandidate {

	/**
	 * Apply this candidate to the current computation state model. This propagates
	 * the type information about arguments and child expressions to the
	 * currently active resolution state.
	 */
	void applyToComputationState();
	
	/**
	 * Injects the resolved feature into the model with the same semantics as the implicit
	 * {@link EcoreUtil#resolve(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject) resolve}
	 * of EMF. This implies that the linked feature call may still point to a proxy afterwards.
	 */
	@Override
	void applyToModel(IResolvedTypes resolvedTypes);
	
	/**
	 * Produces the best candidate for the current two candidates. It may turn out
	 * that both candidates (<code>this</code> and <code>other</code>) are ambiguous 
	 * so no prefered candidate can be chosen. In that case, a new linking candidate
	 * may be produced that carries this information and will use that on {@link #applyToComputationState()},
	 * {@link #applyToModel(IResolvedTypes)}, and {@link #validate(IAcceptor)}.
	 */
	ILinkingCandidate getPreferredCandidate(ILinkingCandidate other);
	
	/**
	 * The currently considered feature (if any). Otherwise <code>null</code>.
	 */
	/* @Nullable */ JvmIdentifiableElement getFeature();
	
	/**
	 * The current expression that shall be linked.
	 */
	XExpression getExpression();
	
	/**
	 * The resolved type arguments.
	 */
	List<LightweightTypeReference> getTypeArguments();

}
