/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.arithmetics.arithmetics.FunctionCall;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;

/**
 * Changes the link text to contain the whole signature of a function.
 *  
 * @author Sven Efftinge - initial contribution and API
 */
public class LinkingService extends DefaultLinkingService {
	
	@Override
	public String getCrossRefNodeAsString(INode node) throws IllegalNodeException {
		String result = super.getCrossRefNodeAsString(node); 
		EObject element = node.getSemanticElement();
		if (element instanceof FunctionCall) {
			FunctionCall fc = (FunctionCall) element;
			if (!fc.getArgs().isEmpty()) {
				result += "(";
				for(int i=0;i<fc.getArgs().size();i++) {
					result+="arg"+(i+1);
					if (i+1<fc.getArgs().size())
						result+=",";
				}
				result += ")";
			}
		}
		return result;
	}
}
