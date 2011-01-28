/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.validation;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringElseIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@ComposedChecks(validators= {ClasspathBasedChecks.class})
public class Xtend2JavaValidator extends XbaseJavaValidator {

	public static final String CLASS_EXPECTED = Xtend2JavaValidator.class.getName() + ".class_expected";
	public static final String INTERFACE_EXPECTED = Xtend2JavaValidator.class.getName() + ".interface_expected";
	
	@Inject
	private RichStringProcessor richStringProcessor;

	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(Xtend2Package.eINSTANCE, XbasePackage.eINSTANCE);
	}

	@Check
	public void checkWhitespaceInRichStrings(RichString richString) {
		// don't check the indentation of nested rich strings in 
		// IF and FOR individually
		if (richString.eContainer() instanceof RichStringIf) {
			RichStringIf container = (RichStringIf) richString.eContainer();
			if (container.getThen() == richString || container.getElse() == richString)
				return;
		}
		if (richString.eContainer() instanceof RichStringElseIf) {
			RichStringElseIf container = (RichStringElseIf) richString.eContainer();
			if (container.getThen() == richString)
				return;
		}
		if (richString.eContainer() instanceof RichStringForLoop) {
			RichStringForLoop container = (RichStringForLoop) richString.eContainer();
			if (container.getEachExpression() == richString)
				return;
		}
		doCheckWhitespaceIn(richString);
	}

	protected void doCheckWhitespaceIn(RichString richString) {
		ValidatingRichStringAcceptor helper = new ValidatingRichStringAcceptor(this);
		richStringProcessor.process(richString, helper, helper);
	}
	
	@Check 
	public void checkSuperTypes(XtendClass xtendClass) {
		JvmTypeReference superClass = xtendClass.getExtends();
		if(superClass != null && superClass.getType() != null) {
			if(!(superClass.getType() instanceof JvmGenericType) || ((JvmGenericType)superClass.getType()).isInterface()) {
				error("Superclass must be a class", Xtend2Package.Literals.XTEND_CLASS__EXTENDS, CLASS_EXPECTED);
			}
		}
		for(int i=0; i<xtendClass.getImplements().size(); ++i) {
			JvmTypeReference implementedType =  xtendClass.getImplements().get(i);
			if(!(implementedType.getType() instanceof JvmGenericType) || !((JvmGenericType)implementedType.getType()).isInterface()) {
				error("Implemented interface must be an interface", Xtend2Package.Literals.XTEND_CLASS__IMPLEMENTS, i, INTERFACE_EXPECTED);
			}
		}
	}
}
