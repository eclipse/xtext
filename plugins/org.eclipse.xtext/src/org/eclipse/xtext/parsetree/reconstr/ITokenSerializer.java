/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse  License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultCrossReferenceSerializer;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultEnumLiteralSerializer;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultKeywordSerializer;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultValueSerializer;

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
	@ImplementedBy(DefaultCrossReferenceSerializer.class)
	interface ICrossReferenceSerializer extends ITokenSerializer {

		boolean equalsOrReplacesNode(EObject context, CrossReference crossref, EObject target, AbstractNode node);

		String serializeCrossRef(EObject context, CrossReference crossref, EObject target, AbstractNode node);
	}

	@ImplementedBy(DefaultEnumLiteralSerializer.class)
	interface IEnumLiteralSerializer extends ITokenSerializer {
		boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, AbstractNode node);

		String serializeAssignedEnumLiteral(EObject context, RuleCall ruleCall, Object value, AbstractNode node);
	}

	interface IErrorAcceptor {
		void error(String message);
	}

	@ImplementedBy(DefaultKeywordSerializer.class)
	interface IKeywordSerializer extends ITokenSerializer {

		boolean equalsOrReplacesNode(EObject context, Keyword keyword, AbstractNode node);

		boolean equalsOrReplacesNode(EObject context, Keyword keyword, Object value, AbstractNode node);

		String serializeAssignedKeyword(EObject context, Keyword keyword, Object value, AbstractNode node);

		String serializeUnassignedKeyword(EObject context, Keyword keyword, AbstractNode node);
	}

	@ImplementedBy(DefaultValueSerializer.class)
	interface IValueSerializer extends ITokenSerializer {

		boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, AbstractNode node);

		boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, AbstractNode node);

		boolean isValid(EObject context, RuleCall ruleCall, Object value, IErrorAcceptor errorAcceptor);

		String serializeAssignedValue(EObject context, RuleCall ruleCall, Object value, AbstractNode node);

		String serializeUnassignedValue(EObject context, RuleCall ruleCall, AbstractNode node);
	}

	// TODO: does an empty string really communicate what's going on? Consider debugging...
	final static String KEEP_VALUE_FROM_NODE_MODEL = new String();
}
