/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.ecore2xtext;

import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * Contributes the registration of the {@link Ecore2XtextTerminalConverters}.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
public class Ecore2XtextValueConverterServiceFragment2 extends AbstractXtextGeneratorFragment {
	@Override
	public void generate() {
		new GuiceModuleAccess.BindingFactory()
				.addTypeToType(TypeReference.typeRef(IValueConverterService.class),
						TypeReference.typeRef(Ecore2XtextTerminalConverters.class))
				.contributeTo(getLanguage().getRuntimeGenModule());
	}
}
