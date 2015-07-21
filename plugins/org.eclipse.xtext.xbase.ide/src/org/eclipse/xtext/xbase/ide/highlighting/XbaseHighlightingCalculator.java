/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
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
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;

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
			operationCanceledManager.checkCanceled(cancelIndicator);
			computeFeatureCallHighlighting((XAbstractFeatureCall) object, acceptor);
		} else if (object instanceof XNumberLiteral) {
			highlightNumberLiterals((XNumberLiteral) object, acceptor);
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
	
	protected void highlightReferenceJvmType(IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject, String highlightingConfiguration) {
		highlightDeprecation(acceptor, referencer, reference, resolvedReferencedObject);
		if (resolvedReferencedObject instanceof JvmAnnotationType) {
			highlightFeature(acceptor, referencer, reference, highlightingConfiguration);
		}
	}

	protected void highlightDeprecation(IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject) {
		if (resolvedReferencedObject instanceof JvmAnnotationTarget) {
			JvmAnnotationTarget annoTarget = (JvmAnnotationTarget) resolvedReferencedObject;
			if(DeprecationUtil.isDeprecated(annoTarget))
				highlightFeature(acceptor, referencer, reference, DEPRECATED_MEMBERS);
		}
	}

	protected void computeFeatureCallHighlighting(XAbstractFeatureCall featureCall, IHighlightedPositionAcceptor acceptor) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature != null && !feature.eIsProxy()) {
			if (feature instanceof JvmField) {
				if (((JvmField) feature).isStatic()) {
					highlightFeatureCall(featureCall, acceptor, STATIC_FIELD);
				} else {
					highlightFeatureCall(featureCall, acceptor, FIELD);
				}
			} else if (feature instanceof JvmOperation && !featureCall.isOperation()) {
				JvmOperation jvmOperation = (JvmOperation) feature;
				if (jvmOperation.isStatic())
					highlightFeatureCall(featureCall, acceptor, STATIC_METHOD_INVOCATION);
			}
			if(!(featureCall instanceof XBinaryOperation || featureCall instanceof XUnaryOperation || featureCall instanceof XPostfixOperation)) {
				if(featureCall.isExtension()){
					highlightFeatureCall(featureCall, acceptor, 
							EXTENSION_METHOD_INVOCATION);
				} else {
					// Extensions without implicit first argument
					XExpression implicitReceiver = featureCall.getImplicitReceiver();
					if(implicitReceiver != null && implicitReceiver instanceof XAbstractFeatureCall){
							if(isExtension(((XAbstractFeatureCall) implicitReceiver).getFeature()))
								highlightFeatureCall(featureCall, acceptor, 
										EXTENSION_METHOD_INVOCATION);
					}
				}	
			}
			if(feature instanceof JvmAnnotationTarget && DeprecationUtil.isDeprecated((JvmAnnotationTarget)feature)){
				highlightFeatureCall(featureCall, acceptor, DEPRECATED_MEMBERS);
			}
		}
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
	
	protected void highlightNumberLiterals(XNumberLiteral literal, IHighlightedPositionAcceptor acceptor) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(literal);
		ITextRegion textRegion = node.getTextRegion();
		acceptor.addPosition(textRegion.getOffset(), textRegion.getLength(), NUMBER_ID);
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
		result.put("this", KEYWORD_ID);
		result.put("it", KEYWORD_ID);
		result.put("self", KEYWORD_ID);
		return result;
	}
}
