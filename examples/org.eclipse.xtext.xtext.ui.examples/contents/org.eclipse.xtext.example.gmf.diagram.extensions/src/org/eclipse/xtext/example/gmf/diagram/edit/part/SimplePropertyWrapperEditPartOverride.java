package org.eclipse.xtext.example.gmf.diagram.edit.part;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimplePropertyEditPart;
import org.eclipse.xtext.example.gmf.ui.internal.EntitiesActivator;
import org.eclipse.xtext.gmf.glue.edit.part.AntlrParserWrapper;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class SimplePropertyWrapperEditPartOverride extends SimplePropertyEditPart {

	@Inject
	protected AntlrParserWrapper antlrParserWrapper;

	@Inject
	protected IGrammarAccess grammarAccess;
	
	public SimplePropertyWrapperEditPartOverride(View view) {
		super(view);
		getInjector().injectMembers(this);
		antlrParserWrapper.initialize(getParserRule(), super.getParser());
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
		return antlrParserWrapper;
	}

	protected Injector getInjector() {
		return EntitiesActivator
				.getInstance().getInjector("org.eclipse.xtext.example.gmf.Entities");
	}
	
	protected ParserRule getParserRule() {
		AbstractRule rule = GrammarUtil.findRuleForName(grammarAccess.getGrammar(), "SimpleProperty");
		return rule instanceof ParserRule ?  (ParserRule) rule : null;
	}

}
