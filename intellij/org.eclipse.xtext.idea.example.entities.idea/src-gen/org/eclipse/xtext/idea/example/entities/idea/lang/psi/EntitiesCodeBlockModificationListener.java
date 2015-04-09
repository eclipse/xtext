package org.eclipse.xtext.idea.example.entities.idea.lang.psi;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;

public class EntitiesCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public EntitiesCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(EntitiesLanguage.INSTANCE, psiModificationTracker);
	}

	protected boolean hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {
		return true;
	}

}
