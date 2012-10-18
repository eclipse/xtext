package org.eclipse.xpect.registry;

import java.util.Collection;

public class DelegatingLanguageRegistry implements ILanguageInfo.Registry {

	private ILanguageInfo.Registry delegate;

	public ILanguageInfo.Registry getDelegate() {
		return delegate;
	}

	@Override
	public ILanguageInfo getLanguageByFileExtension(String fileExtension) {
		return delegate.getLanguageByFileExtension(fileExtension);
	}

	@Override
	public ILanguageInfo getLanguageByName(String languageName) {
		return delegate.getLanguageByName(languageName);
	}

	@Override
	public Collection<ILanguageInfo> getLanguages() {
		return delegate.getLanguages();
	}

	public void setDelegate(ILanguageInfo.Registry delegate) {
		this.delegate = delegate;
	}

}
