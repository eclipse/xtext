/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IContext extends Comparable<IContext> {

	EObject getActionOrRule();

	Action getAssignedAction();

	Set<Parameter> getParameterValues();

	IContext getParent();

	ParserRule getParserRule();

	EClass getType();

}
