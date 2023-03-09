/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.views;

import static org.eclipse.jface.resource.JFaceResources.*;
import static org.eclipse.xtext.ui.util.DisplayRunHelper.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.3
 */
public abstract class AbstractSourceView extends ViewPart implements IPartListener2, ISelectionListener, IPropertyChangeListener {
	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;
	private int computeCount;
	private RGB backgroundColorRGB;
	private Color backgroundColor;
	private SourceViewer sourceViewer;
	private IWorkbenchPartSelection workbenchPartSelection;

	public IWorkbenchPartSelection getWorkbenchPartSelection() {
		return workbenchPartSelection;
	}

	protected void setWorkbenchPartSelection(IWorkbenchPartSelection workbenchPartSelection) {
		this.workbenchPartSelection = workbenchPartSelection;
	}

	protected SourceViewer getSourceViewer() {
		return sourceViewer;
	}

	public String getLanguageName() {
		return languageName;
	}

	@Override
	public void createPartControl(Composite parent) {
		this.sourceViewer = createSourceViewer(parent);
		inititalizeColors();
		inititalizeFont();
		getSite().getWorkbenchWindow().getPartService().addPartListener(this);
	}

	protected abstract SourceViewer createSourceViewer(Composite parent);

	protected void inititalizeColors() {
		Display display = getDisplay();
		if (display == null) {
			return;
		}
		getSourceViewer().getTextWidget().setForeground(display.getSystemColor(SWT.COLOR_INFO_FOREGROUND));
		getColorRegistry().addListener(this);
		backgroundColorRGB = getColorRegistry().getRGB(Strings.nullToEmpty(getBackgroundColorKey()));
		Color bgColor;
		if (backgroundColorRGB == null) {
			bgColor = display.getSystemColor(SWT.COLOR_INFO_BACKGROUND);
			backgroundColorRGB = bgColor.getRGB();
		} else {
			bgColor = new Color(display, backgroundColorRGB);
			backgroundColor = bgColor;
		}
		getSourceViewer().getTextWidget().setBackground(bgColor);
	}

	protected String getBackgroundColorKey() {
		return null;
	}

	protected void inititalizeFont() {
		setViewerFont();
		getFontRegistry().addListener(this);
	}

	private void setViewerFont() {
		Font font = getFont(getViewerFontName());
		SourceViewer viewer = getSourceViewer();
		if (viewer.getDocument() != null) {
			Point selection = viewer.getSelectedRange();
			int topIndex = viewer.getTopIndex();
			StyledText styledText = viewer.getTextWidget();
			Control parent = viewer.getControl();
			parent.setRedraw(false);
			styledText.setFont(font);
			viewer.setSelectedRange(selection.x, selection.y);
			viewer.setTopIndex(topIndex);
			if (parent instanceof Composite) {
				Composite composite = (Composite) parent;
				composite.layout(true);
			}
			parent.setRedraw(true);
		} else {
			StyledText styledText = viewer.getTextWidget();
			styledText.setFont(font);
		}
	}

	protected String getViewerFontName() {
		return JFaceResources.DEFAULT_FONT;
	}

	@Override
	public void selectionChanged(IWorkbenchPart workbenchPart, ISelection selection) {
		computeAndSetInput(new DefaultWorkbenchPartSelection(workbenchPart, selection));
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (getSourceViewer() == null) {
			return;
		}
		if (event.getProperty().equals(getBackgroundColorKey())) {
			inititalizeColors();
		} else if (event.getProperty().equals(getViewerFontName())) {
			setViewerFont();
		}
	}
	
	@Override
	public void partVisible(IWorkbenchPartReference ref) {
		if (ref.getId().equals(getSite().getId())) {
			IWorkbenchPart activePart = ref.getPage().getActivePart();
			if (activePart != null) {
				selectionChanged(activePart, ref.getPage().getSelection());
			}
			addPostSelectionListener();
		}
	}

	@Override
	public void partHidden(IWorkbenchPartReference ref) {
		if (ref.getId().equals(getSite().getId())) {
			removePostSelectionListener();
		}
	}

	@Override
	public void partInputChanged(IWorkbenchPartReference ref) {
		if (!ref.getId().equals(getSite().getId())) {
			IWorkbenchPart workbenchPart = ref.getPart(false);
			ISelectionProvider provider = workbenchPart.getSite().getSelectionProvider();
			if (provider == null) {
				return;
			}
			ISelection selection = provider.getSelection();
			if (selection == null || selection.isEmpty()) {
				return;
			}
			computeAndSetInput(new DefaultWorkbenchPartSelection(ref.getPart(false), selection));
		}
	}

	@Override
	public void partActivated(IWorkbenchPartReference ref) {
	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference ref) {
	}

	@Override
	public void partClosed(IWorkbenchPartReference ref) {
	}

	@Override
	public void partDeactivated(IWorkbenchPartReference ref) {
	}

	@Override
	public void partOpened(IWorkbenchPartReference ref) {
	}

	protected void addPostSelectionListener() {
		getSite().getPage().addPostSelectionListener(this);
	}

