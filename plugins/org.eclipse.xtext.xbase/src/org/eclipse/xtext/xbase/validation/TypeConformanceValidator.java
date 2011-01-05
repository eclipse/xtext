package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.typing.IExpectedTypeProvider;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XbasePackage;

import com.google.inject.Inject;

public class TypeConformanceValidator extends AbstractXbaseJavaValidator {

	public static final String INCOMPATIBLE_TYPES = "xbase.incompatible_types";
	
	@Inject
	private ITypeProvider<JvmTypeReference> typeProvider;
	
	@Inject
	private IExpectedTypeProvider<JvmTypeReference> expectedTypeProvider;
	
	@Inject
	private IJvmTypeConformanceComputer conformanceComputer;
	
	@Check
	public void checkTypes(EObject obj) {
		JvmTypeReference expectedType = expectedTypeProvider.getExpectedType(obj);
		if (expectedType==null)
			return;
		JvmTypeReference actualType = typeProvider.getType(obj);
		if (!conformanceComputer.isConformant(expectedType, actualType)) {
			error("Incompatible types. Expected "+expectedType.getCanonicalName()+" but was "+actualType.getCanonicalName(), -1, INCOMPATIBLE_TYPES);
		}
	}
	
	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(XbasePackage.eINSTANCE, TypesPackage.eINSTANCE);
	}

}
