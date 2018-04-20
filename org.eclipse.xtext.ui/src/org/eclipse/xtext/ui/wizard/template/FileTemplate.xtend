/*******************************************************************************
 * Copyright (c) 2017, 2018 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template

import com.google.common.annotations.Beta
import java.lang.annotation.Retention
import java.lang.annotation.Target
import org.eclipse.xtend.lib.macro.Active

/**
 * Annotation to define a file templates that is used in the new file wizard and declared in a language specific
 * FileTemplateProvider.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
@Target(TYPE)
@Retention(RUNTIME)
@Active(FileTemplateProcessor)
@Beta
annotation FileTemplate {
	/**
	 * Label of the file template presented to the user in the list of templates. The label is written to a file
	 * "messages.properties" and read from there at runtime. This way it is possible to internationalize using i18n.
	 */
	String label
	/**
	 * Path to the icon of the file template presented to the user in the list of templates. Currently not used in the
	 * UI.
	 */
	String icon
	/**
	 * Description of the file template presented to the user in a a text field in the new file wizard when hovering
	 * over the combo box of available templates. If only one template is available used as text for the wizard page.
	 * 
	 * The description is written to a file "messages.properties" and read from there at runtime. This way it is
	 * possible to internationalize using i18n.
	 */
	String description
}
