package org.eclipse.xtend.lib.annotations

import com.google.common.annotations.Beta
import com.google.common.annotations.GwtCompatible
import com.google.common.collect.Sets
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import java.util.List
import java.util.Set
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import java.util.Map

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
@Target(ElementType.FIELD, ElementType.METHOD)
@Active(DelegateProcessor)
annotation Delegate {
	Class<?>[] value = #[]
}

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
class DelegateProcessor implements TransformationParticipant<MutableMemberDeclaration> {

	override doTransform(List<? extends MutableMemberDeclaration> elements, extension TransformationContext context) {
		val extension util = new DelegateProcessor.Util(context)
		elements.forEach [
			if (validDelegate) {
				methodsToImplement.forEach[method|implementMethod(method)]
			}
		]
	}

	/**
	 * @since 2.7
 	*/
 	@Beta
	@GwtCompatible
	static class Util {
		extension TransformationContext context

		new(TransformationContext context) {
			this.context = context
		}
		
		def dispatch isValidDelegate(FieldDeclaration it) {
			hasValidType && !hasDelegationConflicts && areListedInterfacesValid
		}

		def dispatch isValidDelegate(MethodDeclaration it) {
			hasValidType && hasValidSignature && !hasDelegationConflicts && areListedInterfacesValid
		}

		def hasValidType(MemberDeclaration it) {
			if (type.inferred) {
				addError("Cannot use inferred types on delegates")
				false
			} else {
				true
			}
		}
		
		def dispatch getType(FieldDeclaration it) {
			type
		}

		def dispatch getType(MethodDeclaration it) {
			returnType
		}
		
		def hasValidSignature(MethodDeclaration it) {
			switch parameters.map[type].toList {
				case #[],
				case #[string],
				case #[string, Class.newTypeReference.newArrayTypeReference, object.newArrayTypeReference]:
					true
				default: {
					addError("Not a valid delegate signature, use () or (String methodName) or (String methodName, Class<?>[] argumentTypes, Object[] arguments)")
					false
				}
			}
		}

		def hasDelegationConflicts(MemberDeclaration delegate) {
			var conflict = false
			for (other : delegate.otherDelegates) {
				val otherInterfaces = other.delegatedInterfaces
				for (iface : delegate.delegatedInterfaces) {
					if (otherInterfaces.contains(iface)) {
						conflict = true
						delegate.addError('''The interface «iface.simpleName» is also implemented by the delegate «other.simpleName»''')
					}
				}
			}
			conflict
		}
		
		def otherDelegates(MemberDeclaration delegate) {
			delegate.declaringType.delegates.filter[it != delegate]
		}

		def areListedInterfacesValid(MemberDeclaration delegate) {
			val declaringType = delegate.declaringType.newSelfTypeReference
			val interfacesOfDeclaringType = declaringType.implementedInterfaces
			val availableInterfaces = delegate.type.implementedInterfaces
			val listedInterfaces = delegate.listedInterfaces
			var valid = true
			for(iface : listedInterfaces) {
				if (!availableInterfaces.contains(iface)) {
					delegate.addError('''«delegate.type.simpleName» does not implement «iface.simpleName»''')
					valid = false
				}
				if (!interfacesOfDeclaringType.contains(iface)) {
					delegate.addError('''«declaringType.simpleName» does not implement «iface.simpleName»''')
					valid = false
				}
			}
			if (listedInterfaces.empty && Sets.intersection(interfacesOfDeclaringType, availableInterfaces).empty) {
				delegate.addError('''«delegate.type.simpleName» and «declaringType.simpleName» have no interfaces in common''')
				valid = false
			}
			valid
		}

		def getDelegates(TypeDeclaration it) {
			declaredMembers.filter[findAnnotation(findTypeGlobally(Delegate)) !== null]
		}
		
		def listedInterfaces(MemberDeclaration it) {
			findAnnotation(findTypeGlobally(Delegate)).getClassArrayValue("value").toSet
		}

