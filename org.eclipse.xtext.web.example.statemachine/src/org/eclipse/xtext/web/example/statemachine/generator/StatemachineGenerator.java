/**
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.example.statemachine.generator;

import java.util.Comparator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.web.example.statemachine.statemachine.InputSignal;
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal;
import org.eclipse.xtext.web.example.statemachine.statemachine.State;
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine;

import com.google.common.base.Joiner;

/**
 * Generates code from your model files on save.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
public class StatemachineGenerator extends AbstractGenerator {
	@Override
	public void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (EObject o : resource.getContents()) {
			if (o instanceof Statemachine) {
				Statemachine statemachine = (Statemachine)o;
				fsa.generateFile("/DEFAULT_ARTIFACT", generateHtml(statemachine));
				fsa.generateFile("/hidden.txt", "This is an additional generator artifact.");
			}
		}
	}

	private CharSequence generateHtml(Statemachine statemachine) {
		return ""
				+ "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n"
				+ "	<meta http-equiv=\"Content-Language\" content=\"en-us\">\n"
				+ "	<title>State Machine Overview</title>\n"
				+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"/style.css\" />\n"
				+ "	<style>\n"
				+ "		.signal {\n"
				+ "			color: #383;\n"
				+ "			font-weight: bold;\n"
				+ "		}\n"
				+ "		.state {\n"
				+ "			color: #338;\n"
				+ "			font-weight: bold;\n"
				+ "		}\n"
				+ "	</style>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<div class=\"text-container\">\n"
				+ "	<h2>Signals</h2>\n"
				+ Joiner.on("\n").join(
						statemachine.getSignals().stream().sorted(Comparator.comparing(Signal::getName)).map(
							signal -> "		<span class=\"signal\">" + signal.getName() + "</span> (" + (signal instanceof InputSignal ? "input" : "output") + ")</br>\n"
						).iterator()
				  )
				+ "	<h2>States</h2>\n"
				+ Joiner.on("\n").join(
						statemachine.getStates().stream().sorted(Comparator.comparing(State::getName)).map(
							state -> "		<span class=\"state\">" + state.getName() + "</span> &ndash; transitions: "+(state.getTransitions().isEmpty() ? "NONE" : Joiner.on(", ").join(state.getTransitions().stream().map(t -> t.getState().getName()).iterator()))+"</br>\n"
						).iterator()
				  )
				+ "</div>\n"
				+ "</body>\n"
				+ "</html>";
	}
}
