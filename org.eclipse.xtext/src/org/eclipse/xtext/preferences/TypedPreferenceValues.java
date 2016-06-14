/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TypedPreferenceValues implements ITypedPreferenceValues {

	private final IPreferenceValues delegate;

	public static ITypedPreferenceValues castOrWrap(IPreferenceValues values) {
		if (values instanceof ITypedPreferenceValues)
			return (ITypedPreferenceValues) values;
		return new TypedPreferenceValues(values);
	}

	public TypedPreferenceValues(IPreferenceValues delegate) {
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
