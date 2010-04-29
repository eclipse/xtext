/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui;

import org.eclipse.xtext.validation.CheckType;


/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public final class MarkerTypes {
	public final static String ANY_VALIDATION = "org.eclipse.xtext.ui.check";
	public final static String FAST_VALIDATION = "org.eclipse.xtext.ui.check.fast";
	public final static String NORMAL_VALIDATION = "org.eclipse.xtext.ui.check.normal";
	public final static String EXPENSIVE_VALIDATION = "org.eclipse.xtext.ui.check.expensive";
	
	public static String forCheckType(CheckType checkType) {
		switch(checkType) {
			case FAST: return FAST_VALIDATION;
			case NORMAL: return NORMAL_VALIDATION;
			case EXPENSIVE: return EXPENSIVE_VALIDATION;
			default: return ANY_VALIDATION;
		}
	}
}
