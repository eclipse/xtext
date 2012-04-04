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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
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
		dialog.setMessage("Select Buckminster headless installation directory");
		dialog.setText("Buckminster headless");
		return dialog.open();
	}

	public static IFile openWorkspaceFileSelectionDialog(Shell shell, String patternString,
			ViewerFilter additionalFilter) {
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
		if (additionalFilter != null)
			dialog.addFilter(additionalFilter);
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
		if (!(result instanceof IFile)) {
			return null;
		}
		IFile resource = (IFile) result;
		return resource;

	}

	public static IFile openJunitLaunchSelectionDialog(Shell shell) {
		ViewerFilter viewerFilter = new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof IFile) {
					IFile file = (IFile) element;
					ILaunchConfiguration launchConfiguration = DebugPlugin.getDefault().getLaunchManager()
							.getLaunchConfiguration(file);
					try {
						if ("JUnit".equals(launchConfiguration.getType().getName())) {
							return true;
						}
					} catch (CoreException e) {
						e.printStackTrace();
					}
					return false;
				}
				return true;
			}
		};
		return openWorkspaceFileSelectionDialog(shell, "*.launch", viewerFilter);
	}
}
