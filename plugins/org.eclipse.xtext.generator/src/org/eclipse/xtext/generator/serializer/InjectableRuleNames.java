/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.RuleNames;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class InjectableRuleNames extends RuleNames {

	@Inject
	public InjectableRuleNames(Grammar grammar) {
		super(grammar, false);
	}
	
}
