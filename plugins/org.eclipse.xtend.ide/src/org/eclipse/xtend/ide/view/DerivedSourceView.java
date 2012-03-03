/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.view;

import static com.google.common.collect.Iterables.*;

import java.util.Set;

import org.eclipse.core.internal.utils.WrappedRuntimeException;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.javaeditor.JavaSourceViewer;
import org.eclipse.jdt.internal.ui.text.SimpleJavaSourceViewerConfiguration;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.OverviewRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.xtend.ide.labeling.XtendImages;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.ui.views.AbstractSourceView;
import org.eclipse.xtext.ui.views.IWorkbenchPartSelection;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.base.Function;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public class DerivedSourceView extends AbstractSourceView {
	/** The width of the overview ruler. */
	protected static final int OVERVIEW_RULER_WIDTH = 12;
	@Inject
	private ITraceInformation traceInformation;
	@Inject
	XtendImages xtendImages;
	private JavaSourceViewer javaSourceViewer;
	private SimpleJavaSourceViewerConfiguration javaSourceViewerConfiguration;
	private IStorage selectedSource;
	private Set<IStorage> derivedSources = Sets.newHashSet();

	IStorage getSelectedSource() {
		return selectedSource;
	}

	Set<IStorage> getDerivedSources() {
		return derivedSources;
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		createActions();
	}

	private void createActions() {
		IActionBars actionBars = getViewSite().getActionBars();
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		toolBarManager.add(new DerivedSourceDropDownAction(this));
	}

	@Override
	protected SourceViewer createSourceViewer(Composite parent) {
		IPreferenceStore store = JavaPlugin.getDefault().getCombinedPreferenceStore();
		javaSourceViewer = new JavaSourceViewer(parent, null, createOverviewRuler(), true, SWT.V_SCROLL | SWT.H_SCROLL,
				store);
		javaSourceViewerConfiguration = new SimpleJavaSourceViewerConfiguration(JavaPlugin.getDefault()
				.getJavaTextTools().getColorManager(), store, null, IJavaPartitions.JAVA_PARTITIONING, true);
		javaSourceViewer.configure(javaSourceViewerConfiguration);
		javaSourceViewer.setEditable(false);
		return javaSourceViewer;
	}

	@Override
	protected boolean isValidSelection(IWorkbenchPartSelection workbenchPartSelection) {
		return super.isValidSelection(workbenchPartSelection)
				&& traceInformation.getTraceToTarget(getEditorResource(workbenchPartSelection)) != null;
	}

	@Override
	protected String getBackgroundColorKey() {
		return "org.eclipse.jdt.ui.DeclarationView.backgroundColor"; //$NON-NLS-1$
	}

	@Override
	protected String getViewerFontName() {
		return "org.eclipse.jdt.ui.editors.textfont"; //$NON-NLS-1$;
	}

	@Override
	protected String computeInput(IWorkbenchPartSelection workbenchPartSelection) {
		ITrace trace = traceInformation.getTraceToTarget(getEditorResource(workbenchPartSelection));
		if (trace != null) {
			if (workbenchPartSelection instanceof DerivedSourceSelection) {
				DerivedSourceSelection derivedSourceSelection = (DerivedSourceSelection) workbenchPartSelection;
				selectedSource = derivedSourceSelection.getStorage();
			} else {
				derivedSources = Sets.newHashSet();
				TextRegion localRegion = mapTextRegion(workbenchPartSelection);
				Iterable<IStorage> transform = transform(trace.getAllAssociatedLocations(localRegion),
						new Function<ILocationInResource, IStorage>() {
							public IStorage apply(ILocationInResource input) {
								return input.getStorage();
							}
						});
				addAll(derivedSources, transform);
				ILocationInResource bestAssociatedLocation = trace.getBestAssociatedLocation(localRegion);
				if (bestAssociatedLocation != null) {
					selectedSource = bestAssociatedLocation.getStorage();
				} else if (!derivedSources.isEmpty()) {
					selectedSource = derivedSources.iterator().next();
				}
			}
		}
		try {
			return null != selectedSource ? Files.readStreamIntoString(selectedSource.getContents()) : null;
		} catch (CoreException e) {
			throw new WrappedRuntimeException(e);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		if (javaSourceViewerConfiguration.affectsTextPresentation(event)) {
			javaSourceViewerConfiguration.handlePropertyChangeEvent(event);
			javaSourceViewer.invalidateTextPresentation();
		}
	}

	@Override
	protected IDocument createDocument(String input) {
		IDocument document = super.createDocument(input);
		JavaPlugin.getDefault().getJavaTextTools()
				.setupJavaDocumentPartitioner(document, IJavaPartitions.JAVA_PARTITIONING);
		return document;
	}

	@Override
	protected ITextRegion computeSelectedText(IWorkbenchPartSelection workbenchPartSelection) {
		ITextRegion result = ITextRegion.EMPTY_REGION;
		if (selectedSource != null) {
			IAnnotationModel annotationModel = getSourceViewer().getAnnotationModel();
			TextRegion localRegion = mapTextRegion(workbenchPartSelection);
			ITrace trace = traceInformation.getTraceToTarget(getEditorResource(workbenchPartSelection));
			if (trace != null) {
				ILocationInResource bestAssociatedLocation = trace.getBestAssociatedLocation(localRegion,
						selectedSource);
				if (bestAssociatedLocation != null && bestAssociatedLocation.getTextRegion() != null) {
					result = bestAssociatedLocation.getTextRegion();
				}
				for (ILocationInResource locationInResource : trace.getAllAssociatedLocations(localRegion,
						selectedSource)) {
					ITextRegion textRegion = locationInResource.getTextRegion();
					if (textRegion != null) {
						annotationModel.addAnnotation(new Annotation(false), new Position(textRegion.getOffset(),
								textRegion.getLength()));
					}
				}
			}
		}
		return result;
	}

	private TextRegion mapTextRegion(IWorkbenchPartSelection workbenchPartSelection) {
		ITextSelection textSelection = (ITextSelection) workbenchPartSelection.getSelection();
		TextRegion localRegion = new TextRegion(textSelection.getOffset(), textSelection.getLength());
		return localRegion;
	}

	private IOverviewRuler createOverviewRuler() {
		DefaultMarkerAnnotationAccess annotationAccess = new DefaultMarkerAnnotationAccess();
		IOverviewRuler ruler = new OverviewRuler(annotationAccess, OVERVIEW_RULER_WIDTH,
				EditorsUI.getSharedTextColors());
		ruler.addAnnotationType(Annotation.TYPE_UNKNOWN);
		ruler.setAnnotationTypeLayer(Annotation.TYPE_UNKNOWN, 0);
		ruler.setAnnotationTypeColor(Annotation.TYPE_UNKNOWN, getDisplay().getSystemColor(SWT.COLOR_BLUE));
		return ruler;
	}

}
