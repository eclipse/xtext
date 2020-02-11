/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.highlighting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;

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
 * 
 * @deprecated use org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator instead
 */
@Deprecated
public class XbaseHighlightingCalculator extends org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator implements ISemanticHighlightingCalculator {

	/**
	 * @since 2.9
	 */
	@Override
	public void provideHighlightingFor(XtextResource resource,
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		provideHighlightingFor(resource, cast(acceptor));
	}
	
	/**
	 * @since 2.9
	 */
	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		super.provideHighlightingFor(resource, upcast(acceptor), CancelIndicator.NullImpl);
	}
	
	/**
	 * @since 2.9
	 */
	@Override
	protected void doProvideHighlightingFor(XtextResource resource,
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		doProvideHighlightingFor(resource, cast(acceptor));
	}

	/**
	 * @since 2.9
	 */
	@Override
	protected void searchAndHighlightElements(XtextResource resource,
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		searchAndHighlightElements(resource, cast(acceptor));
	}

	/**
	 * @since 2.9
	 */
	@Override
	protected void highlightElementRecursively(EObject element,
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		highlightElementRecursively(element, cast(acceptor));
	}

	/**
	 * @since 2.9
	 */
	@Override
	protected boolean highlightElement(EObject object, org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		return highlightElement(object, cast(acceptor));
	}

	/**
	 * @since 2.9
	 */
	@Override
	protected void highlightTasks(XtextResource resource, org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor) {
		highlightTasks(resource, cast(acceptor));
	}

	/**
	 * @since 2.9
	 */
	@Override
	protected void highlightFeature(org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, EObject object, EStructuralFeature feature,
			String... styleIds) {
		highlightFeature(cast(acceptor), object, feature, styleIds);
	}

	/**
	 * @since 2.9
	 */
	@Override
	protected void highlightNode(org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, INode node, String... styleIds) {
		highlightNode(cast(acceptor), node, styleIds);
	}

	private IHighlightedPositionAcceptor cast(org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor) {
		return IHighlightedPositionAcceptor.DeprecationHelper.cast(acceptor);
	}
	
	private org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor upcast(IHighlightedPositionAcceptor acceptor) {
		return IHighlightedPositionAcceptor.DeprecationHelper.upcast(acceptor);
	}

	/**
	 * @deprecated Use org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator instead.
	 */
	@Deprecated
	protected void doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		super.doProvideHighlightingFor(resource, upcast(acceptor), CancelIndicator.NullImpl);
	}

	/**
	 * @deprecated Use org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator instead.
	 */
	@Deprecated
	protected void searchAndHighlightElements(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		super.searchAndHighlightElements(resource, upcast(acceptor), CancelIndicator.NullImpl);
	}

	/**
	 * @deprecated Use org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightElementRecursively(EObject element, IHighlightedPositionAcceptor acceptor) {
		super.highlightElementRecursively(element, upcast(acceptor), CancelIndicator.NullImpl);
	}

	/**
	 * @deprecated Use org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator instead.
	 */
	@Deprecated
	protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor) {
		return super.highlightElement(object, upcast(acceptor), CancelIndicator.NullImpl);
	}

	/**
	 * @deprecated Use org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightTasks(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		super.highlightTasks(resource, upcast(acceptor));
	}

	/**
	 * @deprecated Use org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightFeature(IHighlightedPositionAcceptor acceptor, EObject object, EStructuralFeature feature,
			String... styleIds) {
		super.highlightFeature(upcast(acceptor), object, feature, styleIds);
	}

	/**
	 * @deprecated Use org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightNode(IHighlightedPositionAcceptor acceptor, INode node, String... styleIds) {
		super.highlightNode(upcast(acceptor), node, styleIds);
	}
	
	/**
	 * Highlights an object at the position of the given {@link EStructuralFeature}
	 * @deprecated use {@link #highlightFeature(IHighlightedPositionAcceptor, EObject, EStructuralFeature, String...)}
	 */
	@Deprecated
	protected void highlightObjectAtFeature(IHighlightedPositionAcceptor acceptor, EObject object, EStructuralFeature feature, String id) {
		highlightFeature(acceptor, object, feature, id);
	}
	
	/**
	 * Highlights the non-hidden parts of {@code node} with the style that is associated with {@code id}.
	 * @deprecated use {@link #highlightNode(IHighlightedPositionAcceptor, INode, String...)}
	 */
	@Deprecated
	protected void highlightNode(INode node, String id, IHighlightedPositionAcceptor acceptor) {
		highlightNode(acceptor, node, id);
	}
	
	@Override
	protected void computeReferencedJvmTypeHighlighting(
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, EObject referencer,
			CancelIndicator cancelIndicator) {
		computeReferencedJvmTypeHighlighting(cast(acceptor), referencer);
	}

	@Override
	protected void highlightReferenceJvmType(
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject) {
		highlightReferenceJvmType(cast(acceptor), referencer, reference, resolvedReferencedObject);
	}

	@Override
	protected void highlightReferenceJvmType(
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject, String highlightingConfiguration) {
		highlightReferenceJvmType(cast(acceptor), referencer, reference, resolvedReferencedObject, highlightingConfiguration);
	}

	@Override
	protected void highlightDeprecation(
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject) {
		highlightDeprecation(cast(acceptor), referencer, reference, resolvedReferencedObject);
	}

	@Override
	protected void computeFeatureCallHighlighting(XAbstractFeatureCall featureCall,
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor) {
		computeFeatureCallHighlighting(featureCall, cast(acceptor));
	}

	@Override
	protected void highlightFeatureCall(XAbstractFeatureCall featureCall,
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, String id) {
		highlightFeatureCall(featureCall, cast(acceptor), id);
	}

	@Override
	protected void highlightAnnotation(XAnnotation annotation,
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor) {
		highlightAnnotation(annotation, cast(acceptor));
	}

	@Override
	protected void highlightAnnotation(XAnnotation annotation,
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor,
			String highlightingConfiguration) {
		highlightAnnotation(annotation, cast(acceptor), highlightingConfiguration);
	}

	@Override
	protected void highlightNumberLiterals(XNumberLiteral literal,
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor) {
		highlightNumberLiterals(literal, cast(acceptor));
	}

	@Override
	protected void highlightSpecialIdentifiers(
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, ICompositeNode root) {
		highlightSpecialIdentifiers(cast(acceptor), root);
	}

	@Override
	protected void highlightSpecialIdentifiers(ILeafNode leafNode,
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, TerminalRule idRule) {
		highlightSpecialIdentifiers(leafNode, cast(acceptor), idRule);
	}
	
	/**
	 * @deprecated Use org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator instead.
	 */
	@Deprecated
	protected void computeReferencedJvmTypeHighlighting(
			IHighlightedPositionAcceptor acceptor, EObject referencer) {
		super.computeReferencedJvmTypeHighlighting(upcast(acceptor), referencer, CancelIndicator.NullImpl);
	}

	/**
	 * @deprecated Use org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightReferenceJvmType(
			IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject) {
		super.highlightReferenceJvmType(upcast(acceptor), referencer, reference, resolvedReferencedObject);
	}

	/**
	 * @deprecated Use org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightReferenceJvmType(
			IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject, String highlightingConfiguration) {
		super.highlightReferenceJvmType(upcast(acceptor), referencer, reference, resolvedReferencedObject, highlightingConfiguration);
	}

	/**
	 * @deprecated Use org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightDeprecation(
			IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject) {
		super.highlightDeprecation(upcast(acceptor), referencer, reference, resolvedReferencedObject);
	}
	
	/**
	 * @deprecated Use org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator instead.
	 */
	@Deprecated
	protected void computeFeatureCallHighlighting(XAbstractFeatureCall featureCall,
			IHighlightedPositionAcceptor acceptor) {
		super.computeFeatureCallHighlighting(featureCall, upcast(acceptor));
	}

	/**
	 * @deprecated Use org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightFeatureCall(XAbstractFeatureCall featureCall,
			IHighlightedPositionAcceptor acceptor, String id) {
		super.highlightFeatureCall(featureCall, upcast(acceptor), id);
	}

	/**
	 * @deprecated Use org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightAnnotation(XAnnotation annotation,
			IHighlightedPositionAcceptor acceptor) {
		super.highlightAnnotation(annotation, upcast(acceptor));
	}

	/**
	 * @deprecated Use org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightAnnotation(XAnnotation annotation,
			IHighlightedPositionAcceptor acceptor,
			String highlightingConfiguration) {
		super.highlightAnnotation(annotation, upcast(acceptor), highlightingConfiguration);
	}

	/**
	 * @deprecated Use org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightNumberLiterals(XNumberLiteral literal,
			IHighlightedPositionAcceptor acceptor) {
		super.highlightNumberLiterals(literal, upcast(acceptor));
	}

	/**
	 * @deprecated Use org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightSpecialIdentifiers(
			IHighlightedPositionAcceptor acceptor, ICompositeNode root) {
		super.highlightSpecialIdentifiers(upcast(acceptor), root);
	}

	/**
	 * @deprecated Use org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator instead.
	 */
	@Deprecated
	protected void highlightSpecialIdentifiers(ILeafNode leafNode,
			IHighlightedPositionAcceptor acceptor, TerminalRule idRule) {
		super.highlightSpecialIdentifiers(leafNode, upcast(acceptor), idRule);
	}
}
