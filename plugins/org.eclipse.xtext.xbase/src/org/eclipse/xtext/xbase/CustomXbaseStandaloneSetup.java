package org.eclipse.xtext.xbase;

import org.eclipse.xtext.xpression.XpressionPackage;
import org.eclipse.xtext.xtype.XtypePackage;

public class CustomXbaseStandaloneSetup extends XbaseStandaloneSetup {
	{
		XtypePackage.eINSTANCE.getName();
		XpressionPackage.eINSTANCE.getName();
		XbasePackage.eINSTANCE.getName();
	}
}
