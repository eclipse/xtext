/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide.highlighting;

import java.util.BitSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.AnnotationLookup;
import org.eclipse.xtext.common.types.util.DeprecationUtil;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xtype.XImportDeclaration;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * <p>
 * A base implementation of the semantic highlighting calculation.
 * </p>
 * 
 * <p>
 * Highlights references to {@link Primitives}, e.g. <code>void, int, boolean</code> and the identifier
 * <code>this</code>.
 * </p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class XbaseHighlightingCalculator extends DefaultSemanticHighlightingCalculator implements XbaseHighlightingStyles {

	@Inject
	private XbaseGrammarAccess grammarAccess;
	
	@Inject
	protected AnnotationLookup annotationLookup;
	
	@Inject
	protected OperationCanceledManager operationCanceledManager;
	
	private Map<String, String> highlightedIdentifiers;
	
	private BitSet idLengthsToHighlight;

	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (resource == null)
			return;
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null || parseResult.getRootASTElement() == null)
			return;
		if (highlightedIdentifiers == null) {
			highlightedIdentifiers = initializeHighlightedIdentifiers();
			idLengthsToHighlight = new BitSet();
			for (String s : highlightedIdentifiers.keySet()) {
				idLengthsToHighlight.set(s.length());
			}
		}
		//TODO remove this check when the typesystem works without a java project
		if (resource.isValidationDisabled()) {
			highlightSpecialIdentifiers(acceptor, parseResult.getRootNode());
			return;
		}
		doProvideHighlightingFor(resource, acceptor, cancelIndicator);
	}
	
	@Override
	protected void doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null)
			throw new IllegalStateException("resource#parseResult may not be null");
		ICompositeNode node = parseResult.getRootNode();
		highlightSpecialIdentifiers(acceptor, node);
		super.doProvideHighlightingFor(resource, acceptor, cancelIndicator);
	}

	@Override
	protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if (object instanceof XAbstractFeatureCall) {
			if (((XAbstractFeatureCall) object).isPackageFragment()) {
				return true;
			}
			if (SPECIAL_FEATURE_NAMES.contains(((XAbstractFeatureCall) object).getConcreteSyntaxFeatureName())) {
				return false;
			}
			operationCanceledManager.checkCanceled(cancelIndicator);
			computeFeatureCallHighlighting((XAbstractFeatureCall) object, acceptor);
		} else if (object instanceof JvmTypeParameter) {
			highlightTypeParameter((JvmTypeParameter) object, acceptor);
		} else if (object instanceof JvmFormalParameter) {
			highlightFormalParameter((JvmFormalParameter) object, acceptor);
		} else if (object instanceof XVariableDeclaration) {
			highlightVariableDeclaration((XVariableDeclaration) object, acceptor);
		} else if (object instanceof XNumberLiteral) {
			highlightNumberLiterals((XNumberLiteral) object, acceptor);
		} else if (object instanceof XConstructorCall) {
			highlightConstructorCall((XConstructorCall) object, acceptor);
		} else if (object instanceof XAnnotation) {
			// Handle XAnnotation in a special way because we want the @ highlighted too
			highlightAnnotation((XAnnotation) object, acceptor);
		} else {
			computeReferencedJvmTypeHighlighting(acceptor, object, cancelIndicator);
		}
		return false;
	}

	protected void computeReferencedJvmTypeHighlighting(IHighlightedPositionAcceptor acceptor, EObject referencer,
			CancelIndicator cancelIndicator) {
		for (EReference reference : referencer.eClass().getEAllReferences()) {
			EClass referencedType = reference.getEReferenceType();
			if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_TYPE, referencedType)) {
				List<EObject> referencedObjects = EcoreUtil2.getAllReferencedObjects(referencer, reference);
				if (referencedObjects.size() > 0)
					operationCanceledManager.checkCanceled(cancelIndicator);
				for (EObject referencedObject : referencedObjects) {
					EObject resolvedReferencedObject = EcoreUtil.resolve(referencedObject, referencer);
					if (resolvedReferencedObject != null && !resolvedReferencedObject.eIsProxy()) {
						highlightReferenceJvmType(acceptor, referencer, reference, resolvedReferencedObject);
					}
				}
			}
		}
	}

	protected void highlightReferenceJvmType(IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject) {
		highlightReferenceJvmType(acceptor, referencer, reference, resolvedReferencedObject, ANNOTATION);
	}
	
	/**
	 * @deprecated override {@link #highlightReferenceJvmType(IHighlightedPositionAcceptor, EObject, EReference, EObject)}
	 * 		or {@link #highlightFeature(IHighlightedPositionAcceptor, EObject, org.eclipse.emf.ecore.EStructuralFeature, String...)}
	 * 		in order to customize the coloring of references of {@link JvmType JvmTypes}.
	 */
	@Deprecated
	protected void highlightReferenceJvmType(IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject, String highlightingConfiguration) {
		highlightDeprecation(acceptor, referencer, reference, resolvedReferencedObject);
		
		final Object referencersContainingFeature = referencer.eContainingFeature();
		
		if (resolvedReferencedObject instanceof JvmTypeParameter) {
			// may happen in cast expressions
			highlightFeature(acceptor, referencer, reference, TYPE_VARIABLE);
			
		} else if (referencer instanceof JvmParameterizedTypeReference
					&& (referencersContainingFeature == TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS
							|| referencersContainingFeature == TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE
							|| referencersContainingFeature == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS
							|| referencersContainingFeature == XbasePackage.Literals.XCONSTRUCTOR_CALL__TYPE_ARGUMENTS)) {
			// case 1: 'referencer' is a type reference within the arguments reference of another (parameterized) type reference
			//  'referencer' definitely is a type argument and to be colored as such
			//  (if 'resolvedReferencedObject' is not a type parameter, which is tested above)
			// case 2: type reference is nested in a JvmWildcardTypeReference -> JvmTypeConstraint
			// case 3: the type reference is part of the type arguments of a method call
			
			if (resolvedReferencedObject instanceof JvmEnumerationType) {
				highlightFeature(acceptor, referencer, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, ENUM);
				
			} else if (resolvedReferencedObject instanceof JvmGenericType) {
				highlightFeature(acceptor, referencer, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, getStyle((JvmGenericType) resolvedReferencedObject));
				
			} else if (resolvedReferencedObject instanceof JvmAnnotationType) {
				highlightFeature(acceptor, referencer, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, highlightingConfiguration);
			}
			highlightFeature(acceptor, referencer, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, TYPE_ARGUMENT);
			
		} else if (resolvedReferencedObject instanceof JvmDeclaredType) {
			if (referencer instanceof XImportDeclaration) {
				// don't highlight import statements
				return;
				
			} else if (resolvedReferencedObject instanceof JvmEnumerationType) {
				highlightFeature(acceptor, referencer, reference, ENUM);
				
			} else if (resolvedReferencedObject instanceof JvmGenericType) {
				highlightFeature(acceptor, referencer, reference, getStyle((JvmGenericType) resolvedReferencedObject));
				
			} else if (resolvedReferencedObject instanceof JvmAnnotationType) {
				highlightFeature(acceptor, referencer, reference, highlightingConfiguration);
			}
		}
	}

	protected void highlightDeprecation(IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject) {
		if (resolvedReferencedObject instanceof JvmAnnotationTarget) {
			JvmAnnotationTarget annoTarget = (JvmAnnotationTarget) resolvedReferencedObject;
			if(DeprecationUtil.isTransitivelyDeprecated(annoTarget))
				highlightFeature(acceptor, referencer, reference, DEPRECATED_MEMBERS);
		}
	}


	protected void computeFeatureCallHighlighting(XAbstractFeatureCall featureCall, IHighlightedPositionAcceptor acceptor) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature != null && !feature.eIsProxy()) {
			
			if (feature instanceof XVariableDeclaration) {
				if (!SPECIAL_FEATURE_NAMES.contains(((XVariableDeclaration) feature).getName())) {
					// highlighting of special identifiers is done separately, so it's omitted here 
					highlightFeatureCall(featureCall, acceptor, LOCAL_VARIABLE);
					
					if (!((XVariableDeclaration) feature).isWriteable()) {
						highlightFeatureCall(featureCall, acceptor, LOCAL_FINAL_VARIABLE);
					}
				}
				
			} else if (feature instanceof JvmFormalParameter) {
				if (!SPECIAL_FEATURE_NAMES.contains(((JvmFormalParameter) feature).getName())) {
					// highlighting of special identifiers is done separately, so it's omitted here 
					final EObject eContainingFeature = feature.eContainingFeature();
					
					if (eContainingFeature == TypesPackage.Literals.JVM_EXECUTABLE__PARAMETERS
							|| eContainingFeature == XbasePackage.Literals.XCLOSURE__DECLARED_FORMAL_PARAMETERS) {
						// which is the case for constructors and methods
						highlightFeatureCall(featureCall, acceptor, PARAMETER_VARIABLE);
					} else {
						// covers parameters of for and template expr FOR loops, as well as switch statements
						highlightFeatureCall(featureCall, acceptor, LOCAL_VARIABLE);
						highlightFeatureCall(featureCall, acceptor, LOCAL_FINAL_VARIABLE);
					}
				}
				
			} else if (feature instanceof JvmTypeParameter) {
				highlightFeatureCall(featureCall, acceptor, TYPE_VARIABLE);
				
			} else if (feature instanceof JvmField) {
				highlightFeatureCall(featureCall, acceptor, FIELD);
				
				if (((JvmField) feature).isStatic()) {
					highlightFeatureCall(featureCall, acceptor, STATIC_FIELD);
					
					if (((JvmField) feature).isFinal()) {
						highlightFeatureCall(featureCall, acceptor, STATIC_FINAL_FIELD);
					}
				}
				
			} else if (feature instanceof JvmOperation && !featureCall.isOperation()) {
				JvmOperation jvmOperation = (JvmOperation) feature;
				
				highlightFeatureCall(featureCall, acceptor, METHOD);
				
				if (jvmOperation.isAbstract()) {
					highlightFeatureCall(featureCall, acceptor, ABSTRACT_METHOD_INVOCATION);
				}
				
				if (jvmOperation.isStatic()) {
					highlightFeatureCall(featureCall, acceptor, STATIC_METHOD_INVOCATION);
				}
				
				if (featureCall.isExtension() || isExtensionWithImplicitFirstArgument(featureCall)) {
					highlightFeatureCall(featureCall, acceptor, EXTENSION_METHOD_INVOCATION);
				}
				
			} else if (feature instanceof JvmDeclaredType) {
				highlightReferenceJvmType(acceptor, featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, feature);
			}
			
			if(feature instanceof JvmAnnotationTarget && DeprecationUtil.isTransitivelyDeprecated((JvmAnnotationTarget)feature)){
				highlightFeatureCall(featureCall, acceptor, DEPRECATED_MEMBERS);
			}
		}
	}
	
	protected boolean isExtensionWithImplicitFirstArgument(XAbstractFeatureCall featureCall) {
		XExpression implicitReceiver = featureCall.getImplicitReceiver();
		return implicitReceiver instanceof XAbstractFeatureCall
				&& isExtension(((XAbstractFeatureCall) implicitReceiver).getFeature());
	}
	
	protected boolean isExtension(JvmIdentifiableElement jvmIdentifiableElement){
		if(jvmIdentifiableElement instanceof JvmAnnotationTarget){
			return annotationLookup.findAnnotation((JvmAnnotationTarget) jvmIdentifiableElement, Extension.class) != null;
		}
		return false;
	}

	protected void highlightFeatureCall(XAbstractFeatureCall featureCall, IHighlightedPositionAcceptor acceptor, String id) {
//		highlightDeprecation(acceptor, featureCall, null, featureCall.getFeature());
		if (featureCall.isTypeLiteral()) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(featureCall);
			highlightNode(acceptor, node, id);
		} else {
			highlightFeature(acceptor, featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, id);
		}
	}
	
	protected void highlightAnnotation(XAnnotation annotation, IHighlightedPositionAcceptor acceptor) {
		highlightAnnotation(annotation, acceptor, ANNOTATION);
	}
	
	protected void highlightAnnotation(XAnnotation annotation, IHighlightedPositionAcceptor acceptor, String highlightingConfiguration) {
		JvmType annotationType = annotation.getAnnotationType();
		if (annotationType != null && !annotationType.eIsProxy() && annotationType instanceof JvmAnnotationType) {
			ICompositeNode xannotationNode = NodeModelUtils.findActualNodeFor(annotation);
			if (xannotationNode != null) {
				ILeafNode firstLeafNode = NodeModelUtils.findLeafNodeAtOffset(xannotationNode, xannotationNode.getOffset() );
				if(firstLeafNode != null)
					highlightNode(acceptor, firstLeafNode, highlightingConfiguration);
			}
			highlightReferenceJvmType(acceptor, annotation, XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, annotationType, highlightingConfiguration);
		}
	}
	
	protected void highlightFormalParameter(JvmFormalParameter parameterDecl, IHighlightedPositionAcceptor acceptor) {
		if (!SPECIAL_FEATURE_NAMES.contains(parameterDecl.getName())) {
			// highlighting of special identifiers is done separately, so it's omitted here 
			if (parameterDecl.eContainingFeature() == XbasePackage.Literals.XCLOSURE__DECLARED_FORMAL_PARAMETERS) {
				highlightFeature(acceptor, parameterDecl, TypesPackage.Literals.JVM_FORMAL_PARAMETER__NAME, PARAMETER_VARIABLE);
			} else {
				// covers parameters of for and template expr FOR loops, as well as switch statements
				highlightFeature(acceptor, parameterDecl, TypesPackage.Literals.JVM_FORMAL_PARAMETER__NAME, LOCAL_VARIABLE_DECLARATION);
				highlightFeature(acceptor, parameterDecl, TypesPackage.Literals.JVM_FORMAL_PARAMETER__NAME, LOCAL_FINAL_VARIABLE_DECLARATION);
			}
		}
	}
	
	protected void highlightVariableDeclaration(XVariableDeclaration varDecl, IHighlightedPositionAcceptor acceptor) {
		if (!SPECIAL_FEATURE_NAMES.contains(varDecl.getName())) {
			// highlighting of special identifiers is done separately, so it's omitted here 
			highlightFeature(acceptor, varDecl, XbasePackage.Literals.XVARIABLE_DECLARATION__NAME, LOCAL_VARIABLE_DECLARATION);
			if (!varDecl.isWriteable()) {
				highlightFeature(acceptor, varDecl, XbasePackage.Literals.XVARIABLE_DECLARATION__NAME, LOCAL_FINAL_VARIABLE_DECLARATION);
			}
		}
	}
	
	protected void highlightNumberLiterals(XNumberLiteral literal, IHighlightedPositionAcceptor acceptor) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(literal);
		ITextRegion textRegion = node.getTextRegion();
		acceptor.addPosition(textRegion.getOffset(), textRegion.getLength(), NUMBER_ID);
	}
	
	protected void highlightConstructorCall(XConstructorCall constructorCall, IHighlightedPositionAcceptor acceptor) {
		if (constructorCall.getConstructor() != null && !constructorCall.getConstructor().eIsProxy()) {
			EObject declaringType = constructorCall.getConstructor().getDeclaringType();
			if (declaringType instanceof JvmGenericType) {
				highlightFeature(acceptor, constructorCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, getStyle((JvmGenericType) declaringType));
			}
		}
	}
	
	protected String getStyle(JvmGenericType type) {
		if (type.isInterface()) {
			return INTERFACE;
		} else if (type.isAbstract()) {
			return ABSTRACT_CLASS;
		} else {
			return CLASS;
		}
	}

	
	protected void highlightTypeParameter(JvmTypeParameter typeParameter, IHighlightedPositionAcceptor acceptor) {
		highlightFeature(acceptor, typeParameter, TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME, TYPE_VARIABLE);
	}
	
	protected void highlightSpecialIdentifiers(IHighlightedPositionAcceptor acceptor, ICompositeNode root) {
		TerminalRule idRule = getIDRule();
		for (ILeafNode leaf : root.getLeafNodes()) {
			if (!leaf.isHidden()) {
				highlightSpecialIdentifiers(leaf, acceptor, idRule);
			}
		}
	}

	protected TerminalRule getIDRule() {
		return grammarAccess.getIDRule();
	}

	protected void highlightSpecialIdentifiers(ILeafNode leafNode, IHighlightedPositionAcceptor acceptor,
			TerminalRule idRule) {
		ITextRegion leafRegion = leafNode.getTextRegion();
		if (idLengthsToHighlight.get(leafRegion.getLength())) {
			EObject element = leafNode.getGrammarElement();
			if (element == idRule || (element instanceof RuleCall && ((RuleCall) element).getRule() == idRule)) {
				String text = leafNode.getText();
				String highlightingID = highlightedIdentifiers.get(text);
				if (highlightingID != null) {
					acceptor.addPosition(leafRegion.getOffset(), leafRegion.getLength(), highlightingID);
				}
			}
		}
	}

	/**
	 * A list of special feature names. Although 'super' is a keyword in the grammar it is contained
	 *  here since this list is used for black list filtering, too.
	 */
	protected static final List<String> SPECIAL_FEATURE_NAMES = Lists.newArrayList(
			IFeatureNames.THIS.getFirstSegment(), IFeatureNames.SUPER.getFirstSegment(),
			IFeatureNames.IT.getFirstSegment(), IFeatureNames.SELF.getFirstSegment());
	
	/**
	 * Returns a mapping from identifier (e.g. 'void', 'int', 'this') to highlighting ID. May not return
	 * <code>null</code>.
	 * 
	 * @return a mapping from identifier (e.g. 'void', 'int', 'this') to highlighting ID.
	 */
	protected Map<String, String> initializeHighlightedIdentifiers() {
		Map<String, String> result = Maps.newHashMap();
		for (Primitive p : Primitives.Primitive.values()) {
			result.put(p.name().toLowerCase(), KEYWORD_ID);
		}
		for (String name : SPECIAL_FEATURE_NAMES) {
			result.put(name, KEYWORD_ID);
		}
		return result;
	}
}
