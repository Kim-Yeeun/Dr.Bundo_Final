package org.techtown.drbundo;

public class LocalItem {
    String local;
    String result;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "LocalItem{" +
                "local='" + local + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
