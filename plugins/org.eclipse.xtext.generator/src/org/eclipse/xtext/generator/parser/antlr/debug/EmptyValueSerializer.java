/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.debug;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.generator.parser.antlr.debug.services.SimpleAntlrGrammarAccess;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.ValueSerializer;

import com.google.inject.Inject;

/**
 * @author Sebastian zarnekow - Initial contribution and API
 */
public class EmptyValueSerializer extends ValueSerializer {

	@Inject private SimpleAntlrGrammarAccess grammarAccess;
	
	@Override
	protected String serializeUnassignedValueByRule(AbstractRule rule, EObject current, INode node) {
		if (rule == grammarAccess.getOPENRule()) {
			return "(";
		}
		return super.serializeUnassignedValueByRule(rule, current, node);
	}
	
}
