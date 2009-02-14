/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.valueconverter;

import java.util.Arrays;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.parser.AbstractParserComparingTest;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.ParsetreePackage;
import org.eclipse.xtext.util.CollectionUtils;
import org.eclipse.xtext.util.Function;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

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
	protected Iterable<Pair<String, String>> getAllModels() {
		return CollectionUtils.map(Arrays.asList(testModels), new Function<String, Pair<String, String>>(){
			public Pair<String, String> exec(String param) {
				return Tuples.create(param, param);
			}
		});
	}

	// XXX FixMe: GrammarAccess has to modularized and used in NonTerminals in a non static way
	@Override
	protected EStructuralFeature[] getIgnoredFeatures() {
		return new EStructuralFeature[]{
				ParsetreePackage.eINSTANCE.getCompositeNode_LookaheadLeafNodes(),
				ParsetreePackage.eINSTANCE.getAbstractNode_GrammarElement()
		};
	}

	@Override
	protected Class<? extends ISetup> getStandaloneSetupClass() {
		return Bug250313StandaloneSetup.class;
	}

}
