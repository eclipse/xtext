/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
