package org.eclipse.xtext.xbase.ui.validation

import org.eclipse.jdt.core.IJavaProject
import org.eclipse.core.resources.ProjectScope
import org.eclipse.core.runtime.preferences.IScopeContext
import java.util.List
import org.eclipse.core.runtime.preferences.InstanceScope
import org.eclipse.core.runtime.preferences.DefaultScope
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.diagnostics.Severity

class JdtPreferenceAccess {
	
	List<IScopeContext> lookupOrder
	
	new(IJavaProject project) {
		lookupOrder = newArrayList(
			new ProjectScope(project.project),
			InstanceScope::INSTANCE,
			DefaultScope::INSTANCE)
	}
	
	def Severity getSeverity(String key) {
		for (ctx : lookupOrder) {
			val result = ctx.getNode(JavaCore::PLUGIN_ID).get(key, null)
			switch result {
				case 'warning' : 
					return Severity::WARNING
				case 'error' : 
					return Severity::ERROR
			}
		}
		return null
	}
	
}