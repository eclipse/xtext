/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.Grammar;
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
	public void grammarUsesMaxOneOther(Grammar grammar) {
		assertTrue("You may not use more than two other grammars.", XtextPackage.GRAMMAR__USED_GRAMMARS,
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

}
