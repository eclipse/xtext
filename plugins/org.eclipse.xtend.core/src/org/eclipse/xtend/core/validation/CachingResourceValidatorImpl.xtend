package org.eclipse.xtend.core.validation

import org.eclipse.xtext.validation.ResourceValidatorImpl
import javax.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.OnChangeEvictingCache

class CachingResourceValidatorImpl extends ResourceValidatorImpl {

	@Inject OnChangeEvictingCache cache

	override validate(Resource resource, CheckMode mode, CancelIndicator mon) {
		return cache.get(mode, resource) [ |
			super.validate(resource, mode, mon)
		]
	}

}
