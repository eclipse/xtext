/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;

/**
 * A Grammar can instruct the parser to consume text without storing the text in
 * the semantic model. If this text can have more than one valid value according
 * to the Grammar, the serializer needs to be instructed which value to take.
 * 
 * Example:
 * 
 * PluralRule: 'contents:' count=INT Plural;
 * 
 * terminal Plural: 'item' | 'items';
 * 
 * In this example, the serializer has to know whether to output the keyword
 * 'item' or 'items'.
 * 
 * An implementation of IUnassignedTextSerializer can specify which value to
 * serialize for unassigned terminal rule calls and for unassigned datatype rule
 * calls. In the above example, the rule PluralRule contains an unassigned
 * terminal rule call to rule Plural.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated
// this has been replaced by org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.IValueSerializer.serializeUnassignedValue(EObject, RuleCall, AbstractNode)
public interface IUnassignedTextSerializer {

	/**
	 * This method determines which value has to be written while the
	 * serialization process for unassigned terminal rule calls and for
	 * unassigned datatype rule calls.
	 * 
	 * @param ruleCall
	 *            The rule call which is to be serialized
	 * @param current
	 *            The EObject which is currently being serialized. The type of
	 *            this EObject is at minimum the return type of the rule in
	 *            which the ruleCall is nested.
	 * @return The String which should be serialized for the rule call. It must
	 *         be a valid value for the called rule.
	 */
	public String serializeUnassignedRuleCall(RuleCall ruleCall, EObject current);
}
