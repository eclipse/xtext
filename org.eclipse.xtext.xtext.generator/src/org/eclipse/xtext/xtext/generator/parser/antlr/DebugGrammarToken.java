/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

/**
 * Static utility that allows to check if the current thread is producing a
 * debug grammar or not.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noreference
 */
public class DebugGrammarToken {
	private static ThreadLocal<Boolean> store = new ThreadLocal<>();

	public static DebugGrammarToken aquire() {
		if (DebugGrammarToken.store.get() != null) {
			throw new IllegalStateException(String.valueOf(DebugGrammarToken.store.get()));
		}
		return new DebugGrammarToken();
	}

	public static boolean isGeneratingDebugGrammar() {
		return Boolean.TRUE.equals(DebugGrammarToken.store.get());
	}

	private DebugGrammarToken() {
		DebugGrammarToken.store.set(Boolean.TRUE);
	}

	public void done() {
		DebugGrammarToken.store.set(null);
	}
}
