/*******************************************************************************
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.serializer

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.nodemodel.INode

class DomainmodelSyntacticSequencer extends AbstractDomainmodelSyntacticSequencer {

	override protected String getArrayBracketsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node !== null)
			return getTokenText(node);
		return "[]";
	}

}
