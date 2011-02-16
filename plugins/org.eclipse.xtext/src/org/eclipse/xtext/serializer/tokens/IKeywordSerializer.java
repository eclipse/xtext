package org.eclipse.xtext.serializer.tokens;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;

import com.google.inject.ImplementedBy;

@ImplementedBy(KeywordSerializer.class)
public interface IKeywordSerializer {

	//	boolean equalsOrReplacesNode(EObject context, Keyword keyword, Object value, INode node);

	boolean isValid(EObject context, Keyword keyword, Object value, ISerializationDiagnostic.Acceptor errorAcceptor);

	String serializeAssignedKeyword(EObject context, Keyword keyword, Object value, INode node,
			ISerializationDiagnostic.Acceptor errorAcceptor);

}
