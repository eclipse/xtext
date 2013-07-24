package org.eclipse.xtext.xbase.typesystem.references

import org.eclipse.xtext.xbase.compiler.ISourceAppender
import java.util.List

class LightweightTypeReferenceSerializer extends TypeReferenceVisitor {
	
	ISourceAppender appender
	
	new(ISourceAppender appender) {
		this.appender = appender
	}
	
	override protected doVisitAnyTypeReference(AnyTypeReference reference) {
		reference.toJavaType.accept(this)
	}
	
	override protected doVisitArrayTypeReference(ArrayTypeReference reference) {
		reference.componentType.accept(this)
		appender.append('[]')
	}
	
	override protected doVisitCompoundTypeReference(CompoundTypeReference reference) {
		reference.toJavaType.accept(this)
	}
	
	override protected doVisitFunctionTypeReference(FunctionTypeReference reference) {
		if(appender.isJava) {
			reference.doVisitParameterizedTypeReference
		} else {
			appender.append('(')
			appendCommaSeparated(reference.parameterTypes)
			appender.append(')=>')
			if(reference.returnType == null) 
				appender.append('void')
			else
				reference.returnType.accept(this)			
		}
	}

	override protected doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
		appender.append(reference.type)
		if(!reference.typeArguments.empty) {
			appender.append('<')
			appendCommaSeparated(reference.typeArguments)			
			appender.append('>')			
		}
	}
	
	override protected doVisitUnboundTypeReference(UnboundTypeReference reference) {
		reference.toJavaType.accept(this)
	}
	
	override protected doVisitUnknownTypeReference(UnknownTypeReference reference) {
		appender.append(reference.simpleName) 
	}
	
	override protected doVisitWildcardTypeReference(WildcardTypeReference reference) {
		appender.append('?')
		if(reference.lowerBound != null) {
			appender.append(" super ")
			reference.lowerBound.accept(this)			
		} else {
			val relevantUpperBounds = reference.upperBounds.filter["java.lang.Object" != identifier]
			if (!relevantUpperBounds.empty) {
				appender.append(" extends ")
				var isFirst = true 
				for(upperBound: relevantUpperBounds) {
					if(!isFirst)
						appender.append(" & ")
					isFirst = false
					upperBound.accept(this)						
				}
			}
		}
	}
	
	def protected appendCommaSeparated(List<LightweightTypeReference> references) {
		var isFirst = true 
		for(reference: references) {
			if(!isFirst)
				appender.append(", ")
			isFirst = false
			reference.accept(this)						
		}
	}
}

