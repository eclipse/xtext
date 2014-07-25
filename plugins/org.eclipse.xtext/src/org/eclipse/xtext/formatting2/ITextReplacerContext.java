/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

import org.eclipse.xtext.formatting2.ITextReplacer.Flow;

/**
 * Relevant state and methods during execution of a TextReplacer.
 */
public interface ITextReplacerContext extends ITextSegment {
	Flow getFlow();

	int getLeadingCharsInLineCount();

	List<ITextReplacement> getLeadingReplacements();

	IFormatterRequest getRequest();

	boolean isInsideFormattedRegion();

	void replaceText(CharSequence text);

	void replaceText(int offset, int lenght, CharSequence text);

	void replaceText(ITextSegment region, CharSequence text);

	void replaceText(ITextReplacement replacement);
}