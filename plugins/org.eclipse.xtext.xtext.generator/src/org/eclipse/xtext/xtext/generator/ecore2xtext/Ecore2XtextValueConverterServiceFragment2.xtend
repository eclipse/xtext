/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ecore2xtext

import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment

/**
 * Contributes the registration of the {@link Ecore2XtextTerminalConverters}.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
class Ecore2XtextValueConverterServiceFragment2 extends AbstractXtextGeneratorFragment {
	
	override generate() {
		new GuiceModuleAccess.BindingFactory()
			.addTypeToType(IValueConverterService.typeRef(), Ecore2XtextTerminalConverters.typeRef())
			.contributeTo(language.runtimeGenModule)
	}
}