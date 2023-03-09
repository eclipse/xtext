/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.xbase;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.UsedRulesFinder;
import org.eclipse.xtext.xtext.generator.util.GrammarUtil2;

public class XbaseUsageDetector {
	public boolean inheritsXtype(Grammar grammar) {
		return GrammarUtil2.inherits(grammar, "org.eclipse.xtext.xbase.Xtype");
	}

	public boolean inheritsXbase(Grammar grammar) {
		return GrammarUtil2.inherits(grammar, "org.eclipse.xtext.xbase.Xbase");
	}

	public boolean inheritsXbaseWithAnnotations(Grammar grammar) {
		return GrammarUtil2.inherits(grammar, "org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations");
	}

	public boolean usesXImportSection(Grammar grammar) {
		Set<AbstractRule> usedRules = new HashSet<>();
		new UsedRulesFinder(usedRules).compute(grammar);
		for (AbstractRule it : usedRules) {
			if ("XImportSection".equals(it.getName())
					&& EcoreUtil2.isAssignableFrom((EClass) it.eResource().getResourceSet().getEObject(URI.createURI("http://www.eclipse.org/xtext/xbase/Xtype#//XImportSection"), true), (EClass) it.getType().getClassifier())) {
				return true;
			}
		}
		return false;
	}
}
