/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendOutlineNodeComparator extends SortOutlineContribution.DefaultComparator {
	@Override
	public int getCategory(IOutlineNode node) {
		if (node instanceof XtendEObjectNode)
			return internalGetCategory(node) + 100 * ((XtendEObjectNode) node).getInheritanceDepth();
		else
			return internalGetCategory(node);
	}

	protected int internalGetCategory(IOutlineNode node) {
		if (node instanceof EStructuralFeatureNode) {
			EStructuralFeature feature = ((EStructuralFeatureNode) node).getEStructuralFeature();
			if (feature == XtendPackage.Literals.XTEND_FILE__PACKAGE)
				return 0;
			else
				return 10;
		}
		boolean isStatic = node instanceof XtendFeatureNode && ((XtendEObjectNode) node).isStatic();
		if (node instanceof EObjectNode) {
			EClass eClass = ((EObjectNode) node).getEClass();
			if (XtendPackage.Literals.XTEND_TYPE_DECLARATION.isSuperTypeOf(eClass)
					|| TypesPackage.Literals.JVM_DECLARED_TYPE.isSuperTypeOf(eClass)
					|| TypesPackage.Literals.JVM_ENUMERATION_LITERAL.isSuperTypeOf(eClass))
				return 20;
			if (eClass == XtendPackage.Literals.XTEND_FIELD || eClass == TypesPackage.Literals.JVM_FIELD)
				return isStatic ? 30 : 50;
			if (eClass == XtendPackage.Literals.XTEND_CONSTRUCTOR || eClass == TypesPackage.Literals.JVM_CONSTRUCTOR)
				return 60;
			if (eClass == XtendPackage.Literals.XTEND_FUNCTION || eClass == TypesPackage.Literals.JVM_OPERATION) {
				if (isStatic)
					return 40;
				else
					return (node instanceof XtendFeatureNode && ((XtendFeatureNode) node).isDispatch()) ? 70 : 80;
			}
		}
		return Integer.MAX_VALUE;
	}
}
