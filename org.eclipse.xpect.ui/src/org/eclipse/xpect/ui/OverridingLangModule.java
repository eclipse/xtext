package org.eclipse.xpect.ui;

import com.google.inject.Binder;
import com.google.inject.Module;

public class OverridingLangModule implements Module {

	@Override
	public void configure(Binder binder) {
		// binder.bind(IResourceValidator.class).to(
		// FilteringResourceValidator.class);
		// binder.bind(ResourceValidatorImpl.class).to(
		// FilteringResourceValidator.class);
	}

}
