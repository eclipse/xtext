/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import com.google.common.base.Function;

/**
 * A TextReplacer is responsible for a text region inside a {@link IFormattableDocument} and produces
 * {@link ITextReplacement}s for that region.
 * 
 * The {@link IFormattableDocument} ensures that TextReplacers are executed in the correct order, i.e. from the
 * beginning of the document to the end of the document.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public interface ITextReplacer {

	public final static Function<ITextReplacer, ITextSegment> GET_REGION = new Function<ITextReplacer, ITextSegment>() {
		public ITextSegment apply(ITextReplacer input) {
			return input.getRegion();
		}
	};

	ITextSegment getRegion();

	ITextReplacerContext createReplacements(ITextReplacerContext context);
}
