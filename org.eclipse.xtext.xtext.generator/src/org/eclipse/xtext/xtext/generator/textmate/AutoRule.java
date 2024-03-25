/**
 * Copyright (c) 2024 Sigasi (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.textmate;

import java.util.Optional;

import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UntilToken;

/**
 * A TextMate rule that will parse the associated terminal rule and infer the TextMate equivalent automatically, if possible. 
 * 
 * @author David Medina
 * @author Sebastian Zarnekow
 * @since 2.35
 */
public class AutoRule extends TextMateRule {
	
	@Mandatory
	@Override
	public void setTerminalRule(String terminalRule) {
		super.setTerminalRule(terminalRule);
	}

	public Optional<TextMateRule> init(Grammar grammar, boolean ignoreCase, TerminalRuleToTextMateRule generator) {
		TerminalRule terminal = (TerminalRule) GrammarUtil.findRuleForName(grammar, getTerminalRule());
		if (terminal != null) {
			Optional<TextMateRule> result = toBeginEndRule(terminal, generator).or(()->toMatchRule(terminal, generator));
			return result.map(r->{
				r.setName(Optional.ofNullable(getName()).orElseGet(()->toTextMateName(terminal, GrammarUtil.getSimpleName(grammar).toLowerCase())));
				return r;
			}).filter(r->r.getName() != null);
		}
		return Optional.empty();
	}
	
	protected Optional<TextMateRule> toBeginEndRule(TerminalRule rule, TerminalRuleToTextMateRule generator) {
		AbstractElement alternatives = rule.getAlternatives();
		if (alternatives instanceof Group) {
			Group group = (Group) alternatives;
			if (group.getElements().size() == 2 && group.getElements().get(1) instanceof UntilToken) {
				String begin = generator.getMatchRegEx(group.getElements().get(0));
				String end = generator.getMatchRegEx(((UntilToken)group.getElements().get(1)).getTerminal());
				BeginEndRule result = new BeginEndRule();
				result.setBegin(begin);
				result.setEnd(end);
				return Optional.of(result);
			}
		}
		return Optional.empty();
	}
	
	protected Optional<TextMateRule> toMatchRule(TerminalRule rule, TerminalRuleToTextMateRule generator) {
		try {
			String match = generator.getMatchRegEx(rule);
			MatchRule result = new MatchRule();
			result.setMatch(match);
			return Optional.of(result);
		} catch(Exception e) {
			return Optional.empty();
		}
	}

	protected String toTextMateName(TerminalRule terminal, String langName) {
		switch(terminal.getName()) {
		case "SL_COMMENT": return "comment.line." + langName;
		case "ML_COMMENT": return "comment.block." + langName;
		case "STRING": return "string.quoted." + langName;
		case "ID": return "variable." + langName;
		case "INT": return "constant.numeric." + langName;
		case "ANY_OTHER": return "invalid." + langName;
		}
		return null;
	}

}