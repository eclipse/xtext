package org.xpect.ui.launching;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;

public class JUnitPDELaunchShortcut extends org.eclipse.pde.ui.launcher.JUnitWorkbenchLaunchShortcut {

	@Override
	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection newSelection = LaunchShortcutUtil.replaceWithJavaElementDelegates((IStructuredSelection) selection);
			super.launch(newSelection, mode);
		}
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		JUnitJavaElementDelegate delegate = (JUnitJavaElementDelegate) editor.getAdapter(JUnitJavaElementDelegate.class);
		if (delegate != null)
			launch(new StructuredSelection(delegate), mode);
		else
			super.launch(editor, mode);

	}
}
