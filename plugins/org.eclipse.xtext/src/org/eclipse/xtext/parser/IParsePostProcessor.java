package org.eclipse.xtext.parser;

import org.eclipse.emf.ecore.EObject;

public interface IParsePostProcessor {

	EObject postProcess(EObject parseResult);
}
