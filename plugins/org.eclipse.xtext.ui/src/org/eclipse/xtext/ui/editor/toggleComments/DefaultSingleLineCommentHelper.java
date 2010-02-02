/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.toggleComments;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.TerminalRule;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class DefaultSingleLineCommentHelper implements ISingleLineCommentHelper {

	public static final String SL_COMMENT = "org.eclipse.xtext.ui.editor.DefaultSingleLineCommentHelper.SL_COMMENT"; 
	
	@Inject
	private IGrammarAccess grammarAccess;
	
	@Inject(optional=true)
	@Named(SL_COMMENT)
	private String singleLineCommentRule = "SL_COMMENT";
	
	private String[] result;
	
	public String[] getDefaultPrefixes(ISourceViewer sourceViewer, String contentType) {
		if (result != null)
			return result;
		AbstractRule rule = GrammarUtil.findRuleForName(grammarAccess.getGrammar(), singleLineCommentRule);
		if (rule == null || !(rule instanceof TerminalRule)) {
			return null;
		}
		calculatePrefixes(rule);
		return this.result;
	}

	protected void calculatePrefixes(AbstractRule rule) {
		final List<String> result = new ArrayList<String>(3);
		createCalculator(result).doSwitch(rule.getAlternatives());
		this.result = result.toArray(new String[result.size()]);
	}

	protected SLCommentPrefixCalculator createCalculator(final List<String> result) {
		return new SLCommentPrefixCalculator(result);
	}

	public void setGrammarAccess(IGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	public IGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}

	public void setSingleLineCommentRule(String singleLineCommentRule) {
		this.singleLineCommentRule = singleLineCommentRule;
	}

	public String getSingleLineCommentRule() {
		return singleLineCommentRule;
	}

}
