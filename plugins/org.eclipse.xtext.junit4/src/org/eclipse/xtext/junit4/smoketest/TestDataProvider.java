/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parser.AbstractParser;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.Assert;

import com.google.common.io.CharStreams;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class TestDataProvider extends AbstractParser { 
	public IParseResult parse(ParserRule rule, Reader reader) throws TestData {
		try {
			throw new TestData(CharStreams.toString(reader));
		} catch (IOException e) {
			Assert.fail(e.getMessage());
			return null;
		}
	}

	public IParseResult parse(RuleCall ruleCall, Reader reader, int initialLookAhead) throws TestData {
		try {
			throw new TestData(CharStreams.toString(reader));
		} catch (IOException e) {
			Assert.fail(e.getMessage());
			return null;
		}
	}

	@Override
	protected IParseResult doParse(Reader reader) throws TestData {
		try {
			throw new TestData(CharStreams.toString(reader));
		} catch (IOException e) {
			Assert.fail(e.getMessage());
			return null;
		}
	}

	@Override
	protected IParseResult doParse(CharSequence sequence) throws TestData {
		throw new TestData(sequence.toString());
	}
}