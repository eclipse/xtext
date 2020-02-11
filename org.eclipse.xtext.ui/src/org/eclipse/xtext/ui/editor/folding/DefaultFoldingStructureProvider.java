/*******************************************************************************
 * Copyright (c) 2010, 2019 Michael Clay and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.projection.IProjectionListener;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Default implementation of interface {@link IFoldingStructureProvider}/
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultFoldingStructureProvider implements IFoldingStructureProvider, IXtextModelListener {
	@Inject
	private IFoldingRegionProvider foldingRegionProvider;
	private XtextEditor editor;
	private ProjectionViewer viewer;
	private ProjectionChangeListener projectionListener;

	@Override
	public void install(XtextEditor editor, ProjectionViewer viewer) {
		Assert.isNotNull(editor);
		Assert.isNotNull(viewer);
		uninstall();
		this.editor = editor;
		this.viewer = viewer;
		projectionListener = new ProjectionChangeListener(viewer);
	}

	@Override
	public void initialize() {
		calculateProjectionAnnotationModel(true);
	}

	@Override
	public void uninstall() {
		if (isInstalled()) {
			handleProjectionDisabled();
			projectionListener.dispose();
			projectionListener = null;
			editor = null;
		}
	}

	/**
	 * Returns <code>true</code> if the provider is installed, <code>false</code> otherwise.
	 * 
	 * @return <code>true</code> if the provider is installed, <code>false</code> otherwise
	 */
	protected final boolean isInstalled() {
		return editor != null;
	}

	/**
	 * @see org.eclipse.xtext.ui.editor.model.IXtextModelListener#modelChanged(org.eclipse.xtext.resource.XtextResource)
	 */
	@Override
	public void modelChanged(XtextResource resource) {
		if (resource == null)
			return;
		boolean existingSyntaxErrors = Iterables.any(resource.getErrors(), new Predicate<Diagnostic>() {
			@Override
			public boolean apply(Diagnostic diagnostic) {
				return diagnostic instanceof XtextSyntaxDiagnostic;
			}
		});

		if (!existingSyntaxErrors) {
			calculateProjectionAnnotationModel(false);
		}
	}

	protected void handleProjectionEnabled() {
		handleProjectionDisabled();
		if (isInstalled()) {
			initialize();
			IXtextDocument document = editor.getDocument();
			if (document != null) {
				document.addModelListener(this);
			}
		}
	}

	protected void handleProjectionDisabled() {
		if (editor != null) {
			IXtextDocument document = editor.getDocument();
			if (document != null) {
				document.removeModelListener(this);
			}
		}
	}

	protected void calculateProjectionAnnotationModel(boolean allowCollapse) {
		ProjectionAnnotationModel projectionAnnotationModel = this.viewer.getProjectionAnnotationModel();
		if (projectionAnnotationModel != null) {
			// make a defensive copy as we modify the folded positions in subsequent operations
			Collection<FoldedPosition> foldedPositions = Sets.newLinkedHashSet(foldingRegionProvider.getFoldingRegions(editor.getDocument()));
			foldedPositions = filterFoldedPositions(foldedPositions);
			Annotation[] newRegions = mergeFoldingRegions(foldedPositions, projectionAnnotationModel);
			updateFoldingRegions(allowCollapse, projectionAnnotationModel, foldedPositions, newRegions);
		}
	}

	/**
	 * @since 2.17
	 */
	protected Collection<FoldedPosition> filterFoldedPositions(Collection<FoldedPosition> foldedPositions) {
		Map<Pair<Integer, Integer>, FoldedPosition> acceptedPositions = new HashMap<>();
		
		for (FoldedPosition foldedPosition : foldedPositions) {
			int startLineNumber = getLineNumber(foldedPosition.getOffset());
			int endLineNumber = getLineNumber(foldedPosition.getOffset() + foldedPosition.getLength());
			Pair<Integer, Integer> startAndEndLineNumbers = Tuples.create(startLineNumber, endLineNumber);
			
			if (!acceptedPositions.containsKey(startAndEndLineNumbers)) {
				acceptedPositions.put(startAndEndLineNumbers, foldedPosition);
			} else {
				// if the folded position has already been accepted, keep the one with the smaller region
				FoldedPosition alreadyAcceptedPosition = acceptedPositions.get(startAndEndLineNumbers);
				if(foldedPosition.getLength() < alreadyAcceptedPosition.getLength()) {
					acceptedPositions.put(startAndEndLineNumbers, foldedPosition);
				}
			}
		}
		
		return acceptedPositions.values();
	}

	/**
	 * @since 2.17
	 */
	protected int getLineNumber(int offset) {
		IDocument document = viewer.getDocument();
		int lineNumber = -1;
		try {
			lineNumber = document.getLineOfOffset(offset);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return lineNumber;
	}

	protected Annotation[] mergeFoldingRegions(Collection<FoldedPosition> foldedPositions,
			ProjectionAnnotationModel projectionAnnotationModel) {
		List<Annotation> deletions = new ArrayList<Annotation>();
		for (Iterator<Annotation> iterator = projectionAnnotationModel.getAnnotationIterator(); iterator.hasNext();) {
			Annotation annotation = iterator.next();
			if (annotation instanceof ProjectionAnnotation) {
				Position position = projectionAnnotationModel.getPosition(annotation);
				if (!foldedPositions.remove(position)) {
					deletions.add(annotation);
				}
			}
		}
		return deletions.toArray(new Annotation[deletions.size()]);
	}

	protected void updateFoldingRegions(boolean allowCollapse, ProjectionAnnotationModel model,
			Collection<FoldedPosition> foldedPositions, Annotation[] deletions) {
		Map<ProjectionAnnotation, Position> additionsMap = Maps.newHashMap();
		for (FoldedPosition foldedPosition: foldedPositions) {
			addProjectionAnnotation(allowCollapse, foldedPosition, additionsMap);
		}
		if (deletions.length != 0 || additionsMap.size() != 0) {
			model.modifyAnnotations(deletions, additionsMap, new Annotation[] {});
		}
	}

	protected void addProjectionAnnotation(boolean allowCollapse, Position foldingRegion,
			Map<ProjectionAnnotation, Position> additionsMap) {
		boolean collapse = allowCollapse && (foldingRegion instanceof DefaultFoldedPosition) && ((DefaultFoldedPosition)foldingRegion).isInitiallyFolded();
		ProjectionAnnotation projectionAnnotation = createProjectionAnnotation(collapse, foldingRegion);
		additionsMap.put(projectionAnnotation, foldingRegion);
	}

	protected ProjectionAnnotation createProjectionAnnotation(boolean isCollapsed, Position foldedRegion) {
		return new ProjectionAnnotation(isCollapsed);
	}

	/**
	 * Internal projection listener.
	 */
	public class ProjectionChangeListener implements IProjectionListener {
		private ProjectionViewer projectionViewer;

		/**
		 * Registers the listener with the viewer.
		 * 
		 * @param viewer
		 *            the viewer to register a listener with
		 */
		public ProjectionChangeListener(ProjectionViewer viewer) {
			Assert.isLegal(viewer != null);
			projectionViewer = viewer;
			projectionViewer.addProjectionListener(this);
		}

		/**
		 * Disposes of this listener and removes the projection listener from the viewer.
		 */
		public void dispose() {
			if (projectionViewer != null) {
				projectionViewer.removeProjectionListener(this);
				projectionViewer = null;
			}
		}

		@Override
		public void projectionEnabled() {
			handleProjectionEnabled();
		}

		@Override
		public void projectionDisabled() {
			handleProjectionDisabled();
		}
	}
}
