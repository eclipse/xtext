/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
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

