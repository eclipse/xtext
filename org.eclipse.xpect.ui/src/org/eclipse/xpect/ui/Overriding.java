package org.eclipse.xpect.ui;

import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.ResourceValidatorImpl;

import com.google.inject.Binder;
import com.google.inject.Module;

public class Overriding implements Module {

	@Override
	public void configure(Binder binder) {
		// binder.bind(IResourceValidator.class).to(
		// FilteringResourceValidator.class);
		// binder.bind(ResourceValidatorImpl.class).to(
		// FilteringResourceValidator.class);

		binder.bind(XtextResourceSetProvider.class).to(
				OverridingXtextResourceSetProvider.class);
		System.out.println("Overriding Module");
	}

}
