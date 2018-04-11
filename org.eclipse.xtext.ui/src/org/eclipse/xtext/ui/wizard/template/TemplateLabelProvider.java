/*******************************************************************************
 * Copyright (c) 2017, 2018 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.xtext.ui.label.AbstractLabelProvider;

import com.google.common.annotations.Beta;

/**
 * Simple label provider used by the new wizards in the template selection page.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
@Beta
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
