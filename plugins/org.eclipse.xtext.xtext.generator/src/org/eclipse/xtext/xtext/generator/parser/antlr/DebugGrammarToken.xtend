/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr

/**
 * Static utility that allows to check if the current thread is producing 
 * a debug grammar or not.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noreference
 */
class DebugGrammarToken {
	
	static ThreadLocal<Boolean> store = new ThreadLocal
	
	static def DebugGrammarToken aquire() {
		if (store.get() !== null) {
			throw new IllegalStateException(String.valueOf(store.get))
		}
		return new DebugGrammarToken
	}
	
	static def boolean isGeneratingDebugGrammar() {
		return store.get == Boolean.TRUE
	}
	
	private new() {
		store.set(Boolean.TRUE)
	}
	
	def void done() {
		store.set(null)
	}
	
}