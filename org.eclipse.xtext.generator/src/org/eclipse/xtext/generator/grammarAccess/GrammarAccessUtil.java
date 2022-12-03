/*******************************************************************************
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xtext.RuleNames;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;

import com.google.common.collect.Maps;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Moritz Eysholdt
 */
@Deprecated(forRemoval = true)
public class GrammarAccessUtil {

	/**
	 * @since 2.9
	 */
	protected static class LineSeparatorModule extends XtextRuntimeModule {
		private final ILineSeparatorInformation lineSeparatorInformation;

		protected LineSeparatorModule(ILineSeparatorInformation lineSeparatorInformation) {
			this.lineSeparatorInformation = lineSeparatorInformation;
		}

		@Override
		public void configure(Binder binder) {
			// avoid duplicate registration of the validator
			Module compound = getBindings();
			compound.configure(binder);
		}

		public ILineSeparatorInformation bindILineSeparatorInformation() {
			return lineSeparatorInformation;
		}
	}

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

	private static Map<String, ISerializer> xtextSerializerByLineDelimiter = Maps.newHashMapWithExpectedSize(2);

	public static String serialize(EObject obj, String prefix) {
		return serialize(obj, prefix, Strings.newLine());
	}
	
	/**
	 * @since 2.7
	 */
	public static String serialize(EObject obj, String prefix, String lineDelimiter) {
		ISerializer serializer = getSerializer(lineDelimiter);
		String result = GrammarAccessExtensions.grammarFragmentToString(serializer, obj, prefix);
		return result;
	}

	private static ISerializer getSerializer(final String delimiter) {
		ISerializer result = xtextSerializerByLineDelimiter.get(delimiter);
		if (result != null) {
			return result;
		}
		final ILineSeparatorInformation lineSeparatorInformation = new ILineSeparatorInformation() {
			@Override
			public String getLineSeparator() {
				return delimiter;
			}
		};
		Injector injector = Guice.createInjector(new LineSeparatorModule(lineSeparatorInformation));
		result = injector.getInstance(ISerializer.class);
		xtextSerializerByLineDelimiter.put(delimiter, result);
		return result;
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
		return naming.basePackageRuntime(grammar) + ".services." +GrammarUtil.getSimpleName(grammar) + "GrammarAccess";
	}
	
	/**
	 * @since 2.9
	 */
	public static String getUniqueRuleName(AbstractRule rule) {
		String plainName = RuleNames.getRuleNames(rule).getUniqueRuleName(rule);
		return toJavaIdentifier(plainName, true);
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
			String n = Character.getName(c);
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
	
	// Duplicated from GrammarAccessFragment2
	/**
	 * @since 2.9
	 */
	public static List<Grammar> getEffectivelyUsedGrammars(final Grammar grammar) {
		List<AbstractRule> allRules = GrammarUtil.allRules(grammar);
		List<Grammar> _map = ListExtensions.map(allRules, new Function1<AbstractRule, Grammar>() {
			@Override
			public Grammar apply(final AbstractRule it) {
				return GrammarUtil.getGrammar(it);
			}
		});
		Iterable<Grammar> filtered = IterableExtensions.filter(_map, new Function1<Grammar, Boolean>() {
			@Override
			public Boolean apply(final Grammar it) {
				return Boolean.valueOf((it != grammar));
			}
		});
		Set<Grammar> set = IterableExtensions.toSet(filtered);
		return IterableExtensions.toList(set);
	}
}
