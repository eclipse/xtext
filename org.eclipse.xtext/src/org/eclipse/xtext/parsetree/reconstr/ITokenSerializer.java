/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.CrossReferenceSerializer;
import org.eclipse.xtext.parsetree.reconstr.impl.EnumLiteralSerializer;
import org.eclipse.xtext.parsetree.reconstr.impl.KeywordSerializer;
import org.eclipse.xtext.parsetree.reconstr.impl.ValueSerializer;

import com.google.inject.ImplementedBy;

/**
 * TODO: this interface does not define any methods. It just acts a container for other interfaces.
 * Shouldn't it be replaced by a package?
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ITokenSerializer {

	/**
	 * In the process of serializing a model to a DSL, references to model elements need to be turned into string
	 * representations which identify the targeted model element. Implementations of this interface compute this string
	 * representation.
	 * 
	 * Implementations must be synchronous with the DSL's parser implementation.
	 * 
	 * Implementations might introduce some kind of scoping.
	 */
	@ImplementedBy(CrossReferenceSerializer.class)
	interface ICrossReferenceSerializer extends ITokenSerializer {
		
		boolean isValid(EObject context, CrossReference crossref, EObject target, IErrorAcceptor errorAcceptor);

		boolean equalsOrReplacesNode(EObject context, CrossReference crossref, EObject target, INode node);

		String serializeCrossRef(EObject context, CrossReference crossref, EObject target, INode node);
	}

	@ImplementedBy(EnumLiteralSerializer.class)
	interface IEnumLiteralSerializer extends ITokenSerializer {
		boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, INode node);

		boolean isValid(EObject context, RuleCall ruleCall, Object value, IErrorAcceptor errorAcceptor);

		String serializeAssignedEnumLiteral(EObject context, RuleCall ruleCall, Object value, INode node);
	}

	interface IErrorAcceptor {
		void error(String message);
	}

	@ImplementedBy(KeywordSerializer.class)
	interface IKeywordSerializer extends ITokenSerializer {

		boolean equalsOrReplacesNode(EObject context, Keyword keyword, INode node);

		boolean equalsOrReplacesNode(EObject context, Keyword keyword, Object value, INode node);
		
		boolean isValid(EObject context, Keyword keyword, Object value, IErrorAcceptor errorAcceptor);

		String serializeAssignedKeyword(EObject context, Keyword keyword, Object value, INode node);

		String serializeUnassignedKeyword(EObject context, Keyword keyword, INode node);
	}

	@ImplementedBy(ValueSerializer.class)
	interface IValueSerializer extends ITokenSerializer {

		boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, INode node);

		boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, INode node);

		boolean isValid(EObject context, RuleCall ruleCall, Object value, IErrorAcceptor errorAcceptor);

		String serializeAssignedValue(EObject context, RuleCall ruleCall, Object value, INode node);

		String serializeUnassignedValue(EObject context, RuleCall ruleCall, INode node);
	}

	final static String KEEP_VALUE_FROM_NODE_MODEL = "<KEEP_VALUE_FROM_NODE_MODEL>";
}
