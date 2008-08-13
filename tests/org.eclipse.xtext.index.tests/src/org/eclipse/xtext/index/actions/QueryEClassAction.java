package org.eclipse.xtext.index.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class QueryEClassAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	private IProject selectedProject;

	public QueryEClassAction() {
	}

	public void run(IAction action) {
		EClassSelectionDialog eClassSelectionDialog = new EClassSelectionDialog(window.getShell(), selectedProject);
		eClassSelectionDialog.open();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				Object selectedElement = structuredSelection.getFirstElement();
				if (selectedElement instanceof IAdaptable) {
					IResource selectedResource = (IResource) ((IAdaptable) selectedElement).getAdapter(IResource.class);
					if (selectedResource != null) {
						selectedProject = selectedResource.getProject();
						action.setEnabled(true);
						return;
					}
				}
			}
		}
		selectedProject = null;
		action.setEnabled(false);
	}

	/**
	 * We can use this method to dispose of any system resources we previously
	 * allocated.
	 * 
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to be able to provide parent shell
	 * for the message dialog.
	 * 
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}