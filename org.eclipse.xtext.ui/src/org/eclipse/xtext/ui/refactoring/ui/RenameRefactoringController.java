/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import static org.eclipse.xtext.util.Strings.*;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ILinkedPositionGroupCalculator;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy.Provider.NoSuchStrategyException;
import org.eclipse.xtext.ui.refactoring2.rename.ISimpleNameProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Handles the various UI states of a refactoring, such as linked mode, dialog, and direct refactoring.
 *  
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class RenameRefactoringController {

	@Inject(optional = true)
	private IWorkbench workbench;

	@Inject
	private Provider<RenameLinkedMode> renameLinkedModeProvider;

	@Inject
	private IRenameSupport.Factory renameSupportFactory;

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	@Inject
	private Provider<LinkedEditingUndoSupport> undoSupportProvider;
	
	@Inject
	private RefactoringPreferences preferences;
	
	@Inject
	private ILinkedPositionGroupCalculator linkedPositionGroupCalculator;
	
	private RenameLinkedMode activeLinkedMode;

	private IRenameElementContext renameElementContext;

	private LinkedEditingUndoSupport undoSupport;

	private String newName;
	
	public void initialize(IRenameElementContext renameElementContext) {
		if (activeLinkedMode != null) {
			if (activeLinkedMode.isSameRenameElementContext(renameElementContext)) {
				return;
			} else {
				cancelLinkedMode();
			}
		}
		this.renameElementContext = renameElementContext;
		this.newName = null;
	}
	
	public void startRefactoring(IRenameElementContext renameElementContext) {
		initialize(renameElementContext);
		if(preferences.useInlineRefactoring() && getActiveLinkedMode() == null)
			startRefactoring(RefactoringType.LINKED_EDITING);
		else 
			startRefactoring(RefactoringType.REFACTORING_DIALOG);
	}

	public void startRefactoring(RefactoringType refactoringType) {
		ViewFreezer freezer = null;
		try {
			if (refactoringType == RefactoringType.LINKED_EDITING) {
				startLinkedEditing();
				return;
			}
			if (activeLinkedMode != null)
				this.newName = activeLinkedMode.getCurrentName();
			freezer = new ViewFreezer(getXtextEditor().getInternalSourceViewer());
			freezer.freeze();
			// Cancel undoable right now because the freezer would show the old
			// state and not the new one
			if (undoSupport != null) {
				undoSupport.undoDocumentChanges();
				undoSupport = null;
			}
			cancelLinkedMode();
			switch (refactoringType) {
				case REFACTORING_DIRECT:
					startDirectRefactoring();
					break;
				case REFACTORING_DIALOG:
					startRefactoringWithDialog(false);
					break;
				case REFACTORING_PREVIEW:
					startRefactoringWithDialog(true);
					break;
				default:
					throw new IllegalStateException("Invalid refactoring type " + refactoringType.toString());
			}
		} catch (InterruptedException exc) {
			// canceling by the user is ok
			restoreOriginalSelection();
		} finally {
			if (freezer != null)
				freezer.release();
		}
	}

	protected void startLinkedEditing() throws InterruptedException {
		if (activeLinkedMode != null) 
			startRefactoring(RefactoringType.REFACTORING_DIALOG);
		try {
			final XtextEditor xtextEditor = getXtextEditor();
			if (xtextEditor != null) {
				workbench.getProgressService().run(true, true, new IRunnableWithProgress() {
					@Override
					public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
						try {
							final Provider<LinkedPositionGroup> provider = linkedPositionGroupCalculator.getLinkedPositionGroup(renameElementContext, monitor);
							Display display = workbench.getDisplay();
							display.syncExec(new Runnable() {
								
								@Override
								public void run() {
									RenameLinkedMode newLinkedMode = renameLinkedModeProvider.get();
									if (newLinkedMode.start(renameElementContext, provider, monitor)) {
										activeLinkedMode = newLinkedMode;
										undoSupport = undoSupportProvider.get();
										undoSupport.startRecording(xtextEditor);
									}
								}
							});
						} catch(OperationCanceledException e) {
							throw new InterruptedException();
						}
					}
				});
				if (activeLinkedMode == null) {
					startRefactoring(RefactoringType.REFACTORING_DIALOG);
				}
			}
		} catch (InterruptedException e) {
			throw e;
		} catch (Exception exc) {
			// unwrap invocation target exceptions
			if (exc.getCause() instanceof RuntimeException)
				throw (RuntimeException) exc.getCause();
			if (exc instanceof RuntimeException)
				throw (RuntimeException) exc;
			throw new WrappedException(exc);
		}
	}

	public RenameLinkedMode getActiveLinkedMode() {
		return activeLinkedMode;
	}

	/**
	 * Linked mode is unrecoverable canceled.
	 */
	public void cancelLinkedMode() {
		if (activeLinkedMode != null) {
			activeLinkedMode.linkedModeLeft();
			activeLinkedMode = null;
		}
	}

	protected void startDirectRefactoring() throws InterruptedException {
		if (Strings.isEmpty(newName)) {
			restoreOriginalSelection();
		} else {
			String originalName = getOriginalName(getXtextEditor());
			if(!equal(originalName, newName)) {
				IRenameSupport renameSupport = createRenameSupport(renameElementContext, newName);
				if(renameSupport != null) 
					renameSupport.startDirectRefactoring();
			}
		}
	}

	protected void startRefactoringWithDialog(final boolean previewOnly) throws InterruptedException {
		if (Strings.isEmpty(newName))
			newName = getOriginalName(getXtextEditor());
		if (Strings.isEmpty(newName)) 
			restoreOriginalSelection();
		else {
			IRenameSupport renameSupport = createRenameSupport(renameElementContext, newName);
			if(renameSupport != null) {
				renameSupport.startRefactoringWithDialog(previewOnly);
			}
		}
	}

	protected String getOriginalName(final XtextEditor xtextEditor) {
		return xtextEditor.getDocument().tryReadOnly(new IUnitOfWork<String, XtextResource>() {
			@Override
			public String exec(XtextResource state) throws Exception {
				EObject targetElement = state.getResourceSet().getEObject(renameElementContext.getTargetElementURI(),
						false);
				if (targetElement == null) {
					return null;
				}
				IRenameStrategy.Provider strategyProvider = globalServiceProvider.findService(targetElement,
						IRenameStrategy.Provider.class);
				try {
					if (strategyProvider != null) {
						IRenameStrategy strategy = strategyProvider.get(targetElement, renameElementContext);
						if (strategy != null)
							return strategy.getOriginalName();
					}
				} catch(NoSuchStrategyException e) {
					// null
				}
				ISimpleNameProvider simpleNameProvider = globalServiceProvider.findService(targetElement, ISimpleNameProvider.class);
				if (simpleNameProvider != null)
					return simpleNameProvider.getSimpleName(targetElement);
				else
					return null;
			}
		});
	}

	protected IRenameSupport createRenameSupport(IRenameElementContext context, String name) {
		return renameSupportFactory.create(context, newName);
	}

	protected void restoreOriginalSelection() {
		ISelection originalSelection = renameElementContext.getTriggeringEditorSelection();
		if (originalSelection instanceof ITextSelection) {
			getXtextEditor().getInternalSourceViewer().setSelectedRange(
					((ITextSelection) originalSelection).getOffset(), ((ITextSelection) originalSelection).getLength());
		}
	}

	protected XtextEditor getXtextEditor() {
		IEditorPart part = renameElementContext.getTriggeringEditor();
		if (part instanceof XtextEditor) {
			return (XtextEditor) part;
		}
		return null;
	}
}
