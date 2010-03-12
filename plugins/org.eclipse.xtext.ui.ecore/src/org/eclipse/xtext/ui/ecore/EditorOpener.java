package org.eclipse.xtext.ui.ecore;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener;

public class EditorOpener extends LanguageSpecificURIEditorOpener {
	
	@Override
	protected void selectAndReveal(IEditorPart openEditor, URI uri,
			EReference crossReference, int indexInList, boolean select) {
		EcoreEditor ecoreEditor = (EcoreEditor) openEditor.getAdapter(EcoreEditor.class);
		if (ecoreEditor != null) {
			EObject eObject = ecoreEditor.getEditingDomain().getResourceSet().getEObject(uri, true);
			ecoreEditor.setSelectionToViewer(Collections.singletonList(eObject));
		}
	}

}
