/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.serializer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.inject.Inject;

public class XtypeSemanticSequencer extends AbstractXtypeSemanticSequencer {
	
	@Inject
	private XtypeGrammarAccess grammarAccess;
	
	@Override
	protected void sequence_XFunctionTypeRef(EObject context, XFunctionTypeRef functionTypeRef) {
		INodesForEObjectProvider nodes = createNodeProvider(functionTypeRef);
		SequenceFeeder acceptor = createSequencerFeeder(functionTypeRef, nodes);
		EList<JvmTypeReference> paramTypes = functionTypeRef.getParamTypes();
		if (!paramTypes.isEmpty()) {
			acceptor.accept(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0(), paramTypes.get(0), 0);
			for (int i = 1; i < paramTypes.size(); i++) {
				acceptor.accept(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0(), paramTypes.get(i), i);
			}
		}
		acceptor.accept(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0(), functionTypeRef.getReturnType());
		acceptor.finish();
	}
	
}
