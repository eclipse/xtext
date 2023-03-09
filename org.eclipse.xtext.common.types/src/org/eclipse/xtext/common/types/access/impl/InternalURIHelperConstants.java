/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

/**
 * @author zarnekow - Initial contribution and API
 */
public class InternalURIHelperConstants implements URIHelperConstants {
	protected static final URI[] PRIMITIVE_URIS = {
		PRIMITIVES_URI.appendFragment("byte"), // 'B'
		PRIMITIVES_URI.appendFragment("char"), // 'C'
		PRIMITIVES_URI.appendFragment("double"), // 'D'
		null, // 'E'
		PRIMITIVES_URI.appendFragment("float"), // 'F'
		null, // 'G'
		null, // 'H'
		PRIMITIVES_URI.appendFragment("int"), // 'I'
		PRIMITIVES_URI.appendFragment("long"), // 'J'
		null, // 'K'
		null, // 'L'
		null, // 'M'
		null, // 'N'
		null, // 'O'
		null, // 'P'
		null, // 'Q'
		null, // 'R'
		PRIMITIVES_URI.appendFragment("short"), // 'S'
		null, // 'T'
		null, // 'U'
		PRIMITIVES_URI.appendFragment("void"), // 'V'
		null, // 'W'
		null, // 'X'
		null, // 'Y'
		PRIMITIVES_URI.appendFragment("boolean"), // 'Z'
	};

	/**
	 * Names of commonly used classes for which we'll {@link #COMMON_URIS cache} their corresponding URIs.
	 */
	static final String[] COMMON_CLASS_NAMES = {
		"java.lang.annotation.Annotation",

		"java.io.Serializable",
		"java.io.IOException",

		"java.lang.Boolean",
		"java.lang.Byte",
		"java.lang.Character",
		"java.lang.CharSequence",
		"java.lang.Class",
		"java.lang.Comparable",
		"java.lang.Double",
		"java.lang.Exception",
		"java.lang.Float",
		"java.lang.Integer",
		"java.lang.Iterable",
		"java.lang.Long",
		"java.lang.Math",
		"java.lang.Object",
		"java.lang.Short",
		"java.lang.String",
		"java.lang.StringBuilder",
		"java.lang.StringBuffer",
		"java.lang.Throwable",
		"java.lang.Void",

		"java.math.BigDecimal",
		"java.math.BigInteger",

		"java.util.ArrayList",
		"java.util.Collection",
		"java.util.HashMap",
		"java.util.HashSet",
		"java.util.Iterator",
		"java.util.List",
		"java.util.Map",
		"java.util.Set",
	};

	/**
	 * Names of commonly used annotations and their methods for which we'll {@link #COMMON_URIS cache} their corresponding full URIs and {@link #COMMON_METHOD_URIS method} URIs.
	 */
	static final String[][] COMMON_ANNOTATIONS = {
		new String[] { "com.google.common.annotations.Beta" },
		new String[] { "com.google.common.annotations.GwtCompatible", "emulated", "serializable" },
		new String[] { "com.google.common.annotations.GwtIncompatible", "value" },

		new String[] { "java.lang.annotation.Documented" },
		new String[] { "java.lang.annotation.Target", "value" },
		new String[] { "java.lang.annotation.Retention", "value" },

		new String[] { "java.lang.Deprecated" },
		new String[] { "java.lang.Override" },
		new String[] { "java.lang.SuppressWarnings", "value" },

		new String[] { "org.eclipse.xtext.xbase.lib.Inline", "value", "imported", "statementExpression" },
		new String[] { "org.eclipse.xtext.xbase.lib.Pure" },
	};

	/**
	 * A cache of commonly used full URIs.
	 */
	protected static final Map<String, URI> COMMON_URIS = new HashMap<String, URI>();
	
	/**
	 * A cache of commonly used full method URIs.
	 */
	protected static final Map<String, URI[]> COMMON_METHOD_URIS = new HashMap<String, URI[]>();

	static {
		for (int i = 0; i < COMMON_CLASS_NAMES.length; ++i) {
			String segment = COMMON_CLASS_NAMES[i];
			COMMON_URIS.put(segment, OBJECTS_URI.appendSegment(segment).appendFragment(segment));
		}

		for (int i = 0; i < COMMON_ANNOTATIONS.length; ++i) {
			String[] annotations = COMMON_ANNOTATIONS[i];
			String annotation = annotations[0];
			COMMON_URIS.put(annotation, OBJECTS_URI.appendSegment(annotation).appendFragment(annotation));
			if (annotations.length > 1) {
				URI[] methodURIs = new URI[annotations.length - 1];
				for (int j = 1; j < annotations.length; ++j) {
					String method = annotation + "." + annotations[j] + "()";
					methodURIs[j - 1] = OBJECTS_URI.appendSegment(annotation).appendFragment(method);
				}
				COMMON_METHOD_URIS.put(annotation, methodURIs);
			}
		}
	}

	/**
	 * A cache of mappings from signatures to their corresponding resources URI.
	 */
	protected static final Map<String, URI> COMMON_SIGNATURE_URIS = new HashMap<String, URI>();

	static {
		for (Map.Entry<String, URI> entry : COMMON_URIS.entrySet()) {
			COMMON_SIGNATURE_URIS.put("L" + entry.getKey() + ";", entry.getValue().trimFragment());
		}
		for (int i = 0; i < PRIMITIVE_URIS.length; ++i) {
			URI uri = PRIMITIVE_URIS[i];
			if (uri != null) {
				COMMON_SIGNATURE_URIS.put(uri.fragment(), PRIMITIVES_URI);
			}
		}
	}
}
