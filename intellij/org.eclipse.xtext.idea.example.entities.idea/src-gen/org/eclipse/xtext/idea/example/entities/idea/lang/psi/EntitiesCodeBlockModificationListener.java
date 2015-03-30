package org.eclipse.xtext.idea.example.entities.idea.lang.psi;

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.util.PsiModificationTracker;

public class EntitiesCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public EntitiesCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(EntitiesLanguage.INSTANCE, psiModificationTracker);
	}

	protected boolean hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {
		return true;
	}

}
