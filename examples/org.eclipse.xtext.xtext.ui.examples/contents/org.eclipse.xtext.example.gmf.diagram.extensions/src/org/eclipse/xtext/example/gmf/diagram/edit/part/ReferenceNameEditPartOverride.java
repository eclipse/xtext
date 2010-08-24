package org.eclipse.xtext.example.gmf.diagram.edit.part;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.ReferenceNameEditPart;

public class ReferenceNameEditPartOverride extends ReferenceNameEditPart {

	public ReferenceNameEditPartOverride(View view) {
		super(view);
	}

	/**
	 * Avoid some NPEs with detached EditParts
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if(getParent() == null)
			return null;
		return super.getAdapter(key);
	}
}
