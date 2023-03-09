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
import org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot;

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
public class ContentAssistFragmentTestLangJvmModelInferrer extends AbstractModelInferrer {
	/**
	 * convenience API to build and initialize JVM types and their members.
	 */
	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	/**
	 * The dispatch method {@code infer} is called for each instance of the given
	 * element's type that is contained in a resource.
	 * 
	 * @param element            the model to create one or more
	 *                           {@link org.eclipse.xtext.common.types.JvmDeclaredType
	 *                           declared types} from.
	 * @param acceptor           each created
	 *                           {@link org.eclipse.xtext.common.types.JvmDeclaredType
	 *                           type} without a container should be passed to the
	 *                           acceptor in order get attached to the current
	 *                           resource. The acceptor's
	 *                           {@link IJvmDeclaredTypeAcceptor#accept(org.eclipse.xtext.common.types.JvmDeclaredType)
	 *                           accept(..)} method takes the constructed empty type
	 *                           for the pre-indexing phase. This one is further
	 *                           initialized in the indexing phase using the closure
	 *                           you pass to the returned
	 *                           {@link org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing#initializeLater(org.eclipse.xtext.xbase.lib.Procedures.Procedure1)
	 *                           initializeLater(..)}.
	 * @param isPreIndexingPhase whether the method is called in a pre-indexing
	 *                           phase, i.e. when the global index is not yet fully
	 *                           updated. You must not rely on linking using the
	 *                           index if isPreIndexingPhase is <code>true</code>.
	 */
	protected void _infer(ContentAssistFragmentTestLanguageRoot element, IJvmDeclaredTypeAcceptor acceptor,
			boolean isPreIndexingPhase) {
		String simpleName = element.eResource().getURI().trimFileExtension().lastSegment();
		acceptor.accept(jvmTypesBuilder.toClass(element, "my.test." + simpleName), c -> {
			c.getMembers().add(jvmTypesBuilder.toMethod(element, "hello", _typeReferenceBuilder.typeRef(Void.class),
					o -> jvmTypesBuilder.setBody(o, element.getExpression())));
		});
	}

	public void infer(EObject element, IJvmDeclaredTypeAcceptor acceptor,
			boolean isPreIndexingPhase) {
		if (element instanceof ContentAssistFragmentTestLanguageRoot) {
			_infer((ContentAssistFragmentTestLanguageRoot) element, acceptor, isPreIndexingPhase);
			return;
		}
		super.infer(element, acceptor, isPreIndexingPhase);
	}
}
