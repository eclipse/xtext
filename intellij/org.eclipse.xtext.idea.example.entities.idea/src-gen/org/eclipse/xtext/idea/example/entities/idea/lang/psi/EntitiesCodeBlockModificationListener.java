/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.example.entities.idea.lang.psi;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;

public class EntitiesCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public EntitiesCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(EntitiesLanguage.INSTANCE, psiModificationTracker);
	}
	protected boolean hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {
		return true;
	}

}
