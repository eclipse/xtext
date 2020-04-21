/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.exporting;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.SimpleNameProvider;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

public class SimpleNamesFragment2 extends AbstractXtextGeneratorFragment {
	@Override
	public void generate() {
		new GuiceModuleAccess.BindingFactory()
				.addfinalTypeToType(TypeReference.typeRef(IQualifiedNameProvider.class),
						TypeReference.typeRef(SimpleNameProvider.class))
				.contributeTo(getLanguage().getRuntimeGenModule());
		new GuiceModuleAccess.BindingFactory()
				.addTypeToType(TypeReference.typeRef("org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator"),
						TypeReference
								.typeRef("org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator"))
				.contributeTo(getLanguage().getEclipsePluginGenModule());
	}
}
