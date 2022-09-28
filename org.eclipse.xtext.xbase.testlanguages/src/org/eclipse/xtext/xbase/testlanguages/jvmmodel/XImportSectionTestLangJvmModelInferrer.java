/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.ImportSectionTestLanguageRoot;

import com.google.inject.Inject;

/**
 * <p>
 * Infers a JVM model from the source model.
 * </p>
 * 
 * <p>
 * The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model. Other models link against the JVM
 * model rather than the source model.
 * </p>
 */
public class XImportSectionTestLangJvmModelInferrer extends AbstractModelInferrer {
	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	protected void _infer(ImportSectionTestLanguageRoot element, IJvmDeclaredTypeAcceptor acceptor,
			boolean isPreIndexingPhase) {
		String simpleName = element.eResource().getURI().trimFileExtension().lastSegment();
		acceptor.accept(jvmTypesBuilder.toClass(element, "my.test." + simpleName), c -> {
			c.getMembers().add(jvmTypesBuilder.toMethod(element, "hello", _typeReferenceBuilder.typeRef(Void.class),
					o -> jvmTypesBuilder.setBody(o, element.getExpression())));
		});
	}

	public void infer(EObject element, IJvmDeclaredTypeAcceptor acceptor,
			boolean isPreIndexingPhase) {
		if (element instanceof ImportSectionTestLanguageRoot) {
			_infer((ImportSectionTestLanguageRoot) element, acceptor, isPreIndexingPhase);
			return;
		}
		super.infer(element, acceptor, isPreIndexingPhase);
	}
}
