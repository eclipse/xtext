package org.eclipse.xtext.example.gmf.diagram.edit.part;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimplePropertyEditPart;
import org.eclipse.xtext.example.gmf.diagram.extensions.Activator;
import org.eclipse.xtext.example.gmf.ui.internal.EntitiesActivator;
import org.eclipse.xtext.gmf.glue.edit.part.PopupXtextEditorHelper;

public class SimplePropertyPopupXtextEditorEditPartOverride extends SimplePropertyEditPart {

	public SimplePropertyPopupXtextEditorEditPartOverride(View view) {
		super(view);
	}

	@Override
	protected void performDirectEdit() {
		openInDiagramXtextEditor();
	}

	@Override
	protected void performDirectEdit(Point eventLocation) {
		openInDiagramXtextEditor();
	}
	
	@Override
	protected void performDirectEditRequest(Request request) {
		final Request theRequest = request;
		try {
			getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					if (isActive() && isEditable()) {
						if ((theRequest instanceof DirectEditRequest)
								&& (getEditText().equals(getLabelText()))) {
							DirectEditRequest editRequest = (DirectEditRequest) theRequest;
							performDirectEdit(editRequest.getLocation());
						} else {
							performDirectEdit();
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void openInDiagramXtextEditor() {
		try {
			new PopupXtextEditorHelper(this, EntitiesActivator.getInstance().getInjector(
					"org.eclipse.xtext.example.gmf.Entities")).showEditor();
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}
	}

}
