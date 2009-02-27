package org.eclipse.xtext.example;

import org.eclipse.emf.mwe.core.WorkflowFacade;

/**
 * Run this class in order to generate the domain model grammar.
 */
public class  GenerateEcoreDsl {

	public static void main(String... args) {
		new WorkflowFacade("org/eclipse/xtext/example/generateEcoreDsl.mwe").run();
	}

}

