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
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.feature.WorkspaceFeatureModel;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.pde.internal.ui.dialogs.FeatureSelectionDialog;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.xtext.util.IAcceptor;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class PDEUtils {

	public static boolean featureProjectExists(String projectName) {
		boolean match = false;
		for (IFeatureModel iFeatureModel : PDECore.getDefault().getFeatureModelManager().getWorkspaceModels()) {
			WorkspaceFeatureModel wsModel = (WorkspaceFeatureModel) iFeatureModel;
			IProject iProject = wsModel.getFile().getProject();
			if (iProject.getName().equals(projectName)) {
				match = true;
				break;
			}
		}
		return match;
	}

	public static void selectFeature(final Shell shell, final IAcceptor<IProject> acceptor) {
		BusyIndicator.showWhile(shell.getDisplay(), new Runnable() {
			public void run() {
				IFeatureModel[] allModels = PDECore.getDefault().getFeatureModelManager().getWorkspaceModels();

				SelectionDialog dialog = new FeatureSelectionDialog(shell, allModels, false);
				if (dialog.open() == Window.OK) {
					Object[] models = dialog.getResult();
					if (models.length > 0) {
						Object selectedElement = models[0];
						if (selectedElement instanceof WorkspaceFeatureModel) {
							IProject project = ((WorkspaceFeatureModel) selectedElement).getFile().getProject();
							acceptor.accept(project);
						}
					}
				}
			}
		});
	}
}
