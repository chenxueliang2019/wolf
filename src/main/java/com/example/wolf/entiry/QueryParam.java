package com.example.wolf.entiry;

public class QueryParam {

    private String provinceCode;

    private String cityCode;

    private String areaCode;

    private String keyWord;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public String toString() {
        return "QueryParam{" +
                "provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", keyWord='" + keyWord + '\'' +
                '}';
    }
}
