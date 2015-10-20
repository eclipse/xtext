/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	}
	
}