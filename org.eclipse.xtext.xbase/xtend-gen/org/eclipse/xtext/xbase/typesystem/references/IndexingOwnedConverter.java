/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.IndexingLightweightTypeReferenceFactory;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @deprecated use the {@link IndexingLightweightTypeReferenceFactory} instead.
 */
@Deprecated
@SuppressWarnings("all")
public class IndexingOwnedConverter extends IndexingLightweightTypeReferenceFactory {
  public IndexingOwnedConverter(final ITypeReferenceOwner owner) {
    super(owner);
  }
  
  public IndexingOwnedConverter(final ITypeReferenceOwner owner, final boolean keepUnboundWildcards) {
    super(owner, keepUnboundWildcards);
  }
}
