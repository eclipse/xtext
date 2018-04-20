/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import com.google.common.annotations.Beta;

/**
 * Provide the templates to be shown in the new file wizard.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
@Beta
public interface IFileTemplateProvider {

	/**
	 * @return all templates to be shown in the list of the new file wizard.
	 */
	AbstractFileTemplate[] getFileTemplates();
}
