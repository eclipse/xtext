package org.eclipse.xpect;

import org.eclipse.xpect.registry.AbstractDelegatingModule;
import org.eclipse.xpect.services.XtFileExtensionProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;

import com.google.inject.Binder;

public class XtRuntimeModule extends AbstractDelegatingModule {

	@Override
	public void configure(Binder binder) {
		overrideAndBackup(binder, FileExtensionProvider.class, XtFileExtensionProvider.class);
	}

}
