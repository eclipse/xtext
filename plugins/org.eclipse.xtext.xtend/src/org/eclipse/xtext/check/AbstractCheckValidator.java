package org.eclipse.xtext.check;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.xtend.check.CheckFacade;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtext.util.MultiMap;
import org.eclipse.xtext.validator.CheckMode;
import org.eclipse.xtext.validator.CheckType;
import org.eclipse.xtext.validator.CompositeEValidator;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public abstract class AbstractCheckValidator implements EValidator {
	
	private ExecutionContext ctx = null;
	
	@Inject
	public void setExecutionContext(ExecutionContext ctx) {
		this.ctx = ctx;
	}
	
	@Inject
	public void register(EValidator.Registry registry) {
		List<? extends EPackage> packages = getEPackages();
		for (EPackage ePackage : packages) {
			CompositeEValidator.register(ePackage, this, registry);
		}
	}
	
	/**
	 * 
	 */
	protected List<? extends EPackage> getEPackages() {
		throw new UnsupportedOperationException("please overwrite");
	}

	private MultiMap<CheckType, String> checkFiles = new MultiMap<CheckType, String>();
	
	public void addCheckFile(String checkFile, CheckType checkType) {
		checkFiles.put(checkType, checkFile);
	}
	
	public void addCheckFile(String checkFile) {
		checkFiles.put(CheckType.FAST, checkFile);
	}

	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(eObject.eClass(),eObject,diagnostics,context);
	}

	public boolean validate(EClass eClass, EObject eObject, final DiagnosticChain diagnostics, Map<Object, Object> context) {
		CheckMode mode = CheckMode.getCheckMode(context);
		Issues issues = new IssuesImpl();
		for (CheckType type: checkFiles.keySet()) {
			if (mode.shouldCheck(type)) {
				List<String> list = checkFiles.get(type);
				for (String string : list) {
					CheckFacade.checkAll(string, Collections.singleton(eObject), ctx, issues);
				}
			}
		}
		
		for (MWEDiagnostic diag : issues.getIssues()) {
			diagnostics.add(diag);
		}
		return !issues.hasErrors();
	}

	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}
	
}
