/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtype.impl;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XImportDeclarationImplCustom extends XImportDeclarationImpl {

	@Override
	public boolean isWildcard() {
		if (isStatic()) 
			return super.isWildcard();
		if (importedNamespace == null)
			return false;
		return importedNamespace.endsWith("*");
	}
	
	@Override
	public String getImportedName() {
		String memberName = getMemberName();
		String importedTypeName = getImportedTypeName();
		if (memberName == null) {
			return importedTypeName;
		}
		if (importedTypeName == null) {
			return memberName;
		}
		return importedTypeName + '.' + memberName;
	}

	@Override
	public String getImportedTypeName() {
		String result = getImportedNamespace();
		if (result == null) {
			if (this.eIsSet(XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE)) {
				JvmType unresolvedType = (JvmType) this.eGet(XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, false);
				if(!unresolvedType.eIsProxy())
					return unresolvedType.getIdentifier();
				List<INode> list = NodeModelUtils.findNodesForFeature(this,
						XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE);
				StringBuilder sb = new StringBuilder();
				for (INode iNode : list) {
					sb.append(NodeModelUtils.getTokenText(iNode).replace("^", ""));
				}
				return sb.toString().replace(" ", "");
			}
			return null;
		}
		if (isWildcard()) {
			if (result.length() > 2)
				return result.substring(0, result.length() - 2);
			return null;
		}
		return result;
	}
}
