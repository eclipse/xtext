/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.highlighting;

import java.util.BitSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.xtext.common.types.util.DeprecationUtil;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
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
public class XbaseHighlightingCalculator implements ISemanticHighlightingCalculator {

	@Inject
	private XbaseGrammarAccess grammarAccess;

	private Map<String, String> highlightedIdentifiers;
	
	private BitSet idLengthsToHighlight;

	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
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
		doProvideHighlightingFor(resource, acceptor);
	}
	
	/**
	 * <p>
	 * Actual implementation of the semantic highlighting calculation. It is ensured, that the given resource is not
	 * <code>null</code> and refers to an initialized parse result.
	 * </p>
	 * <p>
	 * Clients should override this method in order to perform custom highlighting.
	 * </p>
	 * 
	 * @param resource
	 *            a valid to-be-processed resource. Is never <code>null</code>.
	 * @param acceptor
	 *            the acceptor. Is never <code>null</code>.
	 */
	protected void doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null)
			throw new IllegalStateException("resource#parseResult may not be null");
		ICompositeNode node = parseResult.getRootNode();
		highlightSpecialIdentifiers(acceptor, node);
		searchAndHighlightElements(resource, acceptor);
	}

	protected void searchAndHighlightElements(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		TreeIterator<EObject> iterator = EcoreUtil2.eAll(resource.getParseResult().getRootASTElement());
		while (iterator.hasNext()) {
			EObject object = iterator.next();
			if (object instanceof XAbstractFeatureCall) {
				if (((XAbstractFeatureCall) object).isPackageFragment()) {
					iterator.prune();
					continue;
				}
				computeFeatureCallHighlighting((XAbstractFeatureCall) object, acceptor);
			}
			// Handle XAnnotation in a special way because we want the @ highlighted too
			if (object instanceof XNumberLiteral) {
				highlightNumberLiterals((XNumberLiteral) object, acceptor);
			} if (object instanceof XAnnotation) {
				highlightAnnotation((XAnnotation) object, acceptor);
			} else {
				computeReferencedJvmTypeHighlighting(acceptor, object);
			}
		}
	}

	protected void computeReferencedJvmTypeHighlighting(IHighlightedPositionAcceptor acceptor, EObject referencer) {
		for (EReference reference : referencer.eClass().getEAllReferences()) {
			EClass referencedType = reference.getEReferenceType();
			if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_TYPE, referencedType)) {
				List<EObject> referencedObjects = EcoreUtil2.getAllReferencedObjects(referencer, reference);
				for (EObject referencedObject : referencedObjects) {
					EObject resolvedReferencedObject = EcoreUtil.resolve(referencedObject, referencer);
					if(resolvedReferencedObject != null && !resolvedReferencedObject.eIsProxy()){
						highlightReferenceJvmType(acceptor, referencer, reference, resolvedReferencedObject);
					}
				}
			}
		}
	}

	protected void highlightReferenceJvmType(IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject) {
		highlightDeprecation(acceptor, referencer, reference, resolvedReferencedObject);
		if (resolvedReferencedObject instanceof JvmAnnotationType){
			highlightObjectAtFeature(acceptor, referencer, reference, XbaseHighlightingConfiguration.ANNOTATION);
		}
	}

	protected void highlightDeprecation(IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject) {
		if (resolvedReferencedObject instanceof JvmAnnotationTarget) {
			JvmAnnotationTarget annoTarget = (JvmAnnotationTarget) resolvedReferencedObject;
			if(DeprecationUtil.isDeprecated(annoTarget))
				highlightObjectAtFeature(acceptor, referencer, reference, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
		}
	}

	protected void computeFeatureCallHighlighting(XAbstractFeatureCall featureCall, IHighlightedPositionAcceptor acceptor) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature != null && !feature.eIsProxy()) {
			if (feature instanceof JvmField) {
				if (((JvmField) feature).isStatic()) {
					highlightFeatureCall(featureCall, acceptor, XbaseHighlightingConfiguration.STATIC_FIELD);
				} else {
					highlightFeatureCall(featureCall, acceptor, XbaseHighlightingConfiguration.FIELD);
				}
			} else if (feature instanceof JvmOperation && !featureCall.isOperation()) {
				JvmOperation jvmOperation = (JvmOperation) feature;
				if (jvmOperation.isStatic())
					highlightFeatureCall(featureCall, acceptor, XbaseHighlightingConfiguration.STATIC_METHOD_INVOCATION);
			}
			XExpression implicitReceiver = featureCall.getImplicitReceiver();
			if (featureCall instanceof  XMemberFeatureCall){
				XMemberFeatureCall casted = (XMemberFeatureCall) featureCall;
				if(!feature.eIsProxy() && feature instanceof JvmOperation){
					if(((JvmOperation) feature).isStatic() && !casted.isStaticWithDeclaringType()){
							highlightFeatureCall(featureCall, acceptor, 
								XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
					}
					if(implicitReceiver != null){
							highlightFeatureCall(featureCall, acceptor, 
								XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
					}
				}
			}
			if((featureCall instanceof XAssignment && ((XAssignment)featureCall).getValue() != null)){
				if(!feature.eIsProxy() && feature instanceof JvmOperation){
					if(implicitReceiver instanceof XMemberFeatureCall){
						if(((XMemberFeatureCall) implicitReceiver).getFeature() instanceof JvmField)
							highlightFeatureCall(featureCall, acceptor, 
									XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
					}
				}
			}
			if (featureCall instanceof XFeatureCall){
				if(!feature.eIsProxy() && feature instanceof JvmOperation){
					if((implicitReceiver != null && ((JvmOperation) feature).isStatic()))
							highlightFeatureCall(featureCall, acceptor, 
									XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
				}
			}
			if (featureCall instanceof XFeatureCall || featureCall instanceof XAssignment) {
				if(!feature.eIsProxy() && feature instanceof JvmOperation){
					if(featureCall.getImplicitFirstArgument() != null){
						highlightFeatureCall(featureCall, acceptor, 
								XbaseHighlightingConfiguration.EXTENSION_METHOD_INVOCATION);
					}
				}
			}
			if(feature instanceof JvmAnnotationTarget && DeprecationUtil.isDeprecated((JvmAnnotationTarget)feature)){
				highlightFeatureCall(featureCall, acceptor, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
			}
		}
	}

	protected void highlightFeatureCall(XAbstractFeatureCall featureCall, IHighlightedPositionAcceptor acceptor, String id) {
//		highlightDeprecation(acceptor, featureCall, null, featureCall.getFeature());
		if (featureCall.isTypeLiteral()) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(featureCall);
			highlightNode(node, id, acceptor);
		} else {
			highlightObjectAtFeature(acceptor, featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, id);
		}
	}
	
	protected void highlightAnnotation(XAnnotation annotation, IHighlightedPositionAcceptor acceptor) {
		JvmType annotationType = annotation.getAnnotationType();
		if (annotationType != null && !annotationType.eIsProxy() && annotationType instanceof JvmAnnotationType) {
			ICompositeNode xannotationNode = NodeModelUtils.findActualNodeFor(annotation);
			if (xannotationNode != null) {
				ILeafNode firstLeafNode = NodeModelUtils.findLeafNodeAtOffset(xannotationNode, xannotationNode.getOffset() );
				if(firstLeafNode != null)
					highlightNode(firstLeafNode, XbaseHighlightingConfiguration.ANNOTATION, acceptor);
			}
			highlightReferenceJvmType(acceptor, annotation, XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, annotationType);
		}
	}
	
	protected void highlightNumberLiterals(XNumberLiteral literal, IHighlightedPositionAcceptor acceptor) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(literal);
		ITextRegion textRegion = node.getTextRegion();
		acceptor.addPosition(textRegion.getOffset(), textRegion.getLength(), DefaultHighlightingConfiguration.NUMBER_ID);
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
			result.put(p.name().toLowerCase(), DefaultHighlightingConfiguration.KEYWORD_ID);
		}
		result.put("this", DefaultHighlightingConfiguration.KEYWORD_ID);
		result.put("it", DefaultHighlightingConfiguration.KEYWORD_ID);
		result.put("self", DefaultHighlightingConfiguration.KEYWORD_ID);
		return result;
	}

	/**
	 * Highlights an object at the position of the given {@link EStructuralFeature}
	 */
	protected void highlightObjectAtFeature(IHighlightedPositionAcceptor acceptor, EObject object, EStructuralFeature feature, String id) {
		List<INode> children = NodeModelUtils.findNodesForFeature(object, feature);
		if (children.size() > 0)
			highlightNode(children.get(0), id, acceptor);
	}
	
	/**
	 * Highlights the non-hidden parts of {@code node} with the style that is associated with {@code id}.
	 */
	protected void highlightNode(INode node, String id, IHighlightedPositionAcceptor acceptor) {
		if (node == null)
			return;
		if (node instanceof ILeafNode) {
			ITextRegion textRegion = node.getTextRegion();
			acceptor.addPosition(textRegion.getOffset(), textRegion.getLength(), id);
		} else {
			for (ILeafNode leaf : node.getLeafNodes()) {
				if (!leaf.isHidden()) {
					ITextRegion leafRegion = leaf.getTextRegion();
					acceptor.addPosition(leafRegion.getOffset(), leafRegion.getLength(), id);
				}
			}
		}
	}
}
