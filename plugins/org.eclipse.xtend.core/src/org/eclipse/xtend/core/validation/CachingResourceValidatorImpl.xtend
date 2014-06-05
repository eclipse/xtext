package org.eclipse.xtend.core.validation

import com.google.inject.Inject
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.ResourceValidatorImpl
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.validation.Issue

class CachingResourceValidatorImpl extends ResourceValidatorImpl {

	@Inject OnChangeEvictingCache cache

	override validate(Resource resource, CheckMode mode, CancelIndicator mon) {
		try {
			return cache.get(mode, resource) [ |
				val result = super.validate(resource, mode, mon)
				if(mon != null && mon.canceled)
					throw new OperationCanceledException
				else
					result
			]
		} catch(OperationCanceledException exc) {
			return emptyList
		}
	}
	
	override protected validate(Resource resource, CheckMode mode, CancelIndicator monitor, IAcceptor<Issue> acceptor) {
		if (monitor.isCanceled())
			return
		val head = resource.contents.head
		if (head != null)
			validate(resource, head, mode, monitor, acceptor)
	}
	
}
