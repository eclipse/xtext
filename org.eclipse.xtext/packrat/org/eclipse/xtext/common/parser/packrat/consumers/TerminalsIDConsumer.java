/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.parser.packrat.consumers;

import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;


public final class TerminalsIDConsumer extends AbstractRuleAwareTerminalConsumer {

	public TerminalsIDConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}
	
	@Override
	protected int doConsume() {
		return consumeGroup$1() ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
	}

	protected boolean consumeGroup$1() {
		final int marker = mark();
		if (!consumeKeyword$2()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeAlternatives$3()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeAlternatives$11()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$2() {
		doConsumeKeyword$2();
		return true;
	}

	protected boolean doConsumeKeyword$2() {
		return readChar('^');
	}

	protected boolean consumeAlternatives$3() {
		if (consumeCharacterRange$4())
			return true;
		if (consumeCharacterRange$7())
			return true;
		if (consumeKeyword$10())
			return true;
		return false;
	}

	protected boolean consumeCharacterRange$4() {
		return readCharBetween('a', 'z');
	}

	protected boolean consumeCharacterRange$7() {
		return readCharBetween('A', 'Z');
	}

	protected boolean consumeKeyword$10() {
		return readChar('_');
	}

	protected boolean consumeAlternatives$11() {
		while(doConsumeAlternatives$11()) {}
		return true;
	}

	protected boolean doConsumeAlternatives$11() {
		if (consumeCharacterRange$12())
			return true;
		if (consumeCharacterRange$15())
			return true;
		if (consumeKeyword$18())
			return true;
		if (consumeCharacterRange$19())
			return true;
		return false;
	}

	protected boolean consumeCharacterRange$12() {
		return readCharBetween('a', 'z');
	}

	protected boolean consumeCharacterRange$15() {
		return readCharBetween('A', 'Z');
	}

	protected boolean consumeKeyword$18() {
		return readChar('_');
	}

	protected boolean consumeCharacterRange$19() {
		return readCharBetween('0', '9');
	}
	
}
