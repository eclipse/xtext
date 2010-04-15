/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr.internal;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DFA extends org.antlr.runtime.DFA {
	
	@Override
	public int predict(IntStream input) throws RecognitionException {
		try {
			getRecognizer().beginDFAPrediction();
			return super.predict(input);
		} finally {
			getRecognizer().endDFAPrediction();
		}
	}
	
	protected AbstractInternalContentAssistParser getRecognizer() {
		return (AbstractInternalContentAssistParser) recognizer;
	}

}
