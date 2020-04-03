/*******************************************************************************
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.labeling;

import static org.eclipse.jdt.ui.JavaElementImageDescriptor.*;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.DeprecationUtil;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;

import com.google.inject.Inject;

/**
 * Used for calculating the Image adornments.
 */
public class XbaseImageAdornments {

	@Inject
	private OverrideHelper overrideHelper;

	/**
	 * @return an {@code Integer} value representing the adornment to be rendered for a given {@code identifiableElement}
	 */
	public int get(JvmIdentifiableElement identifiableElement) {
		if (identifiableElement instanceof JvmConstructor) {
			return _get((JvmConstructor) identifiableElement);
		} else if (identifiableElement instanceof JvmOperation) {
			return _get((JvmOperation) identifiableElement);
		} else if (identifiableElement instanceof JvmField) {
			return _get((JvmField) identifiableElement);
		} else if (identifiableElement instanceof JvmDeclaredType) {
			return _get((JvmDeclaredType) identifiableElement);
		} else if (identifiableElement != null) {
			return _get(identifiableElement);
		} else {
			return _get((Void) null);
		}
	}

	protected int _get(JvmDeclaredType jvmDeclaredType) {
		int abstract0 = or(0, jvmDeclaredType.isAbstract(), ABSTRACT);
		int final0 = or(abstract0, jvmDeclaredType.isFinal(), FINAL);
		int static0 = or(final0, jvmDeclaredType.isStatic(), STATIC);
		return or(static0, DeprecationUtil.isDeprecatedMember(jvmDeclaredType), DEPRECATED);
	}

	protected int _get(JvmField jvmField) {
		int final0 = or(0, jvmField.isFinal(), FINAL);
		int static0 = or(final0, jvmField.isStatic(), STATIC);
		int deprecated0 = or(static0, DeprecationUtil.isDeprecatedMember(jvmField), DEPRECATED);
		int volatile0 = or(deprecated0, jvmField.isVolatile(), VOLATILE);
		return or(volatile0, jvmField.isTransient(), TRANSIENT);
	}

	protected int _get(JvmConstructor jvmConstructor) {
		return or(CONSTRUCTOR, DeprecationUtil.isDeprecatedMember(jvmConstructor), DEPRECATED);
	}

	protected int _get(JvmOperation jvmOperation) {
		int abstract0 = or(0, jvmOperation.isAbstract(), ABSTRACT);
		int final0 = or(abstract0, jvmOperation.isFinal(), FINAL);
		int synchronized0 = or(final0, jvmOperation.isSynchronized(), SYNCHRONIZED);
		int static0 = or(synchronized0, jvmOperation.isStatic(), STATIC);
		int deprecated0 = or(static0, DeprecationUtil.isDeprecatedMember(jvmOperation), DEPRECATED);
		int adornment = or(deprecated0, jvmOperation.isNative(), 0x4000);// JavaElementImageDescription.NATIVE not available before 3.7

		Resource resource = jvmOperation.eResource();
		if (resource != null && resource.getResourceSet() != null) {
			JvmOperation overriddenOperation = overrideHelper.findOverriddenOperation(jvmOperation);
			if (overriddenOperation != null) {
				return (adornment | getOverrideAdornment(overriddenOperation));
			}
		}
		return adornment;
	}

	protected int _get(Void it) {
		return 0;
	}

	public int getOverrideAdornment(JvmExecutable overriddenOperation) {
		if (overriddenOperation instanceof JvmOperation) {
			return ((JvmOperation) overriddenOperation).isAbstract() ? IMPLEMENTS : OVERRIDES;
		} else {
			return 0;
		}
	}

	protected int _get(JvmIdentifiableElement identifiableElement) {
		return 0;
	}

	protected int or(int adornment, boolean condition, int oredValue) {
		return condition ? (adornment | oredValue) : adornment;
	}

}
