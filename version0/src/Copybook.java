public class Copybook {
    private int levelNumber;
    private String dataName;
    private String dataType;
    private int valueLength;
    private String valueType;

    Copybook() {}

    Copybook(int levelNumber, String dataName, String dataType, int valueLength, String valueType){
        this.levelNumber = levelNumber;
        this.dataName = dataName;
        this.dataType = dataType;
        this.valueLength = valueLength;
        this.valueType = valueType;
    }


    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        if(this.levelNumber == 0)
            this.levelNumber = levelNumber;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        if(this.dataName == null)
            this.dataName = dataName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        if(this.dataType == null)
            this.dataType = dataType;
    }

    public int getValueLength() {
        return valueLength;
    }

    public void setValueLength(int valueLength) {
        if(this.valueLength == 0)
            this.valueLength = valueLength;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        if(this.valueType == null)
            this.valueType = valueType;
    }
}
