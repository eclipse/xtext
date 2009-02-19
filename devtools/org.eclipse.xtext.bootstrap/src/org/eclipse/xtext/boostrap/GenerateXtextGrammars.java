package org.eclipse.xtext.boostrap;

import java.io.IOException;

import org.eclipse.emf.mwe.core.WorkflowFacade;

/**
 * Run this class in order to generate the domain model grammar.
 */
public class  GenerateXtextGrammars {

	public static void main(String... args) throws IOException {
		try {
			new WorkflowFacade("org/eclipse/xtext/boostrap/generateXtext.mwe").run();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}

