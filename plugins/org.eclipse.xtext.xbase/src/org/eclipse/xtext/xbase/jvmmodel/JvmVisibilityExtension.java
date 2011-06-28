/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmVisibility;

/**
 * Workaround to set visibility as long as we cannot deal with enum literals in Xtend.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @deprecated as Xtend supports enum literals now
 */
@Deprecated
public class JvmVisibilityExtension {

	public void makePublic(JvmMember member) {
		member.setVisibility(JvmVisibility.PUBLIC);
	}
	public void makeProtected(JvmMember member) {
		member.setVisibility(JvmVisibility.PROTECTED);
	}
	public void makePrivate(JvmMember member) {
		member.setVisibility(JvmVisibility.PRIVATE);
	}
	public void makePackagePrivte(JvmMember member) {
		member.setVisibility(JvmVisibility.DEFAULT);
	}
}
