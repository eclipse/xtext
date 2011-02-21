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
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

/**
 * A scope which goes through all returned EObjectDescriptions in order to find the best fit, if it is asked for the
 * 'first' element.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class BestMatchingJvmFeatureScope implements IScope {

	protected final EObject context;
	protected final EReference reference;
	private XbaseTypeConformanceComputer computer;
	private IScope delegate;
	private FeatureCallChecker featureCallChecker;

	public BestMatchingJvmFeatureScope(XbaseTypeConformanceComputer computer, EObject context, EReference ref,
			IScope delegate, FeatureCallChecker featureCallChecker) {
		this.computer = computer;
		this.context = context;
		this.reference = ref;
		this.delegate = delegate;
		this.featureCallChecker = featureCallChecker;
	}

	public Iterable<IEObjectDescription> getAllElements() {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getElements(EObject object) {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		throw new UnsupportedOperationException();
	}

	public IEObjectDescription getSingleElement(EObject object) {
		throw new UnsupportedOperationException();
	}

	public IEObjectDescription getSingleElement(QualifiedName name) {
		Iterable<IEObjectDescription> unsorted = delegate.getElements(name);
		return setImplicitReceiverAndIsValid(getBestMatch(unsorted));
	}

	protected IEObjectDescription setImplicitReceiverAndIsValid(IEObjectDescription bestMatch) {
		if (bestMatch instanceof JvmFeatureDescription) {
			if (this.reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE) {
				final XAbstractFeatureCall featureCall = (XAbstractFeatureCall) this.context;
				JvmFeatureDescription featureDesc = (JvmFeatureDescription) bestMatch;
				final XFeatureCall implicitReceiver = featureDesc.getImplicitReceiver();
				if (implicitReceiver!=null) {
					featureCall.setImplicitReceiver(implicitReceiver);
				}
				featureCall.setInvalidFeatureIssueCode(featureDesc.getIssueCode());
			} else if(this.reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR) {
				final XConstructorCall constructorCall = (XConstructorCall) this.context;
				constructorCall.setInvalidFeatureIssueCode(((JvmFeatureDescription) bestMatch).getIssueCode());
			}
		}
		return bestMatch;
	}

	protected IEObjectDescription getBestMatch(Iterable<IEObjectDescription> iterable) {
		IEObjectDescription bestMatch = null;
		for (IEObjectDescription description : iterable) {
			featureCallChecker.check(description);
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
			if(((JvmFeatureDescription) a).isValid()) { 
				if(!((JvmFeatureDescription)b).isValid())
					return a;
			} else if(((JvmFeatureDescription) b).isValid())
				return b;
			JvmFeatureDescription descA = (JvmFeatureDescription) a;
			JvmFeatureDescription descB = (JvmFeatureDescription) b;
			TypeArgumentContext contextA = descA.getContext();
			TypeArgumentContext contextB = descB.getContext();
			if (descA.getJvmFeature() instanceof JvmExecutable) {
				if (descB.getJvmFeature() instanceof JvmExecutable) {
					JvmExecutable opA = (JvmExecutable) descA.getJvmFeature();
					JvmExecutable opB = (JvmExecutable) descB.getJvmFeature();
					if (descA.isValid() && descB.isValid()) {
						if (opA.isVarArgs()) {
							if (!opB.isVarArgs()) {
								return b;
							}
						} else if (opB.isVarArgs()) {
							return a;
						}
					}
					int numParamsA = opA.getParameters().size();
					int numParamsB = opB.getParameters().size();
					for (int i = 0; i < Math.min(numParamsA, numParamsB); i++) {
						JvmTypeReference pA = opA.getParameters().get(numParamsA-i-1).getParameterType();
						JvmTypeReference pB = opB.getParameters().get(numParamsB-i-1).getParameterType();
						if (!computer.isConformant(contextB.getLowerBound(pB), contextA.getLowerBound(pA), true))
							return b;
					}
					return a;
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
