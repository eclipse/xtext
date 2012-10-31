/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.registry;

import java.util.Collection;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
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
