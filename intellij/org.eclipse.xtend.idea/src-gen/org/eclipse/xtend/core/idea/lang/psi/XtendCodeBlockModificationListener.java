/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.lang.psi;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;

public class XtendCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public XtendCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(XtendLanguage.INSTANCE, psiModificationTracker);
	}
	protected boolean hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {
		return true;
	}

}
