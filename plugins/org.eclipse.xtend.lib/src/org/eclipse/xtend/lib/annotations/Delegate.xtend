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
import java.lang.annotation.Documented

/**
 * Implements interfaces by forwarding method calls to an annotated field or method.
 * 
 * <p>
 * <pre>
 * interface I {
 *  def String m()
 * }
 * class Foo implements I {
 *  override String m() {
 *   "Foo"
 *  }
 * }
 * class Bar implements I {
 *  //This will generate a method m(), which calls foo.m()
 *  &#64;Delegate val foo = new Foo
 * }
 * </pre>
 * 
 * For each interface that the declaring class and the delegate have in common,
 * an implementation for each method is added if it does not yet exist. This
 * implementation forwards all calls directly to the delegate. You can restrict
 * which interfaces to implement using the {@link Class}[] value of this
 * annotation. This is especially useful when there are several delegates that
 * have some interfaces in common.
 * 
 * </p>
 * Delegate methods can either take
 * <ul>
 * <li>no arguments</li>
 * <li>the name of the method to be called (String)</li>
 * <li>the name of the method to be called (String), its parameter types
 * (Class[]) and the actual arguments (Object[]) of the call</li>
 * </ul>
 * This allows you to generate meaningful error messages or to dynamically
 * dispatch based on the arguments.
 * 
 * @since 2.7
 */
@Beta
@GwtCompatible
@Target(ElementType.FIELD, ElementType.METHOD)
@Active(DelegateProcessor)
@Documented
annotation Delegate {
	/**
	 * Optional list of interfaces that this delegate is restricted to.
	 * Defaults to the common interfaces of the context type and the annotated
	 * element.
	 */
	Class<?>[] value = #[]
}

/**
 * @since 2.7
 * @noextend
 * @noreference
 */
@Beta
class DelegateProcessor implements TransformationParticipant<MutableMemberDeclaration> {

	override doTransform(List<? extends MutableMemberDeclaration> elements, extension TransformationContext context) {
		val extension util = new DelegateProcessor.Util(context)
		for (it : elements) {
			if (validDelegate) {
				for (method : methodsToImplement)
					implementMethod(method)
			}
		}
	}

	/**
	 * @since 2.7
	 * @noextend
	 * @noreference
 	*/
 	@Beta
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
			if (type == null || type.inferred) {
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
				case #[string, Class.newTypeReference(newWildcardTypeReference).newArrayTypeReference, object.newArrayTypeReference]:
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
				if (!availableInterfaces.exists[type == iface.type]) {
					delegate.addError('''«delegate.type.simpleName» does not implement «iface.simpleName»''')
					valid = false
				}
				if (!interfacesOfDeclaringType.exists[type == iface.type]) {
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

		def Set<TypeReference> getImplementedInterfaces(TypeReference it) {
			val seen = newLinkedHashSet
			collectAllSuperTypes(seen)
			seen.filter[type instanceof InterfaceDeclaration].toSet
		}
		
		private def void collectAllSuperTypes(TypeReference it, Set<TypeReference> seen) {
			val cycle = !seen.add(it)
			if (cycle)
				return;
			for (it : declaredSuperTypes)
				collectAllSuperTypes(seen)
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
				.groupBy[simpleSignature].values.map[head]
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
				for (param : resolvedMethod.resolvedTypeParameters) {
					val copy = impl.addTypeParameter(param.declaration.simpleName, param.resolvedUpperBounds)
					typeParameterMappings.put(param.declaration.newTypeReference, copy.newTypeReference)
					copy.upperBounds = copy.upperBounds.map[replace(typeParameterMappings)]
				}
				impl.exceptions = resolvedMethod.resolvedExceptionTypes.map[replace(typeParameterMappings)]
				impl.varArgs = declaration.varArgs
				impl.returnType = resolvedMethod.resolvedReturnType.replace(typeParameterMappings)
				for (p : resolvedMethod.resolvedParameters)
					impl.addParameter(p.declaration.simpleName, p.resolvedType.replace(typeParameterMappings))
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
			if (!target.actualTypeArguments.isEmpty)
				return newTypeReference(target.type, target.actualTypeArguments.map[replace(oldType, newType)])
			if (target.wildCard) {
				if (target.upperBound != object)
					return target.upperBound.replace(oldType, newType).newWildcardTypeReference
				else if (!target.lowerBound.isAnyType)
					return target.lowerBound.replace(oldType, newType).newWildcardTypeReferenceWithLowerBound
			}
			if (target.isArray)
				return target.arrayComponentType.replace(oldType, newType).newArrayTypeReference
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
				case #[string, Class.newTypeReference(newWildcardTypeReference).newArrayTypeReference, object.newArrayTypeReference]: {
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
