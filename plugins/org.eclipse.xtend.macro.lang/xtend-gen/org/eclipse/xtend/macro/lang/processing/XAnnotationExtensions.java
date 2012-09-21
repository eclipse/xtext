package org.eclipse.xtend.macro.lang.processing;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.macro.lang.macro.MacroAnnotation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage.Literals;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XAnnotationExtensions {
  @Inject
  private IJvmModelAssociations associations;
  
  @Inject
  private LazyURIEncoder encoder;
  
  @Inject
  private ILinkingService linkingService;
  
  /**
   * Checks whether this annotation is pointing to a processed annotation, without resolving the proxy
   */
  public boolean isProcessed(final XAnnotation it) {
    Object _eGet = it.eGet(Literals.XANNOTATION__ANNOTATION_TYPE);
    final Object proxy = _eGet;
    boolean _matched = false;
    if (!_matched) {
      if (proxy instanceof EObject) {
        final EObject _eObject = (EObject)proxy;
        boolean _eIsProxy = _eObject.eIsProxy();
        if (_eIsProxy) {
          _matched=true;
          final URI uri = ((InternalEObject) _eObject).eProxyURI();
          Resource _eResource = it.eResource();
          String _fragment = uri.fragment();
          boolean _isCrossLinkFragment = this.encoder.isCrossLinkFragment(_eResource, _fragment);
          if (_isCrossLinkFragment) {
            Resource _eResource_1 = it.eResource();
            String _fragment_1 = uri.fragment();
            final Triple<EObject,EReference,INode> triple = this.encoder.decode(_eResource_1, _fragment_1);
            EObject _first = triple.getFirst();
            EReference _second = triple.getSecond();
            INode _third = triple.getThird();
            final List<EObject> candidates = this.linkingService.getLinkedObjects(_first, _second, _third);
            boolean _isEmpty = candidates.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              EObject _head = IterableExtensions.<EObject>head(candidates);
              return this.isProcessedAnnotation(((JvmAnnotationType) _head));
            }
          }
        }
      }
    }
    if (!_matched) {
      if (proxy instanceof JvmAnnotationType) {
        final JvmAnnotationType _jvmAnnotationType = (JvmAnnotationType)proxy;
        _matched=true;
        return this.isProcessedAnnotation(_jvmAnnotationType);
      }
    }
    return false;
  }
  
  public MacroAnnotation getMacroAnnotation(final JvmAnnotationType it) {
    Set<EObject> _sourceElements = this.associations.getSourceElements(it);
    Iterable<MacroAnnotation> _filter = Iterables.<MacroAnnotation>filter(_sourceElements, MacroAnnotation.class);
    MacroAnnotation _head = IterableExtensions.<MacroAnnotation>head(_filter);
    return _head;
  }
  
  public MacroAnnotation getMacroAnnotation(final XAnnotation it) {
    Object _eGet = it.eGet(Literals.XANNOTATION__ANNOTATION_TYPE);
    final Object proxy = _eGet;
    boolean _matched = false;
    if (!_matched) {
      if (proxy instanceof EObject) {
        final EObject _eObject = (EObject)proxy;
        boolean _eIsProxy = _eObject.eIsProxy();
        if (_eIsProxy) {
          _matched=true;
          final URI uri = ((InternalEObject) _eObject).eProxyURI();
          Resource _eResource = it.eResource();
          String _fragment = uri.fragment();
          boolean _isCrossLinkFragment = this.encoder.isCrossLinkFragment(_eResource, _fragment);
          if (_isCrossLinkFragment) {
            Resource _eResource_1 = it.eResource();
            String _fragment_1 = uri.fragment();
            final Triple<EObject,EReference,INode> triple = this.encoder.decode(_eResource_1, _fragment_1);
            EObject _first = triple.getFirst();
            EReference _second = triple.getSecond();
            INode _third = triple.getThird();
            final List<EObject> candidates = this.linkingService.getLinkedObjects(_first, _second, _third);
            boolean _isEmpty = candidates.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              EObject _head = IterableExtensions.<EObject>head(candidates);
              return this.getMacroAnnotation(((JvmAnnotationType) _head));
            }
          }
        }
      }
    }
    if (!_matched) {
      if (proxy instanceof JvmAnnotationType) {
        final JvmAnnotationType _jvmAnnotationType = (JvmAnnotationType)proxy;
        _matched=true;
        return this.getMacroAnnotation(_jvmAnnotationType);
      }
    }
    return null;
  }
  
  protected boolean isProcessedAnnotation(final JvmAnnotationType annotationType) {
    Set<EObject> _sourceElements = this.associations.getSourceElements(annotationType);
    final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
        public Boolean apply(final EObject e) {
          return Boolean.valueOf((e instanceof MacroAnnotation));
        }
      };
    boolean _exists = IterableExtensions.<EObject>exists(_sourceElements, _function);
    return _exists;
  }
}
