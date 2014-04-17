package org.eclipse.xtend.core.resource

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescription
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp
import org.eclipse.xtext.util.IResourceScopeCache
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmDeclaredType

class XtendResourceDescriptionManager extends DerivedStateAwareResourceDescriptionManager {
	
	@Inject IBatchTypeResolver typeResolver
	@Inject IQualifiedNameConverter nameConverter
	
	override IResourceDescription createResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		return new XtendResourceDescription(resource, strategy, cache, typeResolver, nameConverter);
	}
}

class XtendResourceDescription extends DefaultResourceDescription {

	static val primitivesFilter = #{'boolean', 'int', 'char', 'byte', 'short', 'long', 'double', 'float', 'void'}

	IBatchTypeResolver typeResolver
	IQualifiedNameConverter nameConverter

	new(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		super(resource, strategy)
	}

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

	def override Iterable<QualifiedName> getImportedNames() {
		val result = newHashSet()
		for (eobject : resource.contents) {
			val types = typeResolver.resolveTypes(eobject)
			val actualTypes = EcoreUtil.getAllContents(eobject, true).filter(XExpression).map[types.getActualType(it)].toIterable
			for (typeRef : actualTypes) {
				if (typeRef != null) {
					registerAllTypes(typeRef.type) [
						result += nameConverter.toQualifiedName(it).toLowerCase
					]
				}
			}
			val typesOfIdentifiables = EcoreUtil.getAllContents(eobject, true).filter(JvmIdentifiableElement).map[
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
		result.addAll(super.getImportedNames())
		return result.filter [
			!primitivesFilter.contains(it.lastSegment)
		].toSet
	}
	
	def void registerAllTypes(JvmType type, (String)=>boolean acceptor) {
		if (type == null)
			return;
		if (!type.local || acceptor.apply(type.identifier)) {
			switch type {
				JvmGenericType : {
					registerAllTypes(type.declaringType, acceptor)
					registerAllTypes(type?.extendedClass?.type, acceptor)
					type.extendedInterfaces.forEach[
						registerAllTypes(it?.type, acceptor)
					]
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
