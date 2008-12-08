package org.eclipse.xtext.grammaraccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.builtin.IXtextBuiltin;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

/**
 * @author Moritz Eysholdt
 */
public class GrammarAccessUtil {

	public static String getClassName(EObject obj) {
		return obj.eClass().getName();
	}

	private static String getElementDescription(AbstractElement ele) {
		if (ele instanceof Keyword)
			return ((Keyword) ele).getValue();
		if (ele instanceof Assignment)
			return ((Assignment) ele).getFeature();
		if (ele instanceof RuleCall)
			return ((RuleCall) ele).getRule().getName();
		if (ele instanceof Action) {
			Action a = (Action) ele;
			return a.getTypeName().getName() + a.getFeature();
		}
		if (ele instanceof CrossReference) {
			CrossReference cr = (CrossReference) ele;
			String rule = (cr.getRule() != null) ? cr.getRule().getName() : "";
			String type = (cr.getType() != null) ? cr.getType().getName() : "";
			return rule + type;
		}
		return "";
	}

	private static String getElementPath(AbstractElement ele) {
		EObject obj = ele;
		StringBuffer buf = new StringBuffer();
		while ((!(obj.eContainer() instanceof AbstractRule))
				&& obj.eContainer() != null) {
			EObject tmp = obj.eContainer();
			buf.insert(0, tmp.eContents().indexOf(obj));
			obj = tmp;
		}
		return buf.toString();
	}

	private static String getElementTypeDescription(AbstractElement ele) {
		if (ele instanceof RuleCall) {
			AbstractRule r = ((RuleCall) ele).getRule();
			return r.eClass().getName() + "Call";
		}
		return ele.eClass().getName();
	}

	public static String getGrammarAccessFQName(Grammar grammar) {
		if (IXtextBuiltin.ID.equals(GrammarUtil.getLanguageId(grammar)))
			return XtextBuiltinGrammarAccess.class.getName();
		return GrammarUtil.getNamespace(grammar) + ".services."
				+ getGrammarAccessSimpleName(grammar);
	}

	public static String getGrammarAccessSimpleName(Grammar grammar) {
		if (IXtextBuiltin.ID.equals(GrammarUtil.getLanguageId(grammar)))
			return XtextBuiltinGrammarAccess.class.getSimpleName();
		return GrammarUtil.getName(grammar) + "GrammarAccess";
	}

	public static String getUniqueElementName(AbstractElement ele) {
		if (ele == null)
			return "null";
		StringBuffer r = new StringBuffer();
		r.append(getElementPath(ele));
		r.append(getElementTypeDescription(ele));
		r.append(toJavaIdentifier(getElementDescription(ele), true));
		return r.toString();
	}

	public static String toJavaIdentifier(String text, Boolean uppercaseFirst) {
		boolean start = true, up = true;
		StringBuffer r = new StringBuffer();
		for (char c : text.toCharArray()) {
			boolean valid = start ? Character.isJavaIdentifierStart(c)
					: Character.isJavaIdentifierPart(c);
			if (valid) {
				if (start)
					r.append(uppercaseFirst ? Character.toUpperCase(c)
							: Character.toLowerCase(c));
				else
					r.append(up ? Character.toUpperCase(c) : c);
				up = false;
				start = false;
			} else
				up = true;
		}
		return r.toString();
	}
}
