/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.util;

import org.eclipse.xtext.util.Strings;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ExtensionFactoryUtil {
	protected static final String EXECUTABLE_EXTENSION_FACTORY = "ExecutableExtensionFactory";

	public static class NameAndClass {
		private final String uiLangName;
		private final String clazz;

		public NameAndClass(String uiLangName, String clazz) {
			super();
			this.uiLangName = uiLangName;
			this.clazz = clazz;
		}

		public String getUiLangName() {
			return uiLangName;
		}

		public String getClazz() {
			return clazz;
		}

		public boolean hasNameAndClass() {
			return !Strings.isEmpty(clazz) && !Strings.isEmpty(uiLangName);
		}
	}

	public static NameAndClass parseExtensionFactory(String factAndClass) {
		if (factAndClass == null)
			return new NameAndClass(null, null);
		String[] segs = factAndClass.split(":");
		if (segs.length == 2) {
			String fact = segs[0];
			String clazz = segs[1];
			if (fact.endsWith(EXECUTABLE_EXTENSION_FACTORY)) {
				return new NameAndClass(fact.substring(0, fact.length() - EXECUTABLE_EXTENSION_FACTORY.length()), clazz);
				// return Tuples.create(Strings.skipLastToken(fact, "."),
				// clazz);
				// String[] s = ).split("\\.");
				// List<String> result = Lists.newArrayList();
				// if (s.length > 1 && "ui".equals(s[s.length - 2])) {
				// for (int i = 0; i < s.length; i++)
				// if (i != s.length - 2)
				// result.add(s[i]);
				// String lang = Joiner.on(".").join(result);
				// return Tuples.create(lang, clazz);
				// }
			}
			return new NameAndClass(null, clazz);
		} else
			return new NameAndClass(null, factAndClass);
	}
}
