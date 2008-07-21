/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.internal.CoreLog;
import org.eclipse.xtext.ui.service.IFoldingStructureProvider;
import org.eclipse.xtext.ui.util.GrammarConstants;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BuiltInFoldingStructureProvider implements IFoldingStructureProvider {

	@SuppressWarnings("unchecked")
	public final void updateFoldingStructure(IEditorModel model, ProjectionViewer projectionViewer) {
		ProjectionAnnotationModel annotationModel = projectionViewer.getProjectionAnnotationModel();
		IDocument document = projectionViewer.getDocument();
		long time = System.currentTimeMillis();
		Set<Position> newAnnotations = new HashSet<Position>();
		for (AbstractNode node : ((CompositeNode) model.getParseTreeRootNode()).getChildren()) {
			createProjectionAnnotationPositions(document, node, newAnnotations);
		}
		Set<Annotation> annotationsToRemove = new HashSet<Annotation>();
		for (Iterator<Annotation> iter = annotationModel.getAnnotationIterator(); iter.hasNext();) {
			Annotation annotation = iter.next();
			if (annotation instanceof ProjectionAnnotation) {
				if (!newAnnotations.remove(annotationModel.getPosition(annotation))) {
					annotationsToRemove.add(annotation);
				}
			}
		}
		Annotation[] annotationsToRemoveArray = annotationsToRemove.toArray(new Annotation[] {});
		Map<Annotation, Position> additions = new HashMap<Annotation, Position>();
		for (Position position : newAnnotations) {
			if (Activator.DEBUG_FOLDING) {
				try {
					System.out.println("FoldingUpdater.startAnnotationCreation(): adding anno for :"
							+ document.get(position.offset, position.length).replaceAll("\n", "<br>"));
				}
				catch (BadLocationException e) {
					// ignore
				}
			}
			additions.put(new ProjectionAnnotation(), position);
		}
		annotationModel.replaceAnnotations(annotationsToRemoveArray, additions);
		if (Activator.DEBUG_FOLDING)
			System.out.println("FoldingUpdater.startAnnotationCreation() Folding calculation took "
					+ (System.currentTimeMillis() - time) + " ms");
	}

	/**
	 * Calculates, creates and gather new annotation positions in a Set. Should
	 * be run recursively for node's children if that should examine too.
	 * 
	 * @param document
	 *            corresponding Document
	 * @param node
	 *            current child of root node
	 * @param annotations
	 *            gathering set for annotation positions
	 */
	protected void createProjectionAnnotationPositions(IDocument document, AbstractNode node, Set<Position> annotations) {
		AbstractNode firstLeafNode = firstLeafNode(node);
		if (isMultiLine(node, firstLeafNode)) {
			annotations.add(calculateAnnotationPosition(document, node, firstLeafNode));
		}
		// Single line composite nodes for example kind (Test 2), can own
		// preceding multiline LeafNodes e.g. Multiline Comments
		if (node instanceof CompositeNode) {
			for (AbstractNode child : ((CompositeNode) node).getChildren()) {
				createProjectionAnnotationPositions(document, child, annotations);
			}
		}
	}

	/**
	 * Calculates the annotation coordinates
	 * 
	 * @param document
	 * @param node
	 * @param firstLeafNode
	 *            if node is an CompositeNode the first non hidden LeafNode or
	 *            null if any
	 * @return folding area as Position(start,length)
	 **/
	private Position calculateAnnotationPosition(IDocument document, AbstractNode node, AbstractNode firstLeafNode) {
		try {
			int start = document.getLineInformation(firstLeafNode.getLine() - 1).getOffset();
			IRegion lastLine = document.getLineInformation(node.endLine() - 1);
			int end = lastLine.getLength() + lastLine.getOffset();
			if (end < document.getLength())
				end++;
			int length = end - start;
			return new Position(start, length);
		}
		catch (BadLocationException e) {
			CoreLog.logError(e);
		}
		throw new IllegalStateException();
	}

	/**
	 * Helps to locate node's offset
	 * 
	 * @param node
	 * @return node if it is instance of LeafNode or the first non hidden
	 *         LeafNode if exists null otherwise
	 */
	private AbstractNode firstLeafNode(AbstractNode node) {
		if (node instanceof LeafNode && !isWhiteSpace((LeafNode) node)) {
			return node;
		}
		for (EObject child : node.eContents()) {
			if (child instanceof LeafNode) {
				if (!((LeafNode) child).isHidden()) {
					return (AbstractNode) child;
				}
			}
			else {
				return null;
			}
		}

		return null;
	}

	/**
	 * @param node
	 * @param firstLeafNode
	 * @return true if node is a multiline one
	 */
	private boolean isMultiLine(AbstractNode node, AbstractNode firstLeafNode) {
		if (firstLeafNode != null) {
			int endLine = node.endLine();
			// SL_Comment case
			if (node instanceof LeafNode) {
				LeafNode leafNode = (LeafNode) node;
				if (leafNode.getText().endsWith("\n") || leafNode.getText().endsWith("\r")) {
					endLine--;
				}
			}
			int lines = endLine - firstLeafNode.getLine();
			return (lines > 0) && (node.getLength() > lines + 1);
		}
		return false;
	}

	private boolean isWhiteSpace(LeafNode ln) {
		return ln.isHidden() && ln.getGrammarElement() instanceof LexerRule
				&& GrammarConstants.LEXER_RULE_WHITESPACE.equals(((LexerRule) ln.getGrammarElement()).getName());
	}
}
