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


public final class TerminalsSTRINGConsumer extends AbstractRuleAwareTerminalConsumer {

	public TerminalsSTRINGConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}
	
	@Override
	protected int doConsume() {
		return consumeAlternatives$1() ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
	}

	protected boolean consumeAlternatives$1() {
		if (consumeGroup$2())
			return true;
		if (consumeGroup$21())
			return true;
		return false;
	}

	protected boolean consumeGroup$2() {
		final int marker = mark();
		if (!consumeKeyword$3()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeAlternatives$4()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeKeyword$20()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$3() {
		return readChar('\"');
	}

	protected boolean consumeAlternatives$4() {
		while(doConsumeAlternatives$4()) {}
		return true;
	}

	protected boolean doConsumeAlternatives$4() {
		if (consumeGroup$5())
			return true;
		if (consumeNegatedToken$16())
			return true;
		return false;
	}

	protected boolean consumeGroup$5() {
		final int marker = mark();
		if (!consumeKeyword$6()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeAlternatives$7()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$6() {
		return readChar('\\');
	}

	protected boolean consumeAlternatives$7() {
		if (consumeKeyword$8())
			return true;
		if (consumeKeyword$9())
			return true;
		if (consumeKeyword$10())
			return true;
		if (consumeKeyword$11())
			return true;
		if (consumeKeyword$12())
			return true;
		if (consumeKeyword$13())
			return true;
		if (consumeKeyword$14())
			return true;
		if (consumeKeyword$15())
			return true;
		return false;
	}

	protected boolean consumeKeyword$8() {
		return readChar('b');
	}

	protected boolean consumeKeyword$9() {
		return readChar('t');
	}

	protected boolean consumeKeyword$10() {
		return readChar('n');
	}

	protected boolean consumeKeyword$11() {
		return readChar('f');
	}

	protected boolean consumeKeyword$12() {
		return readChar('r');
	}

	protected boolean consumeKeyword$13() {
		return readChar('\"');
	}

	protected boolean consumeKeyword$14() {
		return readChar('\'');
	}

	protected boolean consumeKeyword$15() {
		return readChar('\\');
	}

	protected boolean consumeNegatedToken$16() {
		final int marker = mark();
		if (!eof() && !consumeAlternatives$17()) {
			incOffset();
			return true;
		}
		rollbackTo(marker);
		return false;
	}

	protected boolean consumeAlternatives$17() {
		if (consumeKeyword$18())
			return true;
		if (consumeKeyword$19())
			return true;
		return false;
	}

	protected boolean consumeKeyword$18() {
		return readChar('\\');
	}

	protected boolean consumeKeyword$19() {
		return readChar('\"');
	}

	protected boolean consumeKeyword$20() {
		return readChar('\"');
	}

	protected boolean consumeGroup$21() {
		final int marker = mark();
		if (!consumeKeyword$22()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeAlternatives$23()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeKeyword$39()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$22() {
		return readChar('\'');
	}

	protected boolean consumeAlternatives$23() {
		while(doConsumeAlternatives$23()) {}
		return true;
	}

	protected boolean doConsumeAlternatives$23() {
		if (consumeGroup$24())
			return true;
		if (consumeNegatedToken$35())
			return true;
		return false;
	}

	protected boolean consumeGroup$24() {
		final int marker = mark();
		if (!consumeKeyword$25()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeAlternatives$26()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$25() {
		return readChar('\\');
	}

	protected boolean consumeAlternatives$26() {
		if (consumeKeyword$27())
			return true;
		if (consumeKeyword$28())
			return true;
		if (consumeKeyword$29())
			return true;
		if (consumeKeyword$30())
			return true;
		if (consumeKeyword$31())
			return true;
		if (consumeKeyword$32())
			return true;
		if (consumeKeyword$33())
			return true;
		if (consumeKeyword$34())
			return true;
		return false;
	}

	protected boolean consumeKeyword$27() {
		return readChar('b');
	}

	protected boolean consumeKeyword$28() {
		return readChar('t');
	}

	protected boolean consumeKeyword$29() {
		return readChar('n');
	}

	protected boolean consumeKeyword$30() {
		return readChar('f');
	}

	protected boolean consumeKeyword$31() {
		return readChar('r');
	}

	protected boolean consumeKeyword$32() {
		return readChar('\"');
	}

	protected boolean consumeKeyword$33() {
		return readChar('\'');
	}

	protected boolean consumeKeyword$34() {
		return readChar('\\');
	}

	protected boolean consumeNegatedToken$35() {
		final int marker = mark();
		if (!eof() && !consumeAlternatives$36()) {
			incOffset();
			return true;
		}
		rollbackTo(marker);
		return false;
	}

	protected boolean consumeAlternatives$36() {
		if (consumeKeyword$37())
			return true;
		if (consumeKeyword$38())
			return true;
		return false;
	}

	protected boolean consumeKeyword$37() {
		return readChar('\\');
	}

	protected boolean consumeKeyword$38() {
		return readChar('\'');
	}

	protected boolean consumeKeyword$39() {
		return readChar('\'');
	}
	
}
