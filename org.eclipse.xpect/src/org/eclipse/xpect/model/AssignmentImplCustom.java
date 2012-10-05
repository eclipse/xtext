package org.eclipse.xpect.model;

import org.eclipse.xpect.AbstractComponent;
import org.eclipse.xpect.Component;
import org.eclipse.xpect.Value;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.resource.XtextResource;

@SuppressWarnings("restriction")
public class AssignmentImplCustom extends AssignmentImpl {
	@Override
	public AbstractComponent getInstance() {
		return (AbstractComponent) eContainer();
	}

	@Override
	public JvmOperation getTarget() {
		JvmOperation result = getDeclaredTarget();
		if (result != null)
			return result;
		Value val = getValue();
		if (val instanceof Component) {
			JvmDeclaredType toBeAssigned = ((Component) val).getComponentClass();
			JvmDeclaredType containerType = getInstance().getComponentClass();
			if (toBeAssigned != null && !toBeAssigned.eIsProxy() && containerType != null && !containerType.eIsProxy()) {
				for (JvmMember candidate : containerType.getAllFeatures())
					if ("add".equals(candidate.getSimpleName()) && candidate instanceof JvmOperation) {
						JvmOperation op = (JvmOperation) candidate;
						if (op.getParameters().size() == 1) {
							JvmTypeReference parameterType = op.getParameters().get(0).getParameterType();
							if (isTypeAssignable(parameterType, toBeAssigned))
								return op;
						}
					}
			}
		}
		return null;
	}

	private boolean isTypeAssignable(JvmTypeReference left, JvmType right) {
		TypeConformanceComputer tcc = ((XtextResource) eResource()).getResourceServiceProvider().get(TypeConformanceComputer.class);
		JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		reference.setType(right);
		return tcc.isConformant(left, reference, true);
	}
}
