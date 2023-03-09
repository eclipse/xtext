/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class SimpleExpressionsRuntimeModule extends org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AbstractSimpleExpressionsRuntimeModule {

	@Override
	public Class<? extends ISerializer> bindISerializer() {
		return Serializer.class;
	}
	
	public Class<? extends ISemanticNodeProvider> bindNodeProvider() {
		return NullProvider.class;
	}
	
	static class NullProvider implements ISemanticNodeProvider {

		@Override
		public INodesForEObjectProvider getNodesForSemanticObject(EObject semanticObject,
				ICompositeNode suggestedComposite) {
			return ISemanticNodeProvider.NULL_NODES_PROVIDER;
		}
		
	}
}
