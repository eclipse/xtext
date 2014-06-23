package org.eclipse.xtend.lib

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
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration

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
				case #[string, object.newArrayTypeReference]:
					true
				default: {
					addError("Not a valid delegate signature, use (), (String) or (String, Object[])")
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
			delegate.originalDeclaringType.delegates.filter[it != delegate.primarySourceElement]
		}

		def originalDeclaringType(MemberDeclaration it) {
			if (source) 
				declaringType 
			else
				(primarySourceElement as MemberDeclaration).declaringType
		}
		
		def areListedInterfacesValid(MemberDeclaration delegate) {
			val declaringType = delegate.originalDeclaringType
			val interfacesOfDeclaringType = declaringType.implementedInterfaces.map[newTypeReference].toSet
			val availableInterfaces = delegate.type.type.implementedInterfaces.map[newTypeReference].toSet
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

		def dispatch Set<? extends InterfaceDeclaration> getImplementedInterfaces(Type it) {
			#{}
		}

		def dispatch Set<? extends InterfaceDeclaration> getImplementedInterfaces(InterfaceDeclaration it) {
			(#[it] + extendedInterfaces.map[type.implementedInterfaces].flatten).toSet
		}

		def dispatch Set<? extends InterfaceDeclaration> getImplementedInterfaces(ClassDeclaration it) {
			implementedInterfaces.map[type.implementedInterfaces].flatten.toSet
		}

		def getDelegatedInterfaces(MemberDeclaration delegate) {
			val interfacesOfDeclaringType = delegate.originalDeclaringType.implementedInterfaces
			val listedInterfaces = delegate.listedInterfaces
			val availableInterfaces = delegate.type.type.implementedInterfaces
			availableInterfaces.filter[iface|
				interfacesOfDeclaringType.contains(iface)
				&& (listedInterfaces.empty || listedInterfaces.exists[iface.newTypeReference.isAssignableFrom(it)])
			].toSet
		}

		def getMethodsToImplement(MemberDeclaration delegate) {
			delegate.delegatedInterfaces.map[declaredMethods].flatten
				.filter[delegate.originalDeclaringType.findDeclaredMethod(simpleName, parameters.map[type]) == null]
				.filter[!isObjectMethod]
				.toSet
		}
	
		def isObjectMethod(MethodDeclaration it) {
			simpleName == "hashCode" && parameters.empty
			|| simpleName == "toString" && parameters.empty
			|| simpleName == "equals" && parameters.map[type].toList == #[object]
			|| simpleName == "finalize" && parameters.empty
			|| simpleName == "clone" && parameters.empty
		}

		def implementMethod(MutableMemberDeclaration delegate, MethodDeclaration method) {
			delegate.markAsRead
			delegate.declaringType.addMethod(method.simpleName) [ impl |
				//TODO type parameters
				impl.exceptions = method.exceptions
				impl.varArgs = method.varArgs
				impl.returnType = method.returnType
				method.parameters.forEach[impl.addParameter(simpleName, type)]
				impl.body = '''
					«method.returnIfNeeded» «delegate.delegateAccess(method)».«method.simpleName»(«method.parameters.join(", ")[simpleName]»);
				'''
			]
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
				case #[string, object.newArrayTypeReference]: 
					'''this.«simpleName»("«method.simpleName»", new Object[]{«method.parameters.join(", ")[simpleName]»})'''
				default:
					throw new IllegalArgumentException("delegate signature")
			}
		}

		def returnIfNeeded(MethodDeclaration it) {
			if(returnType.isVoid) "" else "return"
		}
	}

}
