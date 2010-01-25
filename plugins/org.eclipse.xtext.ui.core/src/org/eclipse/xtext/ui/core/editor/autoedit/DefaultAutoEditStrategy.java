/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.autoedit;

import java.util.List;

import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.core.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.core.editor.autoedit.MultiLineTerminalsEditStrategy;
import org.eclipse.xtext.ui.core.editor.autoedit.SameTerminalsEditStrategy;
import org.eclipse.xtext.ui.core.editor.autoedit.ShortCutEditStrategy;
import org.eclipse.xtext.ui.core.editor.autoedit.SingleLineTerminalsStrategy;

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
	
	public Provider<MultiLineTerminalsEditStrategy> getMultiLineTerminals() {
		return multiLineTerminals;
	}
	
	public Provider<SameTerminalsEditStrategy> getSameTerminal() {
		return sameTerminal;
	}
	
	public Provider<ShortCutEditStrategy> getShortCuts() {
		return shortCuts;
	}
	
	public Provider<SingleLineTerminalsStrategy> getSingleLineTerminals() {
		return singleLineTerminals;
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
		configureImportantInformation(acceptor);
		configureStringLiteral(acceptor);
		configureParenthesis(acceptor);
		configureSquareBrackets(acceptor);
		configureCurlyBracesBlock(acceptor);
		configureMultilineComments(acceptor);
	}

	protected void configureImportantInformation(IEditStrategyAcceptor acceptor) {
		acceptor.accept(shortCuts.get().configure("42", "42 /*Answer to the Ultimate Question of Life, the Universe, and Everything!*/"));
	}

	protected void configureMultilineComments(IEditStrategyAcceptor acceptor) {
		acceptor.accept(multiLineTerminals.get().configure("/*", " * ", " */"));
	}

	protected void configureCurlyBracesBlock(IEditStrategyAcceptor acceptor) {
		acceptor.accept(multiLineTerminals.get().configure("{", null, "}"));
	}

	protected void configureSquareBrackets(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.get().configure('[', ']'));
	}

	protected void configureParenthesis(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.get().configure('(', ')'));
	}
	
	protected void configureStringLiteral(IEditStrategyAcceptor acceptor) {
		acceptor.accept(sameTerminal.get().configure('"'));
		acceptor.accept(sameTerminal.get().configure('\''));
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
