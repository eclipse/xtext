/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseLazyLinker extends LazyLinker {
	
	@Override
	protected void clearReference(EObject obj, EReference ref) {
		super.clearReference(obj, ref);
		if (obj instanceof XAbstractFeatureCall) {
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) obj;
			featureCall.setImplicitReceiver(null);
			featureCall.setInvalidFeatureIssueCode(null);
			featureCall.setImplicitFirstArgument(null);
			if (featureCall instanceof XFeatureCall) {
				XFeatureCall casted = (XFeatureCall) featureCall;
				casted.setTypeLiteral(false);
				casted.setPackageFragment(false);
			} else if (featureCall instanceof XMemberFeatureCall) {
				XMemberFeatureCall casted = (XMemberFeatureCall) featureCall;
				casted.setTypeLiteral(false);
				casted.setPackageFragment(false);
				casted.setStaticWithDeclaringType(false);
			} else if (featureCall instanceof XAssignment) {
				((XAssignment) featureCall).setStaticWithDeclaringType(false);
			}
		} else if (obj instanceof JvmSpecializedTypeReference) {
			((JvmSpecializedTypeReference) obj).setEquivalent(null);
			if (ref == XtypePackage.Literals.XFUNCTION_TYPE_REF__TYPE) {
				obj.eUnset(ref);
			}
		} else if (obj instanceof XClosure) {
			// EMF 2.5 does not dive into derived contained things thus we do it explicitly
			JvmFormalParameter implicitParameter = ((XClosure) obj).getImplicitParameter();
			if (implicitParameter != null)
				implicitParameter.setParameterType(null);
		}
	}

}
