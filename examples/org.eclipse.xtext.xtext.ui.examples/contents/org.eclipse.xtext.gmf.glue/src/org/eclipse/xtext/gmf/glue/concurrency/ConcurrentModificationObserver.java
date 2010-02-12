/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.concurrency;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * Detects concurrent modifications of GMF and Xtext editors based on Xtext's dirty state management.
 * 
 * @author koehnlein
 */
public class ConcurrentModificationObserver implements IPartListener {

	private EditingDomainAdapter.Factory factory;

	public ConcurrentModificationObserver(IWorkbenchPage activePage) {
		factory = new EditingDomainAdapter.Factory();
		for (IEditorReference editorRef : activePage.getEditorReferences()) {
			IEditorPart editor = editorRef.getEditor(false);
			if (editor != null) {
				partOpened(editor);
			}
		}
	}

	public void partOpened(IWorkbenchPart part) {
		if (part instanceof DiagramEditor) {
			TransactionalEditingDomain editingDomain = ((DiagramEditor) part).getEditingDomain();
			factory.adapt(editingDomain, EditingDomainAdapter.class);
		}
	}

	public void partClosed(IWorkbenchPart part) {
		if (part instanceof DiagramEditor) {
			// as long as bug 299920 is not fixed, we have to dispose the adapter manually
			TransactionalEditingDomain editingDomain = ((DiagramEditor) part).getEditingDomain();
			if (editingDomain != null) {
				EditingDomainAdapter adapter = (EditingDomainAdapter) factory.adapt(editingDomain,
						EditingDomainAdapter.class);
				if (adapter != null) {
					adapter.dispose();
				}
			}
		}
	}

	public void partActivated(IWorkbenchPart part) {
		// do nothing
	}

	public void partDeactivated(IWorkbenchPart part) {
		// do nothing
	}

	public void partBroughtToTop(IWorkbenchPart part) {
		// do nothing
	}

	public static class Initializer implements IStartup {
		public void earlyStartup() {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					activePage.addPartListener(new ConcurrentModificationObserver(activePage));
				}
			});
		}
	}

}
