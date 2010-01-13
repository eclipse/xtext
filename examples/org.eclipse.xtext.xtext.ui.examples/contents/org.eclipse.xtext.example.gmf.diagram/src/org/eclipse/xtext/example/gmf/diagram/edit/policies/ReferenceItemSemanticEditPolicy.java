package org.eclipse.xtext.example.gmf.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.xtext.example.gmf.diagram.providers.EntitiesElementTypes;

/**
 * @generated
 */
public class ReferenceItemSemanticEditPolicy extends
		EntitiesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ReferenceItemSemanticEditPolicy() {
		super(EntitiesElementTypes.Reference_3001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
