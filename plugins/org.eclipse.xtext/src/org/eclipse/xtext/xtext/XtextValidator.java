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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextValidator extends AbstractDeclarativeValidator {

	public XtextValidator() {
		EValidator.Registry.INSTANCE.put(XtextPackage.eINSTANCE, this);
	}

	@Check(CheckType.NORMAL)
	public void grammarUsesMaxOneOther(Grammar grammar) {
		assertTrue("You may not use more than two other grammars.", XtextPackage.GRAMMAR__USED_GRAMMARS,
				grammar.getUsedGrammars().size() <= 1);
	}

}
