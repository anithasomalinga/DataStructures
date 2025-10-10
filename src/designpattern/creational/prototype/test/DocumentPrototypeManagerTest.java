package designpattern.creational.prototype.test;

import designpattern.creational.prototype.PrototypeCapableDocument;
import designpattern.creational.prototype.prototypemanager.DocumentPrototypeManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentPrototypeManagerTest {

    @Test
    public void testGetClonedDocument() {
        PrototypeCapableDocument clonedTAndC = DocumentPrototypeManager.getClonedDocument("tandc");
        clonedTAndC.setVendorName("Telus");
        System.out.println(clonedTAndC);

        PrototypeCapableDocument clonedNDA = DocumentPrototypeManager.getClonedDocument("nda");
        clonedNDA.setVendorName("Bell");
        System.out.println(clonedNDA);
    }

}