/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;


/**
 * TODO Javadoc
 */
public interface IGrammarAccess {

	/**
     * TODO can we use generics instead of inheritance?
     */
	public interface IAbstractRuleAccess {
		public AbstractRule getRule();
	}

	public interface IParserRuleAccess extends IAbstractRuleAccess {
		public ParserRule getRule();
	}
	
	public interface IEnumRuleAccess extends IAbstractRuleAccess {
		public EnumRule getRule();
	}

	public Grammar getGrammar();

}
