/*******************************************************************************
 * Copyright (c) 2009-2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * The implementation ensures that the classToExtend, interfacesToImplement
 * (when this type represent a Java class) and interfacesToExtend (when this
 * type represent a Java interface) are kept consistent with the superTypes.
 * 
 * In particular, if the class to extend is set (respectively, unset) the
 * superTypes will contain it (respectively, will not contain it). Similarly,
 * for interfaces to implement and interfaces to extend. If a type is added to
 * superTypes directly, the class to extend and the interfaces to implement will
 * not be touched. If a type is removed from superTypes, if it corresponds to a
 * class to extend or interface to implement, the classToExtend or the
 * interfacesToImplement/Extend will be updated accordingly.
 * 
 * Note that superTypes is a container list, while interfacesToImplement is not.
 *
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Lorenzo Bettini - classToExtend, interfacesToImplement,
 * interfacesToExtend
 */
public class JvmGenericTypeImplCustom extends JvmGenericTypeImpl {

	private List<JvmTypeReference> superTypesSnapshot = Collections.emptyList();
	private List<JvmTypeReference> interfacesToImplementSnapshot = Collections.emptyList();
	private List<JvmTypeReference> interfacesToExtendSnapshot = Collections.emptyList();

	@Override
	public boolean isInstantiateable() {
		return !isAbstract() && !isInterface();
	}

	// late initialization

	@Override
	public EList<JvmTypeParameter> getTypeParameters() {
		checkPendingInitialization();
		return super.getTypeParameters();
	}

	@Override
	public boolean isStrictFloatingPoint() {
		checkPendingInitialization();
		return super.isStrictFloatingPoint();
	}

	@Override
	public boolean isAnonymous() {
		checkPendingInitialization();
		return super.isAnonymous();
	}

	@Override
	public void setClassToExtend(JvmTypeReference newClassToExtend) {
		checkPendingInitialization();
		JvmTypeReference oldClassToExtend = classToExtend;
		super.setClassToExtend(newClassToExtend);
		super.getSuperTypes().remove(oldClassToExtend);
		if (newClassToExtend != null) {
			getSuperTypes().add(newClassToExtend);
		}
	}

	@Override
	public JvmTypeReference getClassToExtend() {
		checkPendingInitialization();
		if (!super.getSuperTypes().contains(classToExtend)) {
			// some one else removed it via superTypes API
			super.setClassToExtend(null);
		}
		return super.getClassToExtend();
	}

	@Override
	public EList<JvmTypeReference> getSuperTypes() {
		checkPendingInitialization();
		var origSuperTypes = super.getSuperTypes();

		var origInterfacesToImplement = super.getInterfacesToImplement();
		if (!origInterfacesToImplement.equals(interfacesToImplementSnapshot)) {
			// remove elements contained in the snapshot
			origSuperTypes.removeAll(interfacesToImplementSnapshot);
			// add all interfaces to implement
			origSuperTypes.addAll(origInterfacesToImplement);
			// update snapshot
			interfacesToImplementSnapshot =
				createSnapshot(origInterfacesToImplement);
		}

		var origInterfacesToExtend = super.getInterfacesToExtend();
		if (!origInterfacesToExtend.equals(interfacesToExtendSnapshot)) {
			// remove elements contained in the snapshot
			origSuperTypes.removeAll(interfacesToExtendSnapshot);
			// add all interfaces to extend
			origSuperTypes.addAll(origInterfacesToExtend);
			// update snapshot
			interfacesToExtendSnapshot =
				createSnapshot(origInterfacesToExtend);
		}
		return origSuperTypes;
	}

	@Override
	public EList<JvmTypeReference> getInterfacesToImplement() {
		checkPendingInitialization();
		var origInterfacesToImplement = super.getInterfacesToImplement();
		var origSuperTypes = super.getSuperTypes();
		if (!superTypesSnapshot.equals(origSuperTypes)) {
			// remove interfaces that are not in superTypes
			// if they're not there, they have been removed through superTypes
			origInterfacesToImplement.removeIf(e -> !origSuperTypes.contains(e));
			// update snapshot
			superTypesSnapshot =
				createSnapshot(origSuperTypes);
		}
		return origInterfacesToImplement;
	}

	@Override
	public EList<JvmTypeReference> getInterfacesToExtend() {
		checkPendingInitialization();
		var origInterfacesToExtend = super.getInterfacesToExtend();
		var origSuperTypes = super.getSuperTypes();
		if (!superTypesSnapshot.equals(origSuperTypes)) {
			// remove interfaces that are not in superTypes
			// if they're not there, they have been removed through superTypes
			origInterfacesToExtend.removeIf(e -> !origSuperTypes.contains(e));
			// update snapshot
			superTypesSnapshot =
				createSnapshot(origSuperTypes);
		}
		return origInterfacesToExtend;
	}

	private List<JvmTypeReference> createSnapshot(EList<JvmTypeReference> origList) {
		return new ArrayList<>(origList);
	}
}