		def Set<? extends TypeReference> getImplementedInterfaces(TypeReference it) {
			(#[it] + declaredSuperTypes.map[implementedInterfaces].flatten).filter[type instanceof InterfaceDeclaration].toSet 
		}

		def getDelegatedInterfaces(MemberDeclaration delegate) {
			val interfacesOfDeclaringType = delegate.declaringType.newSelfTypeReference.implementedInterfaces
			val listedInterfaces = delegate.listedInterfaces
			val availableInterfaces = delegate.type.implementedInterfaces
			availableInterfaces.filter[iface|
				interfacesOfDeclaringType.contains(iface)
				&& (listedInterfaces.empty || listedInterfaces.exists[iface.isAssignableFrom(it)])
			].toSet
		}

		def getMethodsToImplement(MemberDeclaration delegate) {
			delegate.delegatedInterfaces.map[declaredResolvedMethods].flatten
				.filter[delegate.declaringType.findDeclaredMethod(declaration.simpleName, resolvedParameters.map[resolvedType]) == null]
				.filter[!isObjectMethod]
				.toSet
		}
	
		def isObjectMethod(ResolvedMethod it) {
			val name = declaration.simpleName
			val parameterTypes = resolvedParameters.map[resolvedType].toList
			
			name == "hashCode" && parameterTypes.empty
			|| name == "toString" && parameterTypes.empty
			|| name == "equals" && parameterTypes == #[object]
			|| name == "finalize" && parameterTypes.empty
			|| name == "clone" && parameterTypes.empty
		}

		def implementMethod(MutableMemberDeclaration delegate, ResolvedMethod resolvedMethod) {
			delegate.markAsRead
			val declaration = resolvedMethod.declaration
			delegate.declaringType.addMethod(declaration.simpleName) [ impl |
				impl.primarySourceElement = delegate.primarySourceElement
				val typeParameterMappings = newHashMap
				resolvedMethod.resolvedTypeParameters.forEach[param|
					val copy = impl.addTypeParameter(param.declaration.simpleName, param.resolvedUpperBounds)
					typeParameterMappings.put(param.declaration.newTypeReference, copy.newTypeReference)
				]
				impl.exceptions = resolvedMethod.resolvedExceptionTypes.map[replace(typeParameterMappings)]
				impl.varArgs = declaration.varArgs
				impl.returnType = resolvedMethod.resolvedReturnType.replace(typeParameterMappings)
				resolvedMethod.resolvedParameters.forEach[p|impl.addParameter(p.declaration.simpleName, p.resolvedType.replace(typeParameterMappings))]
				impl.body = '''
					«resolvedMethod.returnIfNeeded»«delegate.delegateAccess(declaration)».«declaration.simpleName»(«declaration.parameters.join(", ")[simpleName]»);
				'''
			]
		}
		
		def TypeReference replace(TypeReference target, Map<? extends TypeReference, ? extends TypeReference> mappings) {
			mappings.entrySet.fold(target)[result, mapping|result.replace(mapping.key, mapping.value)]
		}
		
		def TypeReference replace(TypeReference target, TypeReference oldType, TypeReference newType) {
			if (target == oldType) 
				return newType
			if (target.actualTypeArguments.contains(oldType)) {
				return newTypeReference(target.type, target.actualTypeArguments.map[replace(oldType, newType)])
			}
			return target
		}
		
		def dispatch delegateAccess(FieldDeclaration it, MethodDeclaration method) {
			'''this.«simpleName»'''
		}

		def dispatch delegateAccess(MethodDeclaration it, MethodDeclaration method) {
			switch parameters.map[type].toList {
				case #[]: 
					'''this.«simpleName»()'''
				case #[string]: 
					'''this.«simpleName»("«method.simpleName»")'''
				case #[string, Class.newTypeReference.newArrayTypeReference, object.newArrayTypeReference]: {
					'''this.«simpleName»("«method.simpleName»", new Class[]{«method.parameters.join(", ")[type.type.simpleName + ".class"]»}, new Object[]{«method.parameters.join(", ")[simpleName]»})'''
				}
				default:
					throw new IllegalArgumentException("delegate signature")
			}
		}

		def returnIfNeeded(ResolvedMethod it) {
			if(resolvedReturnType.isVoid) "" else "return "
		}
	}

}
