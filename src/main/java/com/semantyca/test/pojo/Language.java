package com.semantyca.test.pojo;


public class Language extends SimpleReferenceEntity {

    private LanguageCode code = LanguageCode.UNKNOWN;

    private boolean isOn;

    private int position;

    private boolean isCyrillic;

    public LanguageCode getCode() {
        return code;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void setIsOn(boolean on) {
        isOn = on;
    }

    public void setCode(LanguageCode code) {
        this.code = code;
    }

    public void setLanguageCode(String id) {
        this.code = LanguageCode.valueOf(id);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isCyrillic() {
        return isCyrillic;
    }

    public void setCyrillic(boolean cyrillic) {
        isCyrillic = cyrillic;
    }

    public String toString(){
        return super.toString() + ", isOn=" + isOn;
    }

}
