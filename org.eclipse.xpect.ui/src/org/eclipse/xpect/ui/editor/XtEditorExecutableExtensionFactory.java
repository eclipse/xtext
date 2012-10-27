package org.eclipse.xpect.ui.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xpect.registry.ILanguageInfo;
import org.eclipse.xpect.ui.XpectPluginActivator;
import org.eclipse.xpect.ui.util.XtInjectorSetupUtil;
import org.eclipse.xpect.util.ReflectionUtil;
import org.eclipse.xpect.util.URIDelegationHandler;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

public class XtEditorExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return XpectPluginActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		IFile file = getFileOfCurrentlyOpeningEditor();
		if (file == null)
			throw new RuntimeException("Could not determine which editor is currently being opened.");
		String fileExtension = new URIDelegationHandler().getOriginalFileExtension(file.getName());
		if (fileExtension == null)
			throw new RuntimeException("Could determin file extension of Xtext language for file " + file.getName());
		ILanguageInfo languageInfo = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(fileExtension);
		if (languageInfo == null)
			throw new RuntimeException("There is no Xtext Lanugage for file extension '" + fileExtension + "'");
		return XtInjectorSetupUtil.getWorkbenchInjector(languageInfo, file);
	}

	protected IWorkbenchPage getActiveWorkbenchPage() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		if (page != null)
			return page;
		Object perspectiveSwitcher = ReflectionUtil.readField(window, "perspectiveSwitcher", Object.class);
		if (perspectiveSwitcher == null)
			return null;
		Object reorderListener = ReflectionUtil.readField(perspectiveSwitcher, "reorderListener", Object.class);
		if (reorderListener == null)
			return null;
		Object parent = ReflectionUtil.getParentObject(reorderListener);
		if (parent instanceof IWorkbenchPage)
			return (IWorkbenchPage) parent;
		return null;
	}

	protected IFile getFileOfCurrentlyOpeningEditor() {
		try {
			IWorkbenchPage page = getActiveWorkbenchPage();
			if (page != null) {
				IEditorReference[] references = page.getEditorReferences();
				IEditorInput input = references[0].getEditorInput();
				if (input instanceof IFileEditorInput)
					return ((IFileEditorInput) input).getFile();
			}
			return null;
		} catch (PartInitException e) {
			throw new RuntimeException();
		}
	}

}
