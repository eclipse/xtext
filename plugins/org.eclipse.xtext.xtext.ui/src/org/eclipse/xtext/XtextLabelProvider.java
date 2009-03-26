/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.xtext.ui.core.DefaultLabelProvider;

/**
 * @author Sebastian Zarnekow
 */
public class XtextLabelProvider extends DefaultLabelProvider {

	String image(Grammar grammar) {
		return "language.gif";
	}
	
	String image(GeneratedMetamodel metamodel) {
		return "export.gif";
	}
	
	String image(ReferencedMetamodel metamodel) {
		return "import.gif";
	}
	
	String image(AbstractRule rule) {
		return "rule.gif";
	}
	
	String image(RuleCall ruleCall) {
		return "rule.gif";
	}
	
	String image(Keyword keyword) {
		return "keyword.gif";
	}
}
