/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArgumentSlot;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.internal.util.FeatureKinds;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.util.XExpressionHelper;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * A linking candidate that represents a feature call and allows to resolve
 * overloaded members.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureLinkingCandidate extends AbstractPendingLinkingCandidate<XAbstractFeatureCall> implements IFeatureLinkingCandidate, IFeatureNames {

	public FeatureLinkingCandidate(
			XAbstractFeatureCall featureCall,
			IIdentifiableElementDescription description,
			ITypeExpectation expectation,
			ExpressionTypeComputationState state) {
		super(featureCall, description, expectation, state);
	}
	
	@Override
	protected ILinkingCandidate createAmbiguousLinkingCandidate(AbstractPendingLinkingCandidate<?> second) {
		return new AmbiguousFeatureLinkingCandidate(this, second);
	}
	
	@Override
	protected ILinkingCandidate createSuspiciousLinkingCandidate(AbstractPendingLinkingCandidate<?> chosenCandidate) {
		return new SuspiciouslyOverloadedCandidate((FeatureLinkingCandidate) chosenCandidate, this);
	}
	
	@Override
	protected boolean isRawTypeContext() {
		if (isThisOrSuper())
			return false;
		LightweightTypeReference receiverType = getReceiverType();
		if(receiverType != null && receiverType.isRawType()) {
			return true;
		}
		return false;
	}
	
	@Override
	protected void initializeMapping(JvmTypeParameter typeParameter, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> result) {
		ITypeReferenceOwner owner = getState().getReferenceOwner();
		if (typeParameter.getDeclarator() instanceof JvmType && owner.getDeclaredTypeParameters().contains(typeParameter)) {
			LightweightTypeReference typeReference = owner.newParameterizedTypeReference(typeParameter);
			result.put(typeParameter, new LightweightMergedBoundTypeArgument(typeReference, VarianceInfo.INVARIANT));
		} else {
			super.initializeMapping(typeParameter, result);
		}
	}

	/**
	 * Returns the actual arguments of the expression. These do not include the
	 * receiver.  
	 */
	@Override
	protected List<XExpression> getArguments() {
		List<XExpression> syntacticArguments = getSyntacticArguments();
		XExpression firstArgument = getFirstArgument();
		if (firstArgument != null) {
			return createArgumentList(firstArgument, syntacticArguments);
		}
		return syntacticArguments;
	}
	
	/**
	 * Validates this linking candidate and adds respective diagnostics to the given queue.
	 * 
	 * In addition to the checks that are inherited from {@link AbstractPendingLinkingCandidate#validate(IAcceptor)},
	 * the candidate is validated according these criteria:
	 * 
	 * <ol>
	 * <li>{@link #isInvalidStaticSyntax() syntax for static feature calls},</li>
	 * <li>{@link #isStatic() static context for static members},</li>
	 * <li>field accessed as a method, e.g. with parentheses,</li>
	 * <li>usage of {@code this} or {@code super} in an invalid context,</li>
	 * <li>direct invocation of an abstract method,</li>
	 * <li>attempt to enclose a non-final local variable in a lambda expression,</li>
	 * <li>reference to a private feature with a subclass instance,</li>
	 * <li>{@link #isGetClassOnTypeLiteral() errorprone invocation of getClass()}.</li>
	 * </ol>
	 */
	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (isReassignFirstArgument(featureCall)) {
			XBinaryOperation binaryOperation = (XBinaryOperation) featureCall;
			
			LightweightTypeReference actualType = getDeclaredType(featureCall.getFeature());
			LightweightTypeReference expectedType = getActualType(binaryOperation.getLeftOperand());
			if (!expectedType.getIdentifier().equals(actualType.getIdentifier())) {
				AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.INCOMPATIBLE_TYPES, String.format(
						"Type mismatch: cannot convert from %s to %s", actualType.getHumanReadableName(), expectedType.getHumanReadableName()),
						getExpression(), XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
				result.accept(diagnostic);
				return false;
			}
		}
		if (isInvalidStaticSyntax()) {
			Severity severity = getSeverity(IssueCodes.INSTANCE_ACCESS_TO_STATIC_MEMBER);
			if (severity != Severity.IGNORE) {
				String message = String.format("The static %1$s %2$s%3$s should be accessed in a static way",
						getFeatureTypeName(),
						getFeature().getSimpleName(),
						getFeatureParameterTypesAsString());
				AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(severity,
						IssueCodes.INSTANCE_ACCESS_TO_STATIC_MEMBER, message, getExpression(),
						XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
				result.accept(diagnostic);
				return false;
			} else {
				return true;
			}
		} else if (!isStatic() && isStaticAccessSyntax()) {
			EObject featureOwner = getFeature().eContainer();
			String message = String.format("Cannot make a static reference to the non-static %1$s %2$s%3$s",
					getFeatureTypeName(),
					getFeature().getSimpleName(),
					getFeatureParameterTypesAsString());
			if(featureOwner instanceof JvmDeclaredType) 
				message += " from the type " + ((JvmDeclaredType) featureOwner).getSimpleName();
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
					IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, message, getExpression(),
					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
			result.accept(diagnostic);
			return false;
		} else if (super.validate(result)) {
			if (isOperationCallSyntax() && !(getFeature() instanceof JvmExecutable)) {
				String typeName = getFeatureTypeName();
				String code = IssueCodes.FIELD_ACCESS_WITH_PARENTHESES;
				if (!(getFeature() instanceof JvmField)) {
					code = IssueCodes.LOCAL_VAR_ACCESS_WITH_PARENTHESES;
				}
				String message = "Cannot access the " + typeName + " " + getFeature().getSimpleName() + " with parentheses";
				AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR, code, message,
						getExpression(), XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
				result.accept(diagnostic);
				return false;
			}
			JvmIdentifiableElement feature = getFeature();
			if (feature instanceof JvmType) {
				QualifiedName featureName = description.getName();
				if (!getState().isInstanceContext()) {
					if (!(SELF.equals(featureName))) {
						String message = String.format("Cannot use %s in a static context", featureName);
						AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
								IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, message, getExpression(),
								XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
						result.accept(diagnostic);
						return false;
					}
				} else if (getExpression() instanceof XMemberFeatureCall && !(SELF.equals(featureName))) {
					XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) getExpression();
					XAbstractFeatureCall target = (XAbstractFeatureCall) memberFeatureCall.getMemberCallTarget();
					final JvmType referencedType = (JvmType) target.getFeature();
					List<JvmDeclaredType> enclosingTypes = getState().getFeatureScopeSession().getEnclosingTypes();
					if (SUPER.equals(featureName) && referencedType instanceof JvmGenericType
							&& ((JvmGenericType) referencedType).isInterface() && !enclosingTypes.isEmpty()) {
						if (!Iterables.any(enclosingTypes.get(0).getSuperTypes(), new Predicate<JvmTypeReference>() {
							@Override
							public boolean apply(JvmTypeReference input) {
								return input.getType() == referencedType;
							}
						})) {
							String message = String.format("The enclosing type does not extend or implement the interface %s", referencedType.getSimpleName());
							AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
									IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, message, getExpression(),
									XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
							result.accept(diagnostic);
							return false;
						}
					} else if (!enclosingTypes.contains(referencedType)) {
						String message = String.format("No enclosing instance of the type %s is accessible in scope", referencedType.getSimpleName());
						AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
								IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, message, getExpression(),
								XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
						result.accept(diagnostic);
						return false;
					}
				} else if (getExpression() instanceof XFeatureCall && SUPER.equals(featureName)) {
					List<JvmDeclaredType> enclosingTypes = getState().getFeatureScopeSession().getEnclosingTypes();
					JvmDeclaredType declaringType = null;
					if (!enclosingTypes.isEmpty())
						declaringType = enclosingTypes.get(0);
					if (declaringType instanceof JvmGenericType && ((JvmGenericType) declaringType).isInterface()) {
						if (!getState().isIgnored(IssueCodes.UNQUALIFIED_SUPER_CALL)) {
							AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(getSeverity(IssueCodes.UNQUALIFIED_SUPER_CALL),
									IssueCodes.UNQUALIFIED_SUPER_CALL,
									"Unqualified super reference is not allowed in interface context", getExpression(),
									XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
							result.accept(diagnostic);
							return false;
						}
					} else if (declaringType != null && declaringType != feature && declaringType.isLocal()) {
						XClosure closure = EcoreUtil2.getContainerOfType(featureCall, XClosure.class);
						if (closure != null) {
							EObject typeSource = getState().getReferenceOwner().getServices().getJvmModelAssociations().getPrimarySourceElement(declaringType);
							if (typeSource != null && EcoreUtil.isAncestor(typeSource, closure)) {
								AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
										IssueCodes.INVALID_SUPER_CALL,
										"Cannot call super of an anonymous class from a lambda expression", getExpression(),
										XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
								result.accept(diagnostic);
								return false;
							}
						}
					}
				}
			}
			if (feature instanceof XVariableDeclaration) {
				XVariableDeclaration casted = (XVariableDeclaration) feature;
				if (casted.isWriteable()) {
					String message = getState().getResolver().getInvalidWritableVariableAccessMessage(casted, getFeatureCall(), getState().getResolvedTypes());
					if (message != null) {
						AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
								IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS, message, getExpression(),
								XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
						result.accept(diagnostic);
						return false;
					}
				}
				if (EcoreUtil.isAncestor(casted, getFeatureCall())) {
					String message = String.format("The local variable %s may not have been initialized", feature.getSimpleName());
					AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
							IssueCodes.ILLEGAL_FORWARD_REFERENCE, message, getExpression(),
							XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
					result.accept(diagnostic);
					return false;
				}
			}
			if (feature instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) feature;
				if (operation.isAbstract() && featureCall instanceof XMemberFeatureCall) {
					Severity severity = getSeverity(IssueCodes.ABSTRACT_METHOD_INVOCATION);
					if (severity != Severity.IGNORE) {
						XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) featureCall;
						XExpression target = memberFeatureCall.getMemberCallTarget();
						if (target instanceof XAbstractFeatureCall
								&& SUPER.getFirstSegment().equals(((XAbstractFeatureCall) target).getConcreteSyntaxFeatureName())) {
							JvmIdentifiableElement targetFeature = ((XAbstractFeatureCall) target).getFeature();
							String message = String.format("Cannot directly invoke the abstract method %s%s of the type %s",
									operation.getSimpleName(), getFeatureParameterTypesAsString(operation), targetFeature.getSimpleName());
							AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(severity,
									IssueCodes.ABSTRACT_METHOD_INVOCATION, message, memberFeatureCall,
									XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
							result.accept(diagnostic);
							return false;
						}
					}
				}
			}
			if (feature instanceof JvmMember) {
				JvmMember member = (JvmMember) feature;
				if (member.getVisibility() == JvmVisibility.PRIVATE) {
					LightweightTypeReference receiverType = getReceiverType();
					if (receiverType != null) {
						if (receiverType.getType() != member.getDeclaringType()) {
							List<JvmDeclaredType> enclosingTypes = getState().getFeatureScopeSession().getEnclosingTypes();
							if (enclosingTypes.contains(member.getDeclaringType())) {
								String message = String.format("Cannot access the private %s %s%s in a subclass context",
										getFeatureTypeName(), member.getSimpleName(), getFeatureParameterTypesAsString());
								String[] issueData = null;
								// We can fix the issue by adding a type cast to the declaring type of the feature
								issueData = new String[] { "subclass-context", member.getDeclaringType().getSimpleName() };
								AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
										IssueCodes.FEATURE_NOT_VISIBLE, message, featureCall,
										XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, issueData);
								result.accept(diagnostic);
								return false;
							}
						}
					}
				}
			}
		}
		if (isGetClassOnTypeLiteral()) {
			if ("class".equals(description.getName().getFirstSegment())) {
				LightweightTypeReference receiverType = getSyntacticReceiverType();
				if (receiverType == null) {
					throw new IllegalStateException();
				}
				receiverType = receiverType.getTypeArguments().get(0);
				String message = String.format("The syntax for type literals is typeof(%s) or %s.", receiverType.getHumanReadableName(), receiverType.getHumanReadableName());
				AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
						Severity.ERROR,
						IssueCodes.UNEXPECTED_INVOCATION_ON_TYPE_LITERAL,
						message, 
						getExpression(),
						XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 
						-1, 
						null);
				result.accept(diagnostic);
				return false;
			}
		}
		return true;
	}
	
	@Override
	protected boolean validateArity(IAcceptor<? super AbstractDiagnostic> result) {
		if (getFeatureCall() instanceof XFeatureCall) {
			XExpression implicitReceiver = getImplicitReceiver();
			if (implicitReceiver instanceof XFeatureCall) {
				JvmIdentifiableElement feature = ((XFeatureCall) implicitReceiver).getFeature();
				if (feature instanceof JvmType && !getState().isInstanceContext()) {
					return false;
				}
			}
		}
		return super.validateArity(result);
	}

	protected boolean isReassignFirstArgument(XAbstractFeatureCall featureCall) {
		if (featureCall instanceof XBinaryOperation) {
			XBinaryOperation binaryOperation = (XBinaryOperation) featureCall;
			return binaryOperation.isReassignFirstArgument();	
		}
		return false;
	}
	
	/**
	 * Returns <code>true</code> if a static member is accessed with an instance receiver,
	 * e.g. {@code myLocalVariable.STATIC_METHOD(..)} or {@code myLocalVariable.STATIC_FIELD = null}.
	 */
	protected boolean isInvalidStaticSyntax() {
		boolean result = isStatic() && !isExtension() && isAssignmentOrMemberFeatureCall() && !isStaticWithDeclaringType();
		if (result)
			return true;
		return false;
	}

	protected boolean isStaticWithDeclaringType() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) featureCall).isStaticWithDeclaringType();
		}
		if (featureCall instanceof XAssignment) {
			return isStaticWithDeclaringType((XAssignment) featureCall);
		}
		return false;
	}

	protected boolean isStaticWithDeclaringType(XAssignment assignment) {
		return  assignment.isExplicitStatic() || isImplicitlyStatic(assignment);
	}

	protected boolean isImplicitlyStatic(XAssignment assignment) {
		return assignment.isStatic() && isTypeLiteral(assignment.getAssignable());
	}

	protected boolean isTypeLiteral(XExpression expression) {
		return expression instanceof XAbstractFeatureCall && ((XAbstractFeatureCall) expression).isTypeLiteral();
	}

	protected boolean isOperationCallSyntax() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XBinaryOperation || featureCall instanceof XAssignment) {
			return false;
		}
		return featureCall.isExplicitOperationCallOrBuilderSyntax();
	}

	@Override
	protected String getFeatureTypeName() {
		JvmIdentifiableElement feature = getFeature();
		String result = FeatureKinds.getTypeName(feature);
		return result;
	}

	protected boolean isStaticAccessSyntax() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) featureCall).isExplicitStatic();
		}
		return false;
	}
	
	protected boolean isAssignmentOrMemberFeatureCall() {
		if (getImplicitReceiverType() != null)
			return true;
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XAssignment) {
			return isSimpleAssignment((XAssignment) featureCall);
		}
		return featureCall instanceof XMemberFeatureCall;
	}

	protected boolean isSimpleAssignment(XAssignment assignment) {
		return assignment.getAssignable() != null;
	}

	protected List<XExpression> createArgumentList(XExpression head, List<XExpression> tail) {
		// TODO investigate in optimized List impls like HEAD, syntacticArguments
		List<XExpression> result = Lists.newArrayListWithExpectedSize(tail.size() + 1);
		result.add(head);
		for (int i = 0, size = tail.size(); i < size; i++) {
			XExpression expression = tail.get(i);
			// addAll will convert the tail to an array, first which is not necessary at all
			result.add(expression);
		}
		return result;
	}
	
	@Override
	protected List<XExpression> getSyntacticArguments() {
		return new FeatureLinkHelper().getSyntacticArguments(getFeatureCall());
	}
	
	@Override
	public boolean isExtension() {
		return description.isExtension();
	}
	
	@Override
	protected boolean hasReceiver() {
		return !isStatic();
	}
	
	@Override
	public boolean isStatic() {
		return description.isStatic();
	}
	
	/**
	 * Returns <code>true</code> if the linked receiver could be 
	 * a possible argument of this feature. Basically it's false if
	 * this feature is an error feature, a local variable or a if the
	 * receiver is a type literal that's treated as a static qualifier
	 * rather than a literal expression.
	 */
	protected boolean isSyntacticReceiverPossibleArgument() {
		return description.isSyntacticReceiverPossibleArgument();
	}
	
	@Override
	public boolean isTypeLiteral() {
		return false;
	}
	
	@Override
	protected CandidateCompareResult getExpectedTypeCompareResultOther(AbstractPendingLinkingCandidate<?> right) {
		if (!(right instanceof FeatureLinkingCandidate) || getState().isIgnored(IssueCodes.SUSPICIOUSLY_OVERLOADED_FEATURE))
			return CandidateCompareResult.OTHER;
		
		FeatureLinkingCandidate casted = (FeatureLinkingCandidate) right;
		XExpression otherImplicitReceiver = casted.getImplicitReceiver();
		if (otherImplicitReceiver != null) {
			if (isStatic() == casted.isStatic()) {
				if (otherImplicitReceiver instanceof XAbstractFeatureCall && getImplicitReceiver() instanceof XAbstractFeatureCall) {
					JvmIdentifiableElement otherImplicitReceiverFeature = ((XAbstractFeatureCall) otherImplicitReceiver).getFeature();
					if (otherImplicitReceiverFeature != ((XAbstractFeatureCall) getImplicitReceiver()).getFeature())
						return CandidateCompareResult.SUSPICIOUS_OTHER;
				}
			}
		} else {
			if (isStatic() && casted.isStatic()) {
				JvmIdentifiableElement otherFeature = casted.getFeature();
				if (getFeature().eContainer() != otherFeature.eContainer() && otherFeature.eResource() == getExpression().eResource()) {
					if (EcoreUtil.isAncestor(otherFeature.eContainer(), getFeature())) {
						return CandidateCompareResult.SUSPICIOUS_OTHER;
					}
				}
			}
		}
		return CandidateCompareResult.OTHER;
	}
	
	@Override
	protected int getConformanceFlags(int idx, boolean recompute) {
		if (isStatic()) {
			if (idx == -1) {
				return ConformanceFlags.CHECKED_SUCCESS;
			}
		}
		if (idx == 0) {
			if (getReceiver() != null) {
				int result = getReceiverConformanceFlags();
				return result;
			}
		} else if (idx == 1) {
			if (getExpression() instanceof XAssignment && getFeature() instanceof JvmField) {
				return super.getConformanceFlags(0, recompute);
			}
		}
		return super.getConformanceFlags(idx, recompute);
	}
	
	@Override
	protected boolean isLambdaExpression(int argumentIdx) {
		if (isStatic() && argumentIdx == -1) {
			return false;
		}
		if (argumentIdx == 0) {
			if (getReceiver() != null) {
				return getReceiver() instanceof XClosure;
			}
		}
		return super.isLambdaExpression(argumentIdx);
	}
	
	@Override
	/* @Nullable */
	protected LightweightTypeReference getSubstitutedExpectedType(int idx) {
		if (idx == -1) {
			return null;
		}
		if (idx == 0) {
			if (getReceiver() != null) {
				return null;
			}
		}
		return super.getSubstitutedExpectedType(idx);
	}
	
	protected boolean isExplicitOperationCall() {
		return getFeatureCall().isExplicitOperationCallOrBuilderSyntax();
	}
	
	@Override
	protected CandidateCompareResult compareByName(AbstractPendingLinkingCandidate<?> right) {
		if (!(right instanceof FeatureLinkingCandidate)) {
			return super.compareByName(right);
		}
		FeatureLinkingCandidate other = (FeatureLinkingCandidate) right;
		boolean thisCompoundOperator = isCompoundOperator();
		boolean otherCompoundOperator = other.isCompoundOperator();
		if (thisCompoundOperator == otherCompoundOperator) {
			return CandidateCompareResult.AMBIGUOUS;
		}
		if (thisCompoundOperator) {
			return CandidateCompareResult.THIS;
		}
		return CandidateCompareResult.OTHER;
	}
	
	@Override
	protected CandidateCompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right) {
		CandidateCompareResult result = super.compareByArgumentTypes(right);
		if (result == CandidateCompareResult.AMBIGUOUS && !right.isTypeLiteral()) {
			result = compareByNameAndStaticFlag(right);
		}
		return result;
	}
	
	@Override
	protected CandidateCompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right, boolean recompute) {
		CandidateCompareResult result = super.compareByArgumentTypes(right, recompute);
		if (result == CandidateCompareResult.AMBIGUOUS && getExpression() instanceof XAssignment) {
			if (description.isValidStaticState() == right.description.isValidStaticState()) {
				if (getFeature() instanceof JvmExecutable != right.getFeature() instanceof JvmExecutable) {
					if (getFeature() instanceof JvmExecutable) {
						return CandidateCompareResult.OTHER;
					}
					return CandidateCompareResult.THIS;
				}
			}
		}
		return result;
	}
	
	protected CandidateCompareResult compareByNameAndStaticFlag(AbstractPendingLinkingCandidate<?> right) {
		if (!getFeature().getSimpleName().equals(right.getFeature().getSimpleName())) {
			// If the features have different names, it is possible to disambiguate them in the generated Java code
			// prefer the unsugared feature
			if (description.isValidStaticState() == right.description.isValidStaticState()) {
				String concreteSyntax = description.getName().getFirstSegment();
				if (getFeature().getSimpleName().equals(concreteSyntax) && (getFeatureCall().isExplicitOperationCallOrBuilderSyntax() == getFeature() instanceof JvmExecutable)) {
					return CandidateCompareResult.THIS; 
				} else if (right.getFeature().getSimpleName().equals(concreteSyntax) && (getFeatureCall().isExplicitOperationCallOrBuilderSyntax() == right.getFeature() instanceof JvmExecutable)) {
					return CandidateCompareResult.OTHER;
				}
			}
			// If the features have different names, it is possible to disambiguate them in the generated Java code
			// prefer the instance feature
			if (isStatic() != right.description.isStatic()) {
				if (isStatic()) {
					return CandidateCompareResult.OTHER;
				}
				return CandidateCompareResult.THIS;
			}
		} else if (right instanceof FeatureLinkingCandidate) {
			FeatureLinkingCandidate casted = (FeatureLinkingCandidate) right;
			// statically imported fields / methods are shadowed by local instance fields / methods
			if (getFeature() instanceof JvmField == casted.getFeature() instanceof JvmField) {
				if (isStatic()) {
					if (!casted.isStatic()) {
						return CandidateCompareResult.OTHER;
					}
				} else if (casted.isStatic()) {
					return CandidateCompareResult.THIS;
				}
				if (description.isValidStaticState() != right.description.isValidStaticState()) {
					if (description.isValidStaticState()) {
						return CandidateCompareResult.THIS;
					}
					return CandidateCompareResult.OTHER;
				}
			}
		}
		// for assignments we prefer fields, otherwise we use the explicitOperationCall flag to decide if we prefer exectuables
		if (!(getExpression() instanceof XAssignment) && isExplicitOperationCall()) {
			if (getFeature() instanceof JvmExecutable) {
				if (!(right.getFeature() instanceof JvmExecutable)) {
					return CandidateCompareResult.THIS;	
				}
			} else if (right.getFeature() instanceof JvmExecutable) {
				return CandidateCompareResult.OTHER;
			}
		} else {
			if (getFeature() instanceof JvmExecutable) {
				if (!(right.getFeature() instanceof JvmExecutable)) {
					return CandidateCompareResult.OTHER;	
				}
			} else if (right.getFeature() instanceof JvmExecutable) {
				return CandidateCompareResult.THIS;
			}
		}
		return CandidateCompareResult.AMBIGUOUS;
	}

	protected boolean isCompoundOperator() {
		if (!(getFeatureCall() instanceof XBinaryOperation)) {
			return false;
		}
		String methodName = getFeature().getSimpleName();
		return getState().getReferenceOwner().getServices().getOperatorMapping().isCompoundMethod(methodName);
	}

	@Override
	protected CandidateCompareResult compareByBucket(AbstractPendingLinkingCandidate<?> right) {
		if (isExtension() && right.isExtension()) {
			if (description.getShadowingKey().equals(right.description.getShadowingKey())) {
				if (description.getBucketId() == right.description.getBucketId()) {
					return CandidateCompareResult.AMBIGUOUS;
				}
				if (isAmbiguousExtensionProvider(right)) {
					return CandidateCompareResult.AMBIGUOUS;
				}
				return CandidateCompareResult.THIS;
			}
			return CandidateCompareResult.AMBIGUOUS;
		}
		return super.compareByBucket(right);
	}
	
	protected boolean isAmbiguousExtensionProvider(AbstractPendingLinkingCandidate<?> right) {
		XExpression implicitReceiver = getImplicitReceiver();
		if (implicitReceiver instanceof XAbstractFeatureCall) {
			XExpression otherImplicitReceiver = right.description.getImplicitReceiver();
			if (otherImplicitReceiver instanceof XAbstractFeatureCall) {
				JvmIdentifiableElement feature = ((XAbstractFeatureCall) implicitReceiver).getFeature();
				JvmIdentifiableElement otherFeature = ((XAbstractFeatureCall) otherImplicitReceiver).getFeature();
				// e.g. two local extension variables in same block
				if (feature.eContainer() == otherFeature.eContainer()) {
					return true;
				}
			}
		}
		return false;
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	protected CandidateCompareResult compareTo(AbstractPendingLinkingCandidate<?> right, boolean invalid) {
		CandidateCompareResult compareResult = compareByAssignmentName(right);
		switch(compareResult) {
			case SUSPICIOUS_OTHER:
				throw new IllegalStateException();
			case EQUALLY_INVALID:
				invalid = true;
				break;
			case OTHER:
			case THIS:
				return compareResult;
		}
		return super.compareTo(right, invalid);
	}
	
	protected CandidateCompareResult compareByAssignmentName(AbstractPendingLinkingCandidate<?> right) {
		if (getExpression() instanceof XAssignment) {
			if (isValidAssignmentName(description)) {
				if (!isValidAssignmentName(right.description)) {
					return CandidateCompareResult.THIS;
				}
			} else if (isValidAssignmentName(right.description)) {
				return CandidateCompareResult.OTHER;
			} else {
				return CandidateCompareResult.EQUALLY_INVALID;
			}
		}
		return CandidateCompareResult.AMBIGUOUS;
	}
	
	protected boolean isValidAssignmentName(IIdentifiableElementDescription description) {
		JvmIdentifiableElement candidate = description.getElementOrProxy();
		if (candidate.eClass() == TypesPackage.Literals.JVM_OPERATION) {
			if (candidate.getSimpleName().equals(description.getName().getFirstSegment())) {
				return false;
			} else if (!candidate.getSimpleName().startsWith("set")) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected CandidateCompareResult compareByArityWith(AbstractPendingLinkingCandidate<?> right) {
		CandidateCompareResult result = super.compareByArityWith(right);
		if (result == CandidateCompareResult.AMBIGUOUS) {
			boolean isExecutable = getFeature() instanceof JvmExecutable;
			if (isExecutable != right.getFeature() instanceof JvmExecutable && isVisible() == right.isVisible() && isTypeLiteral() == right.isTypeLiteral()) {
				// XAssignments return true from #isExplicitOperationCall though they may link to
				// a field or local variable
				if (!(getExpression() instanceof XAssignment) && isExplicitOperationCall()) {
					if (isExecutable)
						return CandidateCompareResult.THIS;
					return CandidateCompareResult.OTHER;
				}
			} else if (getFeature() == right.getFeature() && right instanceof FeatureLinkingCandidate) {
				FeatureLinkingCandidate casted = (FeatureLinkingCandidate) right;
				if (isStatic() && casted.isStatic()) {
					if (getImplicitReceiver() != casted.getImplicitReceiver()) {
						if (getImplicitReceiver() != null) {
							return CandidateCompareResult.OTHER;
						}
						return CandidateCompareResult.THIS;
					}
					// we link to identical static features with equal assumptions
					// stop comparison and take this one
					if (getReceiver() == casted.getReceiver() 
							&& isSyntacticReceiverPossibleArgument() == casted.isSyntacticReceiverPossibleArgument()) {
						return CandidateCompareResult.THIS; 
					}
				}
			}
		}
		return result;
	}
	
	@Override
	protected CandidateCompareResult compareByArgumentTypesFlags(
			AbstractPendingLinkingCandidate<?> right,
			int leftIdx,
			int rightIdx,
			int leftConformance,
			int rightConformance) {
		CandidateCompareResult result = super.compareByArgumentTypesFlags(right, leftIdx, rightIdx, leftConformance, rightConformance);
		if ((result != CandidateCompareResult.EQUALLY_INVALID && result != CandidateCompareResult.AMBIGUOUS) 
				|| ((leftConformance & ConformanceFlags.SUCCESS) != 0) || !(right instanceof FeatureLinkingCandidate))
			return result;
		// both types do not match - pick the one which is not an extension
		boolean firstArgumentMismatch = isFirstArgument(leftIdx);
		boolean rightFirstArgumentMismatch = ((FeatureLinkingCandidate) right).isFirstArgument(rightIdx);
		if (firstArgumentMismatch != rightFirstArgumentMismatch) {
			if (firstArgumentMismatch)
				return CandidateCompareResult.OTHER;
			return CandidateCompareResult.THIS;
		}
		return result;
	}
	
	protected boolean isFirstArgument(int argumentIndex) {
		if (argumentIndex > 1 || getFirstArgument() == null)
			return false;
		if (isStatic())
			return argumentIndex == 0;
		return argumentIndex == 1;
	}
	
	@Override
	protected CandidateCompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right, int leftBoxing, int rightBoxing, int leftDemand, int rightDemand) {
		if (leftDemand != rightDemand) {
			if (leftDemand < rightDemand)
				return CandidateCompareResult.THIS;
			return CandidateCompareResult.OTHER;
		}
		if (right instanceof FeatureLinkingCandidate) {
			FeatureLinkingCandidate casted = (FeatureLinkingCandidate) right;
			return compareByArgumentTypes(casted, leftBoxing, rightBoxing);
		}
		return compareByBoxing(leftBoxing, rightBoxing);
	}

	protected CandidateCompareResult compareByArgumentTypes(FeatureLinkingCandidate right, int leftBoxing, int rightBoxing) {
		if (isExtension() != right.isExtension()) {
			if (description.isValidStaticState() != right.description.isValidStaticState()) {
				if (description.isValidStaticState()) {
					return CandidateCompareResult.THIS;
				}
				return CandidateCompareResult.OTHER;
			}
			if (isExtension())
				return CandidateCompareResult.OTHER;
			return CandidateCompareResult.THIS;
		} else if (isExtension() && isStatic() != right.isStatic()){
			if (isStatic()) {
				return CandidateCompareResult.OTHER;
			}
			return CandidateCompareResult.THIS;
		}
		return compareByArgumentTypesAndStaticFlag(right, leftBoxing, rightBoxing);
	}

	protected CandidateCompareResult compareByArgumentTypesAndStaticFlag(FeatureLinkingCandidate right, int leftBoxing, int rightBoxing) {
		if (isStatic() != right.isStatic()) {
			if (isSyntacticReceiverPossibleArgument() != right.isSyntacticReceiverPossibleArgument()) {
				if (isStatic() && !isSyntacticReceiverPossibleArgument())
					return CandidateCompareResult.THIS;
				if (right.isStatic() && !right.isSyntacticReceiverPossibleArgument()) {
					return CandidateCompareResult.OTHER;
				}
			} else if (getFeature() instanceof JvmField == right.getFeature() instanceof JvmField) {
				if (isStatic()) {
					if (getImplicitReceiver() != null && right.getImplicitReceiver() == null) {
						return CandidateCompareResult.OTHER;
					}
				} else {
					if (getImplicitReceiver() != null && right.getImplicitReceiver() == null) {
						return CandidateCompareResult.THIS;
					}
				}
			}
		}
		return compareByBoxing(leftBoxing, rightBoxing);
	}
	
	@Override
	protected void preApply() {
		applyImplicitReceiver();
		super.preApply();
		XExpression implicitFirstArgument = getImplicitFirstArgument();
		if (implicitFirstArgument != null) {
			new ImplicitFirstArgument(getFeatureCall(), (XAbstractFeatureCall) implicitFirstArgument, getState()).applyToComputationState();
		}
		getState().markAsRefinedTypeIfNecessary(this);
		discardRefinementTypeIfReassigned();
	}
	
	protected void applyImplicitReceiver() {
		if (!isStatic()) {
			XExpression implicitReceiver = getImplicitReceiver();
			if (implicitReceiver != null) {
				ResolvedTypes resolvedTypes = getState().getResolvedTypes();
				LightweightTypeReference receiverType = getImplicitReceiverType();
				if (receiverType == null) {
					throw new IllegalStateException("Cannot determine the receiver's type");
				}
				LightweightTypeReference expectedReceiverType = new FeatureLinkHelper().getExpectedReceiverType(getFeature(), receiverType);
				if (expectedReceiverType != null)
					expectedReceiverType = expectedReceiverType.copyInto(resolvedTypes.getReferenceOwner());
				if (receiverType.isSynonym()) {
					receiverType = receiverType.getMultiTypeComponents().get(0);
				}
				TypeExpectation expectation = new TypeExpectation(expectedReceiverType, getState(), false);
				resolvedTypes.acceptType(implicitReceiver, expectation, receiverType.copyInto(resolvedTypes.getReferenceOwner()), false, ConformanceFlags.UNCHECKED);
				if (implicitReceiver instanceof XAbstractFeatureCall) {
					new ImplicitReceiver(getFeatureCall(), (XAbstractFeatureCall) implicitReceiver, getState()).applyToComputationState();
				} else {
					throw new IllegalStateException("unexpected implicit receiver, was: " + implicitReceiver);
				}
			}
		}
	}

	@Override
	protected void resolveAgainstActualType(LightweightTypeReference declaredType, LightweightTypeReference actualType, final AbstractTypeComputationState state) {
		super.resolveAgainstActualType(declaredType, actualType, state);
		if (!isStatic() || ((actualType.hasTypeArguments() || actualType.isArray()) && getDeclaredTypeParameters().isEmpty())) {
			DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(state.getReferenceOwner());
			collector.processPairedReferences(declaredType, actualType);
		}
	}

	@Override
	public XAbstractFeatureCall getFeatureCall() {
		return getExpression();
	}
	
	@Override
	protected List<JvmTypeReference> getPlainSyntacticTypeArguments() {
		return getFeatureCall().getTypeArguments();
	}
	
	@Override
	protected void resolveArgumentType(XExpression argument, /* @Nullable */ LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		if (argument == getSyntacticReceiverIfPossibleArgument()) {
			LightweightTypeReference receiverType = getSyntacticReceiverType();
			if (receiverType != null) {
				resolveKnownArgumentType(argument, receiverType, declaredType, argumentState);
			}
		} else if (argument == getImplicitFirstArgument()) {
			LightweightTypeReference argumentType = getImplicitFirstArgumentType();
			if (argumentType != null) {
				resolveKnownArgumentType(argument, argumentType, declaredType, argumentState);
			}
		} else {
			super.resolveArgumentType(argument, declaredType, argumentState);
		}
	}

	// TODO some code is duplicated in ResolvedFeature - extract delegator
	protected void resolveKnownArgumentType(XExpression argument, LightweightTypeReference knownType,
			/* @Nullable */ LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		if (!(argumentState instanceof AbstractLinkingCandidate.ArgumentTypeComputationState))
			throw new IllegalArgumentException("argumentState was " + argumentState);
		AbstractLinkingCandidate<?>.ArgumentTypeComputationState castedArgumentState = (AbstractLinkingCandidate<?>.ArgumentTypeComputationState) argumentState;
		ResolvedTypes resolvedTypes = getState().getResolvedTypes();
		LightweightTypeReference copiedDeclaredType = declaredType != null ? declaredType.copyInto(resolvedTypes.getReferenceOwner()) : null;
		TypeExpectation expectation = new TypeExpectation(copiedDeclaredType, castedArgumentState, false);
		LightweightTypeReference copiedReceiverType = knownType.copyInto(resolvedTypes.getReferenceOwner());
		// TODO should we use the result of #acceptType?
		int defaultFlags = castedArgumentState.getDefaultFlags();
		resolvedTypes.acceptType(argument, expectation, copiedReceiverType, false, ConformanceFlags.UNCHECKED | defaultFlags);
		if (copiedDeclaredType != null)
			resolveAgainstActualType(copiedDeclaredType, copiedReceiverType, castedArgumentState);
	}
	
	@Override
	protected void computeVarArgumentType(IFeatureCallArgumentSlot slot, TypeParameterSubstitutor<?> substitutor) {
		if (isExtension()) {
			List<XExpression> arguments = slot.getArgumentExpressions();
			if (arguments.size() == 1 && arguments.get(0) == getFirstArgument()) {
				computeFixedArityArgumentType(slot, substitutor);
				return;
			}
		}
		super.computeVarArgumentType(slot, substitutor);
	}
	
	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getDeclaratorParameterMapping() {
		if (isStatic()) {
			if (getFeature() instanceof JvmConstructor) // this() or super()
				return description.getImplicitReceiverTypeParameterMapping();
			return super.getDeclaratorParameterMapping();
		}
		if (getImplicitReceiver() != null)
			return description.getImplicitReceiverTypeParameterMapping();
		return description.getSyntacticReceiverTypeParameterMapping();
	}
	
	/* @Nullable */
	protected XExpression getReceiver() {
		if (isStatic())
			return null;
		XExpression result = getImplicitReceiver();
		if (result != null)
			return result;
		return getSyntacticReceiverIfPossibleArgument();
	}

	/* @Nullable */
	protected LightweightTypeReference getReceiverType() {
		if (isStatic())
			return null;
		LightweightTypeReference result;
		if (getImplicitReceiver() != null)
			result = getImplicitReceiverType();
		else
			result = getSyntacticReceiverType();
		return result;
	}
	
	protected int getReceiverConformanceFlags() {
		if (isStatic())
			throw new IllegalStateException();
		if (getImplicitReceiver() != null) {
			return description.getImplicitReceiverConformanceFlags();
		} else if (getSyntacticReceiverIfPossibleArgument() != null) {
			return description.getSyntacticReceiverConformanceFlags();
		}
		throw new IllegalStateException();
	}
	
	/**
	 * Returns the first argument if this is an extension. This may be
	 * the implicit first argument or the syntactic receiver of the feature call.
	 */
	/* @Nullable */
	protected XExpression getFirstArgument() {
		if (!isExtension())
			return null;
		XExpression firstArgument = getImplicitFirstArgument();
		if (firstArgument != null)
			return firstArgument;
		return getSyntacticReceiverIfPossibleArgument();
	}

	/* @Nullable */
	protected LightweightTypeReference getFirstArgumentType() {
		if (!isExtension())
			return null;
		LightweightTypeReference result = getImplicitFirstArgumentType();
		if (result != null)
			return result;
		return getSyntacticReceiverType();
	}
	
	/* @Nullable */
	protected XExpression getImplicitReceiver() {
		return description.getImplicitReceiver();
	}
	
	/* @Nullable */
	protected LightweightTypeReference getImplicitReceiverType() {
		return description.getImplicitReceiverType();
	}
	
	/* @Nullable */
	protected XExpression getSyntacticReceiver() {
		return description.getSyntacticReceiver();
	}
	
	/**
	 * Returns the syntactic receiver if it is an expression.
	 * Type literals are not considered to be expressions thus <code>null</code>
	 * is returned as the syntactic receiver of the expression <code>valueOf(..)</code>
	 * in <code>java.lang.String.valueOf(..)</code>.
	 */
	/* @Nullable */
	protected XExpression getSyntacticReceiverIfPossibleArgument() {
		if (description.isSyntacticReceiverPossibleArgument())
			return getSyntacticReceiver();
		return null;
	}
	
	/* @Nullable */
	protected LightweightTypeReference getSyntacticReceiverType() {
		return description.getSyntacticReceiverType();
	}
	
	/* @Nullable */
	protected XExpression getImplicitFirstArgument() {
		return description.getImplicitFirstArgument();
	}
	
	/* @Nullable */
	protected LightweightTypeReference getImplicitFirstArgumentType() {
		return description.getImplicitFirstArgumentType();
	}
	
	@Override
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		if (feature instanceof JvmConstructor) {
			return getState().getReferenceOwner().toLightweightTypeReference(getState().getTypeReferences().getTypeForName(Void.TYPE, feature));
		}
		/*
		 * The actual result type is Class<? extends |X|> where |X| is the erasure of 
		 * the static type of the expression on which getClass is called. For example, 
		 * no cast is required in this code fragment:
		 *   Number n = 0;
		 *   Class<? extends Number> c = n.getClass();
		 */
		if (isGetClass(feature)) {
			LightweightTypeReference receiverType = getReceiverType();
			if (receiverType == null) {
				throw new IllegalStateException("Cannot determine the receiver's type");
			}
			List<JvmType> rawTypes = receiverType.getRawTypes();
			if (rawTypes.isEmpty()) {
				return super.getDeclaredType(feature);
			}
			ITypeReferenceOwner owner = receiverType.getOwner();
			ParameterizedTypeReference result = owner.newParameterizedTypeReference(((JvmOperation) feature).getReturnType().getType());
			WildcardTypeReference wildcard = owner.newWildcardTypeReference();
			wildcard.addUpperBound(owner.toPlainTypeReference(rawTypes.get(0)));
			result.addTypeArgument(wildcard);
			return result;
		}
		return super.getDeclaredType(feature);
	}
	
	/**
	 * Returns <code>true</code> if the method {@link Class#getClass()} is bound and
	 * the receiver is a type literal. This may indicate a bug.
	 */
	protected boolean isGetClassOnTypeLiteral() {
		JvmIdentifiableElement feature = getFeature();
		if (isGetClass(feature)) {
			XExpression receiver = getSyntacticReceiver();
			if (receiver instanceof XAbstractFeatureCall) {
				IFeatureLinkingCandidate linkingCandidate = getState().getResolvedTypes().getLinkingCandidate((XAbstractFeatureCall) receiver);
				if (linkingCandidate != null && linkingCandidate.isTypeLiteral()) {
					return true;
				}
			}
		}
		return false;
	}
	
	protected boolean isGetClass(JvmIdentifiableElement feature) {
		if (feature instanceof JvmOperation && feature.getSimpleName().equals("getClass")) {
			JvmOperation getClassOperation = (JvmOperation) feature;
			if (getClassOperation.getParameters().isEmpty() && "java.lang.Object".equals(getClassOperation.getDeclaringType().getIdentifier())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void applyToModel(IResolvedTypes resolvedTypes) {
		resolveLinkingProxy(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE);
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XMemberFeatureCall) {
			XMemberFeatureCall casted = (XMemberFeatureCall) featureCall;
			XExpression syntacticReceiver = casted.getMemberCallTarget();
			if (isStaticWithDeclaringType(syntacticReceiver) || isThisOrSuper()) {
				casted.setStaticWithDeclaringType(true);
			}
		} else if (featureCall instanceof XAssignment) {
			XAssignment casted = (XAssignment) featureCall;
			XExpression syntacticReceiver = casted.getAssignable();
			if (isStaticWithDeclaringType(syntacticReceiver)) {
				casted.setStaticWithDeclaringType(true);
			}
		} else if (featureCall instanceof XBinaryOperation) {
			XBinaryOperation binaryOperation = (XBinaryOperation) featureCall;
			CommonTypeComputationServices services = getState().getReferenceOwner().getServices();
			OperatorMapping operatorMapping = services.getOperatorMapping();
			if (operatorMapping.getCompoundOperators().contains(description.getName())) {
				JvmIdentifiableElement feature = description.getElementOrProxy();
				String methodName = feature.getSimpleName();
				if (operatorMapping.isCompoundMethod(methodName)) {
					XExpressionHelper expressionHelper = services.getExpressionHelper();
					if (expressionHelper.findReassignFirstArgumentAnnotation(feature) != null) {
						binaryOperation.setReassignFirstArgument(true);
					}
				} else {
					binaryOperation.setReassignFirstArgument(true);
				}
			}
		}
	}
	
	private boolean isThisOrSuper() {
		if ((THIS.equals(description.getName()) || SUPER.equals(description.getName())) && (description.getElementOrProxy() instanceof JvmType) && !isSyntacticReceiverPossibleArgument()) {
			return true;
		}
		return false;
	}
	
	private boolean isStaticWithDeclaringType(XExpression syntacticReceiver) {
		if (isStatic() && syntacticReceiver instanceof XAbstractFeatureCall && !isExtension()) {
			IFeatureLinkingCandidate candidate = getState().getResolvedTypes().getLinkingCandidate((XAbstractFeatureCall) syntacticReceiver);
			if (candidate != null && candidate.isTypeLiteral()) {
				return true;
			}
		}
		return false;
	}
 	
	@Override
	protected Severity getUnhandledExceptionSeverity(JvmExecutable executable) {
		if (getFeature() instanceof JvmConstructor) {
			return Severity.ERROR;
		}
		return super.getUnhandledExceptionSeverity(executable);
	}

}
