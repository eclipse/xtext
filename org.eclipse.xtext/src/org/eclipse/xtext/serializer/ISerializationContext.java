/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.9
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ISerializationContext extends Comparable<ISerializationContext> {

	Action getAssignedAction();

	Set<Parameter> getEnabledBooleanParameters();

	ParserRule getParserRule();

	EClass getType();

}
