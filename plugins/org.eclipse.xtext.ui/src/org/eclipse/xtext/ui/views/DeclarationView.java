/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.views;

import static org.eclipse.emf.ecore.util.EcoreUtil.*;
import static org.eclipse.jface.resource.JFaceResources.*;
import static org.eclipse.xtext.ui.util.DisplayRunHelper.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.3
 */
public class DeclarationView extends ViewPart implements ISelectionListener, IPropertyChangeListener {
	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	@Inject
	protected Provider<XtextDocument> documentProvider;
	@Inject
	protected Provider<IDocumentPartitioner> documentPartitioner;
	@Inject
	private ReadOnlySourceViewerConfiguration sourceViewerConfiguration;
	@Inject
	private ILabelProvider labelProvider;

	private XtextSourceViewer viewer;
	private RGB backgroundColorRGB;
	private Color backgroundColor;
	private URI currentViewInput;
	private int computeCount;
	private IPartListener2 partListener = new IPartListener2() {
		public void partVisible(IWorkbenchPartReference ref) {
			if (ref.getId().equals(getSite().getId())) {
				IWorkbenchPart activePart = ref.getPage().getActivePart();
				if (activePart != null) {
					selectionChanged(activePart, ref.getPage().getSelection());
				}
				addPostSelectionListener();
			}
		}

		public void partHidden(IWorkbenchPartReference ref) {
			if (ref.getId().equals(getSite().getId())) {
				removePostSelectionListener();
			}
		}

		public void partInputChanged(IWorkbenchPartReference ref) {
			if (!ref.getId().equals(getSite().getId())) {
				computeAndDoSetInput(ref.getPart(false));
			}
		}

		public void partActivated(IWorkbenchPartReference ref) {
		}

		public void partBroughtToTop(IWorkbenchPartReference ref) {
		}

		public void partClosed(IWorkbenchPartReference ref) {
		}

		public void partDeactivated(IWorkbenchPartReference ref) {
		}

		public void partOpened(IWorkbenchPartReference ref) {
		}
	};

	@Override
	public void createPartControl(Composite parent) {
		internalCreatePartControl(parent);
		inititalizeColors();
		inititalizeFont();
		getSite().getWorkbenchWindow().getPartService().addPartListener(partListener);
	}

	protected void internalCreatePartControl(Composite parent) {
		viewer = new XtextSourceViewer(parent, null, null, false, SWT.V_SCROLL | SWT.H_SCROLL);
		viewer.configure(sourceViewerConfiguration);
		viewer.setEditable(false);
	}

	protected void inititalizeColors() {
		Display display = getDisplay();
		if (display == null) {
			return;
		}
		viewer.getTextWidget().setForeground(display.getSystemColor(SWT.COLOR_INFO_FOREGROUND));
		getColorRegistry().addListener(this);
		backgroundColorRGB = getColorRegistry().getRGB(getBackgroundColorKey());
		Color bgColor;
		if (backgroundColorRGB == null) {
			bgColor = display.getSystemColor(SWT.COLOR_INFO_BACKGROUND);
			backgroundColorRGB = bgColor.getRGB();
		} else {
			bgColor = new Color(display, backgroundColorRGB);
			backgroundColor = bgColor;
		}
		viewer.getTextWidget().setBackground(bgColor);
	}

	protected String getBackgroundColorKey() {
		return languageName + "ui.DeclarationView.backgroundColor"; //$NON-NLS-1$
	}

	protected void inititalizeFont() {
		setViewerFont();
		getFontRegistry().addListener(this);
	}

	private void setViewerFont() {
		Font font = JFaceResources.getFont(getViewerFontName());
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
		return languageName + ".ui.editors.textfont"; //$NON-NLS-1$
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (viewer == null) {
			return;
		}
		if (getBackgroundColorKey().equals(event.getProperty())) {
			inititalizeColors();
		} else if (getViewerFontName().equals(event.getProperty())) {
			setViewerFont();
		}
	}

