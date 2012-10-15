/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import java.util.List;

import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;

/**
 * Interpreter for Xbase that does only use the new type system APIs.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseInterpreter2 extends XbaseInterpreter {
	@Override
	protected List<XExpression> getActualArguments(XAbstractFeatureCall featureCall) {
		return featureCall.getActualArguments();
	}

	@Override
	protected XExpression getActualReceiver(XAbstractFeatureCall featureCall) {
		return featureCall.getActualReceiver();
	}
}