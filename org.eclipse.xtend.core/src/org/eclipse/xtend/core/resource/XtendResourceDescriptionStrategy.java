/*******************************************************************************
 * Copyrighst (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.DispatchHelper;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionStrategy;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class XtendResourceDescriptionStrategy extends XbaseResourceDescriptionStrategy {

	public static final String ACTIVE_ANNOTATION_TIMESTAMP = "ACTIVE_ANNOTATION_TIMESTAMP";

	@Inject
	private DispatchHelper dispatchHelper;

	@Inject
	private DescriptionFlags descriptionFlags;
	
	@Override
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		boolean isJvmType = (eObject instanceof JvmType);
		if (isJvmType)
			super.createEObjectDescriptions(eObject, acceptor);
		return isJvmType;
	}
	
	@Override
	public boolean createReferenceDescriptions(EObject from, URI exportedContainerURI,
			IAcceptor<IReferenceDescription> acceptor) {
		return false;
	}
	
	@Override
	protected void createUserData(EObject eObject, ImmutableMap.Builder<String, String> userData) {
		super.createUserData(eObject, userData);
		
		if (eObject instanceof JvmOperation)
			addFlags(getFlags((JvmOperation) eObject), userData);
		else if (eObject instanceof JvmField)
			addFlags(getFlags((JvmField) eObject), userData);
		else if (eObject instanceof XtendFunction) 
			addFlags(getFlags((XtendFunction) eObject), userData);
		else if (eObject instanceof XtendField) 
			addFlags(getFlags((XtendField) eObject), userData);
		else if (eObject instanceof JvmAnnotationType && isActiveAnnotation((JvmAnnotationType) eObject))
			userData.put(ACTIVE_ANNOTATION_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
	}

	protected void addFlags(int flags, ImmutableMap.Builder<String, String> userData) {
		if(flags != 0)
			userData.put(DescriptionFlags.KEY, Integer.toString(flags));
	}

	protected int getFlags(JvmOperation operation) {
		int flags = 0;
		if (dispatchHelper.isDispatcherFunction(operation))
			flags = descriptionFlags.setDispatcherOperation(flags);
		if (operation.isStatic())
			flags = descriptionFlags.setStatic(flags);
		return flags;
	}

	protected int getFlags(JvmField field) {
		return (field.isStatic()) ? descriptionFlags.setStatic(0) : 0;
	}

	protected int getFlags(XtendField field) {
		return (field.isStatic()) ? descriptionFlags.setStatic(0) : 0;
	}
	
	protected int getFlags(XtendFunction function) {
		return (function.isStatic()) ? descriptionFlags.setStatic(0) : 0;
	}
	
	protected boolean isActiveAnnotation(JvmAnnotationType annotationType) {
		for (JvmAnnotationReference anno : annotationType.getAnnotations()) {
			JvmAnnotationType annotation = anno.getAnnotation();
			if (annotation != null && !annotation.eIsProxy()) {
				if ("org.eclipse.xtend.lib.macro.Active".equals(annotation.getIdentifier())) {
					return true;
				}
			}
		}
		return false;
	}
}
