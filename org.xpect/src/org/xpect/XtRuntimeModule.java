package org.xpect;

import org.eclipse.xtext.resource.FileExtensionProvider;
import org.xpect.registry.AbstractDelegatingModule;
import org.xpect.services.XtFileExtensionProvider;

import com.google.inject.Binder;

public class XtRuntimeModule extends AbstractDelegatingModule {

	@Override
	public void configure(Binder binder) {
		overrideAndBackup(binder, FileExtensionProvider.class, XtFileExtensionProvider.class);
	}

}
