/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.nodemodel.detachable;

import org.eclipse.xtext.nodemodel.detachable.DetachableNodeModelBuilder;
import org.eclipse.xtext.nodemodel.detachable.DetachableParseResultWrapper;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.parser.impl.PartialParsingHelper;
import org.eclipse.xtext.resource.ParseResultWrapper;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

/**
 * @since 2.35
 */
public class DetachableNodeModelFragment extends AbstractXtextGeneratorFragment {

	@Override
	public void generate() {
		new GuiceModuleAccess.BindingFactory()
			.addTypeToType(TypeReference.typeRef(NodeModelBuilder.class), TypeReference.typeRef(DetachableNodeModelBuilder.class))
			.addTypeToType(TypeReference.typeRef(ParseResultWrapper.class), TypeReference.typeRef(DetachableParseResultWrapper.class))
			.addTypeToType(TypeReference.typeRef(PartialParsingHelper.class), null)
			.contributeTo(getLanguage().getRuntimeGenModule());
	}

}
