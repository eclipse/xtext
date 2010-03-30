package org.eclipse.xtext.example.arithmetics.scoping;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.arithmetics.arithmetics.DeclaredParameter;
import org.eclipse.xtext.example.arithmetics.arithmetics.Definition;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.example.arithmetics.arithmetics.util.ArithmeticsSwitch;
import org.eclipse.xtext.naming.IQualifiedNameProvider;

public class NameProvider extends IQualifiedNameProvider.AbstractImpl {

	public String getQualifiedName(EObject obj) {
		return new ArithmeticsSwitch<String>() {

			public String caseModule(Module object) {
				return object.getName();
			}

			public String caseDefinition(Definition object) {
				StringBuilder sb = new StringBuilder();
				sb.append(doSwitch(object.eContainer()));
				sb.append(".");
				sb.append(object.getName());
				if (!object.getArgs().isEmpty()) {
					sb.append("(");
					Iterator<DeclaredParameter> iter = object.getArgs()
							.iterator();
					int i = 1;
					while (iter.hasNext()) {
						iter.next();
						sb.append("arg" + (i++));
						if (iter.hasNext())
							sb.append(",");
					}
					sb.append(")");
				}
				return sb.toString();
			}

			public String caseDeclaredParameter(DeclaredParameter object) {
				return doSwitch(object.eContainer()) + "." + object.getName();
			}

		}.doSwitch(obj);
	}
}