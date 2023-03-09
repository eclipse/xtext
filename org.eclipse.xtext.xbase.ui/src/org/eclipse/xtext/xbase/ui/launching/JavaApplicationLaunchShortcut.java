/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.launching;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
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
					.replaceWithJavaElementDelegates((IStructuredSelection) selection, JavaElementDelegateMainLaunch.class);
			super.launch(newSelection, mode);
		}
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		JavaElementDelegate javaElementDelegate = Adapters.adapt(editor, JavaElementDelegateMainLaunch.class);
		if (javaElementDelegate != null) {
			launch(new StructuredSelection(javaElementDelegate), mode);
		} else {
			super.launch(editor, mode);
		}
	}
}
