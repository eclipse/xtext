package org.eclipse.xtext.example.gmf.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.xtext.example.gmf.diagram.edit.commands.SimplePropertyCreateCommand;
import org.eclipse.xtext.example.gmf.diagram.providers.EntitiesElementTypes;

/**
 * @generated
 */
public class EntitySimpleNameCompartmentItemSemanticEditPolicy extends
		EntitiesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public EntitySimpleNameCompartmentItemSemanticEditPolicy() {
		super(EntitiesElementTypes.Entity_1001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EntitiesElementTypes.SimpleProperty_2001 == req.getElementType()) {
			return getGEFWrapper(new SimplePropertyCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
