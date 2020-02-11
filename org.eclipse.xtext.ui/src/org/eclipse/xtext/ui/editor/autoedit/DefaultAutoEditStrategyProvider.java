/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	protected Provider<DefaultIndentLineAutoEditStrategy> defaultIndentLineAutoEditStrategy;
	@Inject
	protected Provider<PartitionEndSkippingEditStrategy> partitionEndSkippingEditStrategy;
	@Inject
	protected PartitionInsertEditStrategy.Factory partitionInsert;
	@Inject
	protected PartitionDeletionEditStrategy.Factory partitionDeletion;
	@Inject
	protected SingleLineTerminalsStrategy.Factory singleLineTerminals;
	@Inject
	protected MultiLineTerminalsEditStrategy.Factory multiLineTerminals;
	
	/**
	 * @since 2.0
	 */
	@Inject
	protected CompoundMultiLineTerminalsEditStrategy.Factory compoundMultiLineTerminals;
	
	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		configureIndentationEditStrategy(acceptor);
		configureStringLiteral(acceptor);
		configureParenthesis(acceptor);
		configureSquareBrackets(acceptor);
		configureCurlyBracesBlock(acceptor);
		configureMultilineComments(acceptor);
		configureCompoundBracesBlocks(acceptor);
	}

	/**
	 * @since 2.0
	 */
	protected void configureCompoundBracesBlocks(IEditStrategyAcceptor acceptor) {
		acceptor.accept(compoundMultiLineTerminals.newInstanceFor("{", "}").and("[", "]").and("(", ")"), IDocument.DEFAULT_CONTENT_TYPE);
	}

	protected void configureIndentationEditStrategy(IEditStrategyAcceptor acceptor) {
		acceptor.accept(defaultIndentLineAutoEditStrategy.get(), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(defaultIndentLineAutoEditStrategy.get(), TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION);
		acceptor.accept(defaultIndentLineAutoEditStrategy.get(), TerminalsTokenTypeToPartitionMapper.SL_COMMENT_PARTITION);
	}

	protected void configureMultilineComments(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("/*", " */"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(multiLineTerminals.newInstance("/***"," * ", " ***/"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(multiLineTerminals.newInstance("/***"," * ", " ***/"),TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION);
		acceptor.accept(multiLineTerminals.newInstance("/*"," * ", " */"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(multiLineTerminals.newInstance("/*"," * ", " */"),TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION);
	}

	protected void configureCurlyBracesBlock(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("{", "}"),IDocument.DEFAULT_CONTENT_TYPE);
	}

	protected void configureSquareBrackets(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("[", "]"),IDocument.DEFAULT_CONTENT_TYPE);
	}

	protected void configureParenthesis(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("(", ")"),IDocument.DEFAULT_CONTENT_TYPE);
	}
	
	protected void configureStringLiteral(IEditStrategyAcceptor acceptor) {
		acceptor.accept(partitionInsert.newInstance("\"","\""),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(partitionInsert.newInstance("'","'"),IDocument.DEFAULT_CONTENT_TYPE);
		// The following two are registered for the default content type, because on deletion 
		// the command.offset is cursor-1, which is outside the partition of terminals.length = 1.
		// How crude is that?
		// Note that in case you have two string literals following each other directly, the deletion strategy wouldn't apply.
		// One could add the same strategy for the STRING partition in addition to solve this
		acceptor.accept(partitionDeletion.newInstance("\"","\""),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(partitionDeletion.newInstance("'","'"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(partitionEndSkippingEditStrategy.get(),TerminalsTokenTypeToPartitionMapper.STRING_LITERAL_PARTITION);
	}


}
