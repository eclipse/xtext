/*******************************************************************************
 * Copyright (c) 2018, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

/**
 * Provide the templates to be shown in the new file wizard.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public interface IFileTemplateProvider {

	/**
	 * @return all templates to be shown in the list of the new file wizard.
	 */
	AbstractFileTemplate[] getFileTemplates();
}
