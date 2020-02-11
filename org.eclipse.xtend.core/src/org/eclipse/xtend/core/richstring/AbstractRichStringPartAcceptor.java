/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.richstring;


import java.util.BitSet;

import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XExpression;

/**
 * No-op implementation of the {@link IRichStringPartAcceptor}. Clients should inherit from this class if they do not
 * want to implement all methods. It is mandatory to implement {@link #forLoopHasNext(XExpression, XExpression, CharSequence) forLoopHasNext()}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractRichStringPartAcceptor implements IRichStringPartAcceptor {

	@Override
	public void acceptSemanticText(CharSequence text, /* @Nullable */ RichStringLiteral origin) {
	}

	@Override
	public void acceptTemplateText(CharSequence text, /* @Nullable */ RichStringLiteral origin) {
	}

	@Override
	public void acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
	}

	@Override
	public void acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
	}

	@Override
	public void acceptIfCondition(XExpression condition) {
	}

	@Override
	public void acceptElseIfCondition(XExpression condition) {
	}

	@Override
	public void acceptElse() {
	}

	@Override
	public void acceptEndIf() {
	}

	@Override
	public void acceptForLoop(JvmFormalParameter parameter, XExpression expression) {
	}
	
	@Override
	public void acceptEndFor(/* @Nullable */ XExpression after, CharSequence indentation) {
	}

	@Override
	public void acceptExpression(XExpression expression, CharSequence indentation) {
	}

	@Override
	public void announceNextLiteral(RichStringLiteral object) {
	}

	public static class ForLoopOnce extends AbstractRichStringPartAcceptor {

		private BitSet forLoopStack = new BitSet();
		private int forLoopStackPointer = -1;

		@Override
		public void acceptForLoop(JvmFormalParameter parameter, /* @Nullable */ XExpression expression) {
			forLoopStackPointer++;
			forLoopStack.set(forLoopStackPointer);
		}

		@Override
		public boolean forLoopHasNext(/* @Nullable */ XExpression before, /* @Nullable */ XExpression separator, CharSequence indentation) {
			if (forLoopStack.get(forLoopStackPointer)) {
				forLoopStack.set(forLoopStackPointer, false);
				return true;
			}
			return false;
		}
		
		@Override
		public void acceptEndFor(/* @Nullable */ XExpression after, CharSequence indentation) {
			forLoopStackPointer--;
		}
	}
}
