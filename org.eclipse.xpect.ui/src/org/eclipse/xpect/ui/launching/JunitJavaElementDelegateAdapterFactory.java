package org.eclipse.xpect.ui.launching;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

public class JunitJavaElementDelegateAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
		if (adaptableObject instanceof JUnitJavaElementDelegate)
			return ((JUnitJavaElementDelegate) adaptableObject).getAdapter(adapterType);
		if (!(JUnitJavaElementDelegate.class.equals(adapterType)))
			return null;

		if (adaptableObject instanceof IFileEditorInput)
			return new JUnitJavaElementDelegate((IFileEditorInput) adaptableObject);
		if (adaptableObject instanceof IResource)
			return new JUnitJavaElementDelegate((IResource) adaptableObject);
		if (adaptableObject instanceof IEditorPart)
			return new JUnitJavaElementDelegate((IEditorPart) adaptableObject);
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Class[] getAdapterList() {
		return new Class[] { JUnitJavaElementDelegate.class };
	}

}
