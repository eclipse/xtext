package org.eclipse.xtext.example.gmf.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.xtext.example.gmf.diagram.providers.EntitiesElementTypes;

/**
 * @generated
 */
public class EntityExtendsItemSemanticEditPolicy extends
		EntitiesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EntityExtendsItemSemanticEditPolicy() {
		super(EntitiesElementTypes.EntityExtends_3002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
