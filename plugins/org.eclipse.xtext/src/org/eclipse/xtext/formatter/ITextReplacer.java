/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter;

import java.util.List;

import org.eclipse.xtext.formatter.IFormatter.Request;

/**
 * A TextReplacer is responsible for a certain region inside a {@link IFormattableDocument} and produces
 * {@link ITextReplacement}s for that region.
 * 
 * The {@link IFormattableDocument} ensures that TextReplacers are executed in the correct order.
 * 
 * This interface is intentionally a single-method interface for convenient implementation using Xtexn't closures.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.7
 */
public interface ITextReplacer {

	/**
	 * Relevant state and methods during execution of a TextReplacer.
	 */
	public interface Context extends ITextRegion {
		Flow getFlow();

		int getLeadingCharsInLineCount();

		List<ITextReplacement> getLeadingReplacements();

		Request getRequest();

		boolean isInsideFormattedRegion();

		void replaceText(CharSequence text);

		void replaceText(int offset, int lenght, CharSequence text);

		void replaceText(ITextRegion region, CharSequence text);

		void replaceText(ITextReplacement replacement);
	}

	public interface Factory<T> {
		ITextReplacer create(T parameter);
	}

	/**
	 * Flow-Objects are passed from Replacer to Replacer in the order of execution.
	 */
	public interface Flow {
		int getIndentation();

		Flow withIndentation(int indentation);
	}

	public interface Mergeable<T> {
		T mergeWith(T other);
	}

	Flow createReplacements(Context context);
}
