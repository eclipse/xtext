/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.preferencepage;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.ui.core.internal.Activator;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class DefaultScopedPreferenceStoreAccess implements IScopedPreferenceStoreAccessor {
	
	private ScopedPreferenceStore store;

	public ScopedPreferenceStore getStore() {
		if (store == null)
			store = new ScopedPreferenceStore(
					new InstanceScope(), Activator.getDefault().getBundle().getSymbolicName());
		return store;
	}

}