	protected void removePostSelectionListener() {
		getSite().getPage().removePostSelectionListener(this);
	}

	public void computeAndSetInput(final IWorkbenchPartSelection workbenchPartSelection) {
		computeAndSetInput(workbenchPartSelection, false);
	}
	
	public void computeAndSetInput(final IWorkbenchPartSelection workbenchPartSelection, boolean forceSelection) {
		if (!isValidSelection(workbenchPartSelection)) {
			return;
		}
		internalComputeAndSetInput(workbenchPartSelection, forceSelection);
	}

	protected void internalComputeAndSetInput(final IWorkbenchPartSelection workbenchPartSelection, boolean forceSelection) {
		if (!forceSelection && isIgnored(workbenchPartSelection)) {
			return;
		}
		this.workbenchPartSelection = workbenchPartSelection;
		final int currentCount = ++computeCount;
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		Thread thread = threadFactory.newThread(new Runnable() {
			@Override
			public void run() {
				if (currentCount != computeCount) {
					return;
				}
				final String input = computeInput(workbenchPartSelection);
				if (input == null) {
					return;
				}
				Display display = getDisplay();
				if (display == null) {
					return;
				}
				runAsyncInDisplayThread(new Runnable() {
					@Override
					public void run() {
						if (computeCount != currentCount || getViewSite().getShell().isDisposed()) {
							return;
						}
						String description = computeDescription(workbenchPartSelection);
						setContentDescription(description);
						setInput(input);
						selectAndReveal(workbenchPartSelection);
					}

				});
			}
		});
		thread.setDaemon(true);
		thread.setPriority(Thread.MIN_PRIORITY);
		thread.start();
	}

	protected boolean isValidSelection(IWorkbenchPartSelection workbenchPartSelection) {
		return !this.equals(workbenchPartSelection.getWorkbenchPart())
				&& workbenchPartSelection.getWorkbenchPart() instanceof XtextEditor
				&& workbenchPartSelection.getSelection() instanceof ITextSelection
				&& ((XtextEditor) workbenchPartSelection.getWorkbenchPart()).getLanguageName().equalsIgnoreCase(
						languageName);
	}
	
	protected boolean isIgnored(IWorkbenchPartSelection workbenchPartSelection) {
		return workbenchPartSelection.equals(this.workbenchPartSelection);
	}

	protected String computeInput(IWorkbenchPartSelection workbenchPartSelection) {
		return null;
	}

	protected String computeDescription(IWorkbenchPartSelection workbenchPartSelection) {
		return "";
	}

	protected void setInput(String input) {
		IDocument document = createDocument(input);
		getSourceViewer().setDocument(document, createAnnotationModel());
	}

	protected AnnotationModel createAnnotationModel() {
		return new AnnotationModel();
	}

	protected IDocument createDocument(String input) {
		IDocument document = new Document(input);
		return document;
	}

	protected void selectAndReveal(IWorkbenchPartSelection workbenchPartSelection) {
		ITextRegion textSelection = computeSelectedText(workbenchPartSelection);
		if (textSelection != null && !ITextRegion.EMPTY_REGION.equals(textSelection)) {
			setSelection(textSelection, true);
		}
	}

	protected void setSelection(ITextRegion textSelection, boolean reveal) {
		StyledText text = getSourceViewer().getTextWidget();
		if (text.getText().length() >= textSelection.getOffset() + textSelection.getLength()) {
			getSourceViewer().setSelection(new TextSelection(textSelection.getOffset(), textSelection.getLength()),
					reveal);
		}
	}

	protected ITextRegion computeSelectedText(IWorkbenchPartSelection workbenchPartSelection) {
		return ITextRegion.EMPTY_REGION;
	}

	protected Display getDisplay() {
		Shell shell = getSite().getShell();
		if (shell == null || shell.isDisposed()) {
			return null;
		}
		Display display = shell.getDisplay();
		if (display == null || display.isDisposed()) {
			return null;
		}
		return display;
	}

	@Override
	public void setFocus() {
		StyledText styledText = getTextWidget();
		if (styledText != null) {
			styledText.setFocus();
		}
	}

	private StyledText getTextWidget() {
		SourceViewer viewer = getSourceViewer();
		if (viewer != null) {
			return viewer.getTextWidget();
		}
		return null;
	}

	@Override
	public void dispose() {
		super.dispose();
		computeCount++;
		removePostSelectionListener();
		getSite().getWorkbenchWindow().getPartService().removePartListener(this);
		getColorRegistry().removeListener(this);
		getFontRegistry().removeListener(this);
		backgroundColorRGB = null;
		if (backgroundColor != null) {
			backgroundColor.dispose();
			backgroundColor = null;
		}
		sourceViewer = null;
	}

	protected IStorage getEditorResource(IWorkbenchPartSelection workbenchPartSelection) {
		IWorkbenchPart workbenchPart = workbenchPartSelection.getWorkbenchPart();
		return (IStorage) (workbenchPart instanceof XtextEditor ? ((XtextEditor) workbenchPart).getResource() : null);
	}

}
