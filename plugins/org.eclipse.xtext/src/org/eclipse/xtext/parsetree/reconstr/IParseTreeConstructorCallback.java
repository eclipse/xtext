/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.service.ILanguageService;

public interface IParseTreeConstructorCallback extends ILanguageService {

	void parserRuleCallStart(IInstanceDescription current, RuleCall call);

	void parserRuleCallEnd();

	void objectCreation(IInstanceDescription current);

	void lexerRuleCall(IInstanceDescription current, RuleCall call);

	void keywordCall(IInstanceDescription current, Keyword call);

	void actionCall(IInstanceDescription oldCurrent, IInstanceDescription newCurrent, Action action);

	void crossRefCall(IInstanceDescription current, CrossReference call);
}
