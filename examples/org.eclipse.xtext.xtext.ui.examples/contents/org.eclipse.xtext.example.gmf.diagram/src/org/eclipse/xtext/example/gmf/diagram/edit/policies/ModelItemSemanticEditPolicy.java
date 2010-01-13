package org.eclipse.xtext.example.gmf.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.xtext.example.gmf.diagram.edit.commands.EntityCreateCommand;
import org.eclipse.xtext.example.gmf.diagram.edit.commands.SimpleTypeCreateCommand;
import org.eclipse.xtext.example.gmf.diagram.providers.EntitiesElementTypes;

/**
 * @generated
 */
public class ModelItemSemanticEditPolicy extends
		EntitiesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ModelItemSemanticEditPolicy() {
		super(EntitiesElementTypes.Model_79);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EntitiesElementTypes.Entity_1001 == req.getElementType()) {
			return getGEFWrapper(new EntityCreateCommand(req));
		}
		if (EntitiesElementTypes.SimpleType_1002 == req.getElementType()) {
			return getGEFWrapper(new SimpleTypeCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
