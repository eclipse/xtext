package org.eclipse.xtext.core.parser;

import org.eclipse.emf.ecore.EObject;

public interface IParsePostProcessor {

	EObject postProcess(EObject parseResult);
}
