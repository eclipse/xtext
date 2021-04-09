/*******************************************************************************
 * Copyright (c) 2017, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.xtext.ui.label.AbstractLabelProvider;

/**
 * Simple label provider used by the new wizards in the template selection page.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public class TemplateLabelProvider extends AbstractLabelProvider {

	@Override
	protected Object doGetText(Object element) {
		if (element instanceof AbstractTemplate)
			return ((AbstractTemplate) element).getLabel();
		return null;
	}

	@Override
	protected Object doGetImage(Object element) {
		if (element instanceof AbstractTemplate)
			return ((AbstractTemplate) element).getIcon();
		return null;
	}

}
