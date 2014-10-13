package org.eclipse.xtext.idea.resource

import com.google.inject.Singleton
import com.intellij.openapi.util.Key
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.ISynchronizable
import org.eclipse.xtext.service.OperationCanceledError

@Singleton
class ResourceInitializationService {

	public static val ENSURE_INITIALIZED = Key.<Boolean>create("ENSURE_INITIALIZED")

	def Resource ensureFullyInitialized(Resource resource) {
		try {
			switch resource {
				DerivedStateAwareResource:
					if (resource instanceof ISynchronizable<?>) {
						resource.execute [
							resource.doEnsureFullyInitialized
						]
					} else {
						resource.doEnsureFullyInitialized
					}
				default:
					resource
			}
		} catch (OperationCanceledError e) {
			throw e.wrapped
		}
	}

	protected def Resource doEnsureFullyInitialized(DerivedStateAwareResource context) {
		val deliver = context.eDeliver
		try {
			context.eSetDeliver(false)
			context.installDerivedState(false)
		} finally {
			context.eSetDeliver(deliver)
		}
		context
	}

}
