package org.eclipse.xtext.xbase.ui.validation

import com.google.inject.Inject
import java.util.Map
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.validation.DiagnosticConverterImpl

import static org.eclipse.xtext.xbase.validation.IssueCodes.*

class PreferenceAwareDiagnosticConverter extends DiagnosticConverterImpl {
	
	@Inject IJavaProjectProvider projectProvider
	
	val Map<String, String> issueCodeToJavaCoreCode
	
	new() {
		issueCodeToJavaCoreCode = getIssueCodeToJavaCoreCodeMap()
	}
	
	def Map<String,String> getIssueCodeToJavaCoreCodeMap() { 
		newHashMap(
			FORBIDDEN_REFERENCE -> JavaCore::COMPILER_PB_FORBIDDEN_REFERENCE,
			DISCOURAGED_REFERENCE -> JavaCore::COMPILER_PB_DISCOURAGED_REFERENCE
		)
	}
	
	override protected getSeverity(org.eclipse.emf.common.util.Diagnostic diagnostic) {
		val original = super.getSeverity(diagnostic)
		if (original == null)
			return null
		
		val issueCode = getIssueCode(diagnostic)
		val javaCoreCode = issueCodeToJavaCoreCode.get(issueCode)
		if (javaCoreCode == null)
			return original
		
		val object = getCauser(diagnostic)
		if (object?.eResource?.resourceSet == null) {
			return original
		}
		
		val project = projectProvider.getJavaProject(object.eResource.resourceSet)
		val jdtSeverity = project.getOption(javaCoreCode, true)
		return switch jdtSeverity {
			case 'error' : Severity::ERROR 
			case 'warning' : Severity::WARNING
			case 'ignore' : null 
		}
	}
	

	
}