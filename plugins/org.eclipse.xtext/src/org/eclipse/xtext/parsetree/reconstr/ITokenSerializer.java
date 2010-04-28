/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
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
 * @author meysholdt - Initial contribution and API
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
	public interface ICrossReferenceSerializer extends ITokenSerializer {

		public boolean equalsOrReplacesNode(EObject context, CrossReference crossref, EObject target, AbstractNode node);

		public String serializeCrossRef(EObject context, CrossReference crossref, EObject target, AbstractNode node);
	}

	@ImplementedBy(DefaultEnumLiteralSerializer.class)
	public interface IEnumLiteralSerializer extends ITokenSerializer {
		public boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, AbstractNode node);

		public String serializeAssignedEnumLiteral(EObject context, RuleCall ruleCall, Object value, AbstractNode node);
	}

	public interface IErrorAcceptor {
		public void error(String message);
	}

	@ImplementedBy(DefaultKeywordSerializer.class)
	public interface IKeywordSerializer extends ITokenSerializer {

		public boolean equalsOrReplacesNode(EObject context, Keyword keyword, AbstractNode node);

		public boolean equalsOrReplacesNode(EObject context, Keyword keyword, Object value, AbstractNode node);

		public String serializeAssignedKeyword(EObject context, Keyword keyword, Object value, AbstractNode node);

		public String serializeUnassignedKeyword(EObject context, Keyword keyword, AbstractNode node);
	}

	@ImplementedBy(DefaultValueSerializer.class)
	public interface IValueSerializer extends ITokenSerializer {

		public boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, AbstractNode node);

		public boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, AbstractNode node);

//		public boolean isValid(EObject context, RuleCall ruleCall, Object value, IErrorAcceptor errorAcceptor);

		public String serializeAssignedValue(EObject context, RuleCall ruleCall, Object value, AbstractNode node);

		public String serializeUnassignedValue(EObject context, RuleCall ruleCall, AbstractNode node);
	}

	public final static String KEEP_VALUE_FROM_NODE_MODEL = new String();
}
