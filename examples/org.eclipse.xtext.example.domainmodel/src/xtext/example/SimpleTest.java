package xtext.example;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.example.DomainmodelStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;

/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class SimpleTest extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new DomainmodelStandaloneSetup());
	}
	
	public void testSimple() throws Exception {
		EObject model = getModel("entity Foo {}");
		Diagnostic validate = Diagnostician.INSTANCE.validate(model);
		System.out.println(validate);
	}
}
