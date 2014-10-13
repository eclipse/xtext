package org.eclipse.xtext.psi;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.lazy.ICrossReferenceDescription;

import com.intellij.openapi.util.Key;

public interface PsiReferenceEObject extends PsiEObject {

	Key<Integer> XTEXT_INDEX_KEY = new Key<Integer>("XTEXT_ECONTEXT_KEY");

	Key<EObject> XTEXT_ECONTEXT_KEY = new Key<EObject>("XTEXT_ECONTEXT_KEY");
	
	Integer getIndex();

	EObject getEContext();

	ICrossReferenceDescription getCrossReferenceDescription();

}
