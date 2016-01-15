package org.eclipse.xpect.registry;

import java.util.Collection;

public class DelegatingExtensionInfoRegistry implements IExtensionInfo.Registry {

	private IExtensionInfo.Registry delegate;

	public IExtensionInfo.Registry getDelegate() {
		return delegate;
	}

	public Collection<String> getExtensionPoints() {
		return delegate.getExtensionPoints();
	}

	public Collection<IExtensionInfo> getExtensions(String extensionPointName) {
		return delegate.getExtensions(extensionPointName);
	}

	public void setDelegate(IExtensionInfo.Registry delegate) {
		this.delegate = delegate;
	}

	@Override
	public String toString() {
		return delegate.toString();
	}

}
