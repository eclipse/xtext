/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.gmf.glue.Activator;
import org.eclipse.xtext.gmf.glue.editingdomain.UpdateXtextResourceTextCommand;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.CompoundXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.info.ResourceWorkingCopyFileEditorInput;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Base class to handle a small in-diagram XtextEditor.
 * 
 * Override the generated <code>performDirectEdit</code> methods in the EditPart of the label to be directly edited, and
 * call {@link #showEditor()} instead of opening the default {@link TextCellEditor}.
 * 
 * @author koehnlein
 */
public class PopupXtextEditorHelper {

	private static int MIN_EDITOR_WIDTH = 100;

	private static int MIN_EDITOR_HEIGHT = 20;

	private IGraphicalEditPart hostEditPart;

	private IEditorPart diagramEditor;

	private XtextEditor xtextEditor;

	private int editorOffset;

	private int initialEditorSize;

	private int initialDocumentSize;

	private Composite xtextEditorComposite;
	private final Injector xtextInjector;

	private XtextResource xtextResource;

	private String semanticElementFragment;

	public PopupXtextEditorHelper(IGraphicalEditPart editPart, Injector xtextInjector) {
		this.hostEditPart = editPart;
		this.xtextInjector = xtextInjector;
	}

	public void showEditor() {
		try {
			EObject semanticElement = hostEditPart.resolveSemanticElement();
			if (semanticElement == null) {
				return;
			}
			Resource semanticResource = semanticElement.eResource();
			if (!(semanticResource instanceof XtextResource)) {
				return;
			}
			semanticElementFragment = semanticResource.getURIFragment(semanticElement);
			if (semanticElementFragment == null || "".equals(semanticElementFragment)) {
				return;
			}
			IDiagramEditDomain diagramEditDomain = hostEditPart.getDiagramEditDomain();
			diagramEditor = ((DiagramEditDomain) diagramEditDomain).getEditorPart();
			xtextResource = (XtextResource) semanticResource;
			createXtextEditor(new ResourceWorkingCopyFileEditorInput(semanticResource));
		} catch (Exception e) {
			Activator.logError(e);
		}
	}

	public void closeEditor(boolean isReconcile) {
		if (xtextEditor != null) {
			if (isReconcile) {
				try {
					final IXtextDocument xtextDocument = xtextEditor.getDocument();
					if (!isDocumentHasErrors(xtextDocument)) {
						// subtract 2 for the artificial newlines
						int documentGrowth = xtextDocument.getLength() - initialDocumentSize - 2;
						String newText = xtextDocument.get(editorOffset + 1, initialEditorSize + documentGrowth);
						UpdateXtextResourceTextCommand.createUpdateCommand(xtextResource, editorOffset,
								initialEditorSize, newText).execute(null, null);
					}
				} catch (Exception exc) {
					Activator.logError(exc);
				}
			}
			xtextEditor.dispose();
			xtextEditorComposite.setVisible(false);
			xtextEditorComposite.dispose();
			xtextEditor = null;
			PartReactivationUtil.forceReactivation(diagramEditor);
		}
	}

	private void createXtextEditor(IEditorInput editorInput) throws Exception {
		Shell diagramShell = diagramEditor.getSite().getShell();
		xtextEditorComposite = new Decorations(diagramShell, SWT.RESIZE | SWT.ON_TOP | SWT.BORDER);
		xtextEditorComposite.setLayout(new FillLayout());
		IEditorSite editorSite = diagramEditor.getEditorSite();
		xtextEditor = xtextInjector.getInstance(XtextEditor.class);
		// remove dirty state editor callback
		xtextEditor.setXtextEditorCallback(new CompoundXtextEditorCallback(Guice.createInjector(new Module() {
			public void configure(Binder binder) {
			}
		})));
		xtextEditor.init(editorSite, editorInput);
		xtextEditor.createPartControl(xtextEditorComposite);
		registerKeyListener();
		setEditorRegion();
		setEditorBounds();
		xtextEditorComposite.setVisible(true);
		xtextEditorComposite.forceFocus();
		xtextEditor.setFocus();
		IWorkbenchPage page = diagramEditor.getSite().getPage();
		page.addPartListener(new IPartListener() {

			public void partActivated(IWorkbenchPart part) {
				closeEditor(false);
			}

			public void partBroughtToTop(IWorkbenchPart part) {
			}

			public void partClosed(IWorkbenchPart part) {
				closeEditor(false);
			}

			public void partDeactivated(IWorkbenchPart part) {
				closeEditor(false);
			}

			public void partOpened(IWorkbenchPart part) {
				closeEditor(false);
			}

		});
	}

	private void registerKeyListener() {
		XtextSourceViewer sourceViewer = (XtextSourceViewer) xtextEditor.getInternalSourceViewer();
		final StyledText xtextTextWidget = sourceViewer.getTextWidget();
		PopupXtextEditorKeyListener keyListener = new PopupXtextEditorKeyListener(this, sourceViewer
				.getContentAssistant());
		xtextTextWidget.addVerifyKeyListener(keyListener);
		xtextTextWidget.addKeyListener(keyListener);
	}

	private void setEditorRegion() throws BadLocationException {
		final IXtextDocument xtextDocument = xtextEditor.getDocument();
		boolean success = xtextEditor.getDocument().modify(new IUnitOfWork<Boolean, XtextResource>() {

			public Boolean exec(XtextResource state) throws Exception {
				EObject semanticElementInDocument = state.getEObject(semanticElementFragment);
				if (semanticElementInDocument == null) {
					return false;
				}
				CompositeNode xtextNode = getCompositeNode(semanticElementInDocument);
				if (xtextNode == null) {
					return false;
				}
				// getOffset() and getLength() are trimming whitespaces
				editorOffset = xtextNode.getOffset();
				initialEditorSize = xtextNode.getLength();
				initialDocumentSize = xtextDocument.getLength();

				// insert a newline directly before and after the node
				xtextDocument.replace(editorOffset, 0, "\n");
				xtextDocument.replace(editorOffset + 1 + initialEditorSize, 0, "\n");
				return true;
			}

		});

		if (success) {
			xtextEditor.showHighlightRangeOnly(true);
			xtextEditor.setHighlightRange(editorOffset + 1, initialEditorSize, true);
			xtextEditor.setFocus();
		}
	}

	private void setEditorBounds() {
		final IXtextDocument xtextDocument = xtextEditor.getDocument();
		// mind the added newlines
		String editString = "";
		try {
			editString = xtextDocument.get(editorOffset + 1, initialEditorSize);
		} catch (BadLocationException exc) {
			Activator.logError(exc);
		}
		int numLines = StringUtil.getNumLines(editString);
		int numColumns = StringUtil.getMaxColumns(editString);

		IFigure figure = hostEditPart.getFigure();
		Rectangle bounds = figure.getBounds().getCopy();
		DiagramRootEditPart diagramEditPart = (DiagramRootEditPart) hostEditPart.getRoot();
		IFigure contentPane = diagramEditPart.getContentPane();
		contentPane.translateToAbsolute(bounds);
		EditPartViewer viewer = hostEditPart.getViewer();
		Control control = viewer.getControl();
		while (control != null && false == control instanceof Shell) {
			bounds.translate(control.getBounds().x, control.getBounds().y);
			control = control.getParent();
		}

		Font font = figure.getFont();
		FontData fontData = font.getFontData()[0];
		int fontHeightInPixel = fontData.getHeight();

		// TODO: this needs some work...
		int width = Math.max(fontHeightInPixel * (numColumns + 3), MIN_EDITOR_WIDTH);
		int height = Math.max(fontHeightInPixel * (numLines + 4), MIN_EDITOR_HEIGHT);
		xtextEditorComposite.setBounds(bounds.x, bounds.y, width, height);
	}

	private CompositeNode getCompositeNode(EObject semanticElement) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(semanticElement);
		if (nodeAdapter != null) {
			final CompositeNode parserNode = nodeAdapter.getParserNode();
			return parserNode;
		}
		return null;
	}

	private boolean isDocumentHasErrors(final IXtextDocument xtextDocument) {
		return (xtextDocument.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
			public Boolean exec(XtextResource state) throws Exception {
				IParseResult parseResult = state.getParseResult();
				return !state.getErrors().isEmpty() || parseResult == null || !parseResult.getParseErrors().isEmpty();
			}
		}));
	}

}
