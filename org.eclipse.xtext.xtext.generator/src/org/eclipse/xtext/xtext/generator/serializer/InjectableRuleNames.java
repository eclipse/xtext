/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.serializer;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.RuleNames;

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
