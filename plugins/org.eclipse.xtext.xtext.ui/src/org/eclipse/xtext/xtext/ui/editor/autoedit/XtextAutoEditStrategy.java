/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.autoedit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.MultiLineTerminalsEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.SingleLineTerminalsStrategy.StrategyPredicate;
import org.eclipse.xtext.ui.editor.model.DocumentUtil;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextAutoEditStrategy extends DefaultAutoEditStrategyProvider {

	private static final Pattern singleColonPattern = Pattern.compile("[^:]:($|[^:])");
	private static final Pattern returnsPattern = Pattern.compile("\\sreturns\\s");
	private static final Pattern doubleColonPattern = Pattern.compile("::");
	
	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.accept(singleLineTerminals.newInstance(":", ";", new StrategyPredicate() {
			@Override
			public boolean isInsertClosingBracket(IDocument doc, final int offset) throws BadLocationException {
				String currentRuleUptoOffset = getCurrentRuleUptoOffset(offset, doc);
				Matcher matcher = singleColonPattern.matcher(currentRuleUptoOffset);
				boolean isInsideRuleBody = matcher.find();
				if(isInsideRuleBody) 
					return false;
				Matcher returnsPatternMatcher = returnsPattern.matcher(currentRuleUptoOffset);
				if(returnsPatternMatcher.find()) {
					return doubleColonPattern.matcher(currentRuleUptoOffset).find(returnsPatternMatcher.end());
				}
				return true;
			}
		}), IDocument.DEFAULT_CONTENT_TYPE);
	}

	protected MultiLineTerminalsEditStrategy createColonSemicolonStrategy() {
		MultiLineTerminalsEditStrategy configure = multiLineTerminals.newInstance(":", null, ";", false);
		// the following is a cheap but working hack, which replaces any double colons '::' by whitespace '  ' temporarily.
		configure.setDocumentUtil(new DocumentUtil() {
			@Override
			protected String preProcessSearchString(String string) {
				return string.replace("::", "  ");
			}
		});
		return configure;
	}
	
	@Override
	protected void configureCompoundBracesBlocks(IEditStrategyAcceptor acceptor) {
		acceptor.accept(compoundMultiLineTerminals.newInstanceFor("{", "}").and("[", "]").and("(", ")")
				.and(createColonSemicolonStrategy()), IDocument.DEFAULT_CONTENT_TYPE);
	}

	protected String getCurrentRuleUptoOffset(int offset, IDocument doc) throws BadLocationException {
		ITypedRegion currentPartition = doc.getPartition(offset);
		String partitionType = currentPartition.getType();
		String currentSegment = doc.get(currentPartition.getOffset(), offset - currentPartition.getOffset());
		StringBuilder ruleAsString = new StringBuilder(); 
		while(currentSegment.indexOf(';') == -1) {
			ruleAsString.insert(0, currentSegment);
			do {
				if(currentPartition.getOffset()==0) {
					return ruleAsString.toString();
				}
				currentPartition = doc.getPartition(currentPartition.getOffset()-1);
				currentSegment = doc.get(currentPartition.getOffset(), currentPartition.getLength());
			} while(!partitionType.equals(currentPartition.getType()));
		}
		ruleAsString.insert(0, currentSegment.substring(currentSegment.lastIndexOf(';') + 1));
		return ruleAsString.toString();
	}

}
