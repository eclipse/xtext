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


public final class TerminalsSL_COMMENTConsumer extends AbstractRuleAwareTerminalConsumer {

	public TerminalsSL_COMMENTConsumer(ITerminalConsumerConfiguration configuration) {
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
		if (!consumeNegatedToken$3()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeGroup$7()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$2() {
		return readString("//");
	}

	protected boolean consumeNegatedToken$3() {
		while(doConsumeNegatedToken$3()) {}
		return true;
	}

	protected boolean doConsumeNegatedToken$3() {
		final int marker = mark();
		if (!eof() && !consumeAlternatives$4()) {
			incOffset();
			return true;
		}
		rollbackTo(marker);
		return false;
	}

	protected boolean consumeAlternatives$4() {
		if (consumeKeyword$5())
			return true;
		if (consumeKeyword$6())
			return true;
		return false;
	}

	protected boolean consumeKeyword$5() {
		return readChar('\n');
	}

	protected boolean consumeKeyword$6() {
		return readChar('\r');
	}

	protected boolean consumeGroup$7() {
		doConsumeGroup$7();
		return true;
	}

	protected boolean doConsumeGroup$7() {
		final int marker = mark();
		if (!consumeKeyword$8()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeKeyword$9()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$8() {
		doConsumeKeyword$8();
		return true;
	}

	protected boolean doConsumeKeyword$8() {
		return readChar('\r');
	}

	protected boolean consumeKeyword$9() {
		return readChar('\n');
	}
	
}
