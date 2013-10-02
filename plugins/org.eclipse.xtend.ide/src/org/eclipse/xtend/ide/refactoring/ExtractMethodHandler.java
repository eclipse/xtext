/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.refactoring.ui.DefaultRenameElementHandler;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringWizardOpenOperation_NonForking;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ExtractMethodHandler extends AbstractHandler {

	private static final Logger LOG = Logger.getLogger(DefaultRenameElementHandler.class);

	@Inject
	private SyncUtil syncUtil;

	@Inject
	private ExpressionUtil expressionUtil;

	@Inject
	private Provider<ExtractMethodRefactoring> refactoringProvider;

	@Inject
	private ExtractMethodWizard.Factory wizardFactory;
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			syncUtil.totalSync(false);
			final XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			if (editor != null) {
				final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
				final IXtextDocument document = editor.getDocument();
				document.readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						List<XExpression> expressions = expressionUtil.findSelectedSiblingExpressions(resource,
								selection);
						if (!expressions.isEmpty()) {
							ExtractMethodRefactoring extractMethodRefactoring = refactoringProvider.get();
							if (extractMethodRefactoring.initialize(editor, expressions, true)) {
								updateSelection(editor, expressions);
								ExtractMethodWizard wizard = wizardFactory.create(extractMethodRefactoring);
								RefactoringWizardOpenOperation_NonForking openOperation = new RefactoringWizardOpenOperation_NonForking(
										wizard);
								openOperation.run(editor.getSite().getShell(), "Extract Method");
							}
						}
					}
				});
			}
		} catch (Exception exc) {
			LOG.error("Error during refactoring", exc);
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error during refactoring", exc.getMessage()
					+ "\nSee log for details");
		}
		return null;
	}

	protected void updateSelection(final XtextEditor editor, List<XExpression> expressions) {
		ICompositeNode firstNode = NodeModelUtils.getNode(expressions.get(0));
		ICompositeNode lastNode = NodeModelUtils.getNode(expressions.get(expressions.size() - 1));
		if (firstNode != null && lastNode != null) {
			int correctedSelectionOffset = firstNode.getOffset();
			int correctedSelectionLength = lastNode.getEndOffset() - correctedSelectionOffset;
			editor.selectAndReveal(correctedSelectionOffset, correctedSelectionLength);
		}
	}
}
