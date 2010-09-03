/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.autoedit;

import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

import com.google.inject.Inject;
import com.google.inject.Provider;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultAutoEditStrategyProvider extends AbstractEditStrategyProvider {
	@Inject
	protected Provider<DefaultIndentLineAutoEditStrategy> defaultIndentLineAutoEditStrategy ;
	@Inject
	protected Provider<SingleLineTerminalsStrategy> singleLineTerminals;
	@Inject
	protected Provider<MultiLineTerminalsEditStrategy> multiLineTerminals;
	@Inject
	protected Provider<MultiLineNewLineEditStrategy> multiLineNewLineEditStrategy;
	@Inject
	protected Provider<PartitionInsertEditStrategy> partitionInsertEditStrategy;
	@Inject
	protected Provider<PartitionDeletionEditStrategy> partitionDeletionEditStrategy;
	@Inject
	protected Provider<PartionEndTerminalSkippingEditStrategy> partionEndTerminalSkippingEditStrategy;

	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		configureIndentationEditStrategy(acceptor);
		configureStringLiteral(acceptor);
		configureParenthesis(acceptor);
		configureSquareBrackets(acceptor);
		configureCurlyBracesBlock(acceptor);
		configureMultilineComments(acceptor);
	}

	protected void configureIndentationEditStrategy(IEditStrategyAcceptor acceptor) {
		acceptor.accept(defaultIndentLineAutoEditStrategy.get(),IDocument.DEFAULT_CONTENT_TYPE);
	}

	protected void configureMultilineComments(IEditStrategyAcceptor acceptor) {
		acceptor.accept(partitionInsertEditStrategy.get().configure("/*", "*/"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(multiLineNewLineEditStrategy.get().configure(" * ", " */"),TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION);
	}

	protected void configureCurlyBracesBlock(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.get().configure("{", "}"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(multiLineTerminals.get().configure("{", null, "}"),IDocument.DEFAULT_CONTENT_TYPE);
	}

	protected void configureSquareBrackets(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.get().configure("[", "]"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(multiLineTerminals.get().configure("[", null, "]"),IDocument.DEFAULT_CONTENT_TYPE);
	}

	protected void configureParenthesis(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.get().configure("(", ")"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(multiLineTerminals.get().configure("(", null, ")"),IDocument.DEFAULT_CONTENT_TYPE);
	}
	
	protected void configureStringLiteral(IEditStrategyAcceptor acceptor) {
		acceptor.accept(partitionInsertEditStrategy.get().configure("\"","\""),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(partitionInsertEditStrategy.get().configure("'","'"),IDocument.DEFAULT_CONTENT_TYPE);
		// The following two are registered for the default content type, because on deletion 
		// the command.offset is cursor-1, which is outside the partition of terminals.length = 1.
		// How crude is that?
		// Note that in case you have two string literals follwiing each other directly, the deletion strategy wouldn't apply.
		// One could add the same strategy for the STRING partition in addition to solve this
		acceptor.accept(partitionDeletionEditStrategy.get().configure("\"","\""),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(partitionDeletionEditStrategy.get().configure("'","'"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(partionEndTerminalSkippingEditStrategy.get(),TerminalsTokenTypeToPartitionMapper.STRING_LITERAL_PARTITION);
	}


}
