/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
@Deprecated
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
