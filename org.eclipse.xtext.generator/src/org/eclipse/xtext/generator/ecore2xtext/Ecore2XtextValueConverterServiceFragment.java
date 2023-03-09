/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.ecore2xtext;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class Ecore2XtextValueConverterServiceFragment extends DefaultGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory().addTypeToType(IValueConverterService.class.getName(), Ecore2XtextTerminalConverters.class.getName()).getBindings();
	}


}
