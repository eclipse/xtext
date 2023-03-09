/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal.util;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XVariableDeclaration;

/**
 * Allows to retrieve a human readable representation of the various
 * possible linking targets.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This method is not intended to be referenced by clients.
 */
public class FeatureKinds {
	public static String getTypeName(JvmIdentifiableElement feature) {
		if (feature instanceof JvmFormalParameter) {
			return "parameter";
		}
		if (feature instanceof XVariableDeclaration) {
			return "local variable";
		}
		if (feature instanceof JvmEnumerationLiteral) {
			return "enum literal";
		}
		if (feature instanceof JvmField) {
			return "field";
		}
		if (feature instanceof JvmOperation) {
			return "method";
		}
		if (feature instanceof JvmConstructor) {
			return "constructor";
		}
		if (feature instanceof JvmType) {
			return "type";
		}
		throw new IllegalStateException();
	}
}
