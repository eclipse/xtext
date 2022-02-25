/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.tokens;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;

import com.google.inject.ImplementedBy;

@ImplementedBy(EnumLiteralSerializer.class)
public interface IEnumLiteralSerializer {
	//	boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, INode node);

	boolean isValid(EObject context, RuleCall ruleCall, Object value, ISerializationDiagnostic.Acceptor errorAcceptor);

	String serializeAssignedEnumLiteral(EObject context, RuleCall ruleCall, Object value, INode node,
			ISerializationDiagnostic.Acceptor errorAcceptor);
}
