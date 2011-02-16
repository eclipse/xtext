package org.eclipse.xtext.serializer.tokens;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;

import com.google.inject.ImplementedBy;

@ImplementedBy(EnumLiteralSerializer.class)
public interface IEnumLiteralSerializer {
	//	boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, INode node);

	boolean isValid(EObject context, RuleCall ruleCall, Object value, ISerializationDiagnostic.Acceptor errorAcceptor);

	String serializeAssignedEnumLiteral(EObject context, RuleCall ruleCall, Object value, INode node,
			ISerializationDiagnostic.Acceptor errorAcceptor);
}
