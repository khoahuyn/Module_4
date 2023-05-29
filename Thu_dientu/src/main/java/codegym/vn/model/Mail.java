package codegym.vn.model;

public class Mail {
    public int id;
    public String languages;
    public int pageSize;
    public String signature;

    public Mail() {
    }

    public Mail(int id, String languages, int pageSize, String signature) {
        this.id = id;
        this.languages = languages;
        this.pageSize = pageSize;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
