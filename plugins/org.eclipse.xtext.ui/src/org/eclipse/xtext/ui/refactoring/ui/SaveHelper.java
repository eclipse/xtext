/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil;
import org.eclipse.xtext.ui.util.DisplayRunnable;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SaveHelper {

	@Inject
	private ProjectUtil projectUtil;

	@Inject
	private RefactoringPreferences prefs;

	@Inject(optional = true)
	private IWorkbench workbench;
	
	@Inject(optional = true)
	private IWorkspace workspace;
	
	@Inject  
	private SyncUtil syncUtil;

	public void saveEditors(final IRenameElementContext context) {
		new DisplayRunnable() {
			@Override
			protected void run() throws Exception {
				workspace.run(new IWorkspaceRunnable() {
					public void run(IProgressMonitor monitor) throws CoreException {
						IWorkbenchPage workbenchPage = getWorkbenchPage(context);
						if (prefs.isSaveAllBeforeRefactoring()) 
							workbenchPage.saveAllEditors(false);
						else
							saveDeclaringEditor(context, workbenchPage);
					}
				}, new NullProgressMonitor());
			}
		}.syncExec();
		syncUtil.waitForBuild(null);
	}

	protected IWorkbenchPage getWorkbenchPage(IRenameElementContext context) {
		IEditorPart triggeringEditor = context.getTriggeringEditor();
		return (triggeringEditor == null) ? workbench.getActiveWorkbenchWindow().getActivePage() : triggeringEditor
				.getEditorSite().getPage();
	}

	protected void saveDeclaringEditor(IRenameElementContext context, IWorkbenchPage workbenchPage) {
		IEditorPart declaringEditor = getOpenEditor(context.getTargetElementURI(), workbenchPage);
		if (declaringEditor != null && declaringEditor.isDirty())
			declaringEditor.doSave(new NullProgressMonitor());
	}

	protected IEditorPart getOpenEditor(URI uri, IWorkbenchPage page) {
		IFile file = projectUtil.findFileStorage(uri.trimFragment(), true);
		if (file != null) {
			FileEditorInput fileEditorInput = new FileEditorInput(file);
			return page.findEditor(fileEditorInput);
		}
		return null;
	}
	
	
}
