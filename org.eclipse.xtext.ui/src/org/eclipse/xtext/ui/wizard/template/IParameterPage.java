/*******************************************************************************
 * Copyright (c) 2018, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.core.runtime.IStatus;

/**
 * Interface to avoid passing concrete implementation of parameter page to {@link TemplateVariable}.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public interface IParameterPage {

	/**
	 * Callback to update the parameter page after a variable has changed.
	 */
	void setStatus(IStatus status);

}
