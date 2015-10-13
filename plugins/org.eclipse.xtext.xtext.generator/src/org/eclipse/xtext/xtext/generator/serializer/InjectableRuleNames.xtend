/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.serializer

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.RuleNames

/** 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton class InjectableRuleNames extends RuleNames {
	
	@Inject
	new(Grammar grammar) {
		super(grammar, false)
	}
	
}
