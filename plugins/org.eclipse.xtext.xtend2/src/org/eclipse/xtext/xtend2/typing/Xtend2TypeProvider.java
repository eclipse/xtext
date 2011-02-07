package org.eclipse.xtext.xtend2.typing;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typing.TypesService;
import org.eclipse.xtext.xbase.typing.XExpressionTypeProvider;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

public class Xtend2TypeProvider extends XExpressionTypeProvider {
	
	@Inject
	private TypesService typeService;
	
	protected JvmTypeReference _expectedType(XtendFunction function, EReference reference, int index) {
		if (reference==Xtend2Package.Literals.XTEND_FUNCTION__EXPRESSION) {
			if (function.getReturnType()==null || typeService.isPrimitiveVoid(function.getReturnType()))
				return null;
			return function.getReturnType();
		}
		return null;
	}
	
	protected JvmTypeReference _type(RichString richString, boolean selfContained) {
		return getTypesService().getTypeForName(StringConcatenation.class, richString);
	}
	
	protected JvmTypeReference _type(RichStringLiteral stringLiteral, boolean selfContained) {
		return getTypesService().getTypeForName(String.class, stringLiteral);
	}
	
}
