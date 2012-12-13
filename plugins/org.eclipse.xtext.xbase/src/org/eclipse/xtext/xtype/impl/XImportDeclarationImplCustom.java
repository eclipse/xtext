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
		return isStatic(); // static imports only work with wildcards atm
	}

	@Override
	public String getImportedTypeName() {
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

}
