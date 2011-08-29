/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.featurecalls;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendField;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Xtend2IdentifiableSimpleNameProvider extends IdentifiableSimpleNameProvider {

	@Override
	public String getSimpleName(JvmIdentifiableElement element) {
		if (element instanceof XtendClass) {
			return "this";
		} else if (element instanceof XtendFunction) {
			return ((XtendFunction) element).getName();
		} else if (element instanceof XtendField) {
			XtendField field = (XtendField) element;
			if (field.getName() != null) {
				return field.getName();
			}
			// TODO override in UI context where a IJavaProject is available
			// and use JdtVariabpleCompletions
			JvmTypeReference type = field.getType();
			if (type != null) {
				while(type instanceof JvmGenericArrayTypeReference) {
					type = ((JvmGenericArrayTypeReference) type).getComponentType();
				}
				if (type instanceof JvmParameterizedTypeReference) {
					List<INode> nodes = NodeModelUtils.findNodesForFeature(type, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
					if (!nodes.isEmpty()) {
						String typeName = nodes.get(0).getText().trim();
						int lastDot = typeName.lastIndexOf('.');
						if (lastDot != -1) {
							typeName = typeName.substring(lastDot + 1); 
						}
						XtendClass clazz = (XtendClass) field.eContainer();
						String result = "_" + Strings.toFirstLower(typeName) + clazz.getMembers().indexOf(field);
						return result;
					}
				}
			}
			return null;
		}
		return super.getSimpleName(element);
	}
}
