/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class XbaseQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof JvmIdentifiableElement)
			return getFullyQualifiedName((JvmIdentifiableElement) obj);
		return super.getFullyQualifiedName(obj);
	}

	protected QualifiedName getFullyQualifiedName(JvmIdentifiableElement obj) {
		if (obj instanceof JvmType || obj instanceof JvmMember) {
			final String qualifiedName = obj.getQualifiedName();
			if (qualifiedName == null)
				return null;
			return getConverter().toQualifiedName(qualifiedName);
		}
		return null;
	}
}

