/*******************************************************************************
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.indentation.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;

public class IndentationAwareTestLanguageSyntacticSequencer extends AbstractIndentationAwareTestLanguageSyntacticSequencer {
	
	/**
	 * Stub implementation for a synthetic terminal rule. Defaults to the empty string.
	 */
	// TODO review the concrete syntax for the terminal
	@Override
	public String getINDENTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	/**
	 * Stub implementation for a synthetic terminal rule. Defaults to the empty string.
	 */
	// TODO review the concrete syntax for the terminal
	@Override
	public String getDEDENTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
}
