package org.eclipse.xtext.example.gmf.diagram.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.PrintingPreferencePage;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPrintingPreferencePage extends PrintingPreferencePage {

	/**
	 * @generated
	 */
	public DiagramPrintingPreferencePage() {
		setPreferenceStore(EntitiesDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}
}
