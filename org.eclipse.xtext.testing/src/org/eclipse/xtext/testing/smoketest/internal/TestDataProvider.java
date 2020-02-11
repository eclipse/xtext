/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.smoketest.internal;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parser.AbstractParser;
import org.eclipse.xtext.parser.IParseResult;
import org.junit.Assert;

import com.google.common.annotations.Beta;
import com.google.common.io.CharStreams;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public class TestDataProvider extends AbstractParser { 
	@Override
	public IParseResult parse(ParserRule rule, Reader reader) throws TestDataCarrier {
		try {
			throw new TestDataCarrier(CharStreams.toString(reader));
		} catch (IOException e) {
			Assert.fail(e.getMessage());
			return null;
		}
	}

	@Override
	public IParseResult parse(RuleCall ruleCall, Reader reader, int initialLookAhead) throws TestDataCarrier {
		try {
			throw new TestDataCarrier(CharStreams.toString(reader));
		} catch (IOException e) {
			Assert.fail(e.getMessage());
			return null;
		}
	}

	@Override
	protected IParseResult doParse(Reader reader) throws TestDataCarrier {
		try {
			throw new TestDataCarrier(CharStreams.toString(reader));
		} catch (IOException e) {
			Assert.fail(e.getMessage());
			return null;
		}
	}

	@Override
	protected IParseResult doParse(CharSequence sequence) throws TestDataCarrier {
		throw new TestDataCarrier(sequence.toString());
	}
}