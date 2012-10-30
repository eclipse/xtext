package org.eclipse.xpect.ui.launching;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

public class LaunchShortcutUtil {
	public static IStructuredSelection replaceWithJavaElementDelegates(IStructuredSelection sel) {
		Object[] selection = sel.toArray();
		Object[] result = new Object[selection.length];
		for (int i = 0; i < selection.length; i++) {
			Object s = selection[i];
			if (s == null || s instanceof IJavaElement || s instanceof JUnitJavaElementDelegate || !(s instanceof IAdaptable))
				result[i] = s;
			else {
				IAdaptable adaptable = (IAdaptable) s;
				JUnitJavaElementDelegate delegate = (JUnitJavaElementDelegate) adaptable.getAdapter(JUnitJavaElementDelegate.class);
				result[i] = delegate != null ? delegate : s;
			}
		}
		StructuredSelection newSelection = new StructuredSelection(result);
		return newSelection;
	}

}
