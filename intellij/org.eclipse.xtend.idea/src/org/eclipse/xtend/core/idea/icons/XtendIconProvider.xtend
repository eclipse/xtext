/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.icons

import com.intellij.ide.IconProvider
import com.intellij.psi.PsiElement
import org.eclipse.xtend.core.idea.lang.psi.impl.XtendFileImpl

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendIconProvider extends IconProvider {

	override getIcon(PsiElement element, int flags) {
		switch element {
			XtendFileImpl : XtendIcons.Xtend_ICON
		}
	}

}