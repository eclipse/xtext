package org.eclipse.xtext.example.gmf.diagram.edit.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.EntitiesEditPartFactory;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.ModelEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimplePropertyEditPart;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesVisualIDRegistry;

public class EntitiesEditPartFactoryOverride extends EntitiesEditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (EntitiesVisualIDRegistry.getVisualID(view)) {

			case ModelEditPart.VISUAL_ID:
				return new ModelEditPartOverride(view);
			case SimplePropertyEditPart.VISUAL_ID:
				return new SimplePropertyPopupXtextEditorEditPartOverride(view);
				// return new SimplePropertyWrapperEditPartOverride(view);
			}
		}
		return super.createEditPart(context, model);
	}
}
