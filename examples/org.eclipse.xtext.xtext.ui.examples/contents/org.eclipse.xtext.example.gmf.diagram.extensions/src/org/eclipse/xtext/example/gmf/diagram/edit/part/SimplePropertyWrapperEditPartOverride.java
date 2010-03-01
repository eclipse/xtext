package org.eclipse.xtext.example.gmf.diagram.edit.part;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimplePropertyEditPart;
import org.eclipse.xtext.example.gmf.ui.internal.EntitiesActivator;
import org.eclipse.xtext.gmf.glue.edit.part.AntlrParserWrapper;

public class SimplePropertyWrapperEditPartOverride extends SimplePropertyEditPart {

	protected AntlrParserWrapper antlrParserWrapper;

	public SimplePropertyWrapperEditPartOverride(View view) {
		super(view);
	}

	@Override
	protected void performDirectEdit() {
		super.performDirectEdit();
	}

	@Override
	protected void performDirectEdit(Point eventLocation) {
		super.performDirectEdit(eventLocation);
	}

	@Override
	public IParser getParser() {
		if (antlrParserWrapper == null) {
			antlrParserWrapper = new AntlrParserWrapper("SimpleProperty", super.getParser(), EntitiesActivator
					.getInstance().getInjector("org.eclipse.xtext.example.gmf.Entities"));
		}
		return antlrParserWrapper;
	}

}
