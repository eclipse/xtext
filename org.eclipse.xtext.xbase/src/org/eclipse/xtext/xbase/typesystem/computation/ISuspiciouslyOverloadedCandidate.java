/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.xtext.xbase.validation.IssueCodes;

/**
 * A linking candidate may be overloaded by other candidates
 * from different implicit receivers. In those situations, the
 * applied candidate my implement this interface.
 * 
 * @see IssueCodes#SUSPICIOUSLY_OVERLOADED_FEATURE
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ISuspiciouslyOverloadedCandidate {

	/**
	 * @return the applied candidate.
	 */
	ILinkingCandidate getChosenCandidate();
	
	/**
	 * @return the suspiciously rejected candidate.
	 */
	ILinkingCandidate getRejectedCandidate();
	
}
