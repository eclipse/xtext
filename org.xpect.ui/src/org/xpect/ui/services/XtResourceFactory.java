package org.xpect.ui.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.xpect.ui.util.XtInjectorSetupUtil;
import org.xpect.util.URIDelegationHandler;

import com.google.inject.Injector;

public class XtResourceFactory implements IResourceFactory {

	@Override
	public Resource createResource(URI uri) {
		String ext = new URIDelegationHandler().getOriginalFileExtension(uri.lastSegment());
		if (ext != null) {
			Injector injector = XtInjectorSetupUtil.getWorkbenchInjector(uri, ext);
			if (injector != null)
				return injector.getInstance(IResourceFactory.class).createResource(uri);
		}
		return Registry.INSTANCE.getFactory(uri.appendFileExtension("xpect")).createResource(uri);
	}

}
