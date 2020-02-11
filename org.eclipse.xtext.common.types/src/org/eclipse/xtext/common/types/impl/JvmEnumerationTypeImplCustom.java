/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.DelegatingEcoreEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.TypesPackage;

public class JvmEnumerationTypeImplCustom extends JvmEnumerationTypeImpl {
	@Override
	public EList<JvmEnumerationLiteral> getLiterals() {
		checkPendingInitialization();
		if (literals == null) {
			@SuppressWarnings("serial")
			EObjectResolvingEList<JvmEnumerationLiteral> list = new EObjectResolvingEList<JvmEnumerationLiteral>(
					JvmEnumerationLiteral.class, this, TypesPackage.JVM_ENUMERATION_TYPE__LITERALS) {
				@Override
				protected boolean isNotificationRequired() {
					return false;
				}
			};
			for (JvmMember member : getMembers()) {
				if (member instanceof JvmEnumerationLiteral)
					list.add((JvmEnumerationLiteral) member);
			}
			literals = new DelegatingEcoreEList.UnmodifiableEList<JvmEnumerationLiteral>(this, TypesPackage.Literals.JVM_ENUMERATION_TYPE__LITERALS, list);
		}
		return literals;
	}

	@Override
	public EList<JvmMember> getMembers() {
		checkPendingInitialization();
		if (members == null) {
			members = new EObjectContainmentWithInverseEList<JvmMember>(JvmMember.class, this,
					TypesPackage.JVM_DECLARED_TYPE__MEMBERS, TypesPackage.JVM_MEMBER__DECLARING_TYPE) {
				private static final long serialVersionUID = 1L;

				@Override
				protected void didChange() {
					literals = null;
					super.didChange();
				}
			};
		}
		return members;
	}

	@Override
	public boolean isFinal() {
		return true;
	}
	
	@Override
	public void setFinal(boolean newFinal) {
		if (!newFinal)
			throw new UnsupportedOperationException("Enums are always final.");
	}
	
}
