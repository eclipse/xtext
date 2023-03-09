/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompositeCondition;
import org.eclipse.xtext.Condition;
import org.eclipse.xtext.Conjunction;
import org.eclipse.xtext.Disjunction;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.LiteralCondition;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.Negation;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParameterReference;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.XtextSwitch;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.OriginalElement;
import org.eclipse.xtext.xtext.OriginalGrammar;
import org.eclipse.xtext.xtext.RuleNames;
import org.eclipse.xtext.xtext.RuleWithParameterValues;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrGrammarGenUtil {
	
	/**
	 * Returns the effective rule name for the generated Antlr grammar.
	 * Inherited rules may be prefixed by {@code super[0..9]*}. Otherwise the
	 * prefix {@code rule or RULE_} is used.
	 * @since 2.9
	 */
	public static String getRuleName(AbstractRule rule) {
		RuleWithParameterValues parameterValues = RuleWithParameterValues.findInEmfObject(rule);
		if (parameterValues != null) {
			return rule.getName();
		}
		RuleNames ruleNames = RuleNames.getRuleNames(rule);
		return ruleNames.getAntlrRuleName(rule);
	}
	
	public static String getContentAssistRuleName(AbstractRule rule) {
		String ruleName = getRuleName(rule);
		if (ruleName.startsWith("rule"))
			return "rule__" + Strings.toFirstUpper(ruleName.substring(4, ruleName.length()));
		return ruleName;
	}
	
	/**
	 * @since 2.9
	 */
	public static String getEntryRuleName(ParserRule rule) {
		RuleWithParameterValues parameterValues = RuleWithParameterValues.findInEmfObject(rule);
		if (parameterValues != null) {
			if (parameterValues.getParamValues().isEmpty()) {
				AbstractRule original = parameterValues.getOriginal();
				RuleNames ruleNames = RuleNames.getRuleNames(original);
				return "entry" + Strings.toFirstUpper(ruleNames.getAntlrRuleName(original));
			}
			return null;
		} else {
			RuleNames ruleNames = RuleNames.getRuleNames(rule);
			return "entry" + Strings.toFirstUpper(ruleNames.getAntlrRuleName(rule));
		}
	}
	
	/**
	 * @since 2.9
	 */
	public static boolean isValidEntryRule(ParserRule rule) {
		if (rule.isFragment()) {
			return false;
		}
		RuleWithParameterValues parameterValues = RuleWithParameterValues.findInEmfObject(rule);
		if (parameterValues.getParamValues().isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * @since 2.9
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getOriginalElement(T obj) {
		if (obj instanceof AbstractRule) {
			AbstractRule result = RuleWithParameterValues.tryGetOriginalRule((AbstractRule) obj);
			if (result != null)
				return (T) result;
			return obj;
		}
		if (obj instanceof Grammar) {
			OriginalGrammar originalGrammar = OriginalGrammar.findInEmfObject(obj);
			return (T) originalGrammar.getOriginal();
		}
		if (obj instanceof AbstractElement) {
			OriginalElement original = OriginalElement.findInEmfObject(obj);
			return (T) original.getOriginal();
		}
		throw new IllegalArgumentException(String.valueOf(obj));
	}
	
	/**
	 * @since 2.9
	 */
	public static int getParameterConfig(ParserRule rule) {
		return RuleWithParameterValues.getParamConfig(rule);
	}
	
	/**
	 * @since 2.9
	 */
	public static String getParameterList(ParserRule rule, Boolean skipCurrent, String currentType) {
		boolean currentAsParam = rule.isFragment() && !GrammarUtil.isDatatypeRule(getOriginalElement(rule));
		if ((skipCurrent || !currentAsParam) && rule.getParameters().isEmpty()) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		result.append("[");
		if (!skipCurrent) {
			if (currentAsParam) {
				result.append(currentType).append(" in_current");
				if (!rule.getParameters().isEmpty()) {
					result.append(", ");
				}
			}
		}
		Joiner.on(", ").appendTo(result, Iterables.transform(rule.getParameters(), new Function<Parameter, String>() {
			@Override
			public String apply(Parameter input) {
				return "boolean p_" + input.getName();
			}
		}));
		result.append("] ");
		return result.toString();
	}
	
	/**
	 * @since 2.9
	 */
	public static String getArgumentList(final RuleCall ruleCall, final Boolean isPredicate) {
		if (DebugGrammarToken.isGeneratingDebugGrammar()) {
			return "";
		}
		return getArgumentList(ruleCall, true, isPredicate);
	}
	
	/**
	 * @since 2.9
	 */
	public static String getArgumentList(final RuleCall ruleCall, boolean passCurrentIntoFragment, boolean isPredicate) {
		final List<NamedArgument> arguments = ruleCall.getArguments();
		AbstractRule abstractRule = ruleCall.getRule();
		boolean needsCurrent = passCurrentIntoFragment && GrammarUtil.isEObjectFragmentRule(abstractRule) && !GrammarUtil.isDatatypeRule((ParserRule) getOriginalElement(abstractRule));
		if (arguments.isEmpty()) {
			if (needsCurrent) {
				return isPredicate ? "[null]" : "[$current]";
			}
			return "";
		}
		ParserRule rule = (ParserRule) abstractRule;
		StringBuilder result = new StringBuilder();
		result.append("[");
		if (needsCurrent) {
			if (isPredicate) {
				result.append("null, ");
			} else {
				result.append("$current, ");
			}
		}
		Joiner.on(", ").appendTo(result, Iterables.transform(rule.getParameters(), new Function<Parameter, String>() {
			@Override
			public String apply(Parameter input) {
				for(NamedArgument argument: arguments) {
					if (argument.getParameter() == input) {
						return conditionToAntlr(argument.getValue(), true);
					}
				}
				throw new IllegalStateException("Cannot find argument for parameter: " + input.getName());
			}
		}));
		result.append("]");
		return result.toString();
	}
	
	/**
	 * @since 2.9
	 */
	public static String conditionToAntlr(Condition condition, final boolean includeRuleName) {
		final StringBuilder result = new StringBuilder();
		new XtextSwitch<StringBuilder>() {
			@Override
			public StringBuilder caseDisjunction(Disjunction object) {
				doSwitch(object.getLeft());
				result.append(" || ");
				doSwitch(object.getRight());
				return result;
			}
			@Override
			public StringBuilder caseConjunction(Conjunction object) {
				appendChild(object.getLeft(), Disjunction.class);
				result.append(" && ");
				appendChild(object.getRight(), Disjunction.class);
				return result;
			}
			public void appendChild(Condition condition, Class<? extends Condition> parenthesizedIf) {
				if (parenthesizedIf.isInstance(condition)) {
					result.append('(');
					doSwitch(condition);
					result.append(')');
				} else {
					doSwitch(condition);
				}
			}
			@Override
			public StringBuilder caseNegation(Negation object) {
				result.append('!');
				appendChild(object.getValue(), CompositeCondition.class);
				return result;
			}
			@Override
			public StringBuilder caseParameterReference(ParameterReference object) {
				Parameter param = object.getParameter();
				if (includeRuleName) {
					AbstractRule declaringRule = GrammarUtil.containingRule(param);
					result.append('$').append(getRuleName(declaringRule)).append('.');
				}
				result.append("p_").append(param.getName());
				return result;
			}
			@Override
			public StringBuilder caseLiteralCondition(LiteralCondition object) {
				return result.append(object.isTrue());
			}
		}.doSwitch(condition);
		return result.toString();
	}
	
	/**
	 * @since 2.9
	 */
	public static String getDefaultArgumentList(ParserRule rule) {
		String result = IterableExtensions.join(rule.getParameters(), "[", ", ", "]", new Functions.Function1<Parameter, String>() {
			@Override
			public String apply(Parameter p) {
				return Boolean.FALSE.toString();
			}
		});
		return result;
	}

	/**
	 * @since 2.9
	 */
	public static String guardConditionToAntlr(Group group) {
		Condition condition = group.getGuardCondition();
		if (condition == null) {
			return "";
		}
		return "{" + conditionToAntlr(condition, false) + "}?=>";
	}

	/**
	 * @since 2.9
	 */
	public static AbstractElement getPredicatedElement(AbstractElement element) {
		if (element.isPredicated()) {
			return doGetPredicatedElement(element);
		}
		if (element instanceof Assignment) {
			return getPredicatedElement(((Assignment) element).getTerminal());
		}
		if (element instanceof RuleCall) {
			final RuleCall ruleCall = (RuleCall) element;
			final AbstractRule calledRule = ruleCall.getRule();
			Group group = (Group) calledRule.getAlternatives();
			AbstractElement first = group.getElements().get(0);
			AbstractElement result = getPredicatedElement(first);
			if (ruleCall.getArguments().isEmpty()) {
				return result;
			}
			EcoreUtil.Copier copier = new EcoreUtil.Copier() {
				private static final long serialVersionUID = 1L;

				@Override
				public EObject copy(EObject eObject) {
					if (eObject instanceof ParameterReference) {
						ParameterReference paramRef = (ParameterReference) eObject;
						Parameter parameter = paramRef.getParameter();
						if (calledRule == GrammarUtil.containingRule(parameter)) {
							for(NamedArgument givenArgument: ruleCall.getArguments()) {
								if (givenArgument.getParameter() == parameter) {
									EObject result = copy(givenArgument.getValue());
									return result;
								}
							}
							throw new IllegalStateException();
						}
					}
					return super.copy(eObject);
				}
			};
			AbstractElement clone = (AbstractElement) copier.copy(result);
			copier.copyReferences();
			return clone;
		}
		return doGetPredicatedElement(element);
	}
	
	private static AbstractElement doGetPredicatedElement(final AbstractElement element) {
		if (element instanceof Alternatives || element instanceof Group) {
			EcoreUtil.Copier copier = new EcoreUtil.Copier(true, true) {
				private static final long serialVersionUID = 1L;

				@Override
				public EObject copy(EObject eObject) {
					if (eObject instanceof AbstractElement) {
						if (((AbstractElement) eObject).isFirstSetPredicated() && isLastInGroup(eObject)) {
							Collection<AbstractElement> firstSet = EcoreUtil.copyAll(getFirstSet((AbstractElement) eObject));
							if (firstSet.size() == 1) {
								AbstractElement result = firstSet.iterator().next();
								result.setCardinality(((AbstractElement) eObject).getCardinality());
								return result;
							}
							Alternatives result = XtextFactory.eINSTANCE.createAlternatives();
							for(AbstractElement firstElement: firstSet) {
								firstElement.setCardinality(null);
							}
							result.getElements().addAll(firstSet);
							result.setCardinality(((AbstractElement) eObject).getCardinality());
							return result;
						}
					}
					return super.copy(eObject);
				}

				private boolean isLastInGroup(EObject eObject) {
					if (eObject == element) {
						return true;
					}
					EObject container = eObject.eContainer();
					if (container instanceof Group) {
						List<AbstractElement> siblings = ((Group) container).getElements();
						if (siblings.get(siblings.size() - 1) == eObject) {
							return isLastInGroup(container);
						}
					}
					if (container instanceof Alternatives) {
						return isLastInGroup(container);
					}
					return false;
				}
			};
			AbstractElement clone = (AbstractElement) copier.copy(element);
			copier.copyReferences();
			return clone;
		}
		return element;
	}
	
	/**
	 * @since 2.9
	 */
	public static String getQualifiedNameAsString(RuleCall ruleCall) {
		AbstractRule rule = getOriginalElement(ruleCall).getRule();
		String result = RuleNames.getRuleNames(rule).getQualifiedName(rule);
		return '"' + result + '"';
	}

	public static String toAntlrString(String string) {
		return Strings.convertToJavaString(string, true).replace("\\\"", "\"");
	}
	
	/**
	 * Returns the first-set of the given abstractElement. That is, all keywords
	 * with distinct values and all rule calls to distinct terminals.
	 * @since 2.9
	 */
	public static List<AbstractElement> getFirstSet(AbstractElement element) {
		return FirstSetComputer.getFirstSet(element);
	}

	public static String toStringInAntlrAction(String string) {
		return Strings.convertToJavaString(string, true).replace("%", "\\%").replace("$", "\\$");
	}

	public static String toAntlrStringIgnoreCase(String string) {
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < string.length() ; i++) {
			final char upperCase = Character.toUpperCase(string.charAt(i));
			final char lowerCase = Character.toLowerCase(string.charAt(i));
			if(upperCase == lowerCase) {
				sb.append("'");
				sb.append(toAntlrString(String.valueOf(upperCase)));
				sb.append("'");
			} else {
				sb.append("('");
				sb.append(toAntlrString(String.valueOf(upperCase)));
				sb.append("'|'");
				sb.append(toAntlrString(String.valueOf(lowerCase)));
				sb.append("')");
			}
		}
		return sb.toString();
	}
	
	public static String getClasspathURI(Grammar grammar, EObject object) {
		String fragment = EcoreUtil.getURI(object).fragment();
		return "classpath:/" + grammar.getName().replace('.', '/') + ".xmi#" + fragment;
	}

}
