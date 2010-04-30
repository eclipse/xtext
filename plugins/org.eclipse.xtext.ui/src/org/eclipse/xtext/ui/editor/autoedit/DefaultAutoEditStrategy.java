/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.autoedit;

import java.util.List;

import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.editor.autoedit.MultiLineTerminalsEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.SameTerminalsEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.ShortCutEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.SingleLineTerminalsStrategy;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultAutoEditStrategy implements IAutoEditStrategy, ISourceViewerAware {

	private List<IAutoEditStrategy> strategies = Lists.newArrayList();

	private Provider<SameTerminalsEditStrategy> sameTerminal;
	private Provider<SingleLineTerminalsStrategy> singleLineTerminals;
	private Provider<MultiLineTerminalsEditStrategy> multiLineTerminals;
	private Provider<ShortCutEditStrategy> shortCuts;
	
	public MultiLineTerminalsEditStrategy newMultiLineTerminals(String start, String indentation, String end) {
		return multiLineTerminals.get().configure(start, indentation, end);
	}
	
	public SameTerminalsEditStrategy newSameTerminal(char terminal) {
		return sameTerminal.get().configure(terminal);
	}
	
	public ShortCutEditStrategy newShortCuts(String shortcut, String replacement) {
		return shortCuts.get().configure(shortcut, replacement);
	}
	
	public SingleLineTerminalsStrategy newSingleLineTerminals(char start, char end) {
		return singleLineTerminals.get().configure(start, end);
	}

	@Inject
	public void initialize(Provider<SameTerminalsEditStrategy> sameTerminal,
			Provider<SingleLineTerminalsStrategy> singleLineTerminals,
			Provider<MultiLineTerminalsEditStrategy> multiLineTerminals,
			Provider<ShortCutEditStrategy> shortCuts) {
		this.sameTerminal = sameTerminal;
		this.singleLineTerminals = singleLineTerminals;
		this.multiLineTerminals = multiLineTerminals;
		this.shortCuts = shortCuts;
	}

	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		for (IAutoEditStrategy strategy : strategies) {
			strategy.customizeDocumentCommand(document, command);
		}
	}

	protected void configure(IEditStrategyAcceptor acceptor) {
		configureStringLiteral(acceptor);
		configureParenthesis(acceptor);
		configureSquareBrackets(acceptor);
		configureCurlyBracesBlock(acceptor);
		configureMultilineComments(acceptor);
	}

	protected void configureMultilineComments(IEditStrategyAcceptor acceptor) {
		acceptor.accept(newMultiLineTerminals("/*", " * ", " */"));
	}

	protected void configureCurlyBracesBlock(IEditStrategyAcceptor acceptor) {
		acceptor.accept(newMultiLineTerminals("{", null, "}"));
	}

	protected void configureSquareBrackets(IEditStrategyAcceptor acceptor) {
		acceptor.accept(newSingleLineTerminals('[', ']'));
	}

	protected void configureParenthesis(IEditStrategyAcceptor acceptor) {
		acceptor.accept(newSingleLineTerminals('(', ')'));
	}
	
	protected void configureStringLiteral(IEditStrategyAcceptor acceptor) {
		acceptor.accept(newSameTerminal('"'));
		acceptor.accept(newSameTerminal('\''));
	}

	public void setSourceViewer(final ISourceViewer sourceViewer) {
		configure(new IEditStrategyAcceptor() {
			
			public void accept(IAutoEditStrategy strategy) {
				if (strategy instanceof ISourceViewerAware) {
					((ISourceViewerAware) strategy).setSourceViewer(sourceViewer);
				}
				strategies.add(strategy);
			}
		});
	}
	
	public interface IEditStrategyAcceptor {
		public void accept(IAutoEditStrategy strategy);
	}

}
