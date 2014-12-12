/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.Reader;

import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 * @author Sebastian Zarnekow
 */
public abstract class AbstractParser implements IParser {

	protected boolean isReparseSupported() {
		return false;
	}

	@Override
	public final IParseResult parse(Reader reader) {
		StoppedTask task = Stopwatches.forTask("AbstractParser.parse");
		try {
			task.start();
			return doParse(reader);
		} finally {
			task.stop();
		}
	}

	protected abstract IParseResult doParse(Reader reader);

	protected abstract IParseResult doParse(CharSequence sequence);

	@Override
	public final IParseResult reparse(IParseResult previousResult, ReplaceRegion replaceRegion) {
		if (!isReparseSupported()) {
			final StringBuilder builder = new StringBuilder(previousResult.getRootNode().getText());
			replaceRegion.applyTo(builder);
			return doParse(builder);
		}
		return doReparse(previousResult, replaceRegion);
	}

	protected IParseResult doReparse(IParseResult previousParseResult, ReplaceRegion replaceRegion) {
		throw new UnsupportedOperationException();
	}

}
