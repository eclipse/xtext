/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

import org.eclipse.xtext.preferences.ITypedPreferenceValues;

/**
 * Relevant state and methods during execution of a TextReplacer.
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ITextReplacerContext {
	
	boolean canAutowrap();

	IFormattableDocument getDocument();

	AbstractFormatter2 getFormatter();

	int getIndentation();

	int getLeadingCharsInLineCount();

	Iterable<ITextReplacement> getLocalReplacements();

	ITypedPreferenceValues getPreferences();

	ITextReplacerContext getPreviousContext();

	List<ITextReplacement> getReplacementsUntil(ITextReplacerContext first);

	ITextReplacer getReplacer();

	Throwable getTrace(ITextReplacement replacement);

	boolean isAutowrap();

	boolean isInsideFormattedRegion();

	void replaceText(CharSequence text);

	void replaceText(int offset, int lenght, CharSequence text);

	void replaceText(ITextReplacement replacement);

	void replaceText(ITextSegment region, CharSequence text);

	void setAutowrap(boolean value);

	void setCanAutowrap(boolean value);

	ITextReplacerContext withDocument(IFormattableDocument document);

	ITextReplacerContext withIndentation(int indentation);

	ITextReplacerContext withReplacer(ITextReplacer replacer);

}