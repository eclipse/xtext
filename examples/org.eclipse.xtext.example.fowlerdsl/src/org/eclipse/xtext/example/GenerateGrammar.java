package org.eclipse.xtext.example;

import java.io.IOException;

import org.eclipse.emf.mwe.core.WorkflowFacade;

/**
 * Run this class in order to generate the domain model grammar.
 */
public class  GenerateGrammar {

	public static void main(String... args) throws IOException {
		new WorkflowFacade("org/eclipse/xtext/example/runGenerator.mwe").run();
	}

}

