/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.parsetree.reconstr.SerializerOptions;
import org.eclipse.xtext.parsetree.reconstr.Serializer;

import com.google.inject.Guice;

/**
 * @author Moritz Eysholdt
 */
public class GrammarAccessUtil {

	public static String getClassName(EObject obj) {
		return obj.eClass().getName();
	}

	private static List<String> getElementDescription(AbstractElement element) {
		final ArrayList<String> result = new ArrayList<String>();
		AbstractElement container = element;
		while (container != null) {
			result.addAll(0, getSingleElementDescription(container));
			container = container.eContainer() instanceof AbstractElement ? (AbstractElement) container
					.eContainer()
					: null;
		}
		return result;
	}

	private static List<String> getSingleElementDescription(AbstractElement ele) {
		if (ele instanceof Keyword)
			return Collections.singletonList(((Keyword) ele).getValue());
		else if (ele instanceof Assignment)
			return Collections.singletonList(((Assignment) ele).getFeature());
		else if (ele instanceof RuleCall)
			return Collections.singletonList(((RuleCall) ele).getRule()
					.getName());
		else if (ele instanceof Action) {
			Action a = (Action) ele;
			ArrayList<String> r = new ArrayList<String>();
			if (a.getType() != null && a.getType().getClassifier() != null)
				r.add(a.getType().getClassifier().getName());
			if (a.getFeature() != null && !"".equals(a.getFeature()))
				r.add(a.getFeature());
			return r;
		} else if (ele instanceof CrossReference) {
			CrossReference cr = (CrossReference) ele;
			if (cr.getType() != null && cr.getType().getClassifier() != null)
				return Collections.singletonList(cr.getType().getClassifier()
						.getName());
		} else if (ele instanceof EnumLiteralDeclaration) {
			EnumLiteralDeclaration decl = (EnumLiteralDeclaration) ele;
			return Collections.singletonList(decl.getEnumLiteral().getName());
		}
		return Collections.emptyList();
	}

	private static Serializer xtextSerializer;

	public static String serialize(EObject obj, String prefix) {
		String s;
		try {
			SerializerOptions opt = new SerializerOptions();
			opt.setFormatting(true);
			s = getSerializer().serialize(obj, opt);
		} catch (Exception e) {
			s = e.toString();
			// e.printStackTrace();
		}
		s = prefix
				+ s.trim().replaceAll("[\\r\\n]", "\n" + prefix).replaceAll(
						"/\\*", "/ *").replaceAll("\\*/", "* /");
		return s;
	}

	private static Serializer getSerializer() {
		if (xtextSerializer==null)
			xtextSerializer = Guice.createInjector(
					new XtextRuntimeModule()).getInstance(Serializer.class);
		return xtextSerializer;
	}

	private static String getElementPath(AbstractElement ele) {
		EObject obj = ele;
		StringBuffer buf = new StringBuffer();
		while ((!(obj.eContainer() instanceof AbstractRule))
				&& obj.eContainer() != null) {
			EObject tmp = obj.eContainer();
			buf.insert(0, tmp.eContents().indexOf(obj));
			buf.insert(0, "_");
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

	public static String getGrammarAccessFQName(Grammar grammar, Naming naming) {
		return naming.basePackageRuntime(grammar) + ".services." +GrammarUtil.getName(grammar) + "GrammarAccess";
	}

	public static String getUniqueElementName(AbstractElement ele) {
		try {
			if (ele == null)
				return "null";
			ArrayList<String> r = new ArrayList<String>();
			r.addAll(getElementDescription(ele));
			r.add(getElementTypeDescription(ele));
			r.add(getElementPath(ele));
			return toJavaIdentifier(r, true);
		} catch (Throwable t) {
			t.printStackTrace();
			return "failure";
		}
	}

	private static String toJavaIdentifier(List<String> text,
			boolean uppercaseFirst) {
		Iterator<String> i = text.iterator();
		StringBuffer b = new StringBuffer(toJavaIdentifierSegment(i.next(),
				true, uppercaseFirst));
		while (i.hasNext())
			b.append(toJavaIdentifierSegment(i.next(), false, true));
		return b.toString();
	}

	private static String toJavaIdentifierSegmentInt(String text,
			boolean isFirst, boolean uppercaseFirst) {
		boolean start = isFirst, up = true;
		StringBuffer r = new StringBuffer();
		for (char c : text.toCharArray()) {
			boolean valid = isValidJavaLatinIdentifier(start, c);
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

	public static boolean isValidJavaLatinIdentifier(boolean start, char c) {
		boolean valid = c >= 'A' && c<= 'Z';
		valid = valid || c >= 'a' && c<= 'z';
		valid = valid || c == 'ä' || c == 'ö' || c == 'ü' || c == 'Ä' || c == 'Ö'|| c == 'Ü';
		valid = valid || c == '_';
		if (!start) {
			valid = valid || c>='0' && c<='9';
		}
		return valid;
	}

	private static String toJavaIdentifierSegment(String text, boolean isFirst,
			boolean uppercaseFirst) {
		String r = toJavaIdentifierSegmentInt(text, isFirst, uppercaseFirst);
		if (r.length() > 0)
			return r;
		StringBuffer b = new StringBuffer();
		for (char c : text.toCharArray()) {
			String n = UnicodeCharacterDatabaseNames.getCharacterName(c);
			if (n != null)
				b.append(n + " ");
		}
		return toJavaIdentifierSegmentInt(b.toString().toLowerCase().trim(),
				isFirst, true);
	}

	public static String toJavaIdentifier(String text, Boolean uppercaseFirst) {
		try {
			return toJavaIdentifierSegment(text, true, uppercaseFirst);
		} catch (Throwable t) {
			t.printStackTrace();
			return "%_FAILURE_(" + text + ")%";
		}
	}
}
