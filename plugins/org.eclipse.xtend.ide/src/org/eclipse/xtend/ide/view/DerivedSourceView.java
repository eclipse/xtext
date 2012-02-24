/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.view;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.javaeditor.JavaSourceViewer;
import org.eclipse.jdt.internal.ui.text.SimpleJavaSourceViewerConfiguration;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DerivedSourceView extends ViewPart implements ISelectionListener {

	@Inject
	private ITraceInformation traceInformation;
	@Inject
	private IResourceDescription.Manager manager;

	private IStorage currentlyShown = null;
	private JavaSourceViewer fViewer;
	private SimpleJavaSourceViewerConfiguration fViewerConfiguration;

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part.equals(this))
			return;
		if (!(part instanceof XtextEditor)) {
			setInput(null);
			return;
		}
		XtextEditor editor = (XtextEditor) part;
		try {
			Control control = fViewer.getControl();
			if (control instanceof StyledText) {
				ITrace source = traceInformation.getTraceToTarget((IStorage)editor.getResource());
				if (source == null) {
					setInput(null);
					return;
				}
				ITextSelection textSelection = (ITextSelection) selection;
				ILocationInResource location = source.getBestAssociatedLocation(new TextRegion(textSelection.getOffset(), textSelection.getLength()));
				if (location != null) {
					final ITextRegionWithLineInformation region = location.getTextRegion();
					if (region != null)
						highlightRange(location.getStorage(), region.getOffset(), region.getLength());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void highlightRange(IStorage iStorage, int myOffset, int myLength) {
		if (currentlyShown == null || !currentlyShown.equals(iStorage)) {
			setInput(iStorage);
		}
		StyledText text = fViewer.getTextWidget();
		text.setStyleRange(new StyleRange(myOffset, myLength, null, Display.getDefault().getSystemColor(SWT.COLOR_GRAY)));
		text.redrawRange(myOffset, myLength, true);
	}


	private void setInput(IStorage iStorage) {
		currentlyShown = iStorage;
		if (iStorage == null) {
			fViewer.setInput(new Document("")); //$NON-NLS-1$
			return;
		}
		try {
			final String source = Files.readStreamIntoString(iStorage.getContents());
			Shell shell = getSite().getShell();
			if (shell.isDisposed())
				return;

			Display display = shell.getDisplay();
			if (display.isDisposed())
				return;

			display.asyncExec(new Runnable() {
				public void run() {
					if (getViewSite().getShell().isDisposed())
						return;
					IDocument document = new Document(source);
					JavaPlugin.getDefault().getJavaTextTools()
							.setupJavaDocumentPartitioner(document, IJavaPartitions.JAVA_PARTITIONING);
					fViewer.setDocument(document, new AnnotationModel());
				}
			});
		} catch (Exception ex) {
			return;
		}

	}

	static class Range implements Comparable<Range> {
		public int offSet, length;

		public Range(int offSet, int length) {
			this.offSet = offSet;
			this.length = length;
		}

		public int compareTo(Range o) {
			return length - o.length;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + length;
			result = prime * result + offSet;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Range other = (Range) obj;
			if (length != other.length)
				return false;
			if (offSet != other.offSet)
				return false;
			return true;
		}

	}

	public void selectionChanged(SelectionChangedEvent event) {
		// TODO Auto-generated method stub

	}

	/** The viewer's font properties change listener. */
	private IPropertyChangeListener fFontPropertyChangeListener = new FontPropertyChangeListener();
	/**
	 * The editor's property change listener.
	 * 
	 * @since 3.0
	 */
	private IPropertyChangeListener fPropertyChangeListener = new PropertyChangeListener();

	@Override
	public void createPartControl(Composite parent) {
		IPreferenceStore store = JavaPlugin.getDefault().getCombinedPreferenceStore();
		fViewer = new JavaSourceViewer(parent, null, null, false, SWT.V_SCROLL | SWT.H_SCROLL, store);
		fViewerConfiguration = new SimpleJavaSourceViewerConfiguration(JavaPlugin.getDefault().getJavaTextTools()
				.getColorManager(), store, null, IJavaPartitions.JAVA_PARTITIONING, false);
		fViewer.configure(fViewerConfiguration);
		fViewer.setEditable(false);

		setViewerFont();
		JFaceResources.getFontRegistry().addListener(fFontPropertyChangeListener);

		store.addPropertyChangeListener(fPropertyChangeListener);

		getSite().getPage().addPostSelectionListener(this);
	}

	private static final String SYMBOLIC_FONT_NAME = "org.eclipse.jdt.ui.editors.textfont"; //$NON-NLS-1$

	private void setViewerFont() {
		Font font = JFaceResources.getFont(SYMBOLIC_FONT_NAME);

		if (fViewer.getDocument() != null) {

			Point selection = fViewer.getSelectedRange();
			int topIndex = fViewer.getTopIndex();

			StyledText styledText = fViewer.getTextWidget();
			Control parent = fViewer.getControl();

			parent.setRedraw(false);

			styledText.setFont(font);

			fViewer.setSelectedRange(selection.x, selection.y);
			fViewer.setTopIndex(topIndex);

			if (parent instanceof Composite) {
				Composite composite = (Composite) parent;
				composite.layout(true);
			}

			parent.setRedraw(true);

		} else {
			StyledText styledText = fViewer.getTextWidget();
			styledText.setFont(font);
		}
	}

	/**
	 * Internal property change listener for handling changes in the editor's preferences.
	 * 
	 * @since 3.0
	 */
	class PropertyChangeListener implements IPropertyChangeListener {
		/*
		 * @see IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
		 */
		public void propertyChange(PropertyChangeEvent event) {
			if (fViewer == null)
				return;

			if (fViewerConfiguration.affectsTextPresentation(event)) {
				fViewerConfiguration.handlePropertyChangeEvent(event);
				fViewer.invalidateTextPresentation();
			}
		}
	}

	/**
	 * Internal property change listener for handling workbench font changes.
	 */
	class FontPropertyChangeListener implements IPropertyChangeListener {
		/*
		 * @see IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
		 */
		public void propertyChange(PropertyChangeEvent event) {
			if (fViewer == null)
				return;

			String property = event.getProperty();

			if (SYMBOLIC_FONT_NAME.equals(property))
				setViewerFont();
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		getSite().getPage().removePostSelectionListener(this);
	}
}