	protected void computeAndDoSetInput(final IWorkbenchPart workbenchPart) {
		final int currentCount = ++computeCount;
		final ISelection selection;
		ISelectionProvider provider = workbenchPart.getSite().getSelectionProvider();
		if (provider == null) {
			return;
		}
		selection = provider.getSelection();
		if (selection == null || selection.isEmpty()) {
			return;
		}
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		Thread thread = threadFactory.newThread(new Runnable() {
			public void run() {
				if (currentCount != computeCount) {
					return;
				}
				final EObject eObject = findSelectedEObject(workbenchPart, selection);
				if (!isIgnored(eObject)) {
					final String input = computeInput(workbenchPart, selection, eObject);
					if (input == null) {
						return;
					}
					final String description = computeDescription(workbenchPart, selection, eObject);
					Display display = getDisplay();
					if (display == null) {
						return;
					}
					runAsyncInDisplayThread(new Runnable() {
						public void run() {
							if (computeCount != currentCount || getViewSite().getShell().isDisposed()) {
								return;
							}
							currentViewInput = getURI(eObject);
							doSetInput(input, description);
						}

					});
				}
			}
		});
		thread.setDaemon(true);
		thread.setPriority(Thread.MIN_PRIORITY);
		thread.start();
	}

	protected String computeInput(IWorkbenchPart workbenchPart, ISelection selection, EObject eObject) {
		String result = null;
		ICompositeNode node = NodeModelUtils.getNode(eObject);
		if (node != null && node.getRootNode() != null) {
			INode rootNode = node.getRootNode();
			int offset = node.getOffset();
			int length = node.getLength();
			result = new String(rootNode.getText().substring(offset, offset + length));
		}
		return result;
	}

	protected String computeDescription(IWorkbenchPart workbenchPart, ISelection selection, EObject eObject) {
		String description = labelProvider.getText(eObject);
		return Strings.nullToEmpty(description);
	}

	protected void doSetInput(final String input, String description) {
		setContentDescription(description);
		XtextDocument xtextDocument = createDocument();
		xtextDocument.set(input);
		viewer.setDocument(xtextDocument);
	}

	protected XtextDocument createDocument() {
		XtextDocument xtextDocument = documentProvider.get();
		IDocumentPartitioner partitioner = documentPartitioner.get();
		partitioner.connect(xtextDocument);
		xtextDocument.setDocumentPartitioner(partitioner);
		return xtextDocument;
	}

	protected boolean isIgnored(EObject eObject) {
		return eObject != null && currentViewInput != null && currentViewInput.equals(getURI(eObject));
	}

	protected EObject findSelectedEObject(IWorkbenchPart workbenchPart, final ISelection selection) {
		Object element = null;
		if (workbenchPart instanceof XtextEditor && selection instanceof ITextSelection) {
			XtextEditor xtextEditor = (XtextEditor) workbenchPart;
			IXtextDocument xtextDocument = xtextEditor.getDocument();
			element = xtextDocument.readOnly(new IUnitOfWork<EObject, XtextResource>() {
				public EObject exec(XtextResource xtextResource) throws Exception {
					ITextSelection textSelection = (ITextSelection) selection;
					return eObjectAtOffsetHelper.resolveElementAt(xtextResource, textSelection.getOffset());
				}
			});
		} else if (selection instanceof IStructuredSelection) {
			element = getSingleElement(selection);
		}
		return findSelectedEObject(element);
	}

	private Object getSingleElement(ISelection s) {
		if (!(s instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection selection = (IStructuredSelection) s;
		if (selection.size() != 1) {
			return null;
		}
		return selection.getFirstElement();
	}

	private EObject findSelectedEObject(Object element) {
		EObject result = null;
		if (element instanceof IAdaptable) {
			result = (EObject) ((IAdaptable) element).getAdapter(EObject.class);
		} else if (element instanceof EObject) {
			result = (EObject) element;
		}
		return result;
	}

	@Override
	public void setFocus() {
		viewer.getTextWidget().setFocus();
	}

	@Override
	public void dispose() {
		super.dispose();
		computeCount++;
		removePostSelectionListener();
		getSite().getWorkbenchWindow().getPartService().removePartListener(partListener);
		getColorRegistry().removeListener(this);
		getFontRegistry().removeListener(this);
		backgroundColorRGB = null;
		if (backgroundColor != null) {
			backgroundColor.dispose();
			backgroundColor = null;
		}
		viewer = null;
		sourceViewerConfiguration = null;
	}

	public void selectionChanged(IWorkbenchPart workbenchPart, ISelection selection) {
		computeAndDoSetInput(workbenchPart);
	}

	protected void addPostSelectionListener() {
		getSite().getPage().addPostSelectionListener(this);
	}

	protected void removePostSelectionListener() {
		getSite().getPage().removePostSelectionListener(this);
	}

	private Display getDisplay() {
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

}
