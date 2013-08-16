package org.xpect.xtext.lib.util;

import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.NegatedToken;
import org.eclipse.xtext.ReferencedMetamodel;
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
	}

	public static class SLCommentRule extends CommentRule {
		public SLCommentRule(String start) {
			super(start);
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

	protected String collectChars(AbstractElement ele) {
		if (GrammarUtil.isOptionalCardinality(ele))
			return "";
		if (ele instanceof Keyword)
			return ((Keyword) ele).getValue();
		if (ele instanceof Group) {
			StringBuilder result = new StringBuilder();
			for (AbstractElement e : ((Group) ele).getElements())
				result.append(collectChars(e));
			return result.toString();
		}
		if (ele instanceof Alternatives)
			return collectChars(((Alternatives) ele).getElements().get(0));
		return "";
	}

	protected void collectCommentRules(AbstractElement ele, List<CommentRule> rules) {
		if (ele instanceof Group) {
			Group group = (Group) ele;
			if (group.getElements().size() == 3) {
				AbstractElement middle = group.getElements().get(1);
				if (middle instanceof NegatedToken) {
					String start = collectChars(group.getElements().get(0));
					String end = collectChars(group.getElements().get(2));
					if ("".equals("") || end.contains("\n"))
						rules.add(new SLCommentRule(start));
					else
						rules.add(new MLCommentRule(start, end));
				}
			} else if (group.getElements().size() == 2) {
				AbstractElement middle = group.getElements().get(1);
				if (middle instanceof UntilToken) {
					String start = collectChars(group.getElements().get(0));
					String end = collectChars(((UntilToken) middle).getTerminal());
					rules.add(new MLCommentRule(start, end));
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

}
