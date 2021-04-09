/**
 * Copyright (c) 2017, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.wizard.template;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.xtend.lib.macro.Active;

/**
 * Annotation to define a file templates that is used in the new file wizard and declared in a language specific FileTemplateProvider.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Active(FileTemplateProcessor.class)
public @interface FileTemplate {
	/**
	 * Label of the file template presented to the user in the list of templates. The label is written to a file "messages.properties" and
	 * read from there at runtime. This way it is possible to internationalize using i18n.
	 */
	public String label();

	/**
	 * Path to the icon of the file template presented to the user in the list of templates. Currently not used in the UI.
	 */
	public String icon();

	/**
	 * Description of the file template presented to the user in a text field in the new file wizard when hovering over the combo box of
	 * available templates. If only one template is available used as text for the wizard page.
	 * 
	 * The description is written to a file "messages.properties" and read from there at runtime. This way it is possible to
	 * internationalize using i18n.
	 */
	public String description();
}
