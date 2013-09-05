package org.xpect.xtext.lib.util;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractNegatedToken;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.NegatedToken;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xbase.XbasePackage;

import com.google.common.collect.Lists;

@SuppressWarnings("restriction")
public class GrammarAnalyzer {

	// be aware, that syntactically one TerminalRule can declare multiple
	// CommentRules.
	public static class CommentRule {
		private final String start;

		public CommentRule(String start) {
			this.start = start;
		}

		public String getStart() {
			return start;
		}
	}

	public static class MLCommentRule extends CommentRule {
		private final String end;

		public MLCommentRule(String start, String end) {
			super(start);
			this.end = end;
		}

		public String getEnd() {
			return end;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + ": '" + getStart() + "' -> '" + getEnd() + "'";
		}
	}

	public static class SLCommentRule extends CommentRule {
		public SLCommentRule(String start) {
			super(start);
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + ": '" + getStart() + "' -> '\n'";
		}
	}

	public enum XtextLanguageKind {
		GENRAL, JAVA, XBASE
	}

	private List<CommentRule> commentRules;

	private final Grammar grammar;

	public GrammarAnalyzer(Grammar grammar) {
		this.grammar = grammar;
	}

	protected List<String> collectChars(AbstractElement ele) {
		ele = resolve(ele);
		if (GrammarUtil.isOptionalCardinality(ele))
			return Collections.emptyList();
		if (ele instanceof Keyword) {
			String value = ((Keyword) ele).getValue();
			if (!"\r".equals(value)) // it suffices to handle \n
				return Collections.singletonList(value);
		}
		if (ele instanceof Group) {
			return collectChars((Group) ele, 0, ((Group) ele).getElements().size());
		}
		if (ele instanceof Alternatives) {
			List<String> current = Lists.newArrayList();
			for (AbstractElement e : ((Alternatives) ele).getElements())
				current.addAll(collectChars(e));
			return current;
		}
		return Collections.emptyList();
	}

	protected List<String> collectChars(Group ele, int from, int to) {
		List<String> last = Lists.newArrayList("");
		List<String> current = Lists.newArrayList();
		for (int i = from; i < to; i++) {
			for (String l : last)
				for (String append : collectChars(ele.getElements().get(i)))
					current.add(l + append);
			last = current;
			current = Lists.newArrayList();
		}
		return last;
	}

	protected void collectCommentRules(AbstractElement ele, List<CommentRule> rules) {
		ele = resolve(ele);
		if (ele instanceof Group) {
			Group group = (Group) ele;
			AbstractNegatedToken negated = null;
			for (AbstractElement child : group.getElements())
				if (child instanceof AbstractNegatedToken) {
					if (negated == null)
						negated = (AbstractNegatedToken) child;
					else
						return;
				}
			if (negated instanceof NegatedToken) {
				int index = group.getElements().indexOf(negated);
				if (index > 0 && index < group.getElements().size() - 1) {
					List<String> starts = collectChars(group, 0, index);
					List<String> ends = collectChars(group, index + 1, group.getElements().size());
					if (ends.isEmpty()) {
						for (String start : starts)
							rules.add(new SLCommentRule(start));
					} else {
						for (String start : starts)
							for (String end : ends)
								if (end.contains("\n"))
									rules.add(new SLCommentRule(start));
								else
									rules.add(new MLCommentRule(start, end));
					}
				}
			} else if (negated instanceof UntilToken) {
				int index = group.getElements().indexOf(negated);
				if (index == group.getElements().size() - 1) {
					List<String> starts = collectChars(group, 0, index);
					List<String> ends = collectChars(((UntilToken) negated).getTerminal());
					for (String start : starts) {
						for (String end : ends)
							rules.add(new MLCommentRule(start, end));
					}
				}
			}
		} else if (ele instanceof Alternatives) {
			for (AbstractElement e : ((Alternatives) ele).getElements())
				collectCommentRules(e, rules);
		}
	}

	public List<CommentRule> getCommentRules() {
		if (this.commentRules == null) {
			this.commentRules = Lists.newArrayList();
			Grammar grammarWithHiddenTokens = grammar;
			while (!grammarWithHiddenTokens.isDefinesHiddenTokens() && !grammarWithHiddenTokens.getUsedGrammars().isEmpty())
				grammarWithHiddenTokens = grammarWithHiddenTokens.getUsedGrammars().get(0);
			if (grammarWithHiddenTokens.isDefinesHiddenTokens())
				for (AbstractRule rule : grammarWithHiddenTokens.getHiddenTokens())
					if (rule instanceof TerminalRule)
						collectCommentRules(rule.getAlternatives(), this.commentRules);
		}
		return this.commentRules;
	}

	public XtextLanguageKind getLanguageKind() {
		List<Grammar> grammars = Lists.newArrayList(grammar);
		grammars.addAll(GrammarUtil.allUsedGrammars(grammar));
		boolean xbase = false;
		boolean java = false;
		for (Grammar g : grammars)
			for (AbstractMetamodelDeclaration decl : g.getMetamodelDeclarations())
				if (decl instanceof ReferencedMetamodel) {
					if (decl.getEPackage().getNsURI().equals(XbasePackage.eNS_URI))
						xbase = true;
					else if (decl.getEPackage().getNsURI().equals(TypesPackage.eNS_URI))
						java = true;
				}
		if (xbase)
			return XtextLanguageKind.XBASE;
		if (java)
			return XtextLanguageKind.JAVA;
		return XtextLanguageKind.GENRAL;
	}

	protected AbstractElement resolve(AbstractElement ele) {
		if (ele instanceof RuleCall) {
			AbstractRule rule = ((RuleCall) ele).getRule();
			if (rule instanceof TerminalRule && ((TerminalRule) rule).isFragment())
				return rule.getAlternatives();
		}
		return ele;
	}

}
