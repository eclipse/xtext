/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Map;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.util.formallang.Pda;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(ContextPDAProvider.class)
public interface IContextPDAProvider {

	Map<ISerializationContext, Pda<ISerState, RuleCall>> getContextPDAs(Grammar grammar);

}
