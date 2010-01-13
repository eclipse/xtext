package org.eclipse.xtext.example.gmf.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimplePropertyEditPart;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesDiagramUpdater;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesNodeDescriptor;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesVisualIDRegistry;
import org.eclipse.xtext.example.gmf.entities.EntitiesPackage;

/**
 * @generated
 */
public class EntitySimpleNameCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = EntitiesDiagramUpdater
				.getEntitySimpleNameCompartment_5001SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
			result.add(((EntitiesNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = EntitiesVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case SimplePropertyEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(EntitiesPackage.eINSTANCE
					.getEntity_Properties());
		}
		return myFeaturesToSynchronize;
	}

}
