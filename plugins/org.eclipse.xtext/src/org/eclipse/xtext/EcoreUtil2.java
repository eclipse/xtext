package org.eclipse.xtext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class EcoreUtil2 extends EcoreUtil {
    private static Log log = LogFactory.getLog(EcoreUtil2.class);

    @SuppressWarnings("unchecked")
    public static <T extends EObject> T getContainerOfType(EObject ele, Class<T> type) {
        if (type.isAssignableFrom(ele.getClass()))
            return (T) ele;
        if (ele.eContainer() != null)
            return getContainerOfType(ele.eContainer(), type);
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T extends EObject> List<T> getAllContentsOfType(EObject ele, Class<T> type) {
        List<T> result = new ArrayList<T>();
        TreeIterator<EObject> allContents = ele.eAllContents();
        while (allContents.hasNext()) {
            EObject object = allContents.next();
            if (type.isAssignableFrom(object.getClass())) {
                result.add((T) object);
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> typeSelect(List<?> elements, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        for (Object ele : elements) {
            if (ele != null && clazz.isAssignableFrom(ele.getClass())) {
                result.add((T) ele);
            }
        }
        return result;
    }

    public static List<EObject> eAllContentsAsList(EObject ele) {
        List<EObject> result = new ArrayList<EObject>();
        TreeIterator<EObject> iterator = ele.eAllContents();
        while (iterator.hasNext())
            result.add(iterator.next());
        return result;
    }

    public static final EPackage loadEPackage(String uriAsString) {
        if (EPackage.Registry.INSTANCE.containsKey(uriAsString))
            return EPackage.Registry.INSTANCE.getEPackage(uriAsString);
        URI uri = URI.createURI(uriAsString);
        Resource resource = new ResourceSetImpl().getResource(uri, true);
        for (TreeIterator<EObject> allContents = resource.getAllContents(); allContents.hasNext();) {
            EObject next = allContents.next();
            if (next instanceof EPackage) {
                EPackage ePackage = (EPackage) next;
                if (ePackage.getNsURI() != null && ePackage.getNsURI().equals(uriAsString)) {
                    return ePackage;
                }
            }
        }
        log.error("Could not load EPackage with nsURI" + uriAsString);
        return null;
    }

    public static void saveEPackage(EPackage ePackage, String path) throws IOException {
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
        URI uri = URI.createFileURI(path + "/" + ePackage.getName() + ".ecore");
        Resource metaModelResource = new ResourceSetImpl().createResource(uri);
        metaModelResource.getContents().add(ePackage);
        metaModelResource.save(null);
    }

    public static String getURIFragment(EObject eObject) {
        Resource resource = eObject.eResource();
        String fragment = resource.getURIFragment(eObject);
        return fragment;
    }
}
