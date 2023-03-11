/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;

import com.google.inject.Inject;

/**
 * @author Robert von Massow - Initial contribution and API
 * @author Holger Schill
 */
public class NewXtendClassWizard extends AbstractNewXtendElementWizard {

	public static final String TITLE = "Xtend Class"; //$NON-NLS-1$

	@Inject
	public NewXtendClassWizard(IImageDescriptorHelper imgHelper, NewXtendClassWizardPage page) {
		super(imgHelper, page, TITLE);
	}
}
