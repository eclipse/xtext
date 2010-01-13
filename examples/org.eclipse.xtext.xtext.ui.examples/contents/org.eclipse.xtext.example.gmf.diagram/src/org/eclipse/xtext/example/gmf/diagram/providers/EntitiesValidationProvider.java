package org.eclipse.xtext.example.gmf.diagram.providers;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.ModelEditPart;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesDiagramEditorPlugin;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class EntitiesValidationProvider {

	/**
	 * @generated
	 */
	private static boolean constraintsActive = false;

	/**
	 * @generated
	 */
	public static boolean shouldConstraintsBePrivate() {
		return false;
	}

	/**
	 * @generated
	 */
	public static void runWithConstraints(
			TransactionalEditingDomain editingDomain, Runnable operation) {
		final Runnable op = operation;
		Runnable task = new Runnable() {
			public void run() {
				try {
					constraintsActive = true;
					op.run();
				} finally {
					constraintsActive = false;
				}
			}
		};
		if (editingDomain != null) {
			try {
				editingDomain.runExclusive(task);
			} catch (Exception e) {
				EntitiesDiagramEditorPlugin.getInstance().logError(
						"Validation failed", e); //$NON-NLS-1$
			}
		} else {
			task.run();
		}
	}

	/**
	 * @generated
	 */
	static boolean isInDefaultEditorContext(Object object) {
		if (shouldConstraintsBePrivate() && !constraintsActive) {
			return false;
		}
		if (object instanceof View) {
			return constraintsActive
					&& ModelEditPart.MODEL_ID.equals(EntitiesVisualIDRegistry
							.getModelID((View) object));
		}
		return true;
	}

}
