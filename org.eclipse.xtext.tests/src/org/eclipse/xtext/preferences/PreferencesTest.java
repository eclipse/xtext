/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.preferences;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PreferencesTest {
	
	@Test public void testPreferenceKeysProvider_01() {
		final Set<? extends PreferenceKey> keys = PreferenceKeysProvider.allConstantKeys(PrefsA.class);
		assertEquals(1, keys.size());
		assertEquals("my.inherited.key", keys.iterator().next().getId());
		assertEquals("inherited", keys.iterator().next().getDefaultValue());
	}
	
	@Test public void testPreferenceKeysProvider_02() {
		final Set<? extends PreferenceKey> keys = PreferenceKeysProvider.allConstantKeys(PrefsB.class);
		assertEquals(3, keys.size());
		assertEquals("true", find(keys, "foo.bar").getDefaultValue());
		assertEquals("42", find(keys, "my.int").getDefaultValue());
		assertEquals("inherited", find(keys, "my.inherited.key").getDefaultValue());
	}
	
	private PreferenceKey find(Set<? extends PreferenceKey> keys, String string) {
		for (PreferenceKey iPreferenceKey : keys) {
			if (iPreferenceKey.getId().equals(string))
				return iPreferenceKey;
		}
		return null;
	}

	public static class PrefsA {
		public static PreferenceKey INHERITED_KEY = new PreferenceKey("my.inherited.key","inherited");
	}
	
	public static class PrefsB extends PrefsA {
		public static String myInt = "42";
		public static PreferenceKey INT_KEY = new PreferenceKey("my.int", myInt);
		@SuppressWarnings("unused")
		private static PreferenceKey PRIVATE_KEY = new PreferenceKey("my.private.key","private");
		public static PreferenceKey BOOL_KEY = new PreferenceKey("foo.bar", Boolean.TRUE.toString());
	}
	
}

