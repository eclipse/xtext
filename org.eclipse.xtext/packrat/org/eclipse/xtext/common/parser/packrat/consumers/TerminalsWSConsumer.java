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


public final class TerminalsWSConsumer extends AbstractRuleAwareTerminalConsumer {

	public TerminalsWSConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}
	
	@Override
	protected int doConsume() {
		return consumeAlternatives$1() ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
	}

	protected boolean consumeAlternatives$1() {
		if (doConsumeAlternatives$1()) {
			while(doConsumeAlternatives$1()) {}
			return true;
		}
		return false;
	}

	protected boolean doConsumeAlternatives$1() {
		if (consumeKeyword$2())
			return true;
		if (consumeKeyword$3())
			return true;
		if (consumeKeyword$4())
			return true;
		if (consumeKeyword$5())
			return true;
		return false;
	}

	protected boolean consumeKeyword$2() {
		return readChar(' ');
	}

	protected boolean consumeKeyword$3() {
		return readChar('\t');
	}

	protected boolean consumeKeyword$4() {
		return readChar('\r');
	}

	protected boolean consumeKeyword$5() {
		return readChar('\n');
	}
	
}
