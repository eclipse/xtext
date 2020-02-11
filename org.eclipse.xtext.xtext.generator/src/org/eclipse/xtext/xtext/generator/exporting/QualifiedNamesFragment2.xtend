/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.exporting

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment

class QualifiedNamesFragment2 extends AbstractXtextGeneratorFragment {
	
	override generate() {
		new GuiceModuleAccess.BindingFactory()
			.addTypeToType(IQualifiedNameProvider.typeRef, DefaultDeclarativeQualifiedNameProvider.typeRef)
			.contributeTo(language.runtimeGenModule)
		
		new GuiceModuleAccess.BindingFactory()
			.addTypeToType('org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher'.typeRef,
					'org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher'.typeRef)
			.addTypeToType('org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator'.typeRef,
					'org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator'.typeRef)
			.contributeTo(language.eclipsePluginGenModule)
		
		new GuiceModuleAccess.BindingFactory()
			.addTypeToType('org.eclipse.xtext.ide.editor.contentassist.IPrefixMatcher'.typeRef,
					'org.eclipse.xtext.ide.editor.contentassist.FQNPrefixMatcher'.typeRef)
			.contributeTo(language.ideGenModule)
	}
	
}
