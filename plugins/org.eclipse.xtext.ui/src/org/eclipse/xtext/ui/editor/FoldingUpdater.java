/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
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
import org.eclipse.xtext.ui.editor.model.IXtextEditorModelListener;
import org.eclipse.xtext.ui.editor.model.XtextEditorModelChangeEvent;
import org.eclipse.xtext.ui.internal.CoreLog;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class FoldingUpdater {

	/**
	 * @author Dennis Hübner - Initial contribution and API
	 * 
	 */
	private class InternalListener implements IXtextEditorModelListener {

		public void modelChanged(XtextEditorModelChangeEvent event) {
			startAnnotationCreation();
		}

	}

	private ProjectionAnnotationModel annotationModel;
	private Map<ProjectionAnnotation, Position> newAnnotations = new HashMap<ProjectionAnnotation, Position>();
	private IEditorModel model;
	private IXtextEditorModelListener editorModelListener;
	private IDocument document;

	/**
	 * Creates new FoldingUpdater user should call bind() to connect Editor
	 * model with an Annotation model and unbind() to disconnect.
	 */
	public FoldingUpdater() {
		this.editorModelListener = new InternalListener();
	}

	/**
	 * Binds Editor model with Annotation model contained in ProjectionViewer
	 * 
	 * @param model
	 * @param viewer
	 */
	public void bind(IEditorModel model, ProjectionViewer viewer) {
		Assert.isLegal(model != null);
		Assert.isLegal(viewer != null);
		Assert.isLegal(viewer.getAnnotationModel() != null);
		Assert.isLegal(viewer.getDocument() != null);
		this.model = model;
		this.annotationModel = viewer.getProjectionAnnotationModel();
		this.document = viewer.getDocument();
		startAnnotationCreation();
		model.addModelListener(editorModelListener);
	}

	/**
	 * Unbinds Editor model and Annotation model
	 */
	public void unbind() {
		if (model != null)
			model.removeModelListener(editorModelListener);
	}

	@SuppressWarnings("unchecked")
	private void startAnnotationCreation() {
		newAnnotations.clear();
		for (AbstractNode node : ((CompositeNode) model.getParseTreeRootNode()).getChildren()) {
			createProjectionAnnotations(node);
		}
		Set<Annotation> oldAnnotations = new HashSet<Annotation>();
		for (Iterator<Annotation> iter = annotationModel.getAnnotationIterator(); iter.hasNext();) {
			oldAnnotations.add(iter.next());
		}
		annotationModel.removeAllAnnotations();
		Annotation[] oldAnnotationsArray = oldAnnotations.toArray(new Annotation[] {});
		annotationModel.replaceAnnotations(oldAnnotationsArray, newAnnotations);
	}

	/**
	 * @param node
	 * @param model
	 */
	private void createProjectionAnnotations(AbstractNode node) {
		AbstractNode firstLeafNode = firstLeafNode(node);
		if (isMultiLine(node, firstLeafNode)) {
			Position normalizePosition = normalizePosition(node, firstLeafNode);
			newAnnotations.put(new ProjectionAnnotation(), normalizePosition);
			try {
				System.out.println("FoldingUpdater.createProjectionAnnotations():" + "putting anno for:"
						+ document.get(normalizePosition.offset, normalizePosition.length));
			}
			catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Single line composite nodes for example kind (Test 2), can own
		// multiline LeafNodes e.g. Multiline Comments
		if (node instanceof CompositeNode) {
			for (AbstractNode child : ((CompositeNode) node).getChildren()) {
				createProjectionAnnotations(child);
			}
		}
	}

	private Position normalizePosition(AbstractNode node, AbstractNode firstLeafNode) {
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
		return null;
	}

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
				&& "WS".equals(((LexerRule) ln.getGrammarElement()).getName());
	}
}
