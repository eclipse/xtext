package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

// TODO: remove this guy - nobody seems to use it and the resource change API of the workspace
// allows fine grained listening
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
