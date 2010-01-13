package org.eclipse.xtext.example.gmf.diagram.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramConnectionsPreferencePage extends ConnectionsPreferencePage {

	/**
	 * @generated
	 */
	public DiagramConnectionsPreferencePage() {
		setPreferenceStore(EntitiesDiagramEditorPlugin.getInstance()
				.getPreferenceStore());
	}
}
