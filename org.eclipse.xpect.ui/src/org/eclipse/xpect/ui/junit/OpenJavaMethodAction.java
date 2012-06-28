package org.eclipse.xpect.ui.junit;

import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.runners.TypeUtil;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PartInitException;

/**
 * @see org.eclipse.ui.actions.OpenFileAction
 */
public class OpenJavaMethodAction extends Action {

	private ITestElement element;

	private String method;

	public OpenJavaMethodAction(ITestElement element, String method, String text, String toolTipText) {
		super();
		this.element = element;
		this.method = method;
		setText(text);
		setToolTipText(toolTipText);
	}

	public IMethod findMethod(IType type, String name) throws JavaModelException {
		for (IMethod m : type.getMethods())
			if (m.getElementName().equals(name))
				return m;
		return null;
	}

	@Override
	public void run() {
		try {
			IType type = TypeUtil.findType(element);
			if (type != null) {
				IMethod iMethod;
				iMethod = findMethod(type, method);
				if (iMethod == null)
					MessageDialog.openError(null, "Java Element not found", "Java Element not found");
				else
					JavaUI.openInEditor(iMethod);
			} else
				MessageDialog.openError(null, "Java Element not found", "Java Element not found");
		} catch (JavaModelException e) {
		} catch (PartInitException e) {
		}
	}

}
