package designpattern.creational.prototype.prototypemanager;

import designpattern.creational.prototype.PrototypeCapableDocument;
import designpattern.creational.prototype.concreteprototype.AuthorizedSignatory;
import designpattern.creational.prototype.concreteprototype.NDAgreement;
import designpattern.creational.prototype.concreteprototype.TAndC;

import java.util.HashMap;
import java.util.Map;

public class DocumentPrototypeManager {

    private static final Map<String, PrototypeCapableDocument> protoDocMap = new HashMap<>();

    static {
        TAndC tAndC = new TAndC();
        tAndC.setVendorName("Vendor place holder");
        // populate from database/network call/disk IO
        tAndC.setContent("Please read the terms and conditions...");
        protoDocMap.put("tandc", tAndC);
        NDAgreement ndAgreement = new NDAgreement();
        ndAgreement.setVendorName("Vendor place holder");
        AuthorizedSignatory signatory = new AuthorizedSignatory();
        signatory.setName("John Doe");
        signatory.setDesignation("Operations Head");
        ndAgreement.setAuthorizedSignatory(signatory);
        protoDocMap.put("nda", ndAgreement);
    }

    public static PrototypeCapableDocument getClonedDocument(final String type) {
        PrototypeCapableDocument clonedDoc = null;
        try {
            PrototypeCapableDocument doc = protoDocMap.get(type);
            clonedDoc = doc.cloneDocument();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonedDoc;
    }
}
