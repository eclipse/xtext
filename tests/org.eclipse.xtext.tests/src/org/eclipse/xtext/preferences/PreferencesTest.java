/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;

import java.util.HashMap;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PreferencesTest {
	
	@Test public void testPreferenceKeysProvider_01() {
		final Set<? extends IPreferenceKey<?>> keys = PreferenceKeysProvider.allConstantKeys(PrefsA.class);
		assertEquals(1, keys.size());
		assertEquals("my.inherited.key", keys.iterator().next().getId());
		assertEquals("inherited", keys.iterator().next().getDefaultValue());
	}
	
	@Test public void testPreferenceKeysProvider_02() {
		final Set<? extends IPreferenceKey<?>> keys = PreferenceKeysProvider.allConstantKeys(PrefsB.class);
		assertEquals(3, keys.size());
		assertEquals(true, find(keys, "foo.bar").getDefaultValue());
		assertEquals(42, find(keys, "my.int").getDefaultValue());
		assertEquals("inherited", find(keys, "my.inherited.key").getDefaultValue());
	}
	
	@Test public void testPreferenceKeysProvider_03() {
		final Set<? extends IPreferenceKey<?>> keys = PreferenceKeysProvider.allConstantKeys(PrefsC.class);
		assertEquals(1, keys.size());
		MapBasedPreferenceValues values = new MapBasedPreferenceValues(new HashMap<String, String>());
		assertEquals(PrefsA.INHERITED_KEY.getDefaultValue(), values.getPreference(find(keys, "delegating.key")));
	}

	private IPreferenceKey<?> find(Set<? extends IPreferenceKey<?>> keys, String string) {
		for (IPreferenceKey<?> iPreferenceKey : keys) {
			if (iPreferenceKey.getId().equals(string))
				return iPreferenceKey;
		}
		return null;
	}

}

class PrefsA {
	public static StringKey INHERITED_KEY = new StringKey("my.inherited.key","inherited");
}

class PrefsB extends PrefsA {
	public static Integer myInt = 42;
	public static IntegerKey INT_KEY = new IntegerKey("my.int", myInt);
	@SuppressWarnings("unused")
	private static StringKey PRIVATE_KEY = new StringKey("my.private.key","private");
	public static BooleanKey BOOL_KEY = new BooleanKey("foo.bar", true);
}

class PrefsC {
	public static StringKey DELEGATING_KEY = new StringKey("delegating.key", null) {
		@Override
		public org.eclipse.xtext.preferences.IPreferenceKey<String> getDelegationKey() {
			return PrefsA.INHERITED_KEY;
		}
	};
}
