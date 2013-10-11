/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.jdt.annotation.NonNullByDefault;
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
@NonNullByDefault
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
