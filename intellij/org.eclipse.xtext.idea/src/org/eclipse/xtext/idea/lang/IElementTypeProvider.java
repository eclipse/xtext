package org.eclipse.xtext.idea.lang;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public interface IElementTypeProvider {

	IFileElementType getFileType();
	
	IGrammarAwareElementType findElementType(EObject grammarElement);

}
