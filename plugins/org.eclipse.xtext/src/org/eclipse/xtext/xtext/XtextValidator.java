/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.TreeSet;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.validator.AbstractDeclarativeValidator;
import org.eclipse.xtext.validator.Check;
import org.eclipse.xtext.validator.CheckType;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextValidator extends AbstractDeclarativeValidator {

	@Inject
	public XtextValidator(EValidator.Registry registry) {
		registry.put(XtextPackage.eINSTANCE, this);
	}

	@Check(CheckType.NORMAL)
	public void checkGrammarUsesMaxOneOther(Grammar grammar) {
		assertTrue("You may not use more than one other grammar.", XtextPackage.GRAMMAR__USED_GRAMMARS,
				grammar.getUsedGrammars().size() <= 1);
	}

	@Check
	public void checkGrammarName(Grammar g) {
		String[] split = g.getName().split("\\.");
		if (split.length==1)
			warning("You should use a namespace.", XtextPackage.GRAMMAR__NAME);
		for (int i=0;i<split.length-1;i++) {
			String nsEle = split[i];
			if (Character.isUpperCase(nsEle.charAt(0)))
				warning("Namespace elements should start with a lower case letter.", XtextPackage.GRAMMAR__NAME);
		}
		String ele = split[split.length-1];
		if (!Character.isUpperCase(ele.charAt(0)))
			warning("The last element should start with an upper case letter.", XtextPackage.GRAMMAR__NAME);
	}

	@Check
	public void checkGeneratedMetamodel(GeneratedMetamodel metamodel) {
		if (metamodel.getName() != null && metamodel.getName().length() != 0)
			if (Character.isUpperCase(metamodel.getName().charAt(0)))
				warning("Metamodel names should start with a lower case letter.", XtextPackage.GENERATED_METAMODEL__NAME);
	}

	@Check
	public void checkCrossReferenceTerminal(CrossReference reference) {
		if (!(reference.getTerminal() instanceof RuleCall))
			warning("Your grammar will not work with the default linking implementation, " +
					"because Alternatives are currently not handled properly in CrossReferences.",
					XtextPackage.CROSS_REFERENCE__TERMINAL);
	}

	@Check
	public void checkRuleName(AbstractRule rule) {
		final Grammar grammar = GrammarUtil.getGrammar(rule);
		final TreeSet<String> foundNames = new TreeSet<String>();
		for(AbstractRule otherRule: GrammarUtil.allRules(grammar)) {
			if (rule.getName().equalsIgnoreCase(otherRule.getName()) && rule != otherRule) {
				foundNames.add(otherRule.getName());
			}
		}
		if (!foundNames.isEmpty()) {
			final String message = "Rulename has to be unique even case insensitive.";
			if (foundNames.size() == 1)
				error(message + "\nOther rule was: " + foundNames.first(), XtextPackage.ABSTRACT_RULE__NAME);
			else {
				final StringBuilder builder = new StringBuilder((rule.getName().length() + 2) * foundNames.size() - 2);
				for(String name: foundNames) {
					if (builder.length() != 0)
						builder.append(", ");
					builder.append(name);
				}
				error(message + "\nOther rules were: " + builder + ".", XtextPackage.ABSTRACT_RULE__NAME);
			}
		}
	}

}
