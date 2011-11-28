/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.launching;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class JavaApplicationLaunchShortcut extends
		org.eclipse.jdt.debug.ui.launchConfigurations.JavaApplicationLaunchShortcut {
	@Override
	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection newSelection = LaunchShortcutUtil
					.replaceWithJavaElementDelegates((IStructuredSelection) selection);
			super.launch(newSelection, mode);
		}
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		IStructuredSelection selection = LaunchShortcutUtil.toSelectionWithJavaElementDelegates(editor);
		if (selection != null) {
			launch(selection, mode);
		} else {
			super.launch(editor, mode);
		}
	}
}
