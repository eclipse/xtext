package org.eclipse.xtext.xbase.junit.typesystem;

import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class PublicAnyTypeReference extends AnyTypeReference {
  public PublicAnyTypeReference(final TypeReferenceOwner owner) {
    super(owner);
  }
}
