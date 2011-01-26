package org.eclipse.xtext.xtend2.typing;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.typing.TypesService;
import org.eclipse.xtext.xbase.typing.XExpressionTypeProvider;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

public class Xtend2TypeProvider extends XExpressionTypeProvider {
	
	public static final QualifiedName STRING_CONCATENATION_TYPE_NAME;
	
	static {
		IQualifiedNameConverter.DefaultImpl nameConverter = new IQualifiedNameConverter.DefaultImpl();
		STRING_CONCATENATION_TYPE_NAME = nameConverter.toQualifiedName(StringConcatenation.class.getName());
	}
	
	protected JvmTypeReference _type(RichString richString) {
		return getTypesService().getTypeForName(STRING_CONCATENATION_TYPE_NAME, richString);
	}
	
	protected JvmTypeReference _type(RichStringLiteral stringLiteral) {
		return getTypesService().getTypeForName(TypesService.STRING_TYPE_NAME, stringLiteral);
	}
	
	protected JvmTypeReference _type(XtendFunction function) {
		JvmTypeReference returnType = function.getReturnType();
		if (returnType!=null)
			return returnType;
		return getConvertedType(function.getExpression());
	}
	
	@Inject
	private TypesFactory factory;
	
	protected JvmTypeReference _type(XtendClass clazz) {
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		reference.setType(clazz);
		return reference;
	}
}
