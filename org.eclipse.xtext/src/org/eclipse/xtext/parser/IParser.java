/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.Reader;

import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
@ImplementedBy(IParser.NullImpl.class)
public interface IParser {
	
	IParseResult parse(Reader reader);
	
	IParseResult parse(ParserRule rule, Reader reader);
	
	IParseResult parse(RuleCall ruleCall, Reader reader, int initialLookAhead);
	
	IParseResult reparse(IParseResult previousParseResult, ReplaceRegion replaceRegion);
	
	static class NullImpl implements IParser {

		@Override
		public IParseResult parse(Reader reader) {
			return null;
		}

		@Override
		public IParseResult parse(ParserRule rule, Reader reader) {
			return null;
		}
		
		@Override
		public IParseResult parse(RuleCall ruleCall, Reader reader, int initialLookAhead) {
			return null;
		}

		@Override
		public IParseResult reparse(IParseResult previousParseResult, ReplaceRegion replaceRegion) {
			return null;
		}
		
	}

}
