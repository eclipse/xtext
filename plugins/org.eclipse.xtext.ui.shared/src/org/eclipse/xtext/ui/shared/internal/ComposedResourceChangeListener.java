package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class ComposedResourceChangeListener extends AbstractComposite<IResourceChangeListener> implements IResourceChangeListener {
	
	@Inject
	public ComposedResourceChangeListener(Injector injector) {
		super(IResourceChangeListener.class, injector);
	}

	public void resourceChanged(IResourceChangeEvent event) {
		for (IResourceChangeListener listener : getElements()) {
			listener.resourceChanged(event);
		}
	}

}
