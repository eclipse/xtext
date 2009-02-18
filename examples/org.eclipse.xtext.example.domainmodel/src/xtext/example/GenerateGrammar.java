package xtext.example;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.mwe.core.WorkflowFacade;

/**
 * Run this class in order to generate the domain model grammar.
 */
public class GenerateGrammar {

	public static void main(String... args) throws IOException {
		new WorkflowFacade("xtext/example/runGenerator.mwe", Collections.singletonMap("runtimeProject",
				getProject(args))).run();
	}

	private static String getProject(String[] args) {
		if (args != null && args.length == 1)
			return args[0];
		return ".";
	}

}
