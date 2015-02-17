package org.eclipse.xtext.parser.bug419429.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429Language;

public class Bug419429PomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public Bug419429PomDeclarationSearcher() {
		super(Bug419429Language.INSTANCE);
	}

}
