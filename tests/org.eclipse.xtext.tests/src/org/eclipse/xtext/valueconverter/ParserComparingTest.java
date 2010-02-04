/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.valueconverter;

import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.parser.AbstractParserComparingTest;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserComparingTest extends AbstractParserComparingTest {

	private static final String[] testModels = new String[] {
		"1 'str'",
		"'str'",
		"2 'str'",
		"1+ 'str'",
		"2+ 'str'",
		"1 str",
		"1 ^str",
		"str",
		"^str",
		"1+ str",
		"1+ ^str",
		"1 foo - bar",
		"foo - bar",
		"3 foo - bar",
		"1+ foo - bar",
		"3+ foo - bar",
		"1 zonk + foo - bar",
		"1 zonk +",
		"zonk + foo - bar",
		"zonk +",
		"4 zonk + foo - bar",
		"4 zonk +",
		"1+ zonk + foo - bar",
		"1+ zonk +",
		"4+ zonk + foo - bar",
		"4+ zonk +",
		"1 mykeyword1",
		"mykeyword1",
		"1+ mykeyword1",
		"content str ref 'str'",
		"content 'str' ref str"
	};

	@Override
	protected IParser createFirstParser() {
		return getAntlrParser();
	}

	@Override
	protected IParser createSecondParser() {
		return getPackratParser();
	}

	@Override
	protected Iterator<Pair<String, String>> getAllModels() {
		return Iterables.transform(Arrays.asList(testModels), new Function<String, Pair<String, String>>(){
			public Pair<String, String> apply(String param) {
				return Tuples.create(param, param);
			}
		}).iterator();
	}

	@Override
	protected Class<? extends ISetup> getStandaloneSetupClass() {
		return Bug250313StandaloneSetup.class;
	}

}
