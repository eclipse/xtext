/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;

/**
 * A closure candidate knows about the assumptions that have been made
 * about a lambda expression regarding the implicitly available parameters.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IClosureCandidate extends IApplicableCandidate {

	/**
	 * Returns the effective list of parameters. This may either be
	 * the declared parameter list or the synthetic parameter list.
	 */
	List<JvmFormalParameter> getParameters();
	
}
