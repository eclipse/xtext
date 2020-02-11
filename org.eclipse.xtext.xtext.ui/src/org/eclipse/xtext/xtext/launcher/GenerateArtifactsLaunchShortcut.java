/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.launcher;

import static org.eclipse.xtext.xtext.launcher.WorkflowLaunchUtils.*;

import org.eclipse.core.resources.IResource;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class GenerateArtifactsLaunchShortcut implements ILaunchShortcut {

	@Override
	public void launch(ISelection selection, String mode) {
		IResource workflowFile = workflowFileFor(selection);
		if (workflowFile != null) {
			runWorkflow(workflowFile, mode);
		}
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		IResource workflowFile = workflowFileFor(editor);
		if (workflowFile != null) {
			runWorkflow(workflowFile, mode);
		}
	}

}
