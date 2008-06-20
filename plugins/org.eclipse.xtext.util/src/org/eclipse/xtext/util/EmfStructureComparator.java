/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class EmfStructureComparator {

	private int counter;
	private String errorMessage;
	
	public void assertSameStructure(EObject left, EObject right) {
		if(!isSameStructure(left, right)) {
			Assert.fail(errorMessage);
		}
		//System.out.println("" + counter + " elements compared");
	}
	
	public boolean isSameStructure(EObject left, EObject right) {
		counter = 0;
		return internalIsSameStructure(left, right);
	}
	
	public boolean internalIsSameStructure(EObject left, EObject right) {
		++counter;
		if (!isSameClass(left.eClass(), right.eClass())) {
			errorMessage = "Classes are not equal: " + left + " != " + right;
			return false;
		}
		List<EObject> leftChildren = getRelevantChildren(left);
		List<EObject> rightChildren = getRelevantChildren(right);
		if(leftChildren.size() != rightChildren.size()) {
			errorMessage = "Number of children differs " + left + " " + right;
			return false;
		}
		for (int i = 0; i < leftChildren.size(); ++i) {
			if(!internalIsSameStructure(leftChildren.get(i), rightChildren.get(i))) {
				errorMessage = "Children differ " + left + " " + right;
				return false;
			}
		}

		return true;
	}

	protected boolean isSameClass(EClass left, EClass right) {
		return left.getName().equals(right.getName())
				&& left.getEPackage().getNsURI().equals(right.getEPackage().getNsURI());
	}

	protected List<EObject> getRelevantChildren(EObject _this) {
		List<EObject> relevantChildren = new ArrayList<EObject>(_this.eContents());
		for (Iterator<EObject> i = relevantChildren.iterator(); i.hasNext();) {
			EObject next = i.next();
			if (!isRelevantChild(_this, next)) {
				i.remove();
			}
		}
		return relevantChildren;
	}

	protected boolean isRelevantChild(EObject container, EObject child) {
		return true;
	}

}
