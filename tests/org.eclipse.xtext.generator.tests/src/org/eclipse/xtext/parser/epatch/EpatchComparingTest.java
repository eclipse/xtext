/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.epatch;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.parser.AbstractParserComparingTest;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.util.CollectionUtils;
import org.eclipse.xtext.util.Function;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EpatchComparingTest extends AbstractParserComparingTest {

	@Override
	protected Iterable<Pair<String, String>> getAllModels() {
		Iterator<String> resources = getAllEpatchTestcases();
		return CollectionUtils.map(resources, new Function<String, Pair<String, String>>() {
			public Pair<String, String> exec(String filename) {
				String model;
				try {
					model = readFileIntoString(filename);
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
				System.out.println(filename);
				return Tuples.create(filename.substring(filename.lastIndexOf('/') + 1), model);
			}
		});
	}

	@SuppressWarnings("all")
	private Iterator<String> getAllEpatchTestcases() {
		final ClassLoader classLoader = getClass().getClassLoader();
		final String root = (getClass().getPackage().getName() + ".testcases.").replace('.', '/');
		return new Iterator<String>() {
			private int current = 1;

			private String getCurrentAsString() {
				if (current < 10)
					return "0" + Integer.toString(current);
				return Integer.toString(current);
			}

			public boolean hasNext() {
				return false;
				// TODO: uncomment if packrat parser can backtrack optional elements in groups
//				return classLoader.getResource(root + getCurrentAsString() + ".epatch") != null;
			}

			public String next() {
				String result = root + getCurrentAsString() + ".epatch";
				current++;
				return result;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

		};
	}

	@Override
	protected Class<? extends ISetup> getStandaloneSetupClass() {
		return EpatchTestLanguageStandaloneSetup.class;
	}

	@Override
	protected IParser createFirstParser() {
		return getAntlrParser();
	}

	@Override
	protected IParser createSecondParser() {
		return getPackratParser();
	}



}
