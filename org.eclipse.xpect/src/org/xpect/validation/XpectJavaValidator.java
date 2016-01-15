/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.validation;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.validation.Check;
import org.xpect.Component;
import org.xpect.XpectConstants;
import org.xpect.XpectPackage;
import org.xpect.XpectTest;
import org.xpect.registry.ILanguageInfo;
import org.xpect.setup.XpectSetupComponent;
import org.xpect.util.JvmAnnotationUtil;
import org.xpect.util.URIDelegationHandler;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XpectJavaValidator extends AbstractXpectJavaValidator {

	@Inject
	private URIDelegationHandler uriDelegationHandler;

	@Inject
	private TypeReferences typeReferences;

	@Override
	protected List<EPackage> getEPackages() {
		return Collections.<EPackage> singletonList(XpectPackage.eINSTANCE);
	}

	@Check
	public void validateLanguageModulesAreOnClasspath(XpectTest test) {
		String extension = uriDelegationHandler.getOriginalFileExtension(test.eResource().getURI().lastSegment());
		if (extension == null || XpectConstants.XPECT_FILE_EXT.equals(extension))
			return;
		ILanguageInfo languageInfo = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(extension);
		validateClassIsOnClasspath(languageInfo.getRuntimeModuleClass(), test);
		if (EcorePlugin.IS_ECLIPSE_RUNNING)
			validateClassIsOnClasspath(languageInfo.getUIModuleClass(), test);
	}

	protected void validateClassIsOnClasspath(Class<?> cls, Notifier ctx) {
		if (typeReferences.findDeclaredType(cls, ctx) == null) {
			error("The class " + cls.getName() + " is not on the classpath", XpectPackage.Literals.XPECT_TEST__DECLARED_SUITE);
		}
	}

	@Check
	public void checkComponent(Component component) {
		JvmDeclaredType type = component.getComponentClass();
		if (type == null || type.eIsProxy())
			return;
		XpectSetupComponent annotation = JvmAnnotationUtil.getJavaAnnotation(type, XpectSetupComponent.class);
		if (annotation == null) {
			String message = "The class " + type.getQualifiedName() + " must be annotated with @" + XpectSetupComponent.class.getSimpleName();
			warning(message, XpectPackage.Literals.COMPONENT__COMPONENT_CLASS);
		}
	}

}
