/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

/**
 * This exception can be thrown by a {@link ISubFormatter} to indicate that a conditional formatting attempt failed.
 * Then, the next {@link ISubFormatter} tries to do the formatting.
 * 
 * @see IFormattableDocument#formatConditionally(org.eclipse.emf.ecore.EObject, ISubFormatter...)
 * @see IFormattableDocument#formatConditionally(int, int, ISubFormatter...)
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("serial")
public class FormattingNotApplicableException extends RuntimeException {
}