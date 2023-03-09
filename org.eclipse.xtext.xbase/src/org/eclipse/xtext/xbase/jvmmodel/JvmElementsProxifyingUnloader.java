/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;

import com.google.common.annotations.Beta;

/**
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.7
 */
@Beta
public class JvmElementsProxifyingUnloader implements IReferableElementsUnloader {
	@Override
	public void unloadRoot(EObject root) {
		if (root instanceof JvmMember) {
			unloadRecursively(((JvmIdentifiableElement) root));
		}
	}

	protected void unloadRecursively(JvmIdentifiableElement element) {
		if (element instanceof JvmDeclaredType) {
			for (JvmMember child : ((JvmDeclaredType) element).getMembers()) {
				unloadRecursively(child);
			}
			if (element instanceof JvmGenericType) {
				for (JvmTypeParameter child : ((JvmGenericType) element).getTypeParameters()) {
					unloadRecursively(child);
				}
			}
		} else {
			if (element instanceof JvmExecutable) {
				for (JvmFormalParameter child : ((JvmExecutable) element).getParameters()) {
					unloadRecursively(child);
				}
				for (JvmTypeParameter child : ((JvmExecutable) element).getTypeParameters()) {
					unloadRecursively(child);
				}
			}
		}
		element.eAdapters().clear();
		((InternalEObject) element).eSetProxyURI(EcoreUtil.getURI(element));
	}
}
