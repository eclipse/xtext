/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.xtend.impl;

import java.util.List;

import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.impl.XtendImportImpl;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtendImportImplCustom extends XtendImportImpl {

	@Override
	public boolean isWildcard() {
		if (isStatic()) // static imports only work with wildcards atm
			return true;
		if (importedNamespace == null)
			return false;
		return importedNamespace.endsWith("*");
	}

	@Override
	public String getImportedTypeName() {
		String result = getImportedNamespace();
		if (result == null) {
			if (this.eIsSet(XtendPackage.Literals.XTEND_IMPORT__IMPORTED_TYPE)) {
				JvmType unresolvedType = (JvmType) this.eGet(XtendPackage.Literals.XTEND_IMPORT__IMPORTED_TYPE, false);
				if(!unresolvedType.eIsProxy())
					return unresolvedType.getIdentifier();
				List<INode> list = NodeModelUtils.findNodesForFeature(this,
						XtendPackage.Literals.XTEND_IMPORT__IMPORTED_TYPE);
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
