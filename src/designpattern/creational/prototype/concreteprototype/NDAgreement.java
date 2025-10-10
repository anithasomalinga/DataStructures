package designpattern.creational.prototype.concreteprototype;

import designpattern.creational.prototype.PrototypeCapableDocument;

public class NDAgreement extends PrototypeCapableDocument {

    private AuthorizedSignatory authorizedSignatory;

    public AuthorizedSignatory getAuthorizedSignatory() {
        return authorizedSignatory;
    }

    public void setAuthorizedSignatory(AuthorizedSignatory authorizedSignatory) {
        this.authorizedSignatory = authorizedSignatory;
    }

    @Override
    public PrototypeCapableDocument cloneDocument() throws CloneNotSupportedException {
        // Clone with Deep Copy
        NDAgreement ndAgreement = (NDAgreement) super.clone();
        AuthorizedSignatory clonedAuthSign = (AuthorizedSignatory) ndAgreement.getAuthorizedSignatory().clone();
        ndAgreement.setAuthorizedSignatory(clonedAuthSign);
        return ndAgreement;
    }

    @Override
    public String toString() {
        return "[ND Vendor Name - " + getVendorName() + ", Content - " + getContent() + ", Authorized Signatory - " + getAuthorizedSignatory() + "]";
    }
}
