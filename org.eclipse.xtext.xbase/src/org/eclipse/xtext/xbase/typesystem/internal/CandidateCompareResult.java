/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

/**
 * The result of the comparison of two linking candidates. 
 */
public enum CandidateCompareResult {
	/**
	 * Indicates that the current candidate is a better match than the other one.
	 */
	THIS,
	/**
	 * Indicates that the current candidate is worse than the other one.
	 */
	OTHER,
	/**
	 * Indicates that the current candidate is worse than the other one due
	 * to less specific parameter types, but the other one is on a different
	 * implicit receiver than this one.
	 * 
	 * This result may only be returned when the expected argument types are compared.
	 */
	SUSPICIOUS_OTHER,
	/**
	 * Indicates that both candidates are equally valid. The situation may be ambiguous.
	 */
	AMBIGUOUS,
	/**
	 * Indicates that both candidates are equally invalid. Pick the first one.
	 */
	EQUALLY_INVALID
}
