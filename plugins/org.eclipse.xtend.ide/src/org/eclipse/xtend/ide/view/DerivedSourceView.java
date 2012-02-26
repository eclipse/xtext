/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.view;

import org.eclipse.core.internal.utils.WrappedRuntimeException;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.javaeditor.JavaSourceViewer;
import org.eclipse.jdt.internal.ui.text.SimpleJavaSourceViewerConfiguration;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.views.AbstractSourceView;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public class DerivedSourceView extends AbstractSourceView {
	@Inject
	private ITraceInformation traceInformation;
	private JavaSourceViewer javaSourceViewer;
	private SimpleJavaSourceViewerConfiguration javaSourceViewerConfiguration;

	@Override
	protected SourceViewer createSourceViewer(Composite parent) {
		IPreferenceStore store = JavaPlugin.getDefault().getCombinedPreferenceStore();
		javaSourceViewer = new JavaSourceViewer(parent, null, null, false, SWT.V_SCROLL | SWT.H_SCROLL, store);
		javaSourceViewerConfiguration = new SimpleJavaSourceViewerConfiguration(JavaPlugin.getDefault()
				.getJavaTextTools().getColorManager(), store, null, IJavaPartitions.JAVA_PARTITIONING, false);
		javaSourceViewer.configure(javaSourceViewerConfiguration);
		javaSourceViewer.setEditable(false);
		return javaSourceViewer;
	}

	@Override
	protected boolean isValidSelection(IWorkbenchPart workbenchPart, ISelection selection) {
		return workbenchPart instanceof XtextEditor && selection instanceof TextSelection;
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
	protected String computeInput(IWorkbenchPart workbenchPart, ISelection selection, EObject eObject) {
		ILocationInResource location = getBestAssociatedLocation(workbenchPart, selection);
		try {
			return null != location ? Files.readStreamIntoString(location.getStorage().getContents()) : null;
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
	protected ITextRegion computeSelectedTextRegion(IWorkbenchPart workbenchPart, ISelection selection, EObject eObject) {
		ITextRegion textRegion = null;
		ILocationInResource locationInResource = getBestAssociatedLocation(workbenchPart, selection);
		if (locationInResource != null) {
			textRegion = locationInResource.getTextRegion();
		}
		return textRegion;
	}

	private ILocationInResource getBestAssociatedLocation(IWorkbenchPart workbenchPart, ISelection selection) {
		IStorage storage = (IStorage) ((XtextEditor) workbenchPart).getResource();
		ITrace trace = traceInformation.getTraceToTarget(storage);
		if (trace == null) {
			return null;
		}
		ITextSelection textSelection = (ITextSelection) selection;
		ILocationInResource location = trace.getBestAssociatedLocation(new TextRegion(textSelection.getOffset(),
				textSelection.getLength()));
		return location;
	}

}
