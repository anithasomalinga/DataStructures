package designpattern.creational.prototype.concreteprototype;

import designpattern.creational.prototype.PrototypeCapableDocument;

public class TAndC extends PrototypeCapableDocument {
    @Override
    public PrototypeCapableDocument cloneDocument() throws CloneNotSupportedException {
        // clone with shallow copy
        return (TAndC) super.clone();
    }

    @Override
    public String toString() {
        return "[TAndC: Vendor Name - " + getVendorName() + ", Content - " + getContent() + "]";
    }
}
