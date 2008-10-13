/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.callbacks;

import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructorCallback;

public class DefaultParsetreeReconstructorCallback implements IParseTreeConstructorCallback {

	public void actionCall(IInstanceDescription oldCurrent, IInstanceDescription newCurrent, Action action) {
	}

	public void keywordCall(IInstanceDescription current, Keyword call) {
	}

	public void lexerRuleCall(IInstanceDescription current, RuleCall call, Object value) {
	}

	public void objectCreation(IInstanceDescription current) {
	}

	public void parserRuleCallEnd() {
	}

	public void parserRuleCallStart(IInstanceDescription current, RuleCall call) {
	}

	public void crossRefCall(IInstanceDescription current, CrossReference call) {
	}

	public void lexerRuleCall(IInstanceDescription current, RuleCall call) {
	}

	public void beginSerialize(OutputStream output) {
	}

	public void endSerialize() {
	}

	public void crossRefCall(IInstanceDescription current, CrossReference call, EObject value) {
	}
}
