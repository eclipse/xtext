/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.releng;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.xtext.util.IAcceptor;

/**
 * @author dhuebner - Initial contribution and API
 */
public class DialogCatalog {

	public static final void openFeatureSelectionDialog(final Shell shell, final IAcceptor<IProject> acceptor) {
		BusyIndicator.showWhile(shell.getDisplay(), new Runnable() {
			@SuppressWarnings("restriction")
			public void run() {
				org.eclipse.pde.internal.core.ifeature.IFeatureModel[] allModels = org.eclipse.pde.internal.core.PDECore
						.getDefault().getFeatureModelManager().getWorkspaceModels();

				SelectionDialog dialog = new org.eclipse.pde.internal.ui.dialogs.FeatureSelectionDialog(shell,
						allModels, false);
				if (dialog.open() == Window.OK) {
					Object[] models = dialog.getResult();
					if (models.length > 0) {
						Object selectedElement = models[0];
						if (selectedElement instanceof org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel) {
							IProject project = ((org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel) selectedElement)
									.getFile().getProject();
							acceptor.accept(project);
						}
					}
				}
			}
		});
	}

	public static String openOSFolderSelectionDialog(Shell shell) {
		DirectoryDialog dialog = new DirectoryDialog(shell, SWT.SAVE | SWT.SHEET);
		dialog.setMessage("TODO Message");
		dialog.setText("TODO Text");
		return dialog.open();
	}

}
