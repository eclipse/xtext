package org.eclipse.xtext.ui.resource.generic;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

import com.google.inject.Inject;

public class AdapterFactoryDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

	@Inject
	private AdapterFactoryLabelProvider delegate;
	
	@Override
	public Object image(IEObjectDescription element) {
		return delegate.getImage(element.getEObjectOrProxy());
	}
	
}
