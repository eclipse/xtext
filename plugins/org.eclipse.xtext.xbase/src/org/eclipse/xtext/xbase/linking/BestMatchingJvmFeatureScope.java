/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * A scope which goes through all returned EObjectDescriptions in order to find the best fit, if it is asked for the
 * 'first' element.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class BestMatchingJvmFeatureScope implements IScope {

	protected final EObject context;
	protected final EReference reference;
	private IJvmTypeConformanceComputer computer;
	private IScope delegate;
	private Predicate<IEObjectDescription> filter;

	public BestMatchingJvmFeatureScope(IJvmTypeConformanceComputer computer, EObject context, EReference ref,
			IScope delegate, Predicate<IEObjectDescription> filter) {
		this.computer = computer;
		this.context = context;
		this.reference = ref;
		this.delegate = delegate;
		this.filter = filter;
	}

	public Iterable<IEObjectDescription> getAllElements() {
		Iterable<IEObjectDescription> unfiltered = delegate.getAllElements();
		return filter(unfiltered);
	}

	public Iterable<IEObjectDescription> getElements(EObject object) {
		Iterable<IEObjectDescription> unfiltered = delegate.getElements(object);
		return filter(unfiltered);
	}

	protected Iterable<IEObjectDescription> filter(Iterable<IEObjectDescription> unfiltered) {
		if (filter != null) {
			Iterable<IEObjectDescription> result = Iterables.filter(unfiltered, filter);
			return result;
		}
		return unfiltered;
	}

	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		Iterable<IEObjectDescription> unfiltered = delegate.getElements(name);
		return filter(unfiltered);
	}

	public IEObjectDescription getSingleElement(EObject object) {
		final Iterable<IEObjectDescription> elements = getElements(object);
		return getBestMatch(elements);
	}

	public IEObjectDescription getSingleElement(QualifiedName name) {
		final Iterable<IEObjectDescription> elements = getElements(name);
		return setImplicitReceiver(getBestMatch(elements));
	}

	protected IEObjectDescription setImplicitReceiver(IEObjectDescription bestMatch) {
		if (bestMatch instanceof JvmFeatureDescription) {
			if (this.reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE) {
				JvmFeatureDescription featureDesc = (JvmFeatureDescription) bestMatch;
				final JvmIdentifyableElement implicitReceiver = featureDesc.getImplicitReceiver();
				final XAbstractFeatureCall featureCall = (XAbstractFeatureCall) this.context;
				featureCall.setImplicitReceiver(implicitReceiver);
				featureCall.setTargetsMemberSyntaxCall(featureDesc.isMemberSyntaxContext());
			}
		}
		return bestMatch;
	}

	protected IEObjectDescription getBestMatch(Iterable<IEObjectDescription> iterable) {
		IEObjectDescription bestMatch = null;
		for (IEObjectDescription description : iterable) {
			if (bestMatch == null) {
				bestMatch = description;
			} else {
				bestMatch = getBestMatch(bestMatch, description);
			}
		}
		return bestMatch;
	}

	protected IEObjectDescription getBestMatch(IEObjectDescription a, IEObjectDescription b) {
		if (a instanceof JvmFeatureDescription && b instanceof JvmFeatureDescription) {
			JvmFeatureDescription descA = (JvmFeatureDescription) a;
			JvmFeatureDescription descB = (JvmFeatureDescription) b;
			TypeArgumentContext contextA = descA.getContext();
			TypeArgumentContext contextB = descB.getContext();
			if (descA.getJvmFeature() instanceof JvmOperation) {
				if (descB.getJvmFeature() instanceof JvmOperation) {
					JvmOperation opA = (JvmOperation) descA.getJvmFeature();
					JvmOperation opB = (JvmOperation) descB.getJvmFeature();
					for (int i = 0; i < opA.getParameters().size(); i++) {
						JvmTypeReference pA = opA.getParameters().get(i).getParameterType();
						JvmTypeReference pB = opB.getParameters().get(i).getParameterType();
						if (!computer.isConformant(contextA.getLowerBound(pA), contextB.getLowerBound(pB)))
							return a;
					}
					return b;
				}
			}
		}
		return a;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " -> " + delegate;
	}
}
