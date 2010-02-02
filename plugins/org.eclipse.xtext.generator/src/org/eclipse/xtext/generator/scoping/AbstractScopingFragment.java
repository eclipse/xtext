/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.scoping;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.Naming;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractScopingFragment extends AbstractGeneratorFragment {

	public static String getScopeProviderName(Grammar grammar, Naming naming) {
		return naming.basePackageRuntime(grammar) + ".scoping." + GrammarUtil.getName(grammar) + "ScopeProvider";
	}
	
}
