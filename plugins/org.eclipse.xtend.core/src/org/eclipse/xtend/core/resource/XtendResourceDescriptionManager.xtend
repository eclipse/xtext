package org.eclipse.xtend.core.resource

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Collection
import java.util.Collections
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.DefaultResourceDescription
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp
import org.eclipse.xtext.util.IResourceScopeCache
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import java.util.Set

@Singleton
class XtendResourceDescriptionManager extends DerivedStateAwareResourceDescriptionManager implements IResourceDescription.Manager.AllChangeAware {
	
	@Inject IBatchTypeResolver typeResolver
	@Inject IQualifiedNameConverter nameConverter
	
	override IResourceDescription createResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		return new XtendResourceDescription(resource, strategy, cache, typeResolver, nameConverter);
	}
	
	override hasChanges(Delta delta, IResourceDescription candidate) {
		super.hasChanges(delta, candidate) || candidate.containsActiveAnnotation
	}
	
	private def boolean containsActiveAnnotation(IResourceDescription description) {
		description.exportedObjects.exists[userDataKeys.contains(XtendResourceDescriptionStrategy.ACTIVE_ANNOTATION_TIMESTAMP)]
	}
	
	/**
	 * When an annotation processor changes, even if it is just its implementation, the downstream classes should be rebuilt. That is why we are interested even in 
	 * deltas that have no changed EObjectDescriptions
	 */
	override isAffectedByAny(Collection<Delta> deltas, IResourceDescription candidate, IResourceDescriptions context) throws IllegalArgumentException {
		isAffected(deltas, candidate, context)
	}
	
}

class XtendResourceDescription extends DefaultResourceDescription {

	static val primitivesFilter = #{'boolean', 'int', 'char', 'byte', 'short', 'long', 'double', 'float', 'void'}

	IBatchTypeResolver typeResolver
	IQualifiedNameConverter nameConverter
	
	Set<QualifiedName> importedNames

	new(Resource resource, IDefaultResourceDescriptionStrategy strategy, IResourceScopeCache cache, IBatchTypeResolver typeResolver, IQualifiedNameConverter nameConverter) {
		super(resource, strategy, cache)
		this.typeResolver = typeResolver
		this.nameConverter = nameConverter
	}

	override protected getLookUp() {
		if (lookup == null)
			lookup = new EObjectDescriptionLookUp(computeExportedObjects());
		return lookup;
	}
	
	override getReferenceDescriptions() {
		return Collections.emptyList
	}
	

	def override Iterable<QualifiedName> getImportedNames() {
		if (importedNames != null) {
			return importedNames;
		}
		val result = newHashSet()
		val astRoot = resource.contents.head
		if (astRoot != null) {
			val types = typeResolver.resolveTypes(astRoot)
			for (expression : EcoreUtil.getAllContents(astRoot, true).toIterable.filter(XExpression)) {
				switch expression {
					// an unresolved member feature call, where the receiver is a type literal could potentially become
					// a reference to a nested type
					XMemberFeatureCall case expression.feature != null && expression.feature.eIsProxy && !expression.explicitOperationCallOrBuilderSyntax: {
						val receiver = expression.actualReceiver
						switch receiver {
							XAbstractFeatureCall case receiver.typeLiteral: {
								val type = receiver.feature
								result +=
									nameConverter.toQualifiedName(
										type.identifier + "$" + expression.concreteSyntaxFeatureName).toLowerCase
							}
						}
					}
					// register resolved type literals
					XAbstractFeatureCall case expression.typeLiteral: {
						val type = expression.feature
						if (type instanceof JvmDeclaredType) {
							registerAllTypes(type) [
								result += nameConverter.toQualifiedName(it).toLowerCase
							]
						}
					}
				}
				val typeRef = types.getActualType(expression)
				if (typeRef != null) {
					registerAllTypes(typeRef.type) [
						result += nameConverter.toQualifiedName(it).toLowerCase
					]
				}
			}
			for (eobject : resource.contents) {
				val typesOfIdentifiables = EcoreUtil.getAllContents(eobject, true).filter(JvmIdentifiableElement).map [
					if (!(it instanceof JvmType) || it instanceof JvmDeclaredType)
						types.getActualType(it)
				].toIterable
				for (typeRef : typesOfIdentifiables) {
					if (typeRef != null) {
						registerAllTypes(typeRef.type) [
							result += nameConverter.toQualifiedName(it).toLowerCase
						]
					}
				}
			}
		}
		result.addAll(super.getImportedNames())
		importedNames = result.filter [
			!primitivesFilter.contains(it.lastSegment)
		].toSet
		return importedNames
	}
	
	def void registerAllTypes(JvmType type, (String)=>boolean acceptor) {
		if (type == null || type.eIsProxy)
			return;
		if (!type.local && acceptor.apply(type.identifier)) {
			switch type {
				JvmGenericType : {
					registerAllTypes(type.declaringType, acceptor)
					registerAllTypes(type?.extendedClass?.type, acceptor)
					for (it : type.extendedInterfaces) {
						registerAllTypes(it?.type, acceptor)
					}
				}
			}
		}
	}
	
	def boolean isLocal(JvmType type) {
		switch type {
			JvmGenericType: type.local
			default: false
		}
	}
}
