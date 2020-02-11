/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.autoedit;

import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextUtilities;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.0
 */
public class CompoundMultiLineTerminalsEditStrategy extends AbstractEditStrategy {
	
	public static class Factory {
		@Inject
		private MembersInjector<CompoundMultiLineTerminalsEditStrategy> injector;
		
		public CompoundMultiLineTerminalsEditStrategy newInstanceFor(String leftTerminal, String rightTerminal) {
			return newInstanceFor(leftTerminal, null, rightTerminal);
		}
				
		public CompoundMultiLineTerminalsEditStrategy newInstanceFor(
				String leftTerminal, String indentationString, String rightTerminal) {
			CompoundMultiLineTerminalsEditStrategy strategy = new CompoundMultiLineTerminalsEditStrategy();
			injector.injectMembers(strategy);
			return strategy.and(leftTerminal, indentationString, rightTerminal);
		}
	}
	
	@Inject
	private MultiLineTerminalsEditStrategy.Factory multiLineTerminalsStrategyFactory;
	
	private List<MultiLineTerminalsEditStrategy> strategies;
	
	protected CompoundMultiLineTerminalsEditStrategy() {
		this.strategies = Lists.newArrayList();
	}
	
	public CompoundMultiLineTerminalsEditStrategy and(String leftTerminal, String indentationString, String rightTerminal) {
		strategies.add(multiLineTerminalsStrategyFactory.newInstance(leftTerminal, indentationString, rightTerminal));
		return this;
	}
	
	public CompoundMultiLineTerminalsEditStrategy and(String leftTerminal, String rightTerminal) {
		return and(leftTerminal, null, rightTerminal);
	}

	/**
	 * @since 2.3
	 */
	public CompoundMultiLineTerminalsEditStrategy and(MultiLineTerminalsEditStrategy strategy) {
		strategies.add(strategy);
		return this;
	}

	@Override
	protected void internalCustomizeDocumentCommand(IDocument document, DocumentCommand command)
			throws BadLocationException {
		if (command.length != 0)
			return;
		String[] lineDelimiters = document.getLegalLineDelimiters();
		int delimiterIndex = TextUtilities.startsWith(lineDelimiters, command.text);
		if (delimiterIndex != -1) {
			MultiLineTerminalsEditStrategy bestStrategy = null;
			IRegion bestStart = null;
			for(MultiLineTerminalsEditStrategy strategy: strategies) {
				IRegion candidate = strategy.findStartTerminal(document, command.offset);
				if (candidate != null) {
					if (bestStart == null || bestStart.getOffset() < candidate.getOffset()) {
						bestStrategy = strategy;
						bestStart = candidate;
					}
				}
			}
			if (bestStrategy != null) {
				bestStrategy.internalCustomizeDocumentCommand(document, command);
			}
		}
	}


}