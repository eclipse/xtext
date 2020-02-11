/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui;

import org.eclipse.xtext.validation.CheckType;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public final class MarkerTypes {
	public final static String ANY_VALIDATION = "org.eclipse.xtext.ui.check"; //$NON-NLS-1$
	public final static String FAST_VALIDATION = "org.eclipse.xtext.ui.check.fast"; //$NON-NLS-1$
	public final static String NORMAL_VALIDATION = "org.eclipse.xtext.ui.check.normal"; //$NON-NLS-1$
	public final static String EXPENSIVE_VALIDATION = "org.eclipse.xtext.ui.check.expensive"; //$NON-NLS-1$
	
	public static String forCheckType(CheckType checkType) {
		switch(checkType) {
			case FAST: return FAST_VALIDATION;
			case NORMAL: return NORMAL_VALIDATION;
			case EXPENSIVE: return EXPENSIVE_VALIDATION;
			default: return ANY_VALIDATION;
		}
	}
	
	public static CheckType toCheckType(String markerType) {
		if (FAST_VALIDATION.equals(markerType))
			return CheckType.FAST;
		if (NORMAL_VALIDATION.equals(markerType))
			return CheckType.NORMAL;
		if (EXPENSIVE_VALIDATION.equals(markerType))
			return CheckType.EXPENSIVE;
		// default
		return CheckType.FAST;
	}
}
