/*******************************************************************************
 * Copyright (c) 2014, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.preferences;

/**
 * A typed wrapper around an existing {@link IPreferenceValues preference values instance}.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @since 2.26
 */
public class TypedPreferenceValues implements ITypedPreferenceValues {

	private final IPreferenceValues delegate;

	public static ITypedPreferenceValues castOrWrap(IPreferenceValues values) {
		if (values instanceof ITypedPreferenceValues)
			return (ITypedPreferenceValues) values;
		return new TypedPreferenceValues(values);
	}

	protected TypedPreferenceValues(IPreferenceValues delegate) {
		super();
		this.delegate = delegate;
	}

	public IPreferenceValues getDelegate() {
		return delegate;
	}

	@Override
	public String getPreference(PreferenceKey key) {
		String string = delegate.getPreference(key);
		return string;
	}

	@Override
	public <T> T getPreference(TypedPreferenceKey<T> key) {
		String string = delegate.getPreference(key);
		T result = key.toValue(string);
		return result;
	}

}
