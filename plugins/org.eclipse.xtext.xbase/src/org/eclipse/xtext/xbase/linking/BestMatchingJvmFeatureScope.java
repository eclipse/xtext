/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.linking;

import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IRawTypeHelper;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeConformanceResult.Kind;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.featurecalls.IValidatedEObjectDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;

/**
 * A scope which goes through all returned EObjectDescriptions in order to find the best fit, if it is asked for the
 * 'first' element.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class BestMatchingJvmFeatureScope implements IScope {

	protected final EObject context;
	protected final EReference reference;
	private TypeConformanceComputer conformanceComputer;
	private IScope delegate;
	private FeatureCallChecker featureCallChecker;
	private IRawTypeHelper rawTypeHelper;

	public BestMatchingJvmFeatureScope(TypeConformanceComputer conformanceComputer, EObject context, EReference ref,
			IScope delegate, FeatureCallChecker featureCallChecker, IRawTypeHelper rawTypeHelper) {
		this.conformanceComputer = conformanceComputer;
		this.context = context;
		this.reference = ref;
		this.delegate = delegate;
		this.featureCallChecker = featureCallChecker;
		this.rawTypeHelper = rawTypeHelper;
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
		if (bestMatch instanceof IValidatedEObjectDescription) {
			if (this.reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE) {
				final XAbstractFeatureCall featureCall = (XAbstractFeatureCall) this.context;
				IValidatedEObjectDescription validated = (IValidatedEObjectDescription) bestMatch;
				featureCall.eSetDeliver(false);
				try {
					featureCall.setInvalidFeatureIssueCode(validated.getIssueCode());
					if (validated instanceof JvmFeatureDescription) {
						final XExpression implicitReceiver = ((JvmFeatureDescription) validated).getImplicitReceiver();
						if (implicitReceiver!=null) {
							featureCall.setImplicitReceiver(EcoreUtil2.clone(implicitReceiver));
						}
						XExpression implicitArgument = ((JvmFeatureDescription) validated).getImplicitArgument();
						if (implicitArgument != null) {
							featureCall.setImplicitFirstArgument(EcoreUtil2.clone(implicitArgument));
						}
					}
				} finally {
					featureCall.eSetDeliver(true);
				}
			} else if(this.reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR) {
				final XConstructorCall constructorCall = (XConstructorCall) this.context;
				constructorCall.eSetDeliver(false);
				try {
					constructorCall.setInvalidFeatureIssueCode(((IValidatedEObjectDescription) bestMatch).getIssueCode());
				} finally {
					constructorCall.eSetDeliver(true);
				}
			}
		}
		return bestMatch;
	}

	protected IEObjectDescription getBestMatch(Iterable<IEObjectDescription> iterable) {
		IEObjectDescription bestMatch = null;
		for (IEObjectDescription description : iterable) {
			featureCallChecker.checkWithoutTypes(description);
			if (bestMatch == null) {
				bestMatch = description;
			} else {
				bestMatch = getBestMatch(bestMatch, description);
			}
		}
		return bestMatch;
	}

	protected IEObjectDescription getBestMatch(IEObjectDescription a, IEObjectDescription b) {
		if (a instanceof IValidatedEObjectDescription && b instanceof IValidatedEObjectDescription) {
			IValidatedEObjectDescription descA = (IValidatedEObjectDescription) a;
			IValidatedEObjectDescription descB = (IValidatedEObjectDescription) b;
			{
				IValidatedEObjectDescription result = selectByIssueCode(descA, descB);
				if (result != null)
					return result;
			}
			featureCallChecker.checkTypesWithoutGenerics(a);
			featureCallChecker.checkTypesWithoutGenerics(b);
			while(true) {
				IValidatedEObjectDescription result = selectByIssueCode(descA, descB);
				if (result != null)
					return result;
				boolean again = featureCallChecker.checkTypesWithGenerics(a);
				again = featureCallChecker.checkTypesWithGenerics(b) || again;
				if (!again) {
					break;
				}
			}
			if (a instanceof JvmFeatureDescription && b instanceof JvmFeatureDescription) {
				JvmFeatureDescription featureDescriptionA = (JvmFeatureDescription) descA;
				JvmFeatureDescription featureDescriptionB = (JvmFeatureDescription) descB;
				if (featureDescriptionA.isValid() && featureDescriptionB.isValid()) {
					JvmFeatureDescription potentialResult = getBestConformanceMatch(featureDescriptionA, featureDescriptionB);
					if (potentialResult != null)
						return potentialResult;
				}
				if (descA.getEObjectOrProxy() instanceof JvmExecutable) {
					if (descB.getEObjectOrProxy() instanceof JvmExecutable) {
						JvmExecutable opA = (JvmExecutable) descA.getEObjectOrProxy();
						JvmExecutable opB = (JvmExecutable) descB.getEObjectOrProxy();
						if (descA.isValid() && descB.isValid()) {
							if (opA.isVarArgs()) {
								if (!opB.isVarArgs()) {
									return b;
								}
							} else if (opB.isVarArgs()) {
								return a;
							}
						}
						ITypeArgumentContext contextA = featureDescriptionA.getRawTypeContext();
						ITypeArgumentContext contextB = featureDescriptionB.getRawTypeContext();
						int numParamsA = opA.getParameters().size();
						int numParamsB = opB.getParameters().size();
						for (int i = 0; i < Math.min(numParamsA, numParamsB); i++) {
							JvmTypeReference pA = opA.getParameters().get(numParamsA-i-1).getParameterType();
							pA = contextA.getLowerBound(pA);
							pA = rawTypeHelper.getRawTypeReference(pA, context.eResource());
							JvmTypeReference pB = opB.getParameters().get(numParamsB-i-1).getParameterType();
							pB = contextB.getLowerBound(pB);
							pB = rawTypeHelper.getRawTypeReference(pB, context.eResource());
							if (!conformanceComputer.isConformant(pB, pA, true))
								return b;
						}
						return a;
					}
				}
			}
		}
		return a;
	}

	protected IValidatedEObjectDescription selectByIssueCode(IValidatedEObjectDescription descA, IValidatedEObjectDescription descB) {
		if (!descA.isSameValidationState(descB))
			return null;
		if(descA.isValid()) { 
			if(!descB.isValid())
				return descA;
		} else if(descB.isValid()) {
			return descB;
		} else if (!descA.isValid() && !descB.isValid()) {
			if (descA.getIssueCode() != null && descB.getIssueCode() != null) {
				int issueCodeComparison = compareIssueCodes(descA.getIssueCode(), descB.getIssueCode());
				if (issueCodeComparison < 0)
					return descA;
				if (issueCodeComparison > 0)
					return descB;
			}
		}
		return null;
	}

	protected JvmFeatureDescription getBestConformanceMatch(JvmFeatureDescription featureDescriptionA,
			JvmFeatureDescription featureDescriptionB) {
		List<EnumSet<Kind>> allHintsA = featureDescriptionA.getArgumentConversionHints();
		if (allHintsA == null)
			allHintsA = Collections.emptyList();
		List<EnumSet<Kind>> allHintsB = featureDescriptionB.getArgumentConversionHints();
		if (allHintsB == null)
			allHintsB = Collections.emptyList();
		int aIsBetter = 0;
		int bIsBetter = 0;
		for(int i = 0; i < allHintsA.size() && i < allHintsB.size(); i++) {
			EnumSet<Kind> hintsA = allHintsA.get(i);
			EnumSet<Kind> hintsB = allHintsB.get(i);
			for(Kind kind: Kind.values()) {
				if (hintsA.contains(kind)) {
					if (!hintsB.contains(kind)) {
						aIsBetter++;
						break;
					}
				} else {
					if (hintsB.contains(kind)) {
						bIsBetter++;
						break;
					}
				}
			}
		}
		if (aIsBetter == bIsBetter)
			return null;
		if (aIsBetter > bIsBetter)
			return featureDescriptionA;
		return featureDescriptionB;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " -> " + delegate;
	}
}
