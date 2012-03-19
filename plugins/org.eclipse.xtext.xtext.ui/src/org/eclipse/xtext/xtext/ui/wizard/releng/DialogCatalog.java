/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.releng;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xtext.ui.Activator;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class DialogCatalog {

	public static final void openFeatureSelectionDialog(final Shell shell, final IAcceptor<IProject> acceptor) {
		PDEUtils.selectFeature(shell, acceptor);
	}

	public static String openOSFolderSelectionDialog(Shell shell) {
		DirectoryDialog dialog = new DirectoryDialog(shell, SWT.SAVE | SWT.SHEET);
		dialog.setMessage("TODO Message");
		dialog.setText("TODO Text");
		return dialog.open();
	}

	public static IFile openWorkspaceFileSelectionDialog(Shell shell, String patternString) {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(shell, new WorkbenchLabelProvider(),
				new WorkbenchContentProvider());
		dialog.setAllowMultiple(false);
		dialog.setTitle("Select workspace resource");
		dialog.setMessage("Select " + patternString + " file");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
		PatternFilter filter = new PatternFilter();
		filter.setPattern(patternString);
		dialog.addFilter(filter);
		dialog.setValidator(new ISelectionStatusValidator() {

			public IStatus validate(Object[] selection) {
				if (selection.length == 1) {
					IResource resource = (IResource) selection[0];
					if (resource instanceof IFile) {
						return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
					}
				}
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Please select a file.");
			}
		});
		dialog.create();
		dialog.open();
		Object result = dialog.getFirstResult();
		if (result == null) {
			return null;
		}
		IFile resource = (IFile) result;
		return resource;

	}
}
