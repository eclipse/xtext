/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.scoping.IScope;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(TokenDiagnosticProvider.class)
public interface ITokenDiagnosticProvider {

	String 	INVALID_ENUM_VALUE = "invalid enum value", 
			NO_EOBJECT_DESCRIPTION_FOUND = "no eobject description found", 
			NO_SCOPE_FOUND = "no scope found", 
			NULL_NOT_ALLOWED = "null not allowed", 
			VALUE_CONVERSION_EXCEPTION = "value conversion exception";
	
	ISerializationDiagnostic getInvalidEnumValueDiagnostic(EObject semanticObject, RuleCall rc, Object value);

	ISerializationDiagnostic getNoEObjectDescriptionFoundDiagnostic(EObject semanticObject, CrossReference element,
			EObject target, IScope scope);

	ISerializationDiagnostic getNoScopeFoundDiagnostic(EObject semanticObject, CrossReference element, EObject target);

	ISerializationDiagnostic getNullNotAllowedDiagnostic(EObject semanticObject, AbstractElement ele);
	
	ISerializationDiagnostic getValueConversionExceptionDiagnostic(EObject semanticObject, AbstractElement element,
			Object value, Throwable exception);
}
