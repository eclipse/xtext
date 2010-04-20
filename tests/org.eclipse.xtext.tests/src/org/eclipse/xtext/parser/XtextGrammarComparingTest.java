/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextGrammarComparingTest extends AbstractParserComparingTest {

	@Override
	protected Iterator<Pair<String, String>> getAllModels() {
		return Iterators.transform(getAllTestGrammarPaths(false).iterator(), new Function<String, Pair<String, String>>() {
			public Pair<String, String> apply(String grammarPath) {
				String model;
				try {
					model = readFileIntoString(grammarPath);
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
				return Tuples.create(grammarPath, model);
			}
		});
	}

	@Override
	protected IParser createFirstParser() {
		return getAntlrParser();
	}

	@Override
	protected IParser createSecondParser() {
		return getPackratParser();
	}

	@Override
	protected Class<? extends ISetup> getStandaloneSetupClass() {
		return XtextStandaloneSetup.class;
	}

}
