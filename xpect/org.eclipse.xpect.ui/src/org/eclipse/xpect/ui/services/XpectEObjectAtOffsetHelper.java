package org.eclipse.xpect.ui.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xpect.XjmMethod;
import org.eclipse.xpect.XjmTest;
import org.eclipse.xpect.XpectJavaModel;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;

public class XpectEObjectAtOffsetHelper extends EObjectAtOffsetHelper {

	@Override
	public EObject getCrossReferencedElement(INode node) {
		EObject element = super.getCrossReferencedElement(node);
		if (!element.eIsProxy()) {
			if (element instanceof XjmMethod)
				return ((XjmMethod) element).getJvmMethod();
			if (element instanceof XpectJavaModel) {
				XjmTest testOrSuite = ((XpectJavaModel) element).getTestOrSuite();
				if (testOrSuite != null && !testOrSuite.eIsProxy())
					return testOrSuite.getJvmClass();
			}
		}
		return element;
	}
}
